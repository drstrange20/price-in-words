package ru.price_in_words.services;

//        Все что заканчивается на 1, кроме 111, 211, 311... рубль
//        10-20, 110-120, 210-220 и 5-10, 25-30, 35-40 рублей
//        Все что на 2, 3 и 4 рубля


import ru.price_in_words.api.services.CommandHandler;
import ru.price_in_words.api.services.IOService;

public class ApplicationRunner {
    private final IOService ioService;
    private final CommandHandler commandHandler;
    public static boolean isActive = true;

    public ApplicationRunner(IOService ioService,
                             CommandHandler commandHandler) {
        this.ioService = ioService;
        this.commandHandler = commandHandler;
    }

    public void run() {
        while (isActive) {
            String commandOrNumber = showPrompt();
            if (!commandHandler.handleExitCommand(commandOrNumber, isActive)) {
                commandHandler.handlePriceInWordsCommand(commandOrNumber);
            }
        }
    }
    private String showPrompt() {
        return ioService.readString("Введите сумму для конвертации или команду exit");
    }
}