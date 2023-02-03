package ru.price_in_words.domain;

public enum CurrencyEndingsInWords {
    RUB(new String[]{"рубль", "рубля", "рублей"});

    private final String[] endings;

    CurrencyEndingsInWords(String[] endings) {
        this.endings = endings;
    }

    public Rubles getCurrencyEndingInWords(long lastDigit) {
        if(lastDigit == 1) {
            return new Rubles(endings[0]);
        } else if(lastDigit >= 2 && lastDigit <= 4) {
            return new Rubles(endings[1]);
        } else {
            return new Rubles(endings[2]);
        }
    }
}
