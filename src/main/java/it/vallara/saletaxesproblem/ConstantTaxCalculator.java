package it.vallara.saletaxesproblem;

public class ConstantTaxCalculator extends TaxCalculator {
    private final double taxRate;

    public ConstantTaxCalculator(double taxRate) {
        this.taxRate = taxRate;
    }

    public double taxRate(){
        return taxRate;
    }
}
