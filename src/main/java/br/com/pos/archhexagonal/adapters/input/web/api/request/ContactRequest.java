package br.com.pos.archhexagonal.adapters.input.web.api.request;

import br.com.pos.archhexagonal.application.domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactRequest {
    private String name;
    private String email;

    public Contact toContactDomain(ContactRequest request){
        return Contact.builder()
                .name(request.name)
                .email(request.email)
                .build();
    }
}
