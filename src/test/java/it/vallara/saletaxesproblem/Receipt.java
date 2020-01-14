package it.vallara.saletaxesproblem;

import java.util.ArrayList;

public class Receipt {

    private final ArrayList<Item> items;

    public Receipt(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Sales Taxes: 0.00\n" +
                "Total: 0.00";
    }
}
