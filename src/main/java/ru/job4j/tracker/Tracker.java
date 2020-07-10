package ru.job4j.tracker;

import java.util.Arrays;
/**
 * Tracker - действия с заявками, добавление, уделение, поиск...
 * @author Zukov Alexander
 * @version 0.1
 */
public class Tracker {
    /**
     * items - массив заявок, 100 элементов
     * ids - ключ(счетчик), увеличивается на 1 при добавлении новой
     * size - размер нового массива, реальное кол-во внесенных заявок
     */
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    /**
     * add - добавление новой заявки
     * @param item - добавляет заявку, переданную в аргументах в массив заявок items
     * @return - возвращает созданную заявку
     */
    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }
    /**
     * findById - поиск заявки по id
     * @param id - номер для поиска заявки
     * @return - возврщает заявку, или null
     */
    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
    /**
     * findAll - получение списка всех заявок, создаем новый массив с длиной size
     * копируем в него все не null объекты, и обрезаем его, на указанный размер size
     * @return - возвращает массив[] всех существующих заявок
     */
    public Item[] findAll(){
        Item[] itemWithOutNull = new Item[size];
        int position = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                itemWithOutNull[position] = this.items[i];
                position++;
            }
        }
        itemWithOutNull = Arrays.copyOf(itemWithOutNull, size);
        return itemWithOutNull;
    }
    /**
     * findByName - получение заявок по имени
     * @param key - имя заявки (текст)
     * @return - возвращаем массив при совпадение имени или имен
     */
    public Item[] findByName(String key){
        Item[] temp = new Item[size];
        int position = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                temp[position] = this.items[i];
                position++;
            }
        }
        temp = Arrays.copyOf(temp, position);
        return temp;
    }
}