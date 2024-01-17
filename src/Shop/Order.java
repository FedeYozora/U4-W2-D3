package Shop;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> product;
    private Customer customer;

    public Order(String status, LocalDate orderDate, List<Product> product, Customer customer) {
        Random rndm = new Random();
        this.id = rndm.nextLong();
        this.status = status;
        this.orderDate = orderDate;
        this.product = product;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Product> getProduct() {
        return product;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", product=" + product +
                ", customer=" + customer.getName() +
                '}';
    }
}