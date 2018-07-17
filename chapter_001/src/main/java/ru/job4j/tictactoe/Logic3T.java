package ru.job4j.tictactoe;

import java.util.function.Predicate;

/**
 * @author Valeriy Gyrievskikh
 * @since 15.06.2018.
 */
public class Logic3T {

    /**
     * Игровое поле.
     */
    private final Figure3T[][] table;

    /**
     * Конструктор, инициализирующий игровое поле.
     *
     * @param table Игровое поле.
     */
    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Проверяется, выиграл ли игрок Х.
     *
     * @return Результат проверки.
     */
    public boolean isWinnerX() {

        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, this.table.length - 1, -1, 0)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, this.table.length - 1, 0, -1)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1);
    }

    /**
     * Проверяется, выиграл ли игрок O
     *
     * @return Результат проверки.
     */
    public boolean isWinnerO() {
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, this.table.length - 1, -1, 0)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, this.table.length - 1, 0, -1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);
    }

    /**
     * Метод проверяет выигрышные позиции.
     *
     * @param predicate Проверяемое состояние игрового поля.
     * @param startX    Координата Х начальной точки.
     * @param startY    Координата Y начальной точки.
     * @param deltaX    Изменение координаты по Х.
     * @param deltaY    Изменение координаты по Y.
     * @return Результат проверки.
     */
    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Проверяется, есть ли свободные поля.
     *
     * @return Результат проверки.
     */
    public boolean hasGap() {
        boolean hasFree = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkO() && !table[i][j].hasMarkX()) {
                    hasFree = true;
                    break;
                }
            }
        }
        return hasFree;
    }
}
