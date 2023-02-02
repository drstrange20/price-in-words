package ru.price_in_words.domain;


public class Numbers {
    private final long number;

    public Numbers(long number) {
        this.number = number;
    }

    public long getNumbersLastDigit() {
        if (number % 100 > 10 && number % 100 < 20) {
            return 5;
        } else {
            return number % 10;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Numbers numbers = (Numbers) o;

        return number == numbers.number;
    }

    @Override
    public int hashCode() {
        return (int) (number ^ (number >>> 32));
    }

        @Override
    public String toString() {
        return String.valueOf(number);
    }
}