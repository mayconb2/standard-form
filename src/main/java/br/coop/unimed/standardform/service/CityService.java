package br.coop.unimed.standardform.service;

import br.coop.unimed.standardform.DTO.CityDTO;
import br.coop.unimed.standardform.DTO.StateDTO;
import br.coop.unimed.standardform.model.City;
import br.coop.unimed.standardform.model.State;
import br.coop.unimed.standardform.repository.CityRepository;
import br.coop.unimed.standardform.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    StateService stateService;

    public List<CityDTO> listCitiesFromState(Integer stateID) {

        List<City> cities = cityRepository.findByStateId(stateID);

        List<CityDTO> cityDTOS = new ArrayList<>();

        for(City city: cities) {
            cityDTOS.add(city.toCityDTO());
        }

        return cityDTOS;
    }
}
