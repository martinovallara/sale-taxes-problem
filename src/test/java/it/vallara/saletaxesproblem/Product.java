package it.vallara.saletaxesproblem;

public class Product {
    private TaxCalculator taxCalculator;

    private int quantity;
    private double price;
    private String description;

    public Product(int quantity, String description, double price, TaxCalculator taxCalculator) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.taxCalculator = taxCalculator;
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
        return quantity * taxRate() * price;
    }

    public int quantity() {
        return quantity;
    }

    public String description() {
        return description;
    }

    private double taxRate() {
        return taxCalculator.taxRate(this.description);
    }
}
