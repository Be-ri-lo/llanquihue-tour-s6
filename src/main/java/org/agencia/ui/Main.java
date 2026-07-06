package org.agencia.ui;

import org.agencia.data.GestorServicios;
import org.agencia.model.ServicioTuristico;

import java.util.List;

/**
 * Clase principal del sistema Llanquihue Tour – Semana 6.
 * Obtiene la colección polimórfica desde GestorServicios y la recorre
 * usando referencias de la superclase ServicioTuristico, para comprobar
 * que cada servicio muestra su información según su tipo (polimorfismo).
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   LLANQUIHUE TOUR - Servicios Turísticos  ");
        System.out.println("============================================\n");

        GestorServicios gestor = new GestorServicios();
        List<ServicioTuristico> servicios = gestor.crearServicios();

        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
            System.out.println("--------------------------------------------");
        }

        System.out.println("\n============================================");
        System.out.println("          Fin del catálogo de servicios     ");
        System.out.println("============================================");
    }
}
