package ru.job4j.tracker;

/**
 * CreateAction - Создание новой заявки
 */
public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("=======================");
        return true;
    }
}
