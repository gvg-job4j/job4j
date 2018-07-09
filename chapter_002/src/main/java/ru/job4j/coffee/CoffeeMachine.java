package ru.job4j.coffee;

import java.util.Arrays;

/**
 * @author Valeriy Gyrievskikh.
 * @since 04.07.2018.
 */
public class CoffeeMachine {
    /**
     * Массив доступных номиналов для сдачи.
     */
    private int[] money = new int[]{10, 5, 2, 1};

    /**
     * Метод возвращает сдачу.
     *
     * @param value Заплаченная сумма.
     * @param price Стоимость выбранного напитка.
     * @return Массив номиналов на сумму сдачи.
     */
    int[] changes(int value, int price) {
        int[] moneyBack = null;
        int change = value - price;
        if (change > 0) {
            int count = 0;
            int[] countBack = new int[]{0, 0, 0, 0};
            for (int coin : money
                    ) {
                while (change - coin >= 0) {
                    change -= coin;
                    countBack[count] += coin;
                }
                if (countBack[count] != 0) {
                    count++;
                }
                if (change == 0) {
                    break;
                }
            }
            moneyBack = new int[count];
            System.arraycopy(countBack, 0, moneyBack, 0, count);
        } else {
            moneyBack = new int[]{0};
        }
        return moneyBack;
    }
}

