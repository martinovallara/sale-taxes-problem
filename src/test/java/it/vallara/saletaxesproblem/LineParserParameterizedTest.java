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
public class LineParserParameterizedTest {

    private final String product;
    private final Double expectedTaxRate;
    LineParser parser;

    @Before
    public void setUp() {
        parser = new LineParser(new ProductFactory());
    }

    public LineParserParameterizedTest(String product, Double expectedTaxRate) {

        this.product = product;
        this.expectedTaxRate = expectedTaxRate;
    }

    @Test
    public void should_create_a_product_with_tax_rate() {
        Product product = parser.parse("10 " + this.product + " at 5");
        Product expectedProduct = new Product(10, this.product, 5.0, this.expectedTaxRate);

        assertThat(product.toString(), Is.is(expectedProduct.toString()));
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