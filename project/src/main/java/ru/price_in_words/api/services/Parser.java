package ru.price_in_words.api.services;

import ru.price_in_words.domain.Numbers;

public interface Parser {
    Numbers parseInt(String stringNumber);
}