package br.com.pos.archhexagonal.application.ports.output;

import br.com.pos.archhexagonal.application.domain.Contact;

public interface IContactRepositoryPort {
    Contact createContact (Contact contactDomain);
}
