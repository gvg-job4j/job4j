package ru.job4j.departmentsort;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh.
 * @since 21.07.2018.
 */
public class DepartmentSortTest {

    private String[] testArray;

    @Before
    public void createArray() {
        testArray = new String[10];
        testArray[0] = "K1";
        testArray[1] = "K1\\SK1";
        testArray[2] = "K1\\SK2";
        testArray[3] = "K1\\SK1\\SSK1";
        testArray[4] = "K1\\SK1\\SSK2";
        testArray[5] = "K2";
        testArray[6] = "K2\\SK1";
        testArray[7] = "K2\\SK1\\SSK1";
        testArray[8] = "K2\\SK1\\SSK2";
        testArray[9] = "K3";
    }

    @Test
    public void whenArrayDescendingSort() {
        String[] result = new DepartmentSort().sortDesc(testArray);
        String[] expect = new String[]{
                "K3",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayAscendingSort() {
        String[] result = new DepartmentSort().sortAcs(testArray);
        String[] expect = new String[]{
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K1\\SK2",
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K3"
        };
        assertThat(result, is(expect));

    }
}
