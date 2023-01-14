package ru.price_in_words.domain;


public class Number {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}