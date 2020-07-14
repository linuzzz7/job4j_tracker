package ru.job4j.tracker;

/**
 * Удаление заявки
 */
public class DeleteActions implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            System.out.println("Удаление произведено успешно");
        } else {
            System.out.println("Удаление не произведено");
        }
        System.out.println("=======================");
        return true;
    }
}
