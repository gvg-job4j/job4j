package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Valeriy Gyrievskikh
 * @since 21.06.2018
 */
public class PaintTest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(out));
    }

    @After
    public void backOutput() {
        System.setOut(stdout);
        System.out.println("execute after method");
    }

    @Test
    public void whenPaintDrawSquareThenSquare() {
        new Paint().draw(new Square());
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append("++++")
                        .append(System.lineSeparator())
                        .append("+  +")
                        .append(System.lineSeparator())
                        .append("+  +")
                        .append(System.lineSeparator())
                        .append("++++")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }

    @Test
    public void whenPaintDrawTriangleThenTriangle() {
        new Paint().draw(new Triangle());
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append("  +")
                        .append(System.lineSeparator())
                        .append(" + +")
                        .append(System.lineSeparator())
                        .append("+++++")
                        .append(System.lineSeparator())
                        .toString()
                )
        );
    }
}
