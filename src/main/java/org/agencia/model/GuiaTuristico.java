package org.agencia.model;

/**
 * Representa un guía turístico vinculado a la agencia Llanquihue Tour.
 * Hereda de {@link Persona} (nombre, teléfono) y agrega los atributos
 * propios de un guía: especialidad y años de experiencia.
 */
public class GuiaTuristico extends Persona {

    /** Largo máximo permitido para la especialidad. */
    public static final int MAX_LARGO_ESPECIALIDAD = 30;

    /** Rango válido de años de experiencia. */
    public static final int ANIOS_EXPERIENCIA_MINIMO = 0;
    public static final int ANIOS_EXPERIENCIA_MAXIMO = 99;

    private String especialidad;
    private int aniosExperiencia;

    public GuiaTuristico(String nombre, String especialidad, String telefono, int aniosExperiencia) {
        super(nombre, telefono);
        setEspecialidad(especialidad);
        setAniosExperiencia(aniosExperiencia);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("La especialidad no puede estar vacía.");
        }
        if (especialidad.trim().length() > MAX_LARGO_ESPECIALIDAD) {
            throw new IllegalArgumentException(
                    "La especialidad no puede superar los " + MAX_LARGO_ESPECIALIDAD + " caracteres.");
        }
        this.especialidad = especialidad.trim();
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        if (aniosExperiencia < ANIOS_EXPERIENCIA_MINIMO || aniosExperiencia > ANIOS_EXPERIENCIA_MAXIMO) {
            throw new IllegalArgumentException(
                    "Los años de experiencia deben estar entre " + ANIOS_EXPERIENCIA_MINIMO +
                            " y " + ANIOS_EXPERIENCIA_MAXIMO + ".");
        }
        this.aniosExperiencia = aniosExperiencia;
    }

    /**
     * Implementa el método de la interfaz {@link Registrable}, retornando
     * un resumen con los datos propios de un guía turístico.
     *
     * @return resumen del guía con nombre, especialidad, teléfono y experiencia.
     */
    @Override
    public String mostrarResumen() {
        return "[Guía Turístico] " + getNombre() +
                " | Especialidad: " + especialidad +
                " | Teléfono: " + getTelefono() +
                " | Experiencia: " + aniosExperiencia + " años";
    }

    @Override
    public String toString() {
        return "GuiaTuristico{" +
                "nombre='" + getNombre() + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", aniosExperiencia=" + aniosExperiencia +
                '}';
    }
}
