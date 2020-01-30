package it.vallara.saletaxesproblem;

public class CashRegister {
    private final LineParser lineParser;
    private final Receipt receipt;

    public CashRegister() {
        lineParser = new LineParser();
        receipt = new Receipt();
    }

    public void addProductLine(String productLine) {
        receipt.addProduct(lineParser.parse(productLine));
    }

    public String generateReceipt() {
        return receipt.toString();
    }
}
