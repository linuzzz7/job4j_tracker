package ru.job4j.tracker;

/**
 * Поиск по номеру заявки
 */
public class FindIdAction implements UserAction {
    private final Output out;

    public FindIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Id ====");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item result = tracker.findById(id);
        if (result != null) {
            out.println(result.getId() + " " + result.getName());
        } else {
            out.println("По данному id ничего не найдено");
        }
        out.println("=======================");
        return true;
    }
}
