package br.com.pos.archhexagonal.application.domain;

import br.com.pos.archhexagonal.application.ports.output.IContactRepositoryPort;
import br.com.pos.archhexagonal.application.ports.output.IListContactDomainRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // Faz get e set ou @Getter ou @Setter
@AllArgsConstructor // Construtor com todos os argumentos
@NoArgsConstructor // Construtor sem argumentos
@Builder // Auxilia na criacao de objetos - Padrao de projeto -- Estudar
public class Contact {

    private Long id;
    private String name;
    private String email;
    private String phone;

    public Contact save(IContactRepositoryPort iContactRepositoryPort) {
        //salvar o contato
        validContactDomain(this);
        return iContactRepositoryPort.createContact(this);
    }

    private void validContactDomain(Contact domain) {
        if (domain.name == null || domain.name.isEmpty()) {
            throw  new IllegalArgumentException("Contact name is not by null or empty");
        }

        if (domain.email == null || domain.email.isEmpty()) {
            throw  new IllegalArgumentException("Contact e-mail is not by null or empty");
        }

        if (domain.phone == null || domain.phone.isEmpty()) {
            throw  new IllegalArgumentException("Contact phone is not by null or empty");
        }
    }

    public List<Contact> list (IListContactDomainRepository iListContactDomainRepository) {
        return iListContactDomainRepository.execute();
    }
}
