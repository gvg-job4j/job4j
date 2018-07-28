package ru.job4j.chess.exception;

/**
 * @author Valeriy Gyrievskikh.
 * @since 10.07.2018.
 */
public class FigureNotFoundException extends Exception {
    public FigureNotFoundException() {
        super("Figure not found!");
    }
}
