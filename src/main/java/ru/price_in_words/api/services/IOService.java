package ru.price_in_words.api.services;

public interface IOService {
    void outputStr(String s);
    String readString();
    String readString(String prompt);
}
