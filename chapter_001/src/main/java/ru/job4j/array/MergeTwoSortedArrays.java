package ru.job4j.array;

/**
 * @author Valeriy Gyrievskikh
 * @since 18.06.2018.
 */
public class MergeTwoSortedArrays {
    /**
     * Объединяет два отсортированных массива.
     *
     * @param array1 Первый отсортированный массив.
     * @param array2 Второй отсортированный массив.
     * @return Объединенный отсортированный массив.
     */
    public int[] merge(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (true) {
            if (index1 < array1.length && index2 < array2.length) {
                if (array1[index1] < array2[index2]) {
                    mergedArray[index3] = array1[index1];
                    index1++;
                } else {
                    mergedArray[index3] = array2[index2];
                    index2++;
                }
            } else {
                if (index1 >= array1.length) {
                    mergedArray[index3] = array2[index2];
                    index2++;
                } else {
                    mergedArray[index3] = array1[index1];
                    index1++;
                }
            }
            index3++;
            if (index3 >= mergedArray.length) break;
        }
        return mergedArray;
    }
}