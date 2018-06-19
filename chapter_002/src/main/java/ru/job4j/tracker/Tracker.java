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
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * Метод, реализующий удаление заявки.
     *
     * @param id Идентификатор заявки.
     */
    public void delete(String id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                items[i] = null;
                Item[] temp = new Item[items.length - 1];
                System.out.println(Arrays.toString(items));
                System.arraycopy(items, i + 1, temp, 0, items.length - (i + 1));
                System.out.println(Arrays.toString(temp));
                System.arraycopy(temp, 0, items, i, temp.length - i);
                System.out.println(Arrays.toString(items));
                break;
            }
        }
    }

    /**
     * Метод, возвращающий список заявок.
     *
     * @return Список заявок без пустых значений.
     */
    public Item[] findAll() {
        int index = -1;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return this.items;
        } else {
            Item[] temp = new Item[index];
            System.arraycopy(items, 0, temp, 0, temp.length);
            return temp;
        }
    }

    /**
     * Метод, возвращающий список заявок по названию.
     *
     * @param key Название заявки.
     * @return Список заявок с одинаковым именем или null.
     */
    public Item[] findByName(String key) {
        Item[] item = new Item[items.length];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) break;
            if (items[i].getName().equals(key)) {
                item[count] = items[i];
                count++;
            }
        }
        if (count != 0) {
            Item[] temp = new Item[count];
            System.arraycopy(item, 0, temp, 0, temp.length);
            return temp;
        } else {
            return null;
        }
    }

    /**
     * Метод, возвращающий заявку по идентификатору.
     *
     * @param id Идентификатор заявки.
     * @return Найденная заявка или null.
     */
    public Item findById(String id) {
        Item item = null;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) continue;
            if (items[i].getId().equals(id)) {
                item = items[i];
                break;
            }
        }
        return item;
    }
}
