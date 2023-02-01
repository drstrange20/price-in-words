package ru.price_in_words.services;

import ru.price_in_words.api.services.Parser;
import ru.price_in_words.domain.Rubles;

import static java.lang.Integer.parseInt;

public class ParserImpl implements Parser {
    @Override
    public Rubles getWordByLastNumber(String stringNumber) {
        String currencyName;
        String[] arr = stringNumber.split("");
        if (arr.length == 1) {
            currencyName = getWordByLastNumberForOneDigit(arr);
        } else {
            currencyName = getWordByLastNumberForMoreThanOneDigit(arr);
        }
        return new Rubles(currencyName);
    }

    public String getWordByLastNumberForMoreThanOneDigit(String[] arr) {
        if (parseInt(arr[arr.length - 1]) == 1 && parseInt(arr[arr.length - 2]) != 1) {
            return "рубль";
        } else if ((parseInt(arr[arr.length - 1]) >= 2 && parseInt(arr[arr.length - 1]) < 5) && (parseInt(arr[arr.length - 2]) != 1)) {
            return "рубля";
        }
        return "рублей";
    }

    public String getWordByLastNumberForOneDigit(String[] arr) {
        if (parseInt(arr[0]) == 1) {
            return "рубль";
        } else if (parseInt(arr[0]) > 1 && parseInt(arr[0]) < 5) {
            return "рубля";
        }
        return "рублей";
    }
}