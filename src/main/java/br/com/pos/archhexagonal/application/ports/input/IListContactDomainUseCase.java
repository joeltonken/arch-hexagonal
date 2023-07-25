package br.com.pos.archhexagonal.application.ports.input;

import br.com.pos.archhexagonal.application.domain.Contact;

import java.util.List;

public interface IListContactDomainUseCase {
    List<Contact> execute();

}
