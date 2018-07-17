package ru.job4j.usersort;

/**
 * @author Valeriy Gyrievskikh
 * @since 16.07.2018
 */
public class User implements Comparable<User> {
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Возраст пользователя.
     */
    private int age;

    /**
     * Конструктор, создает нового пользователя с заданными полями.
     *
     * @param name Имя.
     * @param age  Возраст.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
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
     * Метод возвращает возраст пользователя.
     *
     * @return Возраст.
     */
    public int getAge() {
        return age;
    }

    /**
     * Метод сравнивает пользователей по возрасту.
     *
     * @param user Пользователь, с которым выполняется сравнение.
     * @return Результат сравнения.
     */
    @Override
    public int compareTo(User user) {
        return this.getAge() - user.getAge();
    }
}
