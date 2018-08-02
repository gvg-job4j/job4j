package ru.job4j.chess;

import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figures.*;
import ru.job4j.chess.find.Checker;
import ru.job4j.chess.find.Contained;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Класс реализует шахматную доску.
 *
 * @author Valeriy Gyrievskikh.
 * @since 10.07.2018.
 */
public class Board {
    /**
     * Список фигур на доске.
     */
    private Figure[] figures = new Figure[32];
    /**
     * Количество фигур на доске.
     */
    private int count;

    /**
     * Метод добавляет фигуру на доску.
     *
     * @param figure Фигура, которую нужно добавить.
     */
    public void add(Figure figure) {
        figures[count++] = figure;
    }

    /**
     * Метод выполняет перемещение фигуры по доске.
     *
     * @param source Начальная позиция фигуры.
     * @param dest   Конечная позиция фигуры.
     * @return Удалось ли выполнить перемещение.
     * @throws ImpossibleMoveException Прерывание выбрасывается, если фигуру нельзя передвинуть в указанную точку.
     * @throws OccupiedWayException    Прерывание выбрасывается, если движению фигуры  мешают другие фигуры.
     * @throws FigureNotFoundException Прерывание выбрасывается, если в начальной позиции нет фигуры.
     */
    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        boolean moved = false;
        int figureIndex = getFigureIndex(source);
        Figure figure = figures[figureIndex];
        Cell[] wayCells = figure.way(source, dest);
        if (!contain(figure, wayCells)) {
            figures[figureIndex] = figure.copy(dest);
            moved = true;
        }
        return moved;
    }

    /**
     * Метод проверяет, свободен ли путь движения фигуры.
     *
     * @param figure   Перемещаемая фигура.
     * @param wayCells Список ячеек, через которые пройдет фигура.
     * @return Результат проверки.
     * @throws OccupiedWayException Прерывание выбрасывается, если движению фигуры  мешают другие фигуры.
     */
    private boolean contain(Figure figure, Cell[] wayCells) throws OccupiedWayException {
        boolean isOccupied = new Checker().containFigure(figures, wayCells, (allFigures, path) -> {
            boolean isContain = false;
            for (int i = 0; i < allFigures.length; i++) {
                for (int j = 0; j < path.length; j++) {
                    if (allFigures[i] != null && allFigures[i].getPosition() == path[j]) {
                        isContain = true;
                        break;
                    }
                }
            }
            return isContain;
        });
        if (isOccupied) {
            throw new OccupiedWayException();
        }
        return isOccupied;
    }

    /**
     * Метод проверяет, находится ли в указанной ячейке фигура.
     *
     * @param source Указанная ячекйка.
     * @return Результат проверки.
     * @throws FigureNotFoundException Прерывание выбрасывается, если в начальной позиции нет фигуры.
     */
    private int getFigureIndex(Cell source) throws FigureNotFoundException {
        int index = -1;
        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && figures[i].getPosition() == source) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new FigureNotFoundException();
        }
        return index;
    }
}
