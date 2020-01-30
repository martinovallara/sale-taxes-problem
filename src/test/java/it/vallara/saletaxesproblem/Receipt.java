package it.vallara.saletaxesproblem;

import java.util.ArrayList;

public class Receipt {

    private final ArrayList<Item> items;

    public Receipt() {
        this.items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public java.lang.String toString() {
        StringBuilder itemsSummary = new StringBuilder();
        String summary;

        items.stream().forEach(i -> itemsSummary.append(i.toString() + "\n"));

        summary = String.format("Sales Taxes: 0.00\n" +
                "Total: %.2f", items.stream()
                .map(i -> i.totalPrice())
                .reduce(0.0, Double::sum));

        itemsSummary.append(summary);
        return itemsSummary.toString();
    }


}
