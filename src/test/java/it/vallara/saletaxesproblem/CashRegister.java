package it.vallara.saletaxesproblem;

import java.util.ArrayList;

public class CashRegister {

    public Receipt generateReceipt(String input) {
        return new Receipt(new ArrayList<Item>());
    }
}
