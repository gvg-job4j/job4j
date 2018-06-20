package ru.job4j.tracker;

import java.util.Scanner;

/**
 * @author Valeriy Gyrievskikh
 * @since 20.06.2018.
 */
public class ConsoleInput {

    /**
     * Устройство ввода информации.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод запрашивает ввод информации у пользователя.
     *
     * @param message Сообщение пользователю с описанием ожидаемой информации.
     * @return Полученные данные от пользователя.
     */
    public String ask(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }
}
