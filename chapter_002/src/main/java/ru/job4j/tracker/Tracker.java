package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Valeriy Gyrievskikh
 * @since 19.06.2018.
 */
public class Tracker {
    /**
     * Массив для хранения заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод, реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return new Date().toString() + Math.random();
    }

    /**
     * Метод, реализующий замену заявки в хранилище.
     *
     * @param id   Идентификатор заявки.
     * @param item Заявка.
     */
    public void replace(String id, Item item) {
        if (position != 0) {
            for (int i = 0; i < position; i++) {
                if (items[i].getId().equals(id)) {
                    item.setId(id);
                    items[i] = item;
                    break;
                }
            }
        }
    }

    /**
     * Метод, реализующий удаление заявки.
     *
     * @param id Идентификатор заявки.
     */
    public void delete(String id) {
        if (position != 0) {
            for (int i = 0; i < position; i++) {
                if (items[i].getId().equals(id)) {
                    items[i] = null;
                    Item[] temp = new Item[position - 1];
                    System.out.println(Arrays.toString(items));
                    System.arraycopy(items, i + 1, temp, 0, position - (i + 1));
                    System.out.println(Arrays.toString(temp));
                    System.arraycopy(temp, 0, items, i, temp.length - i);
                    System.out.println(Arrays.toString(items));
                    position--;
                    break;
                }
            }
        }
    }

    /**
     * Метод, возвращающий список заявок.
     *
     * @return Список заявок без пустых значений или null.
     */
    public Item[] findAll() {
        Item[] createdItems = null;
        if (position != 0) {
            createdItems = new Item[position];
            System.arraycopy(items, 0, createdItems, 0, createdItems.length);
        }
        return createdItems;
    }

    /**
     * Метод, возвращающий список заявок по названию.
     *
     * @param key Название заявки.
     * @return Список заявок с одинаковым именем или null.
     */
    public Item[] findByName(String key) {
        Item[] itemsByName = null;
        if (position != 0) {
            Item[] temp = new Item[position];
            int count = 0;
            for (int i = 0; i < items.length; i++) {
                if (items[i] == null) {
                    break;
                }
                if (items[i].getName().equals(key)) {
                    temp[count] = items[i];
                    count++;
                }
            }
            if (count != 0) {
                itemsByName = new Item[count];
                System.arraycopy(temp, 0, itemsByName, 0, itemsByName.length);
            }
        }
        return itemsByName;
    }

    /**
     * Метод, возвращающий заявку по идентификатору.
     *
     * @param id Идентификатор заявки.
     * @return Найденная заявка или null.
     */
    public Item findById(String id) {
        Item item = null;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                item = items[i];
                break;
            }
        }
        return item;
    }
}
