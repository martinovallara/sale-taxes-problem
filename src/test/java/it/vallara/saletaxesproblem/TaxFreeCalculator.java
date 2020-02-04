package it.vallara.saletaxesproblem;

public class TaxFreeCalculator extends TaxCalculator {
    
    public double taxRate(String description){
        return 0.0;
    }
}
