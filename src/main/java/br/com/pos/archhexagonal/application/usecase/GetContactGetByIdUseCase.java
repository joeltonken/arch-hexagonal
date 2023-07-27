package br.com.pos.archhexagonal.application.usecase;

import br.com.pos.archhexagonal.application.domain.Contact;
import br.com.pos.archhexagonal.application.domain.exceptions.ContactNotFoundException;
import br.com.pos.archhexagonal.application.ports.input.IGetContactGetByIdUseCase;
import br.com.pos.archhexagonal.application.ports.output.IGetContactGetByIdRepository;
import br.com.pos.archhexagonal.application.utils.UseCase;
import lombok.AllArgsConstructor;

@UseCase
@AllArgsConstructor
public class GetContactGetByIdUseCase implements IGetContactGetByIdUseCase {

    private final IGetContactGetByIdRepository iGetContactGetByIdRepository;
    @Override
    public Contact execute(Long id) {
        var contact = Contact.builder()
                .id(id)
                .build().getById(iGetContactGetByIdRepository);
        if (contact == null) {
            throw new ContactNotFoundException(id);
        }
        return contact;
    }
}
