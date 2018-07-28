package ru.job4j.chess.exception;

/**
 * @author Valeriy Gyrievskikh.
 * @since 10.07.2018.
 */
public class OccupiedWayException extends Exception {
    public OccupiedWayException() {
        super("Way occupied!");
    }
}
