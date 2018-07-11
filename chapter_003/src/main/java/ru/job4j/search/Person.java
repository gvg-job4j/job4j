package ru.job4j.search;

/**
 * @author Valeriy Gyrievskikh
 * @since 11.07.2018
 */
public class Person {

    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Фамилия пользователя.
     */
    private String surname;
    /**
     * Телефон пользователя.
     */
    private String phone;
    /**
     * Адрес пользователя.
     */
    private String adress;

    /**
     * Конструктор, создает нового пользователя с заполнением полей.
     *
     * @param name    Имя.
     * @param surname Фамилия.
     * @param phone   Телефон.
     * @param adress  Адрес.
     */
    public Person(String name, String surname, String phone, String adress) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.adress = adress;
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
     * Метод возвращает фамилию пользователя.
     *
     * @return Фамилия.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Метод возвращает телефон пользователя.
     *
     * @return Телефон.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Метод возвращает адрес пользователя.
     *
     * @return Адрес.
     */
    public String getAdress() {
        return adress;
    }
}
