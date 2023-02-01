package ru.price_in_words.services;

import ru.price_in_words.api.services.CommandHandler;
import ru.price_in_words.api.services.IOService;
import ru.price_in_words.api.services.Parser;
import ru.price_in_words.domain.CurrencyEndingsInWords;
import ru.price_in_words.domain.Numbers;
import ru.price_in_words.domain.Result;
import ru.price_in_words.domain.Rubles;

import java.util.concurrent.atomic.AtomicBoolean;

public class CommandHandlerImpl implements CommandHandler {
    private static final String EXIT_COMMAND = "exit";
    private final IOService ioService;
    private final Parser parser;
    private final CurrencyEndingsInWords instance;

    public CommandHandlerImpl(IOService ioService, Parser parser, CurrencyEndingsInWords instance) {
        this.ioService = ioService;
        this.parser = parser;
        this.instance = instance;
    }

    @Override
    public boolean handleExitCommand(String command, AtomicBoolean executionFlag) {
        if (!command.equalsIgnoreCase(EXIT_COMMAND)) {
            return false;
        }
        executionFlag.set(false);
        ioService.outputStr("До свидания");
        return true;
    }

    @Override
    public void handlePriceInWordsCommand(String stringNumber) {
        Numbers number = parser.parseInt(stringNumber);
        if (number == null) {
            ioService.outputStr("Неверно введена сумма");
            return;
        }
        Rubles rubles = instance.getCurrencyEndingInWords(number.getNumbersLastDigit());
        Result result = new Result(number, rubles);
        ioService.outputStr(result.toString());
    }
}