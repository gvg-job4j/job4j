package ru.job4j.user;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Valeriy Gyrievskikh
 * @since 16.07.2018
 */
public class UserConvertTest {

    @Test
    public void when3UsersThen3() {
        List<User> list = new ArrayList<>();
        User userVova = new User(1, "Vova", "Piter");
        User userVasya = new User(2, "Vasya", "Moskva");
        User userPetr = new User(3, "Petr", "Omsk");
        list.add(userVova);
        list.add(userVasya);
        list.add(userPetr);

        UserConvert convert = new UserConvert();
        HashMap<Integer, User> result = convert.process(list);

        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, userVova);
        expect.put(2, userVasya);
        expect.put(3, userPetr);

        assertThat(result, is(expect));
    }
}
