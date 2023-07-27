package br.com.pos.archhexagonal.application.ports.output;

import br.com.pos.archhexagonal.application.domain.Contact;

public interface IGetContactGetByIdRepository {

    Contact execute(Long id);
}
