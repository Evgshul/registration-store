package org.acme;

import jakarta.persistence.*;

@Entity
@Table(name = "REGISTRATIONS")
public class RegistrationEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    public Long id;

    @Column(name = "NAME")
    public String name;

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
}
