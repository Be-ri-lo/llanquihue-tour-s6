package org.agencia.model;

/**
 * Subclase que representa un paseo lacustre.
 * Hereda de ServicioTuristico y agrega el atributo
 * específico tipoEmbarcacion.
 */
public class PaseoLacustre extends ServicioTuristico {

    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    /**
    * Sobrescribe mostrarInformacion() con información específica de cada tipo
    */
    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo: Paseo Lacustre | Embarcación: " + tipoEmbarcacion);
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    @Override
    public String toString() {
        return "[Paseo Lacustre] " + super.toString() +
               " | Embarcación: " + tipoEmbarcacion;
    }

    /**
     * Implementa el método de la interfaz {@link Registrable}, heredada por
     * {@link ServicioTuristico}. Reutiliza {@link #toString()} porque ya
     * contiene toda la información relevante del paseo.
     *
     * @return resumen del paseo lacustre.
     */
    @Override
    public String mostrarResumen() {
        return toString();
    }
}
