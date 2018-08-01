package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Valeriy Gyrievskikh
 * @since 11.07.2018
 */
public class PhoneDictionary {

    /**
     * Содержит список пользователей.
     */
    private List<Person> persons = new ArrayList<Person>();

    /**
     * Метод добавляет пользователя в список.
     *
     * @param person пользователь.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод выполняет поиск пользователей, у которых в полях содержится указанное значение.
     *
     * @param key Значение, по которому выполняетсяя поиск.
     * @return Список найденных пользователей, или пустой список.
     */
    public List<Person> find(String key) {
        return persons.stream().filter(person -> verifyPerson(person, key)).collect(Collectors.toList());
    }

    /**
     * Метод выполняет проверку полей пользователя на содержание указанного значения.
     *
     * @param person Проверяемый пользователь.
     * @param key    Значение, по которому выполняется проверка.
     * @return Содержится ли указанное значение в полях пользователя.
     */
    private boolean verifyPerson(Person person, String key) {
        boolean contain = false;
        if (person.getName().contains(key) || person.getSurname().contains(key)
                || person.getAdress().contains(key) || person.getPhone().contains(key)) {
            contain = true;
        }
        return contain;
    }
}
