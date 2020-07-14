package ru.job4j.tracker;

/**
 * Вывести все заявки
 */
public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Find all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] findAllResult = tracker.findAll();
        for (int i = 0; i < findAllResult.length; i++) {
            System.out.println("Id: " + findAllResult[i].getId() + " Text: " + findAllResult[i].getName());
        }
        System.out.println("=======================");
        return true;
    }
}
