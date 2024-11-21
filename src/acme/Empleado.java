package acme;

public class Empleado {

    private int sector; // entre 100 y 300
    private int legajo;
    private String nombre;
    private int antiguedad;

    private boolean esSectorValido(int sector) {
        return (sector >= 100 && sector <= 300);
    }

    public Empleado(int sector, int legajo, String nombre, int antiguedad) {

        if (!esSectorValido(sector)) {
            throw new IllegalArgumentException("Numero de sector invalido");
        }
        this.sector = sector;
        this.legajo = legajo;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
    }

    public int getSector() {
        return sector;
    }

    public void setSector(int sector) {
        if (!esSectorValido(sector)) {
            throw new IllegalArgumentException("Numero de sector invalido");
        }
        this.sector = sector;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    @Override
    public String toString() {
        return sector + "," + legajo + "," + nombre + "," + antiguedad;
    }

}
