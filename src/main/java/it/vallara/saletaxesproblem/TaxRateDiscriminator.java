package it.vallara.saletaxesproblem;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaxRateDiscriminator {

    private List<String> taxfreeProducts;
    public static final BigDecimal STANDARD_TAX_RATE = new BigDecimal("0.10");
    public static final BigDecimal STANDARD_DUTY_TAX_RATE = new BigDecimal("0.05");
    private final List<TaxRateCondition> taxRateConditionsTable;

    public TaxRateDiscriminator() {
        taxfreeProducts = Arrays.asList(new String[]{
                "book",
                "apple",
                "cache",
                "milk",
                "headache pills"
        });
        taxRateConditionsTable = new ArrayList<>();

        Condition isImported = s -> s.contains("imported");
        Condition isTaxedProduct = s -> !isTaxFree(s.replace("imported", "").trim());

        taxationRules(isImported, STANDARD_DUTY_TAX_RATE);
        taxationRules(isTaxedProduct, STANDARD_TAX_RATE);
    }

    private boolean isTaxFree(String description) {
        return taxfreeProducts.contains(description);
    }

    public BigDecimal taxRate(String description) {
        return sumOfApplicableRates(description);
    }

    private BigDecimal sumOfApplicableRates(String description) {
        return taxRateConditionsTable.stream()
                .filter(c -> c.condition.predicate(description))
                .map(c -> c.taxRate)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void taxationRules(Condition predicate, BigDecimal standardDutyTaxRate) {
        taxRateConditionsTable.add(new TaxRateCondition(predicate, standardDutyTaxRate));
    }
}

