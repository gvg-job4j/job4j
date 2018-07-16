package ru.job4j.user;

import java.util.HashMap;
import java.util.List;

/**
 * @author Valeriy Gyrievskikh
 * @since 16.07.2018
 */
public class UserConvert {

    /**
     * Метод создает карту, хранящую пары ключ-значение для пользователя и его идентификатора.
     *
     * @param list Список пользователей.
     * @return Карта пользователей и их идентификаторов.
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userMap = new HashMap<>();
        for (User user : list
                ) {
            userMap.put(user.getId(), user);
        }
        return userMap;
    }
}
