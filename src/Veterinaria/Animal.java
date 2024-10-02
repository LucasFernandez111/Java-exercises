package Veterinaria;

public abstract class Animal {
    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Imprime un sonido dependiendo del animal
     */
    public abstract void hacerSonido();

}
