package ru.job4j.usersort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 16.07.2018
 */
public class SortUserTest {
    @Test
    public void whenListThenSet() {
        List<User> list = new ArrayList<>();
        list.add(new User("Vovan", 31));
        list.add(new User("Vovik", 39));
        list.add(new User("Vova", 30));

        SortUser sortUser = new SortUser();
        Set<User> sortSet = sortUser.sort(list);
        int[] result = new int[3];
        int count = 0;
        for (User user : sortSet
                ) {
            result[count] = user.getAge();
            count++;
        }
        int[] expect = new int[]{30, 31, 39};
        assertThat(result, is(expect));
    }

}
