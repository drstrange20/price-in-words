package ru.price_in_words.api.services;

import java.util.concurrent.atomic.AtomicBoolean;

public interface CommandHandler {
    boolean handleExitCommand(String command, AtomicBoolean executionFlag);
    void handlePriceInWordsCommand(String number);
}