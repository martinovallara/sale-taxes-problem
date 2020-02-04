package it.vallara.saletaxesproblem;

public class ExpectedTaxRate extends TaxCalculator {
    private final Double expectedTaxRate;



    public ExpectedTaxRate(Double expectedTaxRate) {
        this.expectedTaxRate = expectedTaxRate;
    }

    public double taxRate(String Description){
        return expectedTaxRate;
    }
}
