package br.coop.unimed.standardform.model;

import javax.persistence.*;
import java.beans.ConstructorProperties;

@Entity
@Table(name = "City")
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
