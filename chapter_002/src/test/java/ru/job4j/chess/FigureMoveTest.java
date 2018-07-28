package ru.job4j.chess;

import org.junit.Test;
import org.junit.Before;
import ru.job4j.chess.exception.FigureNotFoundException;
import ru.job4j.chess.exception.ImpossibleMoveException;
import ru.job4j.chess.exception.OccupiedWayException;
import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Knight;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 27.07.2018
 */
public class FigureMoveTest {

    private Board board;
    boolean result = false;

    @Before
    public void onStart() {
        board = new Board();
        board.add(new Bishop(Cell.B2));
        board.add(new Knight(Cell.C2));
    }

    @Test
    public void whenFigureNotFound() {
        try {
            result = board.move(Cell.B3, Cell.D4);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(false));
        }
    }

    @Test
    public void whenBishopPathClean() {
        try {
            result = board.move(Cell.B2, Cell.D4);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(true));
        }
    }

    @Test
    public void whenBishopPathNotClean() {
        board.add(new Bishop(Cell.C3));
        try {
            result = board.move(Cell.B2, Cell.D4);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(false));
        }
    }

    @Test
    public void whenBishopCantMoveToDest() {
        try {
            result = board.move(Cell.B2, Cell.H3);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(false));
        }
    }

    @Test
    public void whenKnigthPathClean() {
        try {
            result = board.move(Cell.C2, Cell.D4);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(true));
        }
    }

    @Test
    public void whenKnigthPathNotClean() {
        board.add(new Bishop(Cell.C3));
        try {
            result = board.move(Cell.C2, Cell.D4);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(true));
        }
    }

    @Test
    public void whenKnigthDestNotClean() {
        board.add(new Bishop(Cell.D4));
        try {
            result = board.move(Cell.C2, Cell.D4);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(false));
        }
    }

    @Test
    public void whenKnigthCantMoveToDest() {
        try {
            result = board.move(Cell.C2, Cell.H3);
        } catch (ImpossibleMoveException e) {
            e.printStackTrace();
        } catch (OccupiedWayException e) {
            e.printStackTrace();
        } catch (FigureNotFoundException e) {
            e.printStackTrace();
        } finally {
            assertThat(result, is(false));
        }
    }
}
