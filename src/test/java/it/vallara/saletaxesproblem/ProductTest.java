package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void totalPrice_should_be_product_price_when_one_quantity() {
        Product product = new Product(1, "any desc", 5);

        assertThat(product.totalPrice(), Is.is(5.0));
    }

    @Test
    public void totalPrice_should_be_twice_the_product_price_when_two_quantities() {
        Product product = new Product(2, "any desc", 5);

        assertThat(product.totalPrice(), Is.is(10.0));
    }
}