package org.agencia.model;

/**
 * Representa un vehículo de la agencia usado para trasladar a los turistas.
 * No es una {@link Persona}, por lo que implementa {@link Registrable}
 * de forma directa: comparte el contrato común sin compartir herencia
 * con las entidades de tipo persona.
 */
public class Vehiculo implements Registrable {

    /**
     * Formato de patente chilena vigente: 4 letras, un guion y 2 números
     * (ej. "FFTT-34").
     */
    public static final String PATENTE_REGEX = "^[A-Z]{4}-[0-9]{2}$";

    /** Rango válido de capacidad (N° de pasajeros). */
    public static final int CAPACIDAD_MINIMA = 1;
    public static final int CAPACIDAD_MAXIMA = 99;

    private String tipo;
    private String patente;
    private int capacidad;

    public Vehiculo(String tipo, String patente, int capacidad) {
        setTipo(tipo);
        setPatente(patente);
        setCapacidad(capacidad);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("El tipo de vehículo no puede estar vacío.");
        }
        this.tipo = tipo.trim();
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        if (patente == null || patente.isBlank()) {
            throw new IllegalArgumentException("La patente no puede estar vacía.");
        }
        String patenteNormalizada = patente.trim().toUpperCase();
        if (!patenteNormalizada.matches(PATENTE_REGEX)) {
            throw new IllegalArgumentException(
                    "La patente debe tener el formato chileno de 4 letras, un guion y 2 números. Ej: FFTT-34");
        }
        this.patente = patenteNormalizada;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad < CAPACIDAD_MINIMA || capacidad > CAPACIDAD_MAXIMA) {
            throw new IllegalArgumentException(
                    "La capacidad debe estar entre " + CAPACIDAD_MINIMA +
                            " y " + CAPACIDAD_MAXIMA + " pasajeros.");
        }
        this.capacidad = capacidad;
    }

    /**
     * Implementa el método de la interfaz {@link Registrable}, retornando
     * un resumen con los datos propios del vehículo. A diferencia de
     * {@link GuiaTuristico} y {@link ColaboradorExterno}, Vehiculo no
     * hereda de {@link Persona}, sino que implementa el contrato directamente.
     *
     * @return resumen del vehículo con tipo, patente y capacidad.
     */
    @Override
    public String mostrarResumen() {
        return "[Vehículo] " + tipo +
                " | Patente: " + patente +
                " | Capacidad: " + capacidad + " pasajeros";
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "tipo='" + tipo + '\'' +
                ", patente='" + patente + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
