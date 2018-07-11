package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Valeriy Gyrievskikh
 * @since 11.07.2018
 */
public class PriorityQueue {

    /**
     * Список задач.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод вставляет задачу в список в порядке приоритета.
     *
     * @param task Задача.
     */
    public void put(Task task) {
        if (tasks.size() == 0) {
            tasks.add(0, task);
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).getPriority() > task.getPriority()) {
                    tasks.add(i, task);
                    break;
                }
            }
        }
    }

    /**
     * Метод возвращает первую задачу, при этом удалив ее из списка.
     *
     * @return
     */
    public Task take() {
        return this.tasks.poll();
    }
}
