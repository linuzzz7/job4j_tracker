package ru.job4j.tracker;

/**
 * Выход из программы
 */
public class Exit implements UserAction {
    @Override
    public String name() {
        return "==== Exit Program ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}
