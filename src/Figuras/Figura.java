package Figuras;

public abstract class Figura implements Comparable<Figura> {

    private double area;

    public Figura(double area) {
        this.area = area;
    }

    public final double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Figura o) {
        return Double.compare(this.getArea(), o.getArea());
    }

}
