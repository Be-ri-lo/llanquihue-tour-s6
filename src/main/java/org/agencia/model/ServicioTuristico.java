package org.agencia.model;

/**
 * Superclase que representa un servicio turístico genérico.
 * Contiene los atributos comunes que comparten todos los tipos
 * de servicios ofrecidos por Llanquihue Tour.
 */
public class ServicioTuristico {

    private String nombre;
    private int duracionHoras;

    public ServicioTuristico(String nombre, int duracionHoras) {
        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    /**
     * Muestra la información básica del servicio. Las subclases
     * sobrescriben este método para agregar sus atributos propios.
     */
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + " | Duración: " + duracionHoras + " horas");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Duración: " + duracionHoras + " horas";
    }
}
