package ru.job4j.pseudo;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 21.06.2018
 */
public class ShapeTest {

    @Test
    public void whenPaintSquareThenSquare() {
        Square square = new Square();
        String result = square.draw();
        StringBuilder expect = new StringBuilder();
        expect.append("++++");
        expect.append(System.lineSeparator());
        expect.append("+  +");
        expect.append(System.lineSeparator());
        expect.append("+  +");
        expect.append(System.lineSeparator());
        expect.append("++++");
        Assert.assertThat(result, is(expect.toString()));
    }

    @Test
    public void whenPaintTriangleThenTriangle() {
        Triangle triangle = new Triangle();
        String result = triangle.draw();
        StringBuilder expect = new StringBuilder();
        expect.append("  +");
        expect.append(System.lineSeparator());
        expect.append(" + +");
        expect.append(System.lineSeparator());
        expect.append("+++++");
        Assert.assertThat(result, is(expect.toString()));
    }
}
