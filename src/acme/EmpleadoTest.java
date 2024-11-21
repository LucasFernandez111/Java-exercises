package acme;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class EmpleadoTest {

    @Test
    void testSetSector() {

        Empleado empleado = new Empleado(200, 200, "Lucas", 2);

        assertThrows(IllegalArgumentException.class, () -> {
            empleado.setSector(0);
        });
    }
}
