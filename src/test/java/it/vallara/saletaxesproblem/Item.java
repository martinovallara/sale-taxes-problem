package it.vallara.saletaxesproblem;

public class Item {
    private int count;
    private double price;
    private String description;

    public Item(String line) {
        String[] lineArgs = line.split(" ");
        count = Integer.parseInt(lineArgs[0]);
        description = lineArgs[1].split("at ")[0];
        price = Double.parseDouble(line.split("at ")[1]);
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
