package ru.price_in_words.services;

import ru.price_in_words.api.services.Parser;
import ru.price_in_words.domain.Numbers;


public class ParserImpl implements Parser {
    @Override
    public Numbers parseLong(String stringNumber) {
        long number;
        try {
            number = Long.parseLong(stringNumber);
            if (number < 0) {
                throw new NumberFormatException();
            }
        } catch (NullPointerException | NumberFormatException e) {
            return null;
        }
        return new Numbers(number);
    }
}