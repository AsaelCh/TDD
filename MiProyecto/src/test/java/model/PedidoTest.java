package model;

import excepciones.PedidoInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    @Test
    void crearPedidoValido() {
        Cliente cliente = Cliente.crear("Juan", "juan@gmail.com", 25);

        Pedido pedido = Pedido.crear(cliente, 50000);

        assertNotNull(pedido);
        assertEquals(cliente, pedido.getCliente());
        assertEquals(50000, pedido.getImporteTotal());
    }

    @Test
    void rechazarClienteNulo() {
        assertThrows(PedidoInvalidoException.class,
                () -> Pedido.crear(null, 50000));
    }

    @Test
    void rechazarImporteCero() {
        Cliente cliente = Cliente.crear("Juan", "juan@gmail.com", 25);

        assertThrows(PedidoInvalidoException.class,
                () -> Pedido.crear(cliente, 0));
    }

    @Test
    void rechazarImporteNegativo() {
        Cliente cliente = Cliente.crear("Juan", "juan@gmail.com", 25);

        assertThrows(PedidoInvalidoException.class,
                () -> Pedido.crear(cliente, -100));
    }
}