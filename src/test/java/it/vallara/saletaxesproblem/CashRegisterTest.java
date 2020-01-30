package it.vallara.saletaxesproblem;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CashRegisterTest {

    @Test
    public void should_print_receipt_without_taxes_for_a_book() {
        String input = "1 book at 10.00";

        String expected =
                "1 book: 10.00\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 10.00";

        CashRegister cash = new CashRegister();
        cash.AddItemLine(input);
        assertThat(cash.generateReceipt(), is(expected));
    }
}
