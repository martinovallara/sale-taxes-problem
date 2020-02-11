package it.vallara.saletaxesproblem;

import java.math.BigDecimal;

public class ConstantTaxRateDiscriminator extends TaxRateDiscriminator {
    private final BigDecimal taxRate;

    public ConstantTaxRateDiscriminator(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal taxRate(String description){
        return taxRate;
    }
}
