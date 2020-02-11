package it.vallara.saletaxesproblem;

import java.math.BigDecimal;

public class TaxFreeRateDiscriminator extends TaxRateDiscriminator {
    
    public BigDecimal taxRate(String description){
        return BigDecimal.ZERO;
    }
}
