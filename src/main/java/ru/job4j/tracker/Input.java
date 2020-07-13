package ru.job4j.tracker;

/**
 * Интерфейс на замену Scanner
 */
public interface Input {
    String askStr(String question);

    int askInt(String question);
}
