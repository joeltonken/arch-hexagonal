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
    private Long id;
    private String name;
    private String email;
    private String phone;

    public Contact toDomain(ContactRequest request) {
        return Contact.builder()
                .name(request.name)
                .email(request.email)
                .phone(request.phone)
                .build();
    }
}
