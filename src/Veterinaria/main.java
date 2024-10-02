package Veterinaria;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<Animal> animales = new ArrayList<Animal>();

        animales.add(new Perro("Firulais", 5));
        animales.add(new Gato("Garfield", 3));
        animales.add(new Perro("Dalmata", 10));
        animales.add(new Gato("Pelusa", 1));

        for (Animal animal : animales) {
            animal.hacerSonido();
        }
    }
}
