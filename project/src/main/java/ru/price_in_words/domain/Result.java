package ru.price_in_words.domain;

public class Result {
    private final Numbers number;
    private final Rubles rubles;

    public Result(Numbers number, Rubles currency) {
        this.number = number;
        this.rubles = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result result = (Result) o;

        if (!number.equals(result.number)) return false;
        return rubles.equals(result.rubles);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + rubles.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return number + " " + rubles;
    }
}