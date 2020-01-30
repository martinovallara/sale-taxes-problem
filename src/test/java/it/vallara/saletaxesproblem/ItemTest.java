package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void totalPrice_should_be_equal_to_item_price_when_one_item() {
        Item item = new Item(1, "any desc", 5);

        assertThat(item.totalPrice(), Is.is(5.0));
    }


}