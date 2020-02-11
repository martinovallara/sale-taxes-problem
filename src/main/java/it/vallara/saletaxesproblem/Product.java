package it.vallara.saletaxesproblem;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static it.vallara.saletaxesproblem.Receipt.FIVE_CENTs;

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

    public static BigDecimal roundUp(BigDecimal value) {
        return value.multiply(new BigDecimal("20.00")).setScale(0, RoundingMode.UP).divide(new BigDecimal("20.00"));
    }

    @Override
    public String toString() {
        return String.format("%d %s: %.2f", +
                        quantity(),
                description(),
                totalPrice());
    }

    public double totalPrice() {
        return price * quantity + totalTaxes().doubleValue();
    }

    public BigDecimal totalTaxes() {
        return roundUp(new BigDecimal(quantity).multiply((taxRate().multiply(new BigDecimal(price, MathContext.DECIMAL64)))));
    }

    public int quantity() {
        return quantity;
    }

    public String description() {
        return description;
    }

    private BigDecimal taxRate() {
        return taxRateDiscriminator.taxRate(this.description);
    }
}
