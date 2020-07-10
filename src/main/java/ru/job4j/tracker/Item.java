package ru.job4j.tracker;
/**
 * Item - Класс Item описывает модель заявки
 * @author Zukov Alexander
 * @version 0.1
 */
public class Item {
    /**
     * Поле id - это уникальный номер заявки.
     * Поле name содержит название заявки.
     */
    private int id;
    private String name;

    /**
     * Конструктор принимающий имя заявки
     * @param name - имя заявки
     */
    public Item(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}