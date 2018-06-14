package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 14.06.2018.
 */
public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Привет", "Мир", "Привет", "Супер", "Мир"});
        String[] expect = new String[]{"Привет", "Мир", "Супер"};
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void whenArrayWithoutDuplicateThenNotRemove() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Привет", "Мир", "Салют", "Супер"});
        String[] expect = new String[]{"Привет", "Мир", "Салют", "Супер"};
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void whenRemoveAllDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] result = arrayDuplicate.remove(new String[]{"Привет", "Мир", "Привет", "Привет"});
        String[] expect = new String[]{"Привет", "Мир"};
        Assert.assertThat(result, is(expect));
    }
}
