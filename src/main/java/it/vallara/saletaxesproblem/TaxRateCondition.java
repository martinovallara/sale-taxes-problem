package it.vallara.saletaxesproblem;

import java.math.BigDecimal;

public class TaxRateCondition {

    public Condition condition;
    public BigDecimal taxRate;

    public TaxRateCondition(Condition condition, BigDecimal taxRate) {
        this.condition = condition;
        this.taxRate = taxRate;
    }
}
