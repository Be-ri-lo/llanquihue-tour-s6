package org.agencia.ui;

import org.agencia.data.GestorServicios;
import org.agencia.model.ServicioTuristico;

import java.util.List;

/**
 * Clase principal del sistema Llanquihue Tour – Semana 7.
 */
public class Main {

    /**
     * Llamar al método del GestorServicios que retorna la lista.
     * Mostrar los resultados por consola y verificar que el comportamiento sea el esperado
     * según el tipo de servicio.
     */

    public static void main(String[] args) {

        System.out.println("   LLANQUIHUE TOUR - Servicios Turísticos  ");

        GestorServicios gestor = new GestorServicios();
        List<ServicioTuristico> servicios = gestor.crearServicios();

        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
            System.out.println("--------------------------------------------");
        }

        System.out.println("          Fin del catálogo de servicios     ");
    }
}
