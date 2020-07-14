package ru.job4j.tracker;

/**
 * Поиск по имени заявки
 */
public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] result = tracker.findByName(name);
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                out.println(result[i].getId() + " " + result[i].getName());
            }
        } else {
            out.println("Заявок с таким именем нет");
        }
        out.println("=======================");
        return true;
    }
}
