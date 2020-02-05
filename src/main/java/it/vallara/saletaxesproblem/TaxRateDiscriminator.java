package it.vallara.saletaxesproblem;

import java.util.Arrays;
import java.util.List;

public class TaxRateDiscriminator {

    private List<String> taxfreeProducts;
    public static final double STANDARD_TAX_RATE = 0.10;
    public static final double STANDARD_DUTY_TAX_RATE = 0.05;

    public TaxRateDiscriminator() {
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
        double result = 0.0;
        if (description.contains("imported")) {
            result = STANDARD_DUTY_TAX_RATE;
        }
        if (!isTaxFree(description.replace("imported","").trim())) {
            result = result + STANDARD_TAX_RATE;
        }
        return result;
    }
}

