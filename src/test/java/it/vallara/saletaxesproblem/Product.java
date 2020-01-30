package it.vallara.saletaxesproblem;

public class Product {
    private int quantity;
    private double price;
    private String description;

    public Product(int quantity, String description, double price) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%d %s: %.2f", +
                        quantity(),
                description(),
                totalPrice());
    }

    public double totalPrice() {
        return price * quantity;
    }

    public int quantity() {
        return quantity;
    }

    public String description() {
        return description;
    }
}
