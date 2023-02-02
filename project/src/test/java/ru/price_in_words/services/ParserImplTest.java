package ru.price_in_words.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.price_in_words.api.services.Parser;
import ru.price_in_words.domain.Numbers;


class ParserImplTest {

    @Test
    void parseLong() {
        Parser parser = new ParserImpl();

        Numbers actual = parser.parseLong("100");
        Numbers expected = new Numbers(100);
        Assertions.assertEquals(expected, actual);

        Numbers actual1 = parser.parseLong("-1");
        Assertions.assertNull(actual1);
    }
}