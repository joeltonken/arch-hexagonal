package br.com.pos.archhexagonal.adapters.input.web.controller;

import br.com.pos.archhexagonal.adapters.input.web.api.ContactApi;
import br.com.pos.archhexagonal.adapters.input.web.api.request.ContactRequest;
import br.com.pos.archhexagonal.adapters.input.web.api.response.ContactResponse;
import br.com.pos.archhexagonal.application.domain.Contact;
import br.com.pos.archhexagonal.application.ports.input.ICreateContactUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ContactController implements ContactApi {

    private final ICreateContactUseCase iCreateContactUseCase;
    @Override
    public ResponseEntity<ContactResponse> create(ContactRequest contactRequest) {
        var domain = iCreateContactUseCase.execute(contactRequest.toDomain(contactRequest));
        return ResponseEntity.ok(ContactResponse.toContactResponse(domain));
    }

}
