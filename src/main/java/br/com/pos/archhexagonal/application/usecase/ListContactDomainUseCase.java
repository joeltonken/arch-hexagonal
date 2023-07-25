package br.com.pos.archhexagonal.application.usecase;

import br.com.pos.archhexagonal.application.domain.Contact;
import br.com.pos.archhexagonal.application.ports.input.IListContactDomainUseCase;
import br.com.pos.archhexagonal.application.ports.output.IListContactDomainRepository;
import br.com.pos.archhexagonal.application.utils.UseCase;
import lombok.AllArgsConstructor;

import java.util.List;

@UseCase
@AllArgsConstructor
public class ListContactDomainUseCase implements IListContactDomainUseCase {

    private final IListContactDomainRepository iListContactDomainRepository;
    @Override
    public List<Contact> execute() {
        return Contact.builder().build().list(iListContactDomainRepository);
    }
}
