package ru.job4j.inmutable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

/**
 * @author Valeriy Gyrievskikh
 * @since 03.08.2018
 */
public class InmutableListTest {
    @Test
    public void whenListThenInmutableList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        InmutableList<String> result = new InmutableList(list);
        System.out.println("List have this object: " + result.contains("c"));
        System.out.println("First element from list: " + result.get(0));
        System.out.println("List size: " + result.size());
        list.add("e");
        boolean exceptionThrown = false;
        try {
            result.add("e");
            fail("add supported for InmutableList!");
        } catch (UnsupportedOperationException e) {
            exceptionThrown = true;
            System.out.println("InmutableList.add() not supported");
        }
        assertTrue(exceptionThrown);
        System.out.println("list:" + list);
        System.out.println("immutableList:" + result);
        System.out.println("--");
        assertEquals(4, list.size());
        assertEquals(3, result.size());
    }

    @Test
    public void whenNewInmutableList() {
        InmutableList<String> result = new InmutableList();
        boolean exceptionThrown = false;
        try {
            result.add("e");
            fail("add supported for InmutableList!");
        } catch (UnsupportedOperationException e) {
            exceptionThrown = true;
            System.out.println("InmutableList.add() not supported");
        }
        assertTrue(exceptionThrown);
    }
}
