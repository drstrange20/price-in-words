package ru.price_in_words;

import ru.price_in_words.api.services.CommandHandler;
import ru.price_in_words.api.services.IOService;
import ru.price_in_words.api.services.Parser;
import ru.price_in_words.domain.CurrencyEndingsInWords;
import ru.price_in_words.services.ApplicationRunner;
import ru.price_in_words.services.CommandHandlerImpl;
import ru.price_in_words.services.ConsoleIOService;
import ru.price_in_words.services.ParserImpl;

public class Main {
    public static void main(String[] args) {
        IOService ioService = new ConsoleIOService();
        Parser parser =  new ParserImpl();
        CurrencyEndingsInWords instance = CurrencyEndingsInWords.RUB;
        CommandHandler commandHandler = new CommandHandlerImpl(ioService, parser, instance);
        ApplicationRunner applicationRunner = new ApplicationRunner(ioService, commandHandler);
        applicationRunner.run();
    }
}