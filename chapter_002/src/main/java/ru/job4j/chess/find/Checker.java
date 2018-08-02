package ru.job4j.chess.find;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Valeriy Gyrievskikh
 * @since 02.08.2018
 */
public class Checker {

    public boolean containFigure(Figure[] figures, Cell[] cells, Contained function) {
        return function.contain(figures, cells);
    }
}
