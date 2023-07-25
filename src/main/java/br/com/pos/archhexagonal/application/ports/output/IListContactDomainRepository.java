package br.com.pos.archhexagonal.application.ports.output;

import br.com.pos.archhexagonal.application.domain.Contact;

import java.util.List;

public interface IListContactDomainRepository {
    List<Contact> execute();
}
