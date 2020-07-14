package ru.job4j.tracker;

/**
 * Поиск по имени заявки
 */
public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] result = tracker.findByName(name);
        if (result.length > 0) {
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i].getId() + " " + result[i].getName());
            }
        } else {
            System.out.println("Заявок с таким именем нет");
        }
        System.out.println("=======================");
        return true;
    }
}
