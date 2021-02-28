package br.coop.unimed.standardform.repository;

import br.coop.unimed.standardform.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Integer> {
}
