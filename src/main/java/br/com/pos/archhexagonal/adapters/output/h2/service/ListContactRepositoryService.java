package br.com.pos.archhexagonal.adapters.output.h2.service;

import br.com.pos.archhexagonal.adapters.input.web.api.response.ContactResponse;
import br.com.pos.archhexagonal.adapters.output.h2.repository.ContactRepository;
import br.com.pos.archhexagonal.application.domain.Contact;
import br.com.pos.archhexagonal.application.ports.output.IListContactDomainRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ListContactRepositoryService implements IListContactDomainRepository {

    private final ContactRepository contactRepository;

    @Override
    public List<Contact> execute() {
        return contactRepository.findAll().stream()
                .map(contactEntity -> Contact.builder()
                        .id(contactEntity.getId())
                        .name(contactEntity.getName())
                        .email(contactEntity.getEmail())
                        .phone(contactEntity.getPhone())
                        .build())
                .collect(Collectors.toList());
    }
}
