package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;

public class ReceiptTest {

    @Test
    public void should_build_empty_receipt_when_empty_items() {

        Receipt receipt = new Receipt(new ArrayList<Item>());
        String expected =
                "Sales Taxes: 0.00\n" +
                "Total: 0.00";

        assertThat(receipt.toString(), Is.is(expected));

    }
}