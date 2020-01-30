package it.vallara.saletaxesproblem;

public class Product {
    private int quantity;
    private double price;
    private final double taxRate;
    private String description;

    public Product(int quantity, String description, double price) {
        this(quantity, description, price, 0);
    }

    public Product(int quantity, String description, double price, double taxRate) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.taxRate = taxRate;
    }

    @Override
    public String toString() {
        return String.format("%d %s: %.2f", +
                        quantity(),
                description(),
                totalPrice());
    }

    public double totalPrice() {
        return price * quantity + totalTaxes();
    }

    public double totalTaxes() {
        return quantity * taxRate * price;
    }

    public int quantity() {
        return quantity;
    }

    public String description() {
        return description;
    }
}
