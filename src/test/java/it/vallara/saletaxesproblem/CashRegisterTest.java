package it.vallara.saletaxesproblem;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CashRegisterTest {

    @Test
    public void should_print_receipt_for_product_without_taxes() {
        String input = "1 book at 10.00";

        String expected =
                "1 book: 10.00\n" +
                        "Sales Taxes: 0.00\n" +
                        "Total: 10.00";

        CashRegister cash = CashRegister.CashRegisterFactory();
        cash.addProductLine(input);
        assertThat(cash.generateReceipt(), is(expected));
    }

    @Test
    public void should_print_receipt_for_taxed_musicCD() {
        String input = "1 music CD at 10.00";

        String expected =
                "1 music CD: 11.00\n" +
                        "Sales Taxes: 1.00\n" +
                        "Total: 11.00";

        CashRegister cash = CashRegister.CashRegisterFactory();
        cash.addProductLine(input);
        assertThat(cash.generateReceipt(), is(expected));
    }

    @Test
    public void should_print_receipt_for_taxed_pen() {

        String input = "1 pen CD at 11.00";

        String expected =
                "1 pen CD: 12.10\n" +
                        "Sales Taxes: 1.10\n" +
                        "Total: 12.10";

        CashRegister cash = CashRegister.CashRegisterFactory();
        cash.addProductLine(input);
        assertThat(cash.generateReceipt(), is(expected));
    }
}
