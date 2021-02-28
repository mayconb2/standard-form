package br.coop.unimed.standardform.DTO;

import br.coop.unimed.standardform.model.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StateDTO {

    public int id;
    public String name;
    public String federativeUnit;

    public State toStateModel() {

        State state = new State();

        state.setName(name);
        state.setId(id);
        state.setFederativeUnit(federativeUnit);

        return state;
    }
}
