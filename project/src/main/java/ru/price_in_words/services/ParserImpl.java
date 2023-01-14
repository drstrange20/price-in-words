package ru.price_in_words.services;

import ru.price_in_words.api.services.Parser;
import ru.price_in_words.domain.Number;
import ru.price_in_words.domain.Rubles;

public class ParserImpl implements Parser {
    @Override
    public Number convertStringToInteger(String stringNumber) {
        return Parser.super.convertStringToInteger(stringNumber);
    }

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
        if (Integer.parseInt(arr[arr.length - 1]) == 1 && Integer.parseInt(arr[arr.length - 2]) != 1) {
            return "рубль";
        } else if ((Integer.parseInt(arr[arr.length - 1]) >= 2 && Integer.parseInt(arr[arr.length - 1]) < 5) && (Integer.parseInt(arr[arr.length - 2]) != 1)) {
            return "рубля";
        }
        return "рублей";
    }

    public String getWordByLastNumberForOneDigit(String[] arr) {
        if (Integer.parseInt(arr[0]) == 1) {
            return "рубль";
        } else if (Integer.parseInt(arr[0]) > 1 && Integer.parseInt(arr[0]) < 5) {
            return "рубля";
        }
        return "рублей";
    }
}