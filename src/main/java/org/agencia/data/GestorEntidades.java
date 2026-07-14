package org.agencia.data;

import org.agencia.model.GuiaTuristico;
import org.agencia.model.Registrable;
import org.agencia.model.RutaGastronomica;
import org.agencia.model.Vehiculo;
import org.agencia.model.ColaboradorExterno;

import java.util.ArrayList;
import java.util.List;

public class GestorEntidades {

    //colección genérica
    private final ArrayList<Registrable> entidades = new ArrayList<>();

    public GestorEntidades() {
        entidades.add(new GuiaTuristico("Juan Pérez", "Escalada", "+56 9 1111 2222", 5));
        entidades.add(new Vehiculo("Minibus", "FFTT-34", 15));
        entidades.add(new ColaboradorExterno("María Soto", "+56 9 3333 4444", "Hotel Frutillar", "Alojamiento"));
        entidades.add(new RutaGastronomica("Sabores del Lago", 4, 5));
    }

    //método que se usa en InterfazEntidades
    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

    //método que se usa en InterfazEntidades
    public List<Registrable> getEntidades() {
        return entidades;
    }

    /**
     * Recorre la colección con un for-each y llama a {@link Registrable#mostrarResumen()}
     * sobre cada objeto. Gracias al polimorfismo, cada entidad ejecuta su propia
     * versión de ese método, sin importar su clase real. Además, usa
     * {@code instanceof} para mostrar un dato adicional específico según el tipo.
     */
    public void mostrarEntidades() {
        for (Registrable entidad : entidades) {
            System.out.println(entidad.mostrarResumen());

            if (entidad instanceof GuiaTuristico guia) {
                System.out.println("   -> Especialidad: " + guia.getEspecialidad());
            } else if (entidad instanceof Vehiculo vehiculo) {
                System.out.println("   -> Capacidad: " + vehiculo.getCapacidad() + " pasajeros");
            } else if (entidad instanceof ColaboradorExterno colaborador) {
                System.out.println("   -> Tipo de servicio: " + colaborador.getTipoServicio());
            }
        }
    }
}