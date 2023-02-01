package ru.price_in_words.api.services;

public interface IOService {
    void outputStr(String s);
    String readString();
    void outputToStr(Object o);
    String readString(String prompt);
}
