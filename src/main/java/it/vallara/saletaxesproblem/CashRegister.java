package it.vallara.saletaxesproblem;

public class CashRegister {
    private final LineParser lineParser;
    private final Receipt receipt;

    public static CashRegister CashRegisterFactory() {
        return new CashRegister(new Receipt(), new LineParser(new ProductFactory(new TaxRateDiscriminator())));
    }

    public CashRegister(Receipt receipt, LineParser lineParser) {
        this.lineParser = lineParser;
        this.receipt = receipt;
    }

    public void addProductLine(String productLine) {
        receipt.addProduct(lineParser.parse(productLine));
    }

    public String generateReceipt() {
        return receipt.toString();
    }
}
