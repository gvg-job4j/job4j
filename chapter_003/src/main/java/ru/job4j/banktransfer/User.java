package ru.job4j.banktransfer;

/**
 * @author Valeriy Gyrievskikh
 * @since 23.07.2018
 */
public class User {
    /**
     * Имя пользователя.
     */
    private String name;
    /**
     * Паспортные данные.
     */
    private String passport;

    /**
     * Конструктор, создает пользователя с заданными параметрами.
     *
     * @param name     Имя пользователя.
     * @param passport Паспортные данные.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Метод возвращает имя пользователя.
     *
     * @return Имя пользователя.
     */
    public String getName() {
        return name;
    }

    /**
     * Метод возвращает паспортные данные пользователя.
     *
     * @return Паспортные данные.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод выполняет сравнение данных двух пользователей.
     *
     * @param anotherUser Пользователь, с которым выполняется сравнение.
     * @return Истина, если паспортные данные совпадают, иначе ложь.
     */
    @Override
    public boolean equals(Object anotherUser) {
        boolean isEqual = false;
        if (anotherUser instanceof User) {
            if (this == anotherUser) {
                isEqual = true;
            } else {
                User user = (User) anotherUser;
                if (this.getPassport().equals(user.getPassport())) {
                    isEqual = true;
                }
            }
        }
        return isEqual;
    }

    /**
     * Метод рассчитывает хеш-код пользователя.
     *
     * @return Хеш-код.
     */
    @Override
    public int hashCode() {
        return this.getPassport().hashCode() + this.getName().hashCode();
    }
}
