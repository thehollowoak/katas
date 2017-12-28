package com.audition.pacman;

public class Point {

    private int x, y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point (Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void translate(Direction d) {
        x += d.getX();
        y += d.getY();
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Point)) {
            return false;
        }
        Point otherPoint = (Point) other;
        return this.x == otherPoint.x && this.y == otherPoint.y;
    }
}