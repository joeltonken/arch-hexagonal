package br.com.pos.archhexagonal.adapters.output.h2.repository;

import br.com.pos.archhexagonal.adapters.output.h2.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
}
