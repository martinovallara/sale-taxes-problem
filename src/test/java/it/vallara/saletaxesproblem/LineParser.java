package it.vallara.saletaxesproblem;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LineParser {


    public Product parse(String line)
    {
        List<String> lineArgs = Arrays.asList( line.split(" "));
        int quantity = Integer.parseInt(lineArgs.get(0));
        List<String> wordWithoutQuantity = new ArrayList(lineArgs.stream().skip(1).collect(Collectors.toList()));
        String productWithoutQuantity = String.join(" ", wordWithoutQuantity);
        String description = productWithoutQuantity.split("at ")[0].trim();
        double price = Double.parseDouble(line.split("at ")[1]);

        return new Product(quantity, description, price);
    }
}
