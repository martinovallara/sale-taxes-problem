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

    @Test
    public void should_build_receipt_when_one_item() {

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(1, "book", 12.49));
        Receipt receipt = new Receipt(items);

        String expected =
                "1 book: 12.49\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 12.49";

        assertThat(receipt.toString(), Is.is(expected));

    }

    @Test
    public void should_build_receipt_when_two_item() {

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(2, "book", 12.49));
        Receipt receipt = new Receipt(items);

        String expected =
                "2 book: 24.98\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 24.98";

        assertThat(receipt.toString(), Is.is(expected));

    }
}
