package model;

import excepciones.ClienteInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
     @Test
     void crearClienteValido() {
         Cliente cliente = Cliente.crear("Juan", "juan@gmail.com", 25);

         assertNotNull(cliente);
         assertEquals("Juan", cliente.getNombre());
         assertEquals("juan@gmail.com", cliente.getEmail());
         assertEquals(25, cliente.getEdad());
     }

    @Test
    void rechazarNombreVacio() {
        assertThrows(ClienteInvalidoException.class,
                () -> Cliente.crear("", "juan@gmail.com", 25));
    }


    @Test
    void rechazarEmailInvalido() {
        assertThrows(ClienteInvalidoException.class,
                () -> Cliente.crear("Juan", "correo-invalido", 25));
    }

    @Test
    void rechazarEdadMenorDe18() {
        assertThrows(ClienteInvalidoException.class,
                () -> Cliente.crear("Juan", "juan@gmail.com", 17));
    }

    @Test
    void rechazarEdadMayorDe100() {
        assertThrows(ClienteInvalidoException.class,
                () -> Cliente.crear("Juan", "juan@gmail.com", 101));
    }



}
