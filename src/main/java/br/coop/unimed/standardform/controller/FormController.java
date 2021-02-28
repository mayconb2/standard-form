package br.coop.unimed.standardform.controller;

import br.coop.unimed.standardform.DTO.FormDTO;
import br.coop.unimed.standardform.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/form")
public class FormController {

    @Autowired
    private FormService formService;

    @GetMapping(value = "list-all")
    public List<FormDTO> listAll() {
        return formService.listAll();
    }

}
