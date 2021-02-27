package br.coop.unimed.standardform.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Form")
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

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
