package br.coop.unimed.standardform.model;

import br.coop.unimed.standardform.DTO.FormDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Form")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Form {

    @Id
    private String protocol;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @ManyToOne(targetEntity = State.class, fetch=FetchType.LAZY)
    @JoinColumn(name = "state", referencedColumnName = "id")
    private State state;

    @ManyToOne(targetEntity = City.class, fetch=FetchType.LAZY)
    @JoinColumn(name = "city", referencedColumnName = "id")
    private City city;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String message;

    public FormDTO toDTO() {

        FormDTO dto = new FormDTO();

        dto.setProtocol(protocol);
        dto.setDate(date);
        dto.setName(name);
        dto.setEmail(email);
        dto.setState(state.getId());
        dto.setCity(city.getId());
        dto.setPhone(phone);
        dto.setMessage(message);

        return  dto;
    }

}
