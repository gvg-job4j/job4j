package ru.job4j.chess.figures;

import ru.job4j.chess.exception.ImpossibleMoveException;

/**
 * @author Valeriy Gyrievskikh
 * @since 27.07.2018
 */
public class Pawn extends Figure {

    /**
     * Конструктор, создает фигуру в указанной позиции.
     *
     * @param dest Позиция фигуры.
     */
    public Pawn(Cell dest) {
        super(dest);
    }

    /**
     * Метод возвращает список ячеек, по которым будет двигаться фигура.
     *
     * @param source Начальная позиция фигуры.
     * @param dest   Конечная позиция фигуры.
     * @return Массив ячеек, по которым пройдет фигура.
     * @throws ImpossibleMoveException Прерывание выбрасывается, если фигуру нельзя передвинуть в указанную точку.
     */
    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        Cell[] steps = new Cell[0];
        if (source.y == dest.y + 1 && source.x == dest.x) {
            steps = new Cell[]{dest};
        }
        return steps;
    }

    /**
     * Метод создает новую фигуру с текущей позицией в точке назначения.
     *
     * @param dest Новая позиция фигуры.
     * @return Фигура.
     */
    @Override
    public Figure copy(Cell dest) {
        return new Pawn(dest);
    }
}
