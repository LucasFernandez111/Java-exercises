package acme;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.*;

public class GestionACMETest {

    private GestionACME gestionACME;
    private Map<Integer, List<Empleado>> empleados;

    @Before
    public void setUp() {
        gestionACME = new GestionACME();
        empleados = new HashMap<>();
    }

    @Test
    public void testLeerArchivoPersonal() {
        String entrada = "src/acme/personal.csv";
        Map<Integer, List<Empleado>> resultado = gestionACME.leerArchivoPersonal(entrada);
        assertNotNull("El mapa de empleados no debe ser nulo", resultado);
        assertTrue("El mapa de empleados debe contener al menos un sector", !resultado.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListarEmpleadosDelSector_FueraDeRango() {
        gestionACME.listarEmpleadosDelSector(99, empleados);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testListarEmpleadosDelSector_SectorNoExistente() {
        gestionACME.listarEmpleadosDelSector(101, empleados);
    }

    @Test
    public void testListarEmpleadosDelSector_Correcto() {
        List<Empleado> empleadosSector200 = new ArrayList<>();
        empleadosSector200.add(new Empleado(200, 1, "Juan", 5));
        empleadosSector200.add(new Empleado(200, 2, "Ana", 3));

        empleados.put(200, empleadosSector200);

        gestionACME.listarEmpleadosDelSector(200, empleados);

        String archivo = "src/acme/empleadosDelSector200Test.csv";
        File file = new File(archivo);
        assertTrue("El archivo no fue creado", file.exists());
    }
}
