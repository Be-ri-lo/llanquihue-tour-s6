package org.agencia.model;

public interface Registrable {

    /**
     * Contrato común para todas las entidades gestionables de la agencia.
     * Cada clase que implemente esta interfaz debe retornar un texto con
     * la información relevante de la entidad, personalizado según su tipo.
     *
     * @return resumen legible de la entidad.
     */
    String mostrarResumen();
}
