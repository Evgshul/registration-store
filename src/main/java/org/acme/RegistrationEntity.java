package org.acme;

import jakarta.persistence.*;

/**
 * Model of entity Registration
 */
@Entity
@Table(name = "REGISTRATIONS")
public class RegistrationEntity {

    /**
     * Object RegistrationEntity unique identification.
     */
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    /**
     * Object RegistrationEntity field name.
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Object RegistrationEntity field surname.
     */
    @Column(name = "SURNAME")
    private String surname;

    /**
     * Object RegistrationEntity field email.
     */
    @Column(name = "EMAIL")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
