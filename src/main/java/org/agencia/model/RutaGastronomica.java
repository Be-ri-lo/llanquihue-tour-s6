package org.agencia.model;

/**
 * Subclase que representa una ruta gastronómica.
 * Hereda de ServicioTuristico y agrega el atributo
 * específico numeroDeParadas.
 */
public class RutaGastronomica extends ServicioTuristico {

    private int numeroDeParadas;

    public RutaGastronomica(String nombre, int duracionHoras, int numeroDeParadas) {
        super(nombre, duracionHoras);
        this.numeroDeParadas = numeroDeParadas;
    }

    /**
     * Sobrescribe mostrarInformacion() con información específica de cada tipo
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo: Ruta Gastronómica | N° de paradas: " + numeroDeParadas);
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public String toString() {
        return "[Ruta Gastronómica] " + super.toString() +
               " | Paradas: " + numeroDeParadas;
    }

    /**
     * Implementa el método de la interfaz {@link Registrable}, heredada por
     * {@link ServicioTuristico}. Reutiliza {@link #toString()} porque ya
     * contiene toda la información relevante de la ruta.
     *
     * @return resumen de la ruta gastronómica.
     */
    @Override
    public String mostrarResumen() {
        return toString();
    }
}
