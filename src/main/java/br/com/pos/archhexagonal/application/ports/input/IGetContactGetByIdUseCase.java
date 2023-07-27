package br.com.pos.archhexagonal.application.ports.input;

import br.com.pos.archhexagonal.application.domain.Contact;

public interface IGetContactGetByIdUseCase {
    Contact execute(Long id);
}
