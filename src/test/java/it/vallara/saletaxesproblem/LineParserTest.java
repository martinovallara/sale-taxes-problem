package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import static it.vallara.saletaxesproblem.ProductFactory.buildFixedTaxedProduct;
import static it.vallara.saletaxesproblem.ProductFactory.buildProduct;
import static org.junit.Assert.assertThat;

public class LineParserTest {

    LineParser parser;

    @Before
    public void setUp() {
        parser = new LineParser(new ProductFactory(new TaxCalculator()));
    }

    @Test
    public void should_parse_quantity_description_with_space_and_price() {
        Product product = parser.parse("1 book at 14.99");
        Product expectedProduct = buildProduct(1, "book", 14.99);

        assertThat(expectedProduct.toString(), Is.is(product.toString()));
    }

    @Test
    public void should_parse_quantity_two_digits_description_a_word_and_price() {
        Product product = parser.parse("10 book at 100.88");
        Product expectedProduct = buildProduct(10, "book", 100.88);

        assertThat(product.toString(), Is.is(expectedProduct.toString()));
    }


    //todo: questo testo dopo il refactoring ha ancora senso? testa un comportamento di un collaboratore dell'output della classe di test.
    //Può essere visto come un test di integrazione?
    @Test
    public void should_create_a_product_with_tax_rate() {
        Product product = parser.parse("10 music CD at 5");
        Product expectedProduct = buildFixedTaxedProduct(10, "music CD", 5.0, TaxCalculator.STANDARD_TAX_RATE);

        assertThat(product.toString(), Is.is(expectedProduct.toString()));
    }
}
