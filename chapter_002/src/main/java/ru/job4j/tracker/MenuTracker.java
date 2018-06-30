package ru.job4j.tracker;

/**
 * @author Valeriy Gyrievskikh
 * @since 24.06.2018.
 */
public class MenuTracker {

    /**
     * Запрашивает данные пользователя.
     */
    private Input input;

    /**
     * Система учета заявок.
     */
    private Tracker tracker;

    /**
     * Действия пользователя.
     */
    private UserAction[] actions = new UserAction[10];

    /**
     * Конструктор, инициализирует поля класса.
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Заполняет меню программы
     */
    public int[] fillActions() {
        this.actions[0] = this.new AddItem(0, "Add the new item.");
        this.actions[1] = new ShowItems(1, "Show all items.");
        this.actions[2] = new EditItem(2, "Edit selected item.");
        this.actions[3] = this.new DeleteItem(3, "Delete selected item.");
        this.actions[4] = new FindItemById(4, "Find item by id.");
        this.actions[5] = new FindItemsByName(5, "Find items by name.");
        this.actions[6] = new TrackerExit(6, "Exit.");
        int[] keys = new int[actions.length];
        for (int i = 0; i < actions.length; i++) {
            if (actions[i] != null) {
                keys[i] = actions[i].key();
            }
        }
        return keys;
    }

    /**
     * Метод запускает выбранную процедуру.
     *
     * @param key Выбранный пункт меню.
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**
     * Выводит меню программы
     */
    public void show() {
        for (UserAction action : this.actions
                ) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Внутренний класс, создает объект, выполняющий добавление заявки.
     */
    private class AddItem extends BaseAction {

        /**
         * Конструктор.
         *
         * @param key  Пункт меню.
         * @param name Текст меню.
         */
        public AddItem(int key, String name) {
            super(key, name);
        }

        /**
         * Вызывает метод добавления новой заявки.
         *
         * @param input   Получение данных у пользователя.
         * @param tracker Система заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Enter the task's name:");
            String desc = input.ask("Enter the task's description :");
            Item item = tracker.add(new Item(name, desc));
            System.out.println("Создана новая заявка: " + item.toString());
        }
    }

    /**
     * Внутренний статический класс, выполняет вывод всех заявок.
     */
    private static class ShowItems extends BaseAction {

        /**
         * Конструктор.
         *
         * @param key  Пункт меню.
         * @param name Текст меню.
         */
        public ShowItems(int key, String name) {
            super(key, name);
        }

        /**
         * Вызывает метод получения списка заявок.
         *
         * @param input   Получение данных у пользователя.
         * @param tracker Система заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item[] items = tracker.findAll();
            if (items != null) {
                for (Item item : tracker.findAll()
                        ) {
                    System.out.println("Заявка: " + item.toString());
                }
            } else {
                System.out.println("Заявок нет...");
            }
        }
    }

    /**
     * Внутренний класс, создает объект, выполняющий удаление заявки по идентификатору.
     */
    private class DeleteItem extends BaseAction {

        /**
         * Конструктор.
         *
         * @param key  Пункт меню.
         * @param name Текст меню.
         */
        public DeleteItem(int key, String name) {
            super(key, name);
        }

        /**
         * Вызывает метод удаления заявки по идентификатору.
         *
         * @param input   Получение данных у пользователя.
         * @param tracker Система заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the task's id:");
            Item item = tracker.findById(id);
            if (item != null) {
                tracker.delete(id);
                System.out.println("Удалена заявка: " + id);
            } else {
                System.out.println("Удаление не выполнено! Не найдена заявка с идентификатором: " + id);
            }
        }
    }

    /**
     * Внутренний статический класс, создает объект, выполняющий поиск заявки по идентификатору.
     */
    private static class FindItemById extends BaseAction {

        /**
         * Конструктор.
         *
         * @param key  Пункт меню.
         * @param name Текст меню.
         */
        public FindItemById(int key, String name) {
            super(key, name);
        }

        /**
         * Вызывает метод поиска заявки по идентификатору.
         *
         * @param input   Получение данных у пользователя.
         * @param tracker Система заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Enter the task's id:");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println("Найдена заявка: " + item.toString());
            } else {
                System.out.println("Не найдена заявка с идентификатором: " + id);
            }
        }
    }

    /**
     * Внутренний статический класс, вызов приводит к выходу из программы.
     */
    private static class TrackerExit extends BaseAction {

        /**
         * Конструктор.
         *
         * @param key  Пункт меню.
         * @param name Текст меню.
         */
        public TrackerExit(int key, String name) {
            super(key, name);
        }

        /**
         * Ничего не делает.
         *
         * @param input   Получение данных у пользователя.
         * @param tracker Система заявок.
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Выход из программы...");
        }
    }
}

/**
 * Внешний класс, создает объект, выполняющий редактирование заявки.
 */
class EditItem extends BaseAction {

    /**
     * Конструктор.
     *
     * @param key  Пункт меню.
     * @param name Текст меню.
     */
    public EditItem(int key, String name) {
        super(key, name);
    }

    /**
     * Вызывает метод редактирования выбранной заявки.
     *
     * @param input   Получение данных у пользователя.
     * @param tracker Система заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Enter the task's id:");
        Item item = tracker.findById(id);
        if (item != null) {
            String name = input.ask("Enter the task's name:");
            String desc = input.ask("Enter the task's description :");
            item = new Item(name, desc);
            tracker.replace(id, item);
            System.out.println("Изменена заявка: " + item.toString());
        } else {
            System.out.println("Не найдена заявка с идентификатором: " + id);
        }
    }
}

/**
 * Внешний класс, создает объект, выполняющий поиск заявок по нименованию.
 */
class FindItemsByName extends BaseAction {

    /**
     * Конструктор.
     *
     * @param key  Пункт меню.
     * @param name Текст меню.
     */
    public FindItemsByName(int key, String name) {
        super(key, name);
    }

    /**
     * Вызывает метод поиска заявок по наименованию.
     *
     * @param input   Получение данных у пользователя.
     * @param tracker Система заявок.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Enter the task's name:");
        Item[] items = tracker.findByName(name);
        if (items != null) {
            for (Item item : items
                    ) {
                System.out.println("Найдена заявка: " + item.toString());
            }
        } else {
            System.out.println("Не найдены заявки с наименованием: " + name);
        }
    }
}
