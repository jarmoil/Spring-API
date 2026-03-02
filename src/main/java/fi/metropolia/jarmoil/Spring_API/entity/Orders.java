package fi.metropolia.jarmoil.Spring_API.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "id")
    private int id;
    @Column (name = "customer_id")
    private int customer_id;
    @Column (name = "order_date", columnDefinition = "DATE")
    private Date order_date;
    @Column (name = "delivery_date", columnDefinition = "DATE")
    private Date delivery_date;
    @Column (name = "shipping_address_id")
    private int shipping_address_id;
    @Column (name = "status", columnDefinition = "VARCHAR(50)")
    private String status;


    public Orders() {}
    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public int getShipping_address() {
        return shipping_address_id;
    }

    public void setShipping_address(int shipping_address) {
        this.shipping_address_id = shipping_address_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}

