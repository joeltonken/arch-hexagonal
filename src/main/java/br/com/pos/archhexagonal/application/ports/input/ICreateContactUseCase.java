package br.com.pos.archhexagonal.application.ports.input;

import br.com.pos.archhexagonal.application.domain.Contact;

// Input port interface to start the process
// Is here winch the all process begin to create a contact in database
public interface ICreateContactUseCase {

    Contact execute(Contact contactDomain);
}
