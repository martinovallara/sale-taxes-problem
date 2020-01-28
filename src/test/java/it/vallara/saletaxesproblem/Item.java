package it.vallara.saletaxesproblem;

public class Item {
    private int count;

    public Item(String line) {
        count = Integer.parseInt(line.split(" ")[0]);
    }

    @Override
    public String toString() {
        return String.format("%d %s: %.2f", +
                        count(),
                description(),
                price());

    }

    public double price() {
        return 12.49 * count;
    }

    public int count() {
        return count;
    }

    public String description() {
        return "book";
    }
}
