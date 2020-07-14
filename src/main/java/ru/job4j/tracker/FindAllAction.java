package ru.job4j.tracker;

/**
 * Вывести все заявки
 */
public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find all items ====");
        Item[] findAllResult = tracker.findAll();
        for (int i = 0; i < findAllResult.length; i++) {
            System.out.println("Id: " + findAllResult[i].getId() + " Text: " + findAllResult[i].getName());
        }
        out.println("=======================");
        return true;
    }
}
