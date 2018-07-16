package ru.job4j.user;

/**
 * @author Valeriy Gyrievskikh
 * @since 16.07.2018
 */
public class User {
    /**
     * Идентификатор пользователя.
     */
    private int id;
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Город пользователя.
     */
    private String city;

    /**
     * Конструктор, создает нового пользователя с указанными полями.
     *
     * @param id   Идентификатор.
     * @param name Имя.
     * @param city Город.
     */
    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Метод возвращает идентификатор пользователя.
     *
     * @return Идентификатор.
     */
    public int getId() {
        return id;
    }

    /**
     * Метод возвращает имя пользователя.
     *
     * @return Имя.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает город пользователя.
     *
     * @return Город.
     */
    public String getCity() {
        return city;
    }
}
