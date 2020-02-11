package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.math.BigDecimal;

import static it.vallara.saletaxesproblem.Receipt.FIVE_CENTs;
import static it.vallara.saletaxesproblem.Receipt.TEN_CENTs;
import static org.junit.Assert.*;

public class ProductTest {


    @Test
    public void totalPrice_should_be_product_price_when_one_quantity() {
        Product product = ProductFactory.buildTaxFreeProduct(1, "any desc", 5);
        assertThat(product.totalPrice(), Is.is(5.0));
    }

    @Test
    public void totalPrice_should_be_twice_the_product_price_when_two_quantities() {
        Product product = ProductFactory.buildTaxFreeProduct(2, "any desc", 5);
        assertThat(product.totalPrice(), Is.is(10.0));
    }

    @Test
    public void totalPrice_should_include_taxes_for_one_quantity_of_taxed_product() {
        Product product = ProductFactory.buildFixedTaxedProduct(1, "any desc", 5, TEN_CENTs);
        assertThat(product.totalPrice(), Is.is(5.5));
    }

    @Test
    public void totalPrice_should_include_taxes_for_two_quantities_of_taxed_product() {
        Product product = ProductFactory.buildFixedTaxedProduct(2, "any desc", 5, TEN_CENTs);
        assertThat(product.totalPrice(), Is.is(11.0));
    }

    @Test
    public void total_tax_should_rounded_up_total_price_at_5_cent() {
        Product product = ProductFactory.buildFixedTaxedProduct(1, "any desc", 0.01, BigDecimal.ONE);
        assertEquals(FIVE_CENTs, product.totalTaxes());
    }

    @Test
    public void the_value_should_be_rounded_up_at_nearest_5_cent_up() {
        assertEquals(FIVE_CENTs, Product.roundUp(new BigDecimal("0.02")));
    }

    @Test
    public void the_value_should_be_rounded_up_at_nearest_5_cent() {
        assertEquals(FIVE_CENTs, Product.roundUp(FIVE_CENTs));
    }

    @Test
    public void the_value_should_be_rounded_up_at_nearest_5_cent_up_2() {
        assertEquals(new BigDecimal("0.15"), Product.roundUp(new BigDecimal("0.12")));
    }
}