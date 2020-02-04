package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TaxCalculatorParameterizedTest {

    private final String description;
    private final double expectedTaxRate;
    private TaxCalculator taxCalculator;

    @Before
    public void setUp() {
        taxCalculator = new TaxCalculator();
    }

    public TaxCalculatorParameterizedTest(String description, double expectedTaxRate) {
        this.description = description;
        this.expectedTaxRate = expectedTaxRate;
    }

    @Test
    public void should_create_a_product_with_tax_rate() {

        assertThat(taxCalculator.taxRate(description), Is.is(expectedTaxRate));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"book", 0.0},
                {"apple", 0.0},
                {"cache", 0.0},
                {"milk", 0.0},
                {"headache pills", 0.0},
                {"bottle of perfume", 0.1},
                {"pen", 0.1},
                {"other", 0.1}
        });
    }
}