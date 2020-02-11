package it.vallara.saletaxesproblem;

import org.junit.Ignore;
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

    @Test
    public void should_print_receipt_for_imported_product() {

        String input = "1 imported book at 10.00";

        String expected =
                "1 imported book: 10.50\n" +
                        "Sales Taxes: 0.50\n" +
                        "Total: 10.50";

        CashRegister cash = CashRegister.CashRegisterFactory();
        cash.addProductLine(input);
        assertThat(cash.generateReceipt(), is(expected));
    }

    @Test
    public void should_print_receipt_with_price_and_taxes_rounded_up() {

        String input = "1 taxed product at 10.01";

        String expected =
                "1 taxed product: 11.06\n" +
                        "Sales Taxes: 1.05\n" +
                        "Total: 11.06";

        CashRegister cash = CashRegister.CashRegisterFactory();
        cash.addProductLine(input);
        assertThat(cash.generateReceipt(), is(expected));
    }

}
