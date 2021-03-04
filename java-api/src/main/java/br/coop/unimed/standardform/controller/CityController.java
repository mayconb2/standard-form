package br.coop.unimed.standardform.controller;

import br.coop.unimed.standardform.DTO.CityDTO;
import br.coop.unimed.standardform.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/v1/city")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping(value = "list-cities-from-state/{stateID}")
    public List<CityDTO> listCitiesFromState(@PathVariable Integer stateID) {
        return cityService.listCitiesFromState(stateID);
    }

}
