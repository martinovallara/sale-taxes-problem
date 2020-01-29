package it.vallara.saletaxesproblem;

public class Item {
    private int count;
    private double price;
    private String description;

    public Item(int count, String description, double price) {
        this.count = count;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%d %s: %.2f", +
                        count(),
                description(),
                totalPrice());
    }

    public double totalPrice() {
        return price * count;
    }

    public int count() {
        return count;
    }

    public String description() {
        return description;
    }
}
