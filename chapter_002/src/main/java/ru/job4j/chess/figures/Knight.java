package ru.job4j.chess.figures;

import ru.job4j.chess.exception.ImpossibleMoveException;

import java.util.Arrays;

/**
 * Класс описывает шахматную фигуру слона.
 *
 * @author Valeriy Gyrievskikh
 * @since 27.07.2018
 */
public class Knight extends Figure {

    /**
     * Конструктор, создает фигуру в указанной позиции.
     *
     * @param dest Позиция фигуры.
     */
    public Knight(Cell dest) {
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
        Cell[] cells = new Cell[0];
        int count = 0;
        if (!source.equals(dest)) {
            Cell[] cellsExist = new Cell[8];
            int x = source.x;
            int y = source.y;
            int[][] points = new int[][]{{x + 2, y + 1}, {x + 2, y - 1}, {x - 2, y + 1}, {x - 2, y - 1},
                    {x + 1, y + 2}, {x - 1, y + 2}, {x + 1, y - 2}, {x - 1, y - 2}};
            for (int i = 0; i < points.length; i++) {
                Cell cell = Cell.getCell(points[i][0], points[i][1]);
                if (cell != null && cell == dest) {
                    cellsExist[count] = cell;
                    count++;
                }
            }
            if (count == 0) {
                throw new ImpossibleMoveException();
            }
            cells = new Cell[count];
            System.arraycopy(cellsExist, 0, cells, 0, count);
        }
        return cells;
    }

    /**
     * Метод создает новую фигуру с текущей позицией в точке назначения.
     *
     * @param dest Новая позиция фигуры.
     * @return Фигура.
     */
    @Override
    public Figure copy(Cell dest) {
        return null;
    }
}
