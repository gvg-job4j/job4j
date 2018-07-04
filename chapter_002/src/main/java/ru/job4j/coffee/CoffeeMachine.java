package ru.job4j.coffee;

/**
 * @author Valeriy Gyrievskikh.
 * @since 04.07.2018.
 */
public class CoffeeMachine {
    /**
     * Массив доступных номиналов для сдачи.
     */
    private int[] money = new int[]{1, 2, 5, 10};

    /**
     * Метод возвращает сдачу.
     *
     * @param value Заплаченная сумма.
     * @param price Стоимость выбранного напитка.
     * @return Массив номиналов на сумму сдачи.
     */
    int[] changes(int value, int price) {
        int[] moneyBack = new int[]{0};
        int change = value - price;
        if (change > 0) {
            int[] countBack = new int[]{0, 0, 0, 0};
            int length = money.length;
            while (change > 0) {
                if (change / money[length - 1] > 0) {
                    countBack[length - 1] = change / money[length - 1];
                }
                change -= (change / money[length - 1]) * money[length - 1];
                length--;
            }
            int count = 0;
            for (int i = 0; i < countBack.length; i++) {
                if (countBack[i] != 0) {
                    count += countBack[i];
                }
            }
            if (count != 0) {
                moneyBack = new int[count];
                count = 0;
                for (int i = countBack.length - 1; i >= 0; i--) {
                    if (countBack[i] != 0) {
                        for (int j = 0; j < countBack[i]; j++) {
                            moneyBack[count] = money[i];
                            count++;
                        }
                    }
                }
            }
        }
        return moneyBack;
    }
}

