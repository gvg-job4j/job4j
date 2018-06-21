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
        int left = 0;
        int right = 0;
        int full = 0;
        while (true) {
            if (left < array1.length && right < array2.length) {
                if (array1[left] < array2[right]) {
                    mergedArray[full] = array1[left];
                    left++;
                } else {
                    mergedArray[full] = array2[right];
                    right++;
                }
            } else {
                if (left >= array1.length) {
                    mergedArray[full] = array2[right];
                    right++;
                } else {
                    mergedArray[full] = array1[left];
                    left++;
                }
            }
            full++;
            if (full >= mergedArray.length) {
                break;
            }
        }
        return mergedArray;
    }
}