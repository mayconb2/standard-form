package br.coop.unimed.standardform.model;

import br.coop.unimed.standardform.DTO.StateDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "State")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class State {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "federative_unit")
    private String federativeUnit;

    public StateDTO toStateDTO() {

        StateDTO stateDTO = new StateDTO();

        stateDTO.setName(name);
        stateDTO.setId(id);
        stateDTO.setFederativeUnit(federativeUnit);

        return stateDTO;
    }
}
