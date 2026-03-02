package fi.metropolia.jarmoil.Spring_API.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "customeraddresses")
public class Customeraddresses {

    @Id
    @Column(name = "id")
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    private Customers customers;

    @Column(name = "street_address", columnDefinition = "VARCHAR(255)")
    private String street_address;

    @Column(name = "postal_code", columnDefinition = "VARCHAR(20)")
    private String postal_code;

    @Column(name = "city", columnDefinition = "VARCHAR(100)")
    private String city;

    @Column(name = "country", columnDefinition = "VARCHAR(100)")
    private String country;

    public Customeraddresses() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



}
