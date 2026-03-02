package fi.metropolia.jarmoil.Spring_API.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "contacts")
public class Contacts {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name= "email", columnDefinition = "VARCHAR(255)",nullable = false)
    private String email;

    @Column(name= "reference", columnDefinition = "CHAR(32)", nullable = false, length = 32)
    private String reference;

    public Contacts() {}

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

}
