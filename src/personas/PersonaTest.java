package personas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;

public class PersonaTest {
    @Test
    void testEquals() {
        Persona persona1 = new Persona(1, "Pepe", 20);
        Persona persona2 = new Persona(1, "Pepe", 20);
        Persona persona3 = new Persona(2, "Pepe", 20);

        assertEquals(persona1, persona2);
        assertNotEquals(persona1, persona3);
    }
}
