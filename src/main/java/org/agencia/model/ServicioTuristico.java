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
        setNombre(nombre);
        setDuracionHoras(duracionHoras);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        if (duracionHoras <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor a 0.");
        }
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Duración: " + duracionHoras + " horas";
    }
}
