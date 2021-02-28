package br.coop.unimed.standardform.controller;

import br.coop.unimed.standardform.DTO.FormDTO;
import br.coop.unimed.standardform.DTO.ProtocolDTO;
import br.coop.unimed.standardform.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/form")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping(value = "list-all")
    public List<FormDTO> listAll() {
        return formService.listAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProtocolDTO saveForm(@RequestBody FormDTO dto) {
        return formService.saveForm(dto);
    }

}
