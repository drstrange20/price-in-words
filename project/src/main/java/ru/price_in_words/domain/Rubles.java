package ru.price_in_words.domain;

public class Rubles {
    private final String currencyName;
    public Rubles(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public String toString() {
        return currencyName;
    }
}