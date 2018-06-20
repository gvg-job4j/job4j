package ru.job4j.tracker;

/**
 * @author Valeriy Gyrievskikh
 * @since 20.06.2018.
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для вывода списка заявок.
     */
    private static final String SHOWALL = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DELETE = "3";

    /**
     * Константа меню для поиска заявки по идентификатору.
     */
    private static final String FIND_BYID = "4";

    /**
     * Константа меню для поиска заявок по наименованию.
     */
    private static final String FIND_BYNAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */
    private final ConsoleInput input;

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
    public StartUI(ConsoleInput input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showAllItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FIND_BYID.equals(answer)) {
                this.findItemById();
            } else if (FIND_BYNAME.equals(answer)) {
                this.findItemsByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }else{
                System.out.println("Указанный пункт меню не найден! Попробуйте снова...");
            }
        }
    }

    /**
     * Метод реализует добавление новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует вывод списка заявок.
     */
    private void showAllItems() {
        Item[] items = tracker.findAll();
        System.out.println("------------ Список заявок --------------");
        if (items == null) {
            System.out.println("Список пуст...");
        } else {
            for (int i = 0; i < items.length; i++) {
                System.out.println("Заявка: " + items[i].getId() + ", " + items[i].getName() + ", описание: " + items[i].getDescription());
            }
        }
        System.out.println("------------ Конец списка заявок --------------");
    }

    /**
     * Метод реализует редактирование выбранной заявки.
     */
    private void editItem() {
        String id = this.input.ask("Введите идентификатор заявки:");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Текущая заявка: " + item.getName() + ", описание: " + item.getDescription());
            String name = this.input.ask("Введите новое наименование:");
            String desc = this.input.ask("Введите новое описание заявки :");
            if (name != null && !name.equals("") && desc != null && !desc.equals("")) {
                Item newItem = new Item(name, desc);
                newItem.setId(id);
                this.tracker.replace(id, newItem);
                System.out.println("------------ Изменена заявка с getId : " + item.getId() + "-----------");
            } else {
                System.out.println("------------ Нет изменений в заявке с getId : " + item.getId() + "-----------");
            }
        } else {
            System.out.println("------------ Не найдена заявка с идентификатором : " + id + "-----------");
        }
    }

    /**
     * Метод реализует удаление выбранной заявки.
     */
    private void deleteItem() {
        String id = this.input.ask("Введите идентификатор заявки:");
        Item item = this.tracker.findById(id);
        if (item != null) {
            this.tracker.delete(id);
            System.out.println("------------ Удалена заявка с идентификатором : " + id + "-----------");

        } else {
            System.out.println("------------ Не найдена заявка с идентификатором : " + id + "-----------");
        }

    }

    /**
     * Метод реализует поиск заявки по идентификатору.
     */
    private void findItemById() {
        String id = this.input.ask("Введите идентификатор заявки:");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка: " + item.getId() + ", " + item.getName() + ", описание: " + item.getDescription());
        } else {
            System.out.println("------------ Не найдена заявка с идентификатором : " + id + "-----------");
        }

    }

    /**
     * Метод реализует поиск заявок по наименованию.
     */
    private void findItemsByName() {
        String name = this.input.ask("Введите наименование:");
        Item[] items = tracker.findByName(name);
        System.out.println("------------ Список заявок --------------");
        if (items == null) {
            System.out.println("Не найдены заявки с наименованием: " + name);
        } else {
            for (int i = 0; i < items.length; i++) {
                System.out.println("Заявка: " + items[i].getId() + ", " + items[i].getName() + ", описание: " + items[i].getDescription());
            }
        }
        System.out.println("------------ Конец списка заявок --------------");
    }

    /**
     * Выводит меню программы
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0 - добавление заявки.");
        System.out.println("1 - вывод на экран списка заявок.");
        System.out.println("2 - изменение заявки.");
        System.out.println("3 - удаление заявки.");
        System.out.println("4 - поиск заявки по идентификатору.");
        System.out.println("5 - поиск заявок но наименованию.");
        System.out.println("6 - выход из программы.");
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
