package br.coop.unimed.standardform.service;

import br.coop.unimed.standardform.DTO.FormDTO;
import br.coop.unimed.standardform.DTO.ProtocolDTO;
import br.coop.unimed.standardform.model.Form;
import br.coop.unimed.standardform.repository.CityRepository;
import br.coop.unimed.standardform.repository.FormRepository;
import br.coop.unimed.standardform.repository.StateRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class FormService {

    @Autowired
    private FormRepository formRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CityRepository cityRepository;

    public List<FormDTO> listAll() {
        List<Form> allForms = formRepository.findAll();

        List<FormDTO> allFormsDto = new ArrayList<>();

        for(Form form : allForms) {
            allFormsDto.add(form.toDTO());
        }

        return allFormsDto;
    }

    public ProtocolDTO saveForm(FormDTO dto) {
        LocalDate day = LocalDate.now();

        String protocol = (day.toString() + dto.getPhone()).replaceAll("-","");

        dto.setProtocol(protocol);
        dto.setDate(day);

        Form savedForm = formRepository.save(dto.toFormModel(stateRepository, cityRepository));

        String newProtocol = savedForm.getProtocol();

        return new ProtocolDTO(newProtocol);
    }
}
