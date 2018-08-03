package ru.job4j.inmutable;

import java.util.*;

/**
 * @author Valeriy Gyrievskikh
 * @since 03.08.2018
 */
public class InmutableList<E> extends AbstractList<E> implements List<E> {

    /**
     * Неизменяемый список.
     */
    private List<E> list;

    /**
     * Конструктор для нового списка.
     */
    public InmutableList() {
        this.list = Collections.unmodifiableList(new ArrayList<>());
    }

    /**
     * Конструктор нового списка на основании переданного.
     *
     * @param list Переданный список.
     */
    public InmutableList(List<E> list) {
        this.list = Collections.unmodifiableList(new ArrayList<>(list));
    }

    /**
     * Метод возвращает размер списка.
     *
     * @return Размер списка.
     */
    @Override
    public int size() {
        return this.list.size();
    }

    /**
     * Метод проверяет наличие объекта в списке.
     *
     * @param o Искомый объект.
     * @return
     */
    @Override
    public boolean contains(Object o) {
        return this.list.contains(o);
    }

    /**
     * Метод возвращает элемент списка по индексу.
     *
     * @param index Индекс элемента.
     * @return Элемент списка.
     */
    @Override
    public E get(int index) {
        return this.list.get(index);
    }

    /**
     * Метод добавляет новый элемент в список.
     *
     * @param e Добавляемый элемент.
     * @return Результат добавления.
     */
    @Override
    public boolean add(E e) {
        this.list.add(e);
        return true;
    }
}
