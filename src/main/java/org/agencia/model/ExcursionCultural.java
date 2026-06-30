package org.agencia.model;

/**
 * Subclase que representa una excursión cultural.
 * Hereda de ServicioTuristico y agrega el atributo
 * específico lugarHistorico.
 */
public class ExcursionCultural extends ServicioTuristico {

    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        //metodo que permite crear el servicio turistico.
        super(nombre, duracionHoras);
        // atributo solo de clase hija
        this.lugarHistorico = lugarHistorico;
    }

    //Setter y Getter solo de la clase hija
    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(String lugarHistorico) {
        this.lugarHistorico = lugarHistorico;
    }

    //Override toString
    @Override
    public String toString() {
        return "[Excursión Cultural] " + super.toString() +
               " | Lugar histórico: " + lugarHistorico;
    }
}
