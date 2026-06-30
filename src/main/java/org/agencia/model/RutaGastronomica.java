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
        setNumeroDeParadas(numeroDeParadas);
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {
        if (numeroDeParadas <= 0) {
            throw new IllegalArgumentException("El número de paradas debe ser mayor a 0.");
        }
        this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public String toString() {
        return "[Ruta Gastronómica] " + super.toString() +
               " | Paradas: " + numeroDeParadas;
    }
}
