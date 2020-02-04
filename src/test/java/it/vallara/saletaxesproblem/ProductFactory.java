package it.vallara.saletaxesproblem;

public class ProductFactory {

    private final TaxCalculator taxCalculator;

    public ProductFactory(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public Product build(int quantity, String description, double price) {
        return new Product(quantity, description, price, taxCalculator);
    }
}
