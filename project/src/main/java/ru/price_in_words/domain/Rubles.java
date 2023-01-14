package ru.price_in_words.domain;

import ru.price_in_words.api.services.Currency;
public class Rubles implements Currency {
    private final String currencyName;
    public Rubles(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public String toString() {
        return currencyName;
    }
}