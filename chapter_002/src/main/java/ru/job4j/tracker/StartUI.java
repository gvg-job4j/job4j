package ru.job4j.tracker;

/**
 * @author Valeriy Gyrievskikh
 * @since 20.06.2018.
 */
public class StartUI {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     *
     */
    private int[] ranges;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {

        boolean exit = false;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        ranges = menu.fillActions();
        do {
            menu.show();
//            menu.select(this.input.ask("Select: ", ranges));
//            int key = Integer.parseInt(this.input.ask("Select: "));
            int key = this.input.ask("Select: ", ranges);
            if (key == 6) {
                exit = true;
            }
            menu.select(key);
        } while (!exit);
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
