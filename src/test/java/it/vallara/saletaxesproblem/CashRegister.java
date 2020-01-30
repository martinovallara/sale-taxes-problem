package it.vallara.saletaxesproblem;

import java.util.ArrayList;

public class CashRegister {
    private final LineParser lineParser;
    private final Receipt receipt;

    public CashRegister() {
        lineParser = new LineParser();
        receipt = new Receipt();
    }

    public void AddItemLine(String itemLine) {
        receipt.addItem(lineParser.parse(itemLine));
    }

    public String generateReceipt() {
        return receipt.toString();
    }
}
