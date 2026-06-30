package org.agencia.model;

/**
 * Subclase que representa una excursión cultural.
 * Hereda de ServicioTuristico y agrega el atributo
 * específico lugarHistorico.
 */
public class ExcursionCultural extends ServicioTuristico {

    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);
        setLugarHistorico(lugarHistorico);
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        if (lugarHistorico == null || lugarHistorico.isBlank()) {
            throw new IllegalArgumentException("El lugar histórico no puede estar vacío.");
        }
        this.lugarHistorico = lugarHistorico;
    }

    @Override
    public String toString() {
        return "[Excursión Cultural] " + super.toString() +
               " | Lugar histórico: " + lugarHistorico;
    }
}
