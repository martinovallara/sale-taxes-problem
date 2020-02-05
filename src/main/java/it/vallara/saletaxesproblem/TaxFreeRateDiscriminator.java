package it.vallara.saletaxesproblem;

public class TaxFreeRateDiscriminator extends TaxRateDiscriminator {
    
    public double taxRate(String description){
        return 0.0;
    }
}
