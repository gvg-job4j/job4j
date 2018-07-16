package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Valeriy Gyrievskikh
 * @since 19.06.2018.
 */
public class Tracker {
    /**
     * Список для хранения заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();

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
        this.items.add(this.position++, item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
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
                if (items.get(i).getId().equals(id)) {
                    item.setId(id);
                    items.set(i, item);
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
                if (items.get(i).getId().equals(id)) {
                    items.remove(i);
                    items.trimToSize();
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
    public ArrayList<Item> findAll() {
        ArrayList<Item> createdItems = null;
        if (position != 0) {
            createdItems = items;
            createdItems.trimToSize();
        }
        return createdItems;
    }

    /**
     * Метод, возвращающий список заявок по названию.
     *
     * @param key Название заявки.
     * @return Список заявок с одинаковым именем или null.
     */
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> itemsByName = null;
        if (position != 0) {
            itemsByName = new ArrayList<>();
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i) == null) {
                    break;
                }
                if (items.get(i).getName().equals(key)) {
                    itemsByName.add(items.get(i));
                }
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
            if (items.get(i).getId().equals(id)) {
                item = items.get(i);
                break;
            }
        }
        return item;
    }
}
