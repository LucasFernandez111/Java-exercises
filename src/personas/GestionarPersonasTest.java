package personas;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class GestionarPersonasTest {
    /**
     * Tests that the getPersonas method returns the correct number of personas
     * from a given file.
     */
    @Test
    void testGetPersonas() {

        LinkedList<Persona> personas = GestionarPersonas.getPersonas("src/datos-personas.txt");

        int cantPersonas = 20;

        assertEquals(personas.size(), cantPersonas);

    }

    /**
     * Tests that the getPersonasMayoresAEdad method returns the correct number of
     * personas
     * from a given list of personas and age.
     */
    @Test
    void testGetPersonasMayoresAEdad() {

        LinkedList<Persona> personas = GestionarPersonas.getPersonas("src/datos-personas.txt");
        LinkedList<Persona> personasMayores = GestionarPersonas.getPersonasMayoresAEdad(personas, 70);

        assertEquals(personasMayores.size(), 3);
    }

    @Test
    void testGenerarDocumentoPersonas() {

    }

    @Test
    void testOrdenarPorApellido() {

    }

    @Test
    void testOrdenarPorDNI() {

    }
}
