package it.vallara.saletaxesproblem;

import java.math.BigDecimal;

public class ProductFactory {

    private final TaxRateDiscriminator taxRateDiscriminator;

    public ProductFactory(TaxRateDiscriminator taxRateDiscriminator) {
        this.taxRateDiscriminator = taxRateDiscriminator;
    }

    public static Product buildTaxFreeProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxFreeRateDiscriminator());
    }

    public static Product buildProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxFreeRateDiscriminator());
    }

    public static Product buildFixedTaxedProduct(int quantity, String description, double price, BigDecimal taxRate) {
        return new Product(quantity, description, price, new ConstantTaxRateDiscriminator(taxRate));
    }

    public Product build(int quantity, String description, double price) {
        return new Product(quantity, description, price, taxRateDiscriminator);
    }
}
