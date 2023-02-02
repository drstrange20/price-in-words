package ru.price_in_words.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.price_in_words.api.services.IOService;
import ru.price_in_words.api.services.Parser;
import ru.price_in_words.domain.CurrencyEndingsInWords;
import ru.price_in_words.domain.Numbers;
import ru.price_in_words.domain.Result;
import ru.price_in_words.domain.Rubles;

import java.util.concurrent.atomic.AtomicBoolean;


class CommandHandlerImplTest {
    @DisplayName("Проверка корректности добавления окончания валюты")
    @Test
    void handlePriceInWordsCommand() {
        IOService ioService = new ConsoleIOService();
        Parser parser = new ParserImpl();
        CurrencyEndingsInWords instance = CurrencyEndingsInWords.RUB;
        CommandHandlerImpl commandHandler = new CommandHandlerImpl(ioService, parser, instance);

        Result actual = commandHandler.handlePriceInWordsCommand("1");
        Result expected = new Result(new Numbers(1), new Rubles("рубль"));
        Assertions.assertEquals(expected, actual);

        Result actual1 = commandHandler.handlePriceInWordsCommand("22");
        Result expected1 = new Result(new Numbers(22), new Rubles("рубля"));
        Assertions.assertEquals(expected1, actual1);

        Result actual2 = commandHandler.handlePriceInWordsCommand("111");
        Result expected2 = new Result(new Numbers(111), new Rubles("рублей"));
        Assertions.assertEquals(expected2, actual2);
    }

    @DisplayName("Проверка корректного выхода из программы")
    @Test
    void handleExitCommand() {
        AtomicBoolean executionFlag = new AtomicBoolean(true);
        IOService ioService = new ConsoleIOService();
        Parser parser = new ParserImpl();
        CurrencyEndingsInWords instance = CurrencyEndingsInWords.RUB;
        CommandHandlerImpl commandHandler = new CommandHandlerImpl(ioService, parser, instance);

        boolean actual = commandHandler.handleExitCommand("exit", executionFlag);
        boolean expected = true;
        Assertions.assertEquals(expected, actual);

        boolean actual1 = commandHandler.handleExitCommand("5", executionFlag);
        boolean expected1 = false;
        Assertions.assertEquals(expected1, actual1);
    }
}