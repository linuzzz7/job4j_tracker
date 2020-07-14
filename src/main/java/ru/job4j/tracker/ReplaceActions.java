package ru.job4j.tracker;

/**
 * Замена заявки
 */
public class ReplaceActions implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String textNew = input.askStr("Enter new text: ");
        Item itemNew = new Item(textNew);
        if (tracker.replace(id, itemNew)) {
            System.out.println("Замена произведена успешно");
        } else {
            System.out.println("Замена не произведена");
        }
        System.out.println("=======================");
        return true;
    }
}
