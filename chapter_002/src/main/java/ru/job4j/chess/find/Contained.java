package ru.job4j.chess.find;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

/**
 * @author Valeriy Gyrievskikh
 * @since 02.08.2018
 */
@FunctionalInterface
public interface Contained {

    boolean contain(Figure[] figures, Cell[] cells);
}
