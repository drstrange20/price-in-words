package ru.price_in_words.domain;

public class Result {
    private final Numbers number;
    private final Rubles rubles;

    public Result(Numbers number, Rubles currency) {
        this.number = number;
        this.rubles = currency;
    }

    @Override
    public String toString() {
        return number + " " + rubles;
    }
}