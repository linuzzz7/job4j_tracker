package ru.job4j.tracker;

/**
 * Удаление заявки
 */
public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        if (tracker.delete(id)) {
            out.println("Удаление произведено успешно");
        } else {
            out.println("Удаление не произведено");
        }
        out.println("=======================");
        return true;
    }
}
