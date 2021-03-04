package br.coop.unimed.standardform.repository;

import br.coop.unimed.standardform.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findByStateId(Integer stateID);
}
