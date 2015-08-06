package com.example.fenix.fortest;

/**
 * Created by Fenix on 27.05.2015.
 */
public final class Dot {
    private final float x, y;
    private final int color;
    private final int diameter;

    /**
     * @param x координата по горизонталі
     * @param y     координата по вертикали
     * @param color цвет
     * @param diameter диаметр точки
     */
    public Dot(float x, float y, int color, int diameter) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.diameter = diameter;
    }
    /** @return координаты по горизонтали */
    public float getX() { return x; }
    /** @return координаты по вертикали. */
    public float getY() { return y; }
    /** @return цвета */
    public int getColor() { return color; }
    /** @return диаметра точки. */
    public int getDiameter() { return diameter; }
}

