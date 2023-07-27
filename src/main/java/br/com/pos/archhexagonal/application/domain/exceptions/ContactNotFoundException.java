package br.com.pos.archhexagonal.application.domain.exceptions;

public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException(Long id) {
        super(String.format("Contact with %d not found", id));
    }

}
