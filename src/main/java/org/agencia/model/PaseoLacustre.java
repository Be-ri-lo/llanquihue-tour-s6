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
        setTipoEmbarcacion(tipoEmbarcacion);
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(String tipoEmbarcacion) {
        if (tipoEmbarcacion == null || tipoEmbarcacion.isBlank()) {
            throw new IllegalArgumentException("El tipo de embarcación no puede estar vacío.");
        }
        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    @Override
    public String toString() {
        return "[Paseo Lacustre] " + super.toString() +
               " | Embarcación: " + tipoEmbarcacion;
    }
}
