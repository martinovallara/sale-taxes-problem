package it.vallara.saletaxesproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxRateDiscriminator {

    private List<String> taxfreeProducts;
    public static final double STANDARD_TAX_RATE = 0.10;
    public static final double STANDARD_DUTY_TAX_RATE = 0.05;
    private final List<TaxRateCondition> taxRateConditionsTable;

    public TaxRateDiscriminator() {
        taxfreeProducts = Arrays.asList(new String[]{
                "book",
                "apple",
                "cache",
                "milk",
                "headache pills"
        });
        taxRateConditionsTable = new ArrayList<TaxRateCondition>();

        Condition isImported = s -> s.contains("imported");
        Condition isTaxedProduct = s -> !isTaxFree(s.replace("imported", "").trim());

        taxationRules(isImported, STANDARD_DUTY_TAX_RATE);
        taxationRules(isTaxedProduct, STANDARD_TAX_RATE);
    }

    private boolean isTaxFree(String description) {
        return taxfreeProducts.contains(description);
    }

    public double taxRate(String description) {



        double result = taxRateConditionsTable.stream()
                .filter(c -> c.condition.predicate(description))
                .map(c -> c.taxRate)
                .reduce(0.0, Double::sum);


        return result;
    }

    private void taxationRules(Condition predicate, double standardDutyTaxRate) {
        taxRateConditionsTable.add(new TaxRateCondition(predicate, standardDutyTaxRate));
    }
}

