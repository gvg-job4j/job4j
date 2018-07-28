package ru.job4j.chess.exception;

/**
 * @author Valeriy Gyrievskikh.
 * @since 10.07.2018.
 */
public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException() {
        super("Figure can't move to destination!");
    }
}
