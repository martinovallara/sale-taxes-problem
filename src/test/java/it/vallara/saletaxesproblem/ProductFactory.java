package it.vallara.saletaxesproblem;

import java.util.Arrays;
import java.util.List;

public class ProductFactory {
    public static final double STANDARD_TAX_RATE = 0.1;
    private List<String> taxfreeProducts;

    public ProductFactory() {
        taxfreeProducts = Arrays.asList(new String[]{
                "book",
                "apple",
                "cache",
                "milk",
                "headache pills"
        });
    }

    public Product build(int quantity, String description, double price) {
        if (isTaxFree(description)) //todo: non mi piace. Preferirei if product.isTaxFree(). Forse che questa logica possa stare dentro al product?
            return new Product(quantity, description, price);
      return  new Product(quantity, description, price, STANDARD_TAX_RATE);
    }

    private boolean isTaxFree(String description) {
        return taxfreeProducts.contains(description);
    }
}
