
package model;

import excepciones.ClienteInvalidoException;

public class Cliente {

    private String nombre;
    private String email;
    private int edad;

    private Cliente(String nombre, String email, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    public static Cliente crear(String nombre, String email, int edad) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ClienteInvalidoException("El nombre es obligatorio");
        }

        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new ClienteInvalidoException("El email no es valido");
        }

        if (edad < 18 || edad > 100) {
            throw new ClienteInvalidoException("La edad debe estar entre 18 y 100");
        }

        return new Cliente(nombre, email, edad);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getEdad() {
        return edad;
    }
}

