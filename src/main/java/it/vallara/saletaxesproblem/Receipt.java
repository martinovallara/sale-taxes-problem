package it.vallara.saletaxesproblem;

import java.util.ArrayList;

public class Receipt {

    private final ArrayList<Product> products;

    public Receipt() {
        this.products = new ArrayList<Product>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public java.lang.String toString() {
        StringBuilder productsSummary = new StringBuilder();
        String summary;

        products.stream().forEach(i -> productsSummary.append(i.toString() + "\n"));

        summary = String.format("Sales Taxes: %.2f\n" +
                        "Total: %.2f",
                products.stream()
                        .map(p -> p.totalTaxes())
                        .reduce(0.0, Double::sum),
                products.stream()
                        .map(i -> i.totalPrice())
                        .reduce(0.0, Double::sum));

        productsSummary.append(summary);
        return productsSummary.toString();
    }


}
