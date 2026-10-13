package model;

import excepciones.PedidoInvalidoException;

public class Pedido {

    private Cliente cliente;
    private double importeTotal;

    private Pedido(Cliente cliente, double importeTotal) {
        this.cliente = cliente;
        this.importeTotal = importeTotal;
    }

    public static Pedido crear(Cliente cliente, double importeTotal) {
        if (cliente == null) {
            throw new PedidoInvalidoException("El cliente es obligatorio");
        }

        if (importeTotal <= 0) {
            throw new PedidoInvalidoException("El importe debe ser mayor que cero");
        }

        return new Pedido(cliente, importeTotal);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getImporteTotal() {
        return importeTotal;
    }
}