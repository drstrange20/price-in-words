package ru.price_in_words.domain;

public class Rubles {
    private final String currencyName;
    public Rubles(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rubles rubles = (Rubles) o;

        return currencyName.equals(rubles.currencyName);
    }

    @Override
    public int hashCode() {
        return currencyName.hashCode();
    }

        @Override
    public String toString() {
        return currencyName;
    }
}