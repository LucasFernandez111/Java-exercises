package personas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

// -------------------------------------------------------------------------------------------------------
// 1. Implementar un método estático getPersonas que reciba el nombre de un archivo 
//    y devuelva un objeto LinkedList con personas que fueron leídas del archivo de texto 
//    con formato “dni apellido edad”.

// 2. Implementar un método estático getPersonasMayoresAEdad que reciba un objeto LinkedList 
//    y una edad, y devuelva otro objeto LinkedList con las personas cuyas edades son mayores a esa edad.

// 3. Sobreescribir los métodos: equals de Object para determinar que dos objetos personas 
//    son iguales si sus dni's son iguales, toString para aplanar el objeto a una cadena 
//    que contiene los colaboradores internos del objeto separados por “,”.

// 4. Rehacer el punto 1, pero evitando cargar del archivo personas repetidas.

// 5. Generar el archivo personasMayoresDeX.csv con el resultado del punto 2 
//    en dos versiones: ordenado por Apellido y ordenado por DNI.
// -------------------------------------------------------------------------------------------------------

public class GestionarPersonas {

    public static LinkedList<Persona> getPersonas(String archivo) {

        LinkedList<Persona> personas = new LinkedList<Persona>();

        try {
            File file = new File(archivo);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();

                String[] datos = linea.split(" ");

                int dni = Integer.parseInt(datos[0]);
                String apellido = datos[1];
                int edad = Integer.parseInt(datos[2]);

                Persona persona = new Persona(dni, apellido, edad);

                // Verificacion por DNI
                if (!personas.contains(persona)) {
                    personas.add(persona);
                }

            }

            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.getStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("El formato del archivo no es correcto");
            e.getStackTrace();
        }
        return personas;
    }

    public static LinkedList<Persona> getPersonasMayoresAEdad(LinkedList<Persona> personas, int edad) {
        LinkedList<Persona> personasMayores = new LinkedList<Persona>();

        for (Persona persona : personas) {
            if (persona.getEdad() > edad) {
                personasMayores.add(persona);
            }
        }

        return personasMayores;

    }

    public static void generarDocumentoPersonas(LinkedList<Persona> personas, String archivo) {

        try {

            FileWriter fw = new FileWriter(new File(archivo));

            for (Persona persona : personas) {
                fw.write(persona.toString() + "\n");
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("No se pudo crear el archivo");
            e.getStackTrace();
        }
    }

    public static LinkedList<Persona> ordenarPorDNI(LinkedList<Persona> personas) {
        LinkedList<Persona> copiaPersonas = new LinkedList<Persona>(personas);
        Collections.sort(personas, new ComparadorDeEdad());

        return copiaPersonas;
    }

    public static LinkedList<Persona> ordenarPorApellido(LinkedList<Persona> personas) {

        LinkedList<Persona> copiaPersonas = new LinkedList<Persona>(personas);
        Collections.sort(copiaPersonas);

        return copiaPersonas;
    }

    public static void main(String[] args) {
        LinkedList<Persona> personas = GestionarPersonas.getPersonas("src/datos-personas.txt");

        LinkedList<Persona> personasMayores = GestionarPersonas.getPersonasMayoresAEdad(personas, 70);
        LinkedList<Persona> personasOrdenadasPorApellido = GestionarPersonas.ordenarPorApellido(personas);
        LinkedList<Persona> personasOrdenadasPorDNI = GestionarPersonas.ordenarPorDNI(personas);

        GestionarPersonas.generarDocumentoPersonas(personasMayores,
                "src/personasMayoresDe70.csv");
        GestionarPersonas.generarDocumentoPersonas(personasOrdenadasPorApellido,
                "src/personasOrdenadasPorApellido.csv");
        GestionarPersonas.generarDocumentoPersonas(personasOrdenadasPorDNI,
                "src/personasOrdenadasPorDNI.csv");

    }

}
