package ru.job4j.tracker;

/**
 * Поиск по номеру заявки
 */
public class FindIdActions implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item result = tracker.findById(id);
        if (result != null) {
            System.out.println(result.getId() + " " + result.getName());
        } else {
            System.out.println("По данному id ничего не найдено");
        }
        System.out.println("=======================");
        return true;
    }
}
