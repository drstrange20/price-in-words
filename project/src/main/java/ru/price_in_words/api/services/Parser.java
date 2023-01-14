package ru.price_in_words.api.services;

import ru.price_in_words.domain.Number;
import ru.price_in_words.domain.Rubles;

public interface Parser {
    default Number convertStringToInteger(String stringNumber) {
        return new Number(Integer.parseInt(stringNumber));
    }
    Rubles getWordByLastNumber(String stringNumber);
}