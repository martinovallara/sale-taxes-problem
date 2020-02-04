package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void totalPrice_should_be_product_price_when_one_quantity() {
        Product product = BuildTaxFreeProduct(1, "any desc", 5);;
        assertThat(product.totalPrice(), Is.is(5.0));
    }

    @Test
    public void totalPrice_should_be_twice_the_product_price_when_two_quantities() {
        Product product = BuildTaxFreeProduct(2, "any desc", 5);
        assertThat(product.totalPrice(), Is.is(10.0));
    }

    @Test
    public void totalPrice_should_include_taxes_for_one_quantity_of_taxed_product() {
        Product product = BuildFixedTaxedProduct(1, "any desc", 5, 0.5);
        assertThat(product.totalPrice(), Is.is(5.5));
    }

    @Test
    public void totalPrice_should_include_taxes_for_two_quantities_of_taxed_product() {
        Product product = BuildTaxedProduct(2, "any desc", 5);
        assertThat(product.totalPrice(), Is.is(11.0));
    }

    public static Product BuildTaxedProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxCalculator());
    }

    public static Product BuildTaxFreeProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxFreeCalculator());
    }

    public static Product BuildProduct(int quantity, String description, double price) {
        return new Product(quantity, description, price, new TaxFreeCalculator());
    }

    public static Product BuildFixedTaxedProduct(int quantity, String description, double price, double taxRate) {
        return new Product(quantity, description, price, new ConstantTaxCalculator(taxRate));
    }
}