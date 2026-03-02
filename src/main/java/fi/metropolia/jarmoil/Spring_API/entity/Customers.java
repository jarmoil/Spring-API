package fi.metropolia.jarmoil.Spring_API.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "first_name", columnDefinition = "VARCHAR(100)")
    private String first_name;
    @Column(name = "last_name", columnDefinition = "VARCHAR(100)")
    private String last_name;
    @Column(name = "email", columnDefinition = "VARCHAR(255)", nullable = false)
    private String email;
    @Column(name = "phone", columnDefinition = "VARCHAR(30)")
    private String phone;

    public Customers() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
