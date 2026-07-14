package org.agencia.model;

/**
 * Clase base común para las entidades de la agencia que representan
 * personas (guías turísticos, colaboradores externos, etc.).
 * Concentra los atributos y validaciones compartidos por todas ellas.
 */
public abstract class Persona implements Registrable {

    /**
     * Formato aceptado para el teléfono: solo números y espacios, con un
     * '+' opcional al inicio (ej. "+56 9 1111 2222"), entre 8 y 15 caracteres.
     */
    public static final String TELEFONO_REGEX = "^\\+?[0-9 ]{8,15}$";

    /** Largo máximo permitido para el nombre (solo nombre y apellido paterno). */
    public static final int MAX_LARGO_NOMBRE = 40;

    private String nombre;
    private String telefono;

    public Persona(String nombre, String telefono) {
        setNombre(nombre);
        setTelefono(telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (nombre.trim().length() > MAX_LARGO_NOMBRE) {
            throw new IllegalArgumentException(
                    "El nombre no puede superar los " + MAX_LARGO_NOMBRE +
                            " caracteres (solo nombre y apellido paterno).");
        }
        this.nombre = nombre.trim();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        String telefonoLimpio = telefono.trim();
        if (!telefonoLimpio.matches(TELEFONO_REGEX)) {
            throw new IllegalArgumentException(
                    "El teléfono debe contener solo números y espacios (puede iniciar con '+'), "
                            + "entre 8 y 15 caracteres. Ej: +56 9 1111 2222");
        }
        this.telefono = telefonoLimpio;
    }

    /**
     * Cada subclase de Persona debe personalizar su propio resumen.
     */
    @Override
    public abstract String mostrarResumen();
}
