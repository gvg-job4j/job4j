package ru.job4j.banktransfer;

/**
 * @author Valeriy Gyrievskikh
 * @since 23.07.2018
 */
public class Account {
    /**
     * Первоначальная сумма на счете.
     */
    private double value;
    /**
     * Реквизиты счета.
     */
    private String requisites;

    /**
     * Конструктор, создает новый счет с заданными значениями.
     *
     * @param value      Первоначальная сумма.
     * @param requisites Реквизиты.
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Метод возвращает сумму на счете.
     *
     * @return Сумма на счете.
     */
    public double getValue() {
        return value;
    }

    /**
     * Метод возвращает реквизиты счета.
     *
     * @return Реквизиты счета.
     */
    public String getRequisites() {
        return requisites;
    }
}
