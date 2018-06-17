package ru.job4j.condition;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.06.2018.
 */
public class Triangle {

    private Point a;
    private Point b;
    private Point c;

    /**
     * Конструктор треугольника.
     *
     * @param a первая вершина.
     * @param b вторая вершина.
     * @param c третья вершина.
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     * <p>
     * Формула.
     * <p>
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Перимент.
     */
    public double period(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double result = -1;
        double ab = this.a.distanceTo(this.b);
        double ac = this.a.distanceTo(this.c);
        double bc = this.b.distanceTo(this.c);
        double p = this.period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            result = Math.sqrt((p * (p - ab) * (p - ac) * (p - bc)));
        } else {
            result = -1;
        }
        return result;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     * <p>
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     *
     * @param ab Длина от точки a до b.
     * @param ac Длина от точки a до c.
     * @param bc Длина от точки b до c.
     * @return
     */
    private boolean exist(double ab, double ac, double bc) {
        boolean exist = false;
        if (ab < (ac + bc) && ac < (ab + bc) && bc < (ab + ac)) {
            exist = true;
        }
        return exist;
    }
}
