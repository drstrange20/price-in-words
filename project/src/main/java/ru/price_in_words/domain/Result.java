package ru.price_in_words.domain;

import ru.price_in_words.api.services.Currency;

public class Result {
    private final Number number;
    private final Currency currency;

    public Result(Number number, Currency currency) {
        this.number = number;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return number + " " + currency;
    }
}