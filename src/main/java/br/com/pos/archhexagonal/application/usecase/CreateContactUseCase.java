package br.com.pos.archhexagonal.application.usecase;

import br.com.pos.archhexagonal.application.domain.Contact;
import br.com.pos.archhexagonal.application.ports.input.ICreateContactUseCase;
import br.com.pos.archhexagonal.application.ports.output.IContactRepositoryPort;
import br.com.pos.archhexagonal.application.utils.UseCase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@UseCase
public class CreateContactUseCase implements ICreateContactUseCase {

    private final IContactRepositoryPort iContactRepositoryPort;
    public Contact execute(Contact contactDomain) {
        return contactDomain.save(iContactRepositoryPort);
    }
}
