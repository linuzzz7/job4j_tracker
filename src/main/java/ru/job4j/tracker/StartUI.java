package ru.job4j.tracker;

/**
 * StartIU - действия с заявками, добавление, уделение, поиск...
 * @author Zukov Alexander
 * @version 1
 */
public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    /**
     * @param input   - принимает ввод с клавиатуры
     * @param tracker - создание объекта
     * @param actions - массив с действиями
     */
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = Integer.parseInt(input.askStr("Select: "));
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    /**
     * Метод показа пунктов меню
     */
    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindAllAction(output),
                new ReplaceAction(output),
                new DeleteAction(output),
                new FindIdAction(output),
                new FindByNameAction(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}