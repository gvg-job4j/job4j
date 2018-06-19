package ru.job4j.tracker;

import java.util.Date;
import java.util.UUID;

/**
 * @author Valeriy Gyrievskikh
 * @since 19.06.2018.
 */
public class Item {
    private String id;
    private String name;
    private String description;
    private long number;

    public Item(String name, String description, long number) {
        this.name = name;
        this.description = description;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
