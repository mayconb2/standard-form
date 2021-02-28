package br.coop.unimed.standardform.repository;

import br.coop.unimed.standardform.model.Form;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormRepository extends JpaRepository<Form, String> {
}
