package estadio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionEventos {

    private Map<String, EspectadoresPorEvento> estadio;

    public GestionEventos() {
        this.estadio = new HashMap<String, EspectadoresPorEvento>();
    }

    public void cargarDatosdeLosEventos(String archivo) {

        try {
            File file = new File(archivo);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {

                String linea = sc.nextLine();
                String[] datos = linea.split(",");

                String codigoEvento = datos[0];
                int puerta = Integer.parseInt(datos[1]);
                int espectadores = Integer.parseInt(datos[2]);

                EspectadoresPorEvento espectadoresEventos = new EspectadoresPorEvento();

                espectadoresEventos.ingresarEspectadoresPorLaPuerta(puerta, espectadores);
                estadio.put(codigoEvento, espectadoresEventos);

            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo");
            e.getStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("No se pudo transformar a entero ");
            e.getStackTrace();

        }

    }

    public void generarEspectadoresPorEvento(String salida) {

        try {
            FileWriter fw = new FileWriter(salida);

            for (Map.Entry<String, EspectadoresPorEvento> evento : estadio.entrySet()) {

                fw.write(evento.getKey() + "," + evento.getValue());
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("No se ha podido crear el archivo");
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        GestionEventos gestionEventos = new GestionEventos();
        gestionEventos.cargarDatosdeLosEventos("src/eventos.csv");
        gestionEventos.generarEspectadoresPorEvento("espectadores.csv");
    }
}