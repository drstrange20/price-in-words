package ru.price_in_words.api.services;

public interface CommandHandler {
    boolean handleExitCommand(String command, boolean isActive);
    void handlePriceInWordsCommand(String number);
}
