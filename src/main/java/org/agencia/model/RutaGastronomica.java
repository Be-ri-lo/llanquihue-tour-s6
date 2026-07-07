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
        super.mostrarInformacion();
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
}
