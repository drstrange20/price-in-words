package ru.price_in_words;

import ru.price_in_words.api.services.CommandHandler;
import ru.price_in_words.api.services.IOService;
import ru.price_in_words.services.ApplicationRunner;
import ru.price_in_words.services.CommandHandlerImpl;
import ru.price_in_words.services.ConsoleIOService;

//Цена прописью.
//Надо запрограммировать программу, которая считывает с консоли число и выводит это значение прописью
//с добавлением «рублей».
//Например.
//Ввод с консоли: 5
//Вывод программы: 5 рублей
//Ввод с консоли: 3
//Вывод программы: 3 рубля
//Ввод с консоли: 45
//Вывод программы: 45 рублей.
//Надо не забыть написать тесты.
//Т.е. основная часть программы должна быть написана так, чтобы можно было легко передать значение,
//полученное из консоли или из тестовых данных.
//Помните, что тесты – это важная и обязательная часть работы.
//Программа должна быть написана так, чтобы добавление другой валюты не привело к переписыванию
//всего приложения "с нуля".

public class Main {
    public static void main(String[] args) {
        IOService ioService = new ConsoleIOService();
        CommandHandler commandHandler = new CommandHandlerImpl(ioService);
        ApplicationRunner applicationRunner = new ApplicationRunner(ioService, commandHandler);
        applicationRunner.run();
    }
}