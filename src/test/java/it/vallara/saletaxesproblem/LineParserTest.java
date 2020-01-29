package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class LineParserTest {
    @Test
    public void should_parse_count_description_with_space_and_price() {
        LineParser parser = new LineParser("1 music CD at 14.99");

        Item item = parser.parse();
        Item expectedItem = new Item(1, "music CD", 14.99);

        assertThat(expectedItem.toString(), Is.is(item.toString()));
    }

    @Test
    public void should_parse_count_two_digits_description_a_word_and_price() {
        LineParser parser = new LineParser("10 music CD at 100.88");

        Item item = parser.parse();
        Item expectedItem = new Item(10, "music CD", 100.88);

        assertThat(expectedItem.toString(), Is.is(item.toString()));
    }
}
