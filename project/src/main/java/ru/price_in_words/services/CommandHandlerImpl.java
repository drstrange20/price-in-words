package ru.price_in_words.services;

import ru.price_in_words.api.services.CommandHandler;
import ru.price_in_words.api.services.Currency;
import ru.price_in_words.api.services.IOService;
import ru.price_in_words.api.services.Parser;
import ru.price_in_words.domain.Number;
import ru.price_in_words.domain.Result;
import java.util.concurrent.atomic.AtomicBoolean;
import static java.util.Objects.isNull;

public class CommandHandlerImpl implements CommandHandler {
    private static final String EXIT_COMMAND = "exit";
    private final IOService ioService;
    private final Parser parser;

    public CommandHandlerImpl(IOService ioService, Parser parser) {
        this.ioService = ioService;
        this.parser = parser;
    }

    @Override
    public boolean handleExitCommand(String command, AtomicBoolean executionFlag) {
        if (!command.equalsIgnoreCase(EXIT_COMMAND)) {
            return false;
        }
        executionFlag.set(false);
        ioService.outputStr("Goodbye");
        return true;
    }

    @Override
    public void handlePriceInWordsCommand(String stringNumber) {
        Number number = parser.convertStringToInteger(stringNumber);
        if (isNull(number)) {
            ioService.outputStr("Неверно введена сумма");
            return;
        }
        Currency currency = parser.getWordByLastNumber(stringNumber);
        Result result = new Result(number, currency);
        ioService.outputStr(result.toString());
    }
}