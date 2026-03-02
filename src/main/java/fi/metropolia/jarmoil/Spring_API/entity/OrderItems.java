package fi.metropolia.jarmoil.Spring_API.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderitems")
public class OrderItems {

    @Id
    @Column(name = "order_id")
    private int order_id;
    @Column(name = "product_id")
    private int product_id;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "unit_price", columnDefinition = "DECIMAL(10,2)")
    private double unit_price;

    public OrderItems() {}

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

}
