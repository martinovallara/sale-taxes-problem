package it.vallara.saletaxesproblem;

public class Product {
    private TaxRateDiscriminator taxRateDiscriminator;

    private int quantity;
    private double price;
    private String description;

    public Product(int quantity, String description, double price, TaxRateDiscriminator taxRateDiscriminator) {
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.taxRateDiscriminator = taxRateDiscriminator;
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
        return taxRateDiscriminator.taxRate(this.description);
    }
}
