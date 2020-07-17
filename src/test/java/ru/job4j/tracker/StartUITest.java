package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        Output output = new ConsoleOutput();
        UserAction[] actions = {
                new ReplaceAction(output),
                new Exit(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }


    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        Output out = new ConsoleOutput();
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. ==== Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );

        UserAction[] actions = {
                new FindAllAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find all items ====" + System.lineSeparator() +
                        "1. ==== Exit Program ====" + System.lineSeparator() +
                        "=== Find all items ====" + System.lineSeparator() +
                        "=======================" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find all items ====" + System.lineSeparator() +
                        "1. ==== Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByNameAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Alex"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", item.getName(), "1"}
        );
        UserAction[] actions = {
                new FindByNameAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find items by name ====" + System.lineSeparator() +
                        "1. ==== Exit Program ====" + System.lineSeparator() +
                        "=== Find items by name ====" + System.lineSeparator() +
                        "1 Alex" + System.lineSeparator() +
                        "=======================" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find items by name ====" + System.lineSeparator() +
                        "1. ==== Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test id search"));
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new FindIdAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find item by Id ====" + System.lineSeparator() +
                        "1. ==== Exit Program ====" + System.lineSeparator() +
                        "=== Find item by Id ====" + System.lineSeparator() +
                        "1 test id search" + System.lineSeparator() +
                        "=======================" + System.lineSeparator() +
                        "Menu." + System.lineSeparator() +
                        "0. === Find item by Id ====" + System.lineSeparator() +
                        "1. ==== Exit Program ====" + System.lineSeparator()
        ));
    }
}