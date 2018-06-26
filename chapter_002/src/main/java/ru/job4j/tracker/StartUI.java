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
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.parseInt(this.input.ask("Select: "));
            if (key >= 0 && key <= 5) {
                menu.select(key);
            } else if (key == 6) {
                menu.select(key);
                exit = true;
            } else {
                System.out.println("Указанный пункт меню не найден! Попробуйте снова...");
            }
        } while (!exit);
    }

    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
