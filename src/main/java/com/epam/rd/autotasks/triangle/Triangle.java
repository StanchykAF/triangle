package com.epam.rd.autotasks.triangle;

import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Triangle {

    private final double ab;
    private final double bc;
    private final double ac;
    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        ab = new Segment(a, b).length();
        bc = new Segment(b, c).length();
        ac = new Segment(a, c).length();
        //System.out.println(ab + " " + bc + " " + ac);
        this.a = a;
        this.b = b;
        this.c = c;

        if ((ab >= bc + ac) || (bc >= ab + ac) || (ac >= bc + ab)) {
            throw new IllegalArgumentException();
        }
    }

    public double area() {
        return sqrt(pow(pow(ab, 2) + pow(bc, 2) + pow(ac, 2), 2) - 2 * (pow(ab, 4) + pow(bc, 4) + pow(ac, 4))) / 4;
    }

    public Point centroid(){
        Point midPointBC = new Segment(b, c).middle();
        Point midpointAC = new Segment(a, c).middle();

        return (new Segment(a, midPointBC).intersection(new Segment(b, midpointAC)));
    }

}
