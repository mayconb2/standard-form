package br.coop.unimed.standardform.DTO;

import br.coop.unimed.standardform.model.City;
import br.coop.unimed.standardform.model.Form;
import br.coop.unimed.standardform.model.State;
import br.coop.unimed.standardform.repository.CityRepository;
import br.coop.unimed.standardform.repository.StateRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormDTO {

    public String protocol;
    public LocalDate date;
    public String name;
    public String email;
    public Integer state;
    public Long city;
    public String phone;
    public String message;

    @Autowired
    public Form toFormModel(StateRepository stateRepository, CityRepository cityRepository) {

        Form formModel = new Form();

        //todo criar uma exception
        City cityModel = cityRepository.findById(city).orElseThrow(() -> new RuntimeException("City with " + city + " not found"));

        //todo criar uma exception
        State stateModel = stateRepository.findById(state).orElseThrow(() -> new RuntimeException("State with " + state + " not found"));

        formModel.setProtocol(protocol);
        formModel.setDate(date);
        formModel.setName(name);
        formModel.setEmail(email);
        formModel.setState(stateModel);
        formModel.setCity(cityModel);
        formModel.setPhone(phone);
        formModel.setMessage(message);

        return formModel;
    }


}
