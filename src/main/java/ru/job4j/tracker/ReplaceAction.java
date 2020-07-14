package ru.job4j.tracker;

/**
 * Замена заявки
 */
public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String textNew = input.askStr("Enter new text: ");
        Item itemNew = new Item(textNew);
        if (tracker.replace(id, itemNew)) {
            out.println("Замена произведена успешно");
        } else {
            out.println("Замена не произведена");
        }
        out.println("=======================");
        return true;
    }
}
