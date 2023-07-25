package br.com.pos.archhexagonal.adapters.input.web.api.response;

import br.com.pos.archhexagonal.application.domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContactResponse {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public static ContactResponse toContactResponse(Contact domain) {
        return ContactResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .email(domain.getEmail())
                .phone(domain.getPhone())
                .build();
    }
}
