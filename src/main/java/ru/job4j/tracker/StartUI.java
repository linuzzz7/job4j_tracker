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
            try {
                int select = Integer.parseInt(input.askStr("Select: "));
                if (select < 0 || select >= actions.length) {
                    out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                    continue;
                }
                UserAction action = actions[select];
                run = action.execute(input, tracker);
            } catch (NumberFormatException e) {
                out.println("Wrong input, you can select Number: 0 .. " + (actions.length - 1));
                continue;
            }
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
        Input input = new ValidateInput();
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