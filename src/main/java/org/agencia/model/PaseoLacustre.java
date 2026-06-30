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
}
