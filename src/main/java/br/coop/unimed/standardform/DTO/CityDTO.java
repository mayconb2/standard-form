package br.coop.unimed.standardform.DTO;

import br.coop.unimed.standardform.model.City;
import br.coop.unimed.standardform.model.State;
import br.coop.unimed.standardform.repository.StateRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {

    public Long id;
    public String name;
    public Integer state;

    @Autowired
    public City toCityModel(StateRepository stateRepository) {

        City city = new City();

        city.setId(id);
        city.setName(name);

        //todo criar uma exception
        State stateModel = stateRepository.findById(state).orElseThrow(() -> new RuntimeException("State with " + state + " not found"));

        city.setState(stateModel);

        return city;
    }
}
