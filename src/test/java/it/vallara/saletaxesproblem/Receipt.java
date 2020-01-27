package it.vallara.saletaxesproblem;

import java.util.ArrayList;

public class Receipt {

    private final ArrayList<Item> items;

    public Receipt(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        String itemsSummary = "";
        String summary;
        if (!items.isEmpty()) {
            itemsSummary = items.get(0).toString();
            summary = String.format("Sales Taxes: 0.00\n" +
                    "Total: %.2f", items.get(0).price());
        } else {

            summary = String.format("Sales Taxes: 0.00\n" +
                    "Total: %.2f", 0.0);
        }

        return itemsSummary + summary;
    }
}
