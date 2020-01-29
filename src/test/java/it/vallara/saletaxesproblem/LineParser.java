package it.vallara.saletaxesproblem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LineParser {

    private final int count;
    private final String description;
    private final double price;

    public LineParser(String line) {

        List<String> lineArgs = Arrays.asList( line.split(" "));
        count = Integer.parseInt(lineArgs.get(0));
        List<String> wordWithoutQuantity = new ArrayList(lineArgs.stream().skip(1).collect(Collectors.toList()));
        String itemWithoutQuantity = String.join(" ", wordWithoutQuantity);
        description = itemWithoutQuantity.split("at ")[0].trim();
        price = Double.parseDouble(line.split("at ")[1]);

    }

    public Item parse() {
        return new Item(count, description, price);
    }
}
