package it.vallara.saletaxesproblem;

public class TaxRateCondition {

    public Condition condition;
    public double taxRate;

    public TaxRateCondition(Condition condition, double taxRate) {
        this.condition = condition;
        this.taxRate = taxRate;
    }
}
