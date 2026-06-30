package org.agencia.ui;

import org.agencia.data.GestorServicios;

/**
 * Clase principal del sistema Llanquihue Tour – Semana 6.
 * Ejecuta el programa y muestra los servicios turísticos
 * creados mediante la jerarquía de herencia.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("   LLANQUIHUE TOUR - Servicios Turísticos  ");
        System.out.println("============================================\n");

        GestorServicios gestor = new GestorServicios();
        gestor.mostrarServicios();

        System.out.println("\n============================================");
        System.out.println("          Fin del catálogo de servicios     ");
        System.out.println("============================================");
    }
}
