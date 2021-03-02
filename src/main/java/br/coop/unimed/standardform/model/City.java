package br.coop.unimed.standardform.model;

import br.coop.unimed.standardform.DTO.CityDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Entity
@Table(name = "City")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = State.class, fetch=FetchType.LAZY)
    @JoinColumn(name = "state", referencedColumnName = "id")
    private State state;

    public CityDTO toCityDTO() {

        CityDTO dto = new CityDTO();

        dto.setState(state.getId());
        dto.setName(name);
        dto.setId(id);

        return dto;
    }

}
