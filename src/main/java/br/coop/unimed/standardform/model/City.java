package br.coop.unimed.standardform.model;

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

//
}
