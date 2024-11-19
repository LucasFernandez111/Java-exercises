package personas;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

    private int DNI;
    private String apellido;
    private int edad;

    public Persona(int dni, String apellido, int edad) {
        this.DNI = dni;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int dni) {
        this.DNI = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Persona))
            return false;
        Persona otraPersona = (Persona) obj;

        return Objects.equals(this.DNI, otraPersona.DNI);
    }

    @Override
    public String toString() {
        return "dni=" + DNI + ", apellido=" + apellido + ", edad=" + edad;
    }

    @Override
    public int compareTo(Persona otra) {
        return this.apellido.compareTo(otra.apellido);
    }

}
