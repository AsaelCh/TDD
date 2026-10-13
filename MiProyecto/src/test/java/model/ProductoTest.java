package model;

import excepciones.ProductoInvalidoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    @Test
    void crearProductoValido() {
        Producto producto = Producto.crear("Teclado", 25000, 10);

        assertNotNull(producto);
        assertEquals("Teclado", producto.getNombre());
        assertEquals(25000, producto.getPrecio());
        assertEquals(10, producto.getStock());
    }

    @Test
    void rechazarNombreVacio() {
        assertThrows(ProductoInvalidoException.class,
                () -> Producto.crear("", 25000, 10));
    }

    @Test
    void rechazarPrecioCero() {
        assertThrows(ProductoInvalidoException.class,
                () -> Producto.crear("Teclado", 0, 10));
    }

    @Test
    void rechazarPrecioNegativo() {
        assertThrows(ProductoInvalidoException.class,
                () -> Producto.crear("Teclado", -100, 10));
    }

    @Test
    void rechazarStockNegativo() {
        assertThrows(ProductoInvalidoException.class,
                () -> Producto.crear("Teclado", 25000, -1));
    }
}