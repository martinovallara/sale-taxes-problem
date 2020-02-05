package it.vallara.saletaxesproblem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TaxRateDiscriminatorParameterizedTest {

    private final String description;
    private final double expectedTaxRate;
    private TaxRateDiscriminator taxRateDiscriminator;

    @Before
    public void setUp() {
        taxRateDiscriminator = new TaxRateDiscriminator();
    }

    public TaxRateDiscriminatorParameterizedTest(String description, double expectedTaxRate) {
        this.description = description;
        this.expectedTaxRate = expectedTaxRate;
    }

    @Test
    public void should_create_a_product_with_tax_rate() {

        assertEquals(expectedTaxRate, taxRateDiscriminator.taxRate(description), 0.001);
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"book", 0.00},
                {"apple", 0.00},
                {"cache", 0.00},
                {"milk", 0.00},
                {"headache pills", 0.00},
                {"bottle of perfume", 0.10},
                {"pen", 0.10},
                {"other", 0.10},
                {"imported other", 0.15},
                {"imported book", 0.05}
        });
    }
}