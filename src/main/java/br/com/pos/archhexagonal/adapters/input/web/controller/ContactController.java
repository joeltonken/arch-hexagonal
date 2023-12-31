package br.com.pos.archhexagonal.adapters.input.web.controller;

import br.com.pos.archhexagonal.adapters.input.web.api.ContactApi;
import br.com.pos.archhexagonal.adapters.input.web.api.request.ContactRequest;
import br.com.pos.archhexagonal.adapters.input.web.api.response.ContactResponse;
import br.com.pos.archhexagonal.application.domain.Contact;
import br.com.pos.archhexagonal.application.domain.exceptions.ContactNotFoundException;
import br.com.pos.archhexagonal.application.ports.input.ICreateContactUseCase;
import br.com.pos.archhexagonal.application.ports.input.IGetContactGetByIdUseCase;
import br.com.pos.archhexagonal.application.ports.input.IListContactDomainUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class ContactController implements ContactApi {

    private final ICreateContactUseCase iCreateContactUseCase;
    private final IListContactDomainUseCase iListContactDomainUseCase;
    private final IGetContactGetByIdUseCase iGetContactGetByIdUseCase;

    @Override
    public ResponseEntity<ContactResponse> create(ContactRequest contactRequest) {
        var domain = iCreateContactUseCase.execute(contactRequest.toDomain(contactRequest));
        return ResponseEntity.ok(ContactResponse.toContactResponse(domain));
    }

    @Override
    public ResponseEntity<ContactResponse> get(Long id) {
        try {
            var domain = (Contact) this.iGetContactGetByIdUseCase.execute(id);
            var contactResponse = new ContactResponse(domain.getId(), domain.getName(), domain.getEmail(), domain.getPhone());
            return ResponseEntity.ok(contactResponse);
        }catch (ContactNotFoundException e) {
            throw new ContactNotFoundException(id);
        }
    }

    @Override
    public ResponseEntity<List<ContactResponse>> list() {
        var domains = iListContactDomainUseCase.execute();
        var contactResponses = domains.stream()
                .map(ContactResponse::toContactResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(contactResponses);
    }


}
