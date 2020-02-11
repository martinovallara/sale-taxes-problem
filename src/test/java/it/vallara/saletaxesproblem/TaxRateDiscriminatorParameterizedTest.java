package it.vallara.saletaxesproblem;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import static it.vallara.saletaxesproblem.Receipt.FIVE_CENTs;
import static it.vallara.saletaxesproblem.Receipt.TEN_CENTs;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TaxRateDiscriminatorParameterizedTest {

    private final String description;
    private final BigDecimal expectedTaxRate;
    private TaxRateDiscriminator taxRateDiscriminator;

    @Before
    public void setUp() {
        taxRateDiscriminator = new TaxRateDiscriminator();
    }

    public TaxRateDiscriminatorParameterizedTest(String description, BigDecimal expectedTaxRate) {
        this.description = description;
        this.expectedTaxRate = expectedTaxRate;
    }

    @Test
    public void should_create_a_product_with_tax_rate() {

        assertEquals(expectedTaxRate, taxRateDiscriminator.taxRate(description));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"book", BigDecimal.ZERO},
                {"apple", BigDecimal.ZERO},
                {"cache", BigDecimal.ZERO},
                {"milk", BigDecimal.ZERO},
                {"headache pills", BigDecimal.ZERO},
                {"bottle of perfume", TEN_CENTs},
                {"pen", TEN_CENTs},
                {"other", TEN_CENTs},
                {"imported other", new BigDecimal("0.15")},
                {"imported book", FIVE_CENTs}
        });
    }
}