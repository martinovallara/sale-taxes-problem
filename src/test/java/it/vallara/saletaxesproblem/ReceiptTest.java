package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.math.BigDecimal;

import static it.vallara.saletaxesproblem.ProductFactory.*;
import static it.vallara.saletaxesproblem.Receipt.*;
import static org.junit.Assert.assertThat;

public class ReceiptTest {



    @Test
    public void should_build_empty_receipt_when_empty_products() {
        Receipt receipt = buildReceipt();
        String expected =
                "Sales Taxes: 0.00\n" +
                        "Total: 0.00";

        assertThat(receipt.toString(), Is.is(expected));
    }

    @Test
    public void should_build_receipt_when_one_product() {
        Receipt receipt = buildReceipt();
        receipt.addProduct(buildProduct(1, "book", 12.49));
        String expected =
                "1 book: 12.49\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 12.49";

        assertThat(receipt.toString(), Is.is(expected));
    }

    @Test
    public void should_build_receipt_when_two_products() {
        Receipt receipt = buildReceipt();
        receipt.addProduct(buildProduct(2, "book", 12.49));
        String expected =
                "2 book: 24.98\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 24.98";

        assertThat(receipt.toString(), Is.is(expected));
    }

    @Test
    public void should_build_receipt_when_two_taxed_products() {
        Receipt receipt = buildReceipt();
        receipt.addProduct(buildFixedTaxedProduct(2, "music CD", 10.0, TEN_CENTs));
        String expected =
                "2 music CD: 22.00\n" +
                        "Sales Taxes: 2.00\n" +
                        "Total: 22.00";

        assertThat(receipt.toString(), Is.is(expected));
    }

    @Test
    public void should_build_receipt_whit_rounded_up_price_ad_taxes() {
        Receipt receipt = buildReceipt();
        receipt.addProduct(buildFixedTaxedProduct(1, "music CD", 0.01, BigDecimal.ONE));
        String expected =
                "1 music CD: 0.06\n" +
                        "Sales Taxes: 0.05\n" +
                        "Total: 0.06";

        assertThat(receipt.toString(), Is.is(expected));
    }
}
