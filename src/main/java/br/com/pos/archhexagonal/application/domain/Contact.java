package br.com.pos.archhexagonal.application.domain;

import br.com.pos.archhexagonal.adapters.input.web.api.response.ContactResponse;
import br.com.pos.archhexagonal.application.ports.output.IContactRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Faz get e set ou @Getter ou @Setter
@AllArgsConstructor // Construtor com todos os argumentos
@NoArgsConstructor // Construtor sem argumentos
@Builder // Auxilia na criacao de objetos - Padrao de projeto -- Estudar
public class Contact {

    private Long id;
    private String name;
    private String email;

    public Contact save(IContactRepositoryPort iContactRepositoryPort) {
        //salvar o contato
        return iContactRepositoryPort.createContact(this);
    }

}
