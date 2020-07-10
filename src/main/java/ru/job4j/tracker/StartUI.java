package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item item1 = new Item("Alex");
        Item item2 = new Item("John");
        Tracker tracker = new Tracker();
        tracker.add(item1);
        tracker.add(item2);
        System.out.println("---Find by id - item1---");
        System.out.println(tracker.findById(item1.getId()).getName());
        System.out.println(System.lineSeparator() + "---Find by Name Alex---");
        Item[] findByNameMass = tracker.findByName("Alex");
        for (int i = 0; i < findByNameMass.length; i++) {
            System.out.println(findByNameMass[i].getId() + " " + findByNameMass[i].getName());
        }
        System.out.println(System.lineSeparator() + "---Find All---");
        Item[] findAllMass = tracker.findAll();
        for (int i = 0; i < findAllMass.length; i++) {
            System.out.println(findAllMass[i].getId() + " " + findAllMass[i].getName());
        }
    }
}
