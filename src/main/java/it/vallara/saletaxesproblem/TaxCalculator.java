package it.vallara.saletaxesproblem;

import java.util.Arrays;
import java.util.List;

public class TaxCalculator {

    private List<String> taxfreeProducts;
    public static final double STANDARD_TAX_RATE = 0.1;

    public TaxCalculator() {
        taxfreeProducts = Arrays.asList(new String[]{
                "book",
                "apple",
                "cache",
                "milk",
                "headache pills"
        });
    }

    private boolean isTaxFree(String description) {
        return taxfreeProducts.contains(description);
    }

    public double taxRate(String description) {
        return isTaxFree(description) ? 0 : STANDARD_TAX_RATE;
    }
}
