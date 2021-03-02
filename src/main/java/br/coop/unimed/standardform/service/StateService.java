package br.coop.unimed.standardform.service;

import br.coop.unimed.standardform.DTO.StateDTO;
import br.coop.unimed.standardform.model.State;
import br.coop.unimed.standardform.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateService {

    @Autowired
    StateRepository stateRepository;

    public List<StateDTO> listAll() {
        List<State> allStates = stateRepository.findAll();

        List<StateDTO> statesDTO = new ArrayList<>();

        for(State state: allStates) {

            statesDTO.add(state.toStateModel());
        }

        return statesDTO;
    }
}
