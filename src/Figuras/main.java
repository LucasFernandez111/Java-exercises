package Figuras;

import java.util.Arrays;

public class main {

    public static void main(String[] args) {
        Figura figuras[] = {
                new Cuadrado(5),
                new Circulo(4.5),
                new Rectangulo(5, 10),
                new Elipse(5, 10),
                new Triangulo(5, 10)
        };

        double sumaFiguras = Arrays.stream(figuras).reduce(0.0, (acc, figura) -> acc + figura.getArea(), Double::sum);

        System.out.println(sumaFiguras);
    }
}
