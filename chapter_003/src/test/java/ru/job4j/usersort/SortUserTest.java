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
        list.add(new User("Vovka", 15));

        SortUser sortUser = new SortUser();
        Set<User> sortSet = sortUser.sort(list);
        int[] result = new int[4];
        int count = 0;
        for (User user : sortSet) {
            result[count] = user.getAge();
            count++;
        }
        int[] expect = new int[]{15, 30, 31, 39};
        assertThat(result, is(expect));
    }

    @Test
    public void whenListThenListSortetByNameLength() {
        List<User> list = new ArrayList<>();
        list.add(new User("Abbybas", 31));
        list.add(new User("Z", 39));
        list.add(new User("Vovik", 15));
        list.add(new User("Vova", 30));

        SortUser sortUser = new SortUser();
        List<User> sortList = sortUser.sortNameLength(list);
        int[] result = new int[4];
        int count = 0;
        for (User user : sortList) {
            result[count] = user.getAge();
            count++;
        }
        int[] expect = new int[]{39, 30, 15, 31};
        assertThat(result, is(expect));
    }

    @Test
    public void whenListThenListSortetByNameAge() {
        List<User> list = new ArrayList<>();
        list.add(new User("Abb", 31));
        list.add(new User("Vovik", 39));
        list.add(new User("Vovik", 15));
        list.add(new User("Abb", 30));

        SortUser sortUser = new SortUser();
        List<User> sortList = sortUser.sortByAllFields(list);
        int[] result = new int[4];
        int count = 0;
        for (User user : sortList) {
            result[count] = user.getAge();
            count++;
        }
        int[] expect = new int[]{30, 31, 15, 39};
        assertThat(result, is(expect));
    }

}
