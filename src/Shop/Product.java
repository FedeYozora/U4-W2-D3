package Shop;

import java.util.Random;

public class Product {
    private Long id;
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        Random random = new Random();
        this.id = random.nextLong();
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSconto() {
        this.price = (this.price / 100) * 90;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}