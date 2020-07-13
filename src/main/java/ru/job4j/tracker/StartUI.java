package ru.job4j.tracker;

/**
 * StartIU - действия с заявками, добавление, уделение, поиск...
 *
 * @author Zukov Alexander
 * @version 1
 */
public class StartUI {

    /**
     * @param input - принимает ввод с клавиатуры
     * @param tracker - создание объекта
     */
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt(input.askStr(""));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name =  input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] findAllResult = tracker.findAll();
                for (int i = 0; i < findAllResult.length; i++) {
                    System.out.println("Id: " + findAllResult[i].getId() + " Text: " + findAllResult[i].getName());
                }
                System.out.println("=======================");
            } else if (select == 2) {
                System.out.println("=== Edit item ====");
                int id = Integer.parseInt( input.askStr("Enter id: "));
                String textNew =  input.askStr("Enter new text: ");
                Item itemNew = new Item(textNew);
                if (tracker.replace(id, itemNew)) {
                    System.out.println("Замена произведена успешно");
                } else {
                    System.out.println("Замена не произведена");
                }
                System.out.println("=======================");
            } else if (select == 3) {
                System.out.println("=== Delete item  ====");
                int id = Integer.parseInt( input.askStr("Enter id: "));
                if (tracker.delete(id)) {
                    System.out.println("Удаление произведено успешно");
                } else {
                    System.out.println("Удаление не произведено");
                }
                tracker.delete(id);
                System.out.println("=======================");
            } else if (select == 4) {
                System.out.println("=== Find item by Id  ====");
                int id = Integer.parseInt( input.askStr("Enter id: "));
                Item result = tracker.findById(id);
                if (result != null) {
                    System.out.println(result.getId() + " " + result.getName());
                } else {
                    System.out.println("По данному id ничего не найдено");
                }
                System.out.println("=======================");
            } else if (select == 5) {
                System.out.println("=== Find items by name  ====");
                String name =  input.askStr("Enter name: ");
                Item[] result = tracker.findByName(name);
                if (result.length > 0) {
                    for (int i = 0; i < result.length; i++) {
                        System.out.println(result[i].getId() + " " + result[i].getName());
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
                System.out.println("=======================");
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Вы ввели не верный пункт меню, повторите ввод" +
                        System.lineSeparator() + "=======================");
            }
        }
    }

    /**
     * Метод показа пунктов меню
     */
    private void showMenu() {
        System.out.println("Menu." + System.lineSeparator() +
                "0. Add new Item" + System.lineSeparator() +
                "1. Show all items" + System.lineSeparator() +
                "2. Edit item " + System.lineSeparator() +
                "3. Delete item" + System.lineSeparator() +
                "4. Find item by Id " + System.lineSeparator() +
                "5. Find items by name" + System.lineSeparator() +
                "6. Exit Program" + System.lineSeparator() +
                "Select:");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}