package it.vallara.saletaxesproblem;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;

public class LineParserTest {
    LineParser parser;
    @Before
    public void setUp() {
        parser = new LineParser();
    }

    @Test
    public void should_parse_count_description_with_space_and_price() {
        //todo: Attezione "music CD" ha le tasse!
        Item item = parser.parse("1 music CD at 14.99");
        Item expectedItem = new Item(1, "music CD", 14.99);

        assertThat(expectedItem.toString(), Is.is(item.toString()));
    }

    @Test
    public void should_parse_count_two_digits_description_a_word_and_price() {
        Item item = parser.parse("10 music CD at 100.88");
        Item expectedItem = new Item(10, "music CD", 100.88);

        assertThat(expectedItem.toString(), Is.is(item.toString()));
    }
}
