package ru.job4j.search;

/**
 * @author Valeriy Gyrievskikh
 * @since 11.07.2018
 */
public class Task {
    /**
     * Описание задачи.
     */
    private String desc;
    /**
     * Приоритет зпдпчи.
     */
    private int priority;

    /**
     * Конструктор, создает новую задачу и заполняет ее поля.
     * @param desc
     * @param priority
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Метод возвращает описание задачи.
     * @return Описание задачи.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Метод возвращает приоритет задачи.
     * @return Приоритет.
     */
    public int getPriority() {
        return priority;
    }
}
