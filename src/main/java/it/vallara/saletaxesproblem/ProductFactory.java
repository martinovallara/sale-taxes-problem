package it.vallara.saletaxesproblem;

public class ProductFactory {

    private final TaxCalculator taxCalculator;

    public ProductFactory(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public static Product buildTaxedProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxCalculator());
    }

    public static Product buildTaxFreeProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxFreeCalculator());
    }

    public static Product buildProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxFreeCalculator());
    }

    public static Product buildFixedTaxedProduct(int quantity, String description, double price, double taxRate) {
        return new Product(quantity, description, price, new ConstantTaxCalculator(taxRate));
    }

    public Product build(int quantity, String description, double price) {
        return new Product(quantity, description, price, taxCalculator);
    }
}
