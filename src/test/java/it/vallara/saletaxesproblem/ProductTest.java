package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void totalPrice_should_be_product_price_when_one_quantity() {
        Product product = ProductFactory.buildTaxFreeProduct(1, "any desc", 5);;
        assertThat(product.totalPrice(), Is.is(5.0));
    }

    @Test
    public void totalPrice_should_be_twice_the_product_price_when_two_quantities() {
        Product product = ProductFactory.buildTaxFreeProduct(2, "any desc", 5);
        assertThat(product.totalPrice(), Is.is(10.0));
    }

    @Test
    public void totalPrice_should_include_taxes_for_one_quantity_of_taxed_product() {
        Product product = ProductFactory.buildFixedTaxedProduct(1, "any desc", 5, 0.5);
        assertThat(product.totalPrice(), Is.is(5.5));
    }

    @Test
    public void totalPrice_should_include_taxes_for_two_quantities_of_taxed_product() {
        Product product = ProductFactory.buildTaxedProduct(2, "any desc", 5);
        assertThat(product.totalPrice(), Is.is(11.0));
    }

}