package ru.price_in_words.services;


import ru.price_in_words.api.services.CommandHandler;
import ru.price_in_words.api.services.IOService;
import ru.price_in_words.domain.Result;

import java.util.concurrent.atomic.AtomicBoolean;

public class ApplicationRunner {
    private final IOService ioService;
    private final CommandHandler commandHandler;

    public ApplicationRunner(IOService ioService,
                             CommandHandler commandHandler) {
        this.ioService = ioService;
        this.commandHandler = commandHandler;
    }

    public void run() {
        AtomicBoolean executionFlag = new AtomicBoolean(true);

        while (executionFlag.get()) {
            String commandOrNumber = showPromptAndReadCommand();
            if (!commandHandler.handleExitCommand(commandOrNumber, executionFlag)) {
                Result result = commandHandler.handlePriceInWordsCommand(commandOrNumber);
                if (result == null) {
                    run();
                } else {
                    ioService.outputToStr(result);
                }
            }
        }
    }
    private String showPromptAndReadCommand() {
        return ioService.readString("Введите положительное число или команду exit");
    }
}