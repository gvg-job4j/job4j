package ru.job4j.tracker;

/**
 * @author Valeriy Gyrievskikh
 * @since 26.06.2018.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Метод проверяет корректность ввода данных пользователем.
     *
     * @param message Сообщение пользователю.
     * @param range   Список доступных значений.
     * @return Введеное значение.
     */
    @Override
    public int ask(String message, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(message, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Please input value from menu range...");
            } catch (NumberFormatException e) {
                System.out.println("Please input numeric value...");
            }
        } while (invalid);
        return value;
    }
}
