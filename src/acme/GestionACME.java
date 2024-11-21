package acme;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GestionACME {

    private Map<Integer, List<Empleado>> mapEmpleados;

    public GestionACME() {
        this.mapEmpleados = new HashMap<Integer, List<Empleado>>();
    }

    public Map<Integer, List<Empleado>> getMapEmpleados() {
        return mapEmpleados;
    }

    public void setMapEmpleados(Map<Integer, List<Empleado>> empleados) {
        this.mapEmpleados = empleados;
    }

    public Map<Integer, List<Empleado>> leerArchivoPersonal(String entrada) {

        try (FileReader fileReader = new FileReader(entrada)) {

            BufferedReader bufferReader = new BufferedReader(fileReader);

            String linea;
            while ((linea = bufferReader.readLine()) != null) {

                String[] datos = linea.split(",");

                int sector = Integer.parseInt(datos[0]);
                int legajo = Integer.parseInt(datos[1]);
                String nombre = datos[2];
                int antiguedad = Integer.parseInt(datos[3]);

                Empleado empleado = new Empleado(sector, legajo, nombre, antiguedad);

                if (mapEmpleados.containsKey(sector)) {
                    mapEmpleados.get(sector).add(empleado);

                } else {
                    LinkedList<Empleado> empleados = new LinkedList<Empleado>();
                    empleados.add(empleado);

                    mapEmpleados.put(sector, empleados);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo en: " + entrada);
            e.getStackTrace();

        } catch (IOException e) {
            System.err.println("Error de al leer el archivo");
            e.getStackTrace();

        } catch (NumberFormatException e) {
            System.err.println("Error al convertir string a entero");
            e.getStackTrace();
        }
        return getMapEmpleados();
    }

    public void listarEmpleadosDelSector(int sector, Map<Integer, List<Empleado>> empleados) {

        if (sector < 100 || sector > 300)
            throw new IllegalArgumentException("Sector fuera de rango");

        if (!empleados.containsKey(sector))
            throw new IllegalArgumentException("No existe sector en Map");

        String archivo = "src/acme/empleadosDelSector" + sector + ".csv";

        try (FileWriter fw = new FileWriter(archivo)) {

            PrintWriter printer = new PrintWriter(fw);

            List<Empleado> listEmpleados = empleados.get(sector);

            for (Empleado empleado : listEmpleados) {

                printer.println(empleado);
            }
        } catch (IOException e) {
            System.out.println("Hubo un problema al escribir el archivo");
            e.getStackTrace();
        }
    }

    @Override
    public String toString() {
        return "GestionACME [empleados=" + mapEmpleados + "]";
    }

    public static void main(String[] args) {
        GestionACME gestion = new GestionACME();
        Map<Integer, List<Empleado>> mapEmpleados = gestion.leerArchivoPersonal("src/acme/personal.csv");

        gestion.listarEmpleadosDelSector(200, mapEmpleados);
    }
}
