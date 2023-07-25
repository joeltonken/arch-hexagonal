package br.com.pos.archhexagonal.adapters.output.h2.service;

import br.com.pos.archhexagonal.adapters.output.h2.entity.ContactEntity;
import br.com.pos.archhexagonal.adapters.output.h2.repository.ContactRepository;
import br.com.pos.archhexagonal.application.domain.Contact;
import br.com.pos.archhexagonal.application.ports.output.IContactRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ContactRepositoryService implements IContactRepositoryPort {

    private final ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contactDomain) {
        var entity =  this.contactRepository.save(new ContactEntity().toContactEntity(contactDomain));
        return Contact.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .build();
    }
}
