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
     * indexOf - метод, который будет возвращать index по id.
     * @param id - номер заявки
     * @return - возвращает index найденной заявки
     */
    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
    /**
     * Метод замены заявки, индекс остается тот  же
     * @param id - с каким индексом заявку надо поменять
     * @param item - заявка на которую нада заменить. Меняет только поле Name
     * @return - true, если замена произведена или false, если index по id не найден.
     */
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if(index != -1) {
            item.setId(id);
            this.items[index] = item;
            rsl = true;
        }
        return rsl;
    }
    /**
     * findById - поиск заявки по id
     * @param id - номер для поиска заявки
     * @return - возврщает заявку, или null
     */
    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }
    /**
     * findAll - получение списка всех заявок, создаем новый массив с длиной size
     * @return - возвращает массив[] всех существующих заявок
     */
    public Item[] findAll(){
        return Arrays.copyOf(items, size);
    }
    /**
     * findByName - получение заявок по имени
     * @param key - имя заявки (текст)
     * @return - возвращаем массив при совпадение имени или имен
     */
    public Item[] findByName(String key){
        Item[] temp = new Item[size];
        int position = 0;
        for (int i = 0; i < size; i++) {
            if (this.items[i].getName().equals(key)) {
                temp[position] = this.items[i];
                position++;
            }
        }
        return Arrays.copyOf(temp, position);
    }
    /**
     * delete - метод удаления  заявки.
     * Берем исходный массив, и в него же будем копировать item.
     * "index + 1" - индекс следующего элемента после найденного
     * "size - index" - сколько элементов скопировать
     * далее обнуляем последнюю ячейку, и уменьшаем показатель size
     * @param id - с каким номером удалить заявку
     * @return - возвращает true или false
     */
    public boolean delete(int id) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index);
            items[size - 1] = null;
            size--;
            rsl = true;
        }
        return rsl;
    }
}