package br.com.pos.archhexagonal.adapters.input.web.controller;

import br.com.pos.archhexagonal.adapters.input.web.api.ContactApi;
import br.com.pos.archhexagonal.adapters.input.web.api.request.ContactRequest;
import br.com.pos.archhexagonal.adapters.input.web.api.response.ContactResponse;
import br.com.pos.archhexagonal.application.domain.Contact;
import br.com.pos.archhexagonal.application.ports.input.ICreateContactUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ContactController implements ContactApi {

    private final ICreateContactUseCase iCreateContactUseCase;
    @Override
    public ContactResponse create(ContactRequest request) {
        var domain = iCreateContactUseCase.execute(request.toContactDomain(request));
        return ContactResponse.toContactResponse(domain);
    }

    private static ContactResponse getContactResponse(Contact domain) {
        return ContactResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .email(domain.getEmail())
                .build();
    }
}
