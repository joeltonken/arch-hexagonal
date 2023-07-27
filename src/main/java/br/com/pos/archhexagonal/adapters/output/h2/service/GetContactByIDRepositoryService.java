package br.com.pos.archhexagonal.adapters.output.h2.service;

import br.com.pos.archhexagonal.adapters.output.h2.repository.ContactRepository;
import br.com.pos.archhexagonal.application.domain.Contact;
import br.com.pos.archhexagonal.application.domain.exceptions.ContactNotFoundException;
import br.com.pos.archhexagonal.application.ports.output.IGetContactGetByIdRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetContactByIDRepositoryService implements IGetContactGetByIdRepository {

    private final ContactRepository contactRepository;

    @Override
    public Contact execute(Long id) {
        return contactRepository.findById(id)
                .map(contactEntity -> Contact.builder()
                        .id(contactEntity.getId())
                        .name(contactEntity.getName())
                        .email(contactEntity.getEmail())
                        .phone(contactEntity.getPhone())
                        .build())
                .orElseThrow(() -> new ContactNotFoundException(id));
    }

}
