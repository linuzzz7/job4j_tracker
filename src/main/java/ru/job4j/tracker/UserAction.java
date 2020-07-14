package ru.job4j.tracker;

/**
 * Интерфейс, который описывает все действия системы
 */
public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
