package br.coop.unimed.standardform.service;

import br.coop.unimed.standardform.DTO.FormDTO;
import br.coop.unimed.standardform.model.Form;
import br.coop.unimed.standardform.repository.FormRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class FormService {

    @Autowired
    private FormRepository formRepository;

    public List<FormDTO> listAll() {

        List<Form> allForms = formRepository.findAll();

        List<FormDTO> allFormsDto = new ArrayList<>();

        for(Form form : allForms) {
            allFormsDto.add(form.toDTO());
        }

        return allFormsDto;
    }
    
}
