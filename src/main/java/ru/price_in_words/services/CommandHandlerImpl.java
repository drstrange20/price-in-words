package ru.price_in_words.services;

import ru.price_in_words.api.services.CommandHandler;
import ru.price_in_words.api.services.IOService;

public class CommandHandlerImpl implements CommandHandler {
    private static final String EXIT_COMMAND = "exit";
    private final IOService ioService;

    public CommandHandlerImpl(IOService ioService) {
        this.ioService = ioService;
    }

    @Override
    public boolean handleExitCommand(String command, boolean isActive) {
        if (!command.equalsIgnoreCase(EXIT_COMMAND)) {
            return false;
        }
        isActive = false;
        ioService.outputStr("До свидания");
        return true;
    }

    @Override
    public void handlePriceInWordsCommand(String number) {

    }
}
