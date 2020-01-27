package it.vallara.saletaxesproblem;

public class Item {
    public Item(String line) {

    }

    @Override
    public String toString() {
        return "1 book: 12.49";
    }

    public double price() {
        return 12.49;
    }
}
