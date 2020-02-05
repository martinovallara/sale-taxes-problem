package it.vallara.saletaxesproblem;

public class ConstantTaxRateDiscriminator extends TaxRateDiscriminator {
    private final double taxRate;

    public ConstantTaxRateDiscriminator(double taxRate) {
        this.taxRate = taxRate;
    }

    public double taxRate(String description){
        return taxRate;
    }
}
