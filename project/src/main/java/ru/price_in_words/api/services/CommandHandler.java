package ru.price_in_words.api.services;

import ru.price_in_words.domain.Result;

import java.util.concurrent.atomic.AtomicBoolean;

public interface CommandHandler {
    boolean handleExitCommand(String command, AtomicBoolean executionFlag);
    Result handlePriceInWordsCommand(String number);
}