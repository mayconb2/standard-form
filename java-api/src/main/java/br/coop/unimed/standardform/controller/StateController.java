package br.coop.unimed.standardform.controller;

import br.coop.unimed.standardform.DTO.StateDTO;
import br.coop.unimed.standardform.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/state")
public class StateController {

    @Autowired
    StateService stateService;

    @GetMapping(value = "list-all")
    public List<StateDTO> listAll(){
        return stateService.listAll();
    }

}
