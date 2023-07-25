package br.com.pos.archhexagonal.application.ports.input;

import br.com.pos.archhexagonal.application.domain.Contact;

public interface ICreateContactUseCase {

    Contact execute(Contact contactDomain);
}
