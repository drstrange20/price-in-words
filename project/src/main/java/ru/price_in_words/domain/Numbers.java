package ru.price_in_words.domain;


public class Numbers {
    private final int number;

    public Numbers(int number) {
        this.number = number;
    }

    public int getNumbersLastDigit() {
        if (number % 100 > 10 && number % 100 < 20) {
            return 5;
        } else {
            return number % 10;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}