package it.vallara.saletaxesproblem;

public class ProductFactory {

    private final TaxRateDiscriminator taxRateDiscriminator;

    public ProductFactory(TaxRateDiscriminator taxRateDiscriminator) {
        this.taxRateDiscriminator = taxRateDiscriminator;
    }

    public static Product buildTaxedProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxRateDiscriminator());
    }

    public static Product buildTaxFreeProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxFreeRateDiscriminator());
    }

    public static Product buildProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxFreeRateDiscriminator());
    }

    public static Product buildFixedTaxedProduct(int quantity, String description, double price, double taxRate) {
        return new Product(quantity, description, price, new ConstantTaxRateDiscriminator(taxRate));
    }

    public Product build(int quantity, String description, double price) {
        return new Product(quantity, description, price, taxRateDiscriminator);
    }
}
