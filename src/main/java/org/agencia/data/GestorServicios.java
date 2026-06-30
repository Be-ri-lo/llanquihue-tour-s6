package org.agencia.data;

import org.agencia.model.ExcursionCultural;
import org.agencia.model.PaseoLacustre;
import org.agencia.model.RutaGastronomica;

/**
 * Clase encargada de crear instancias de prueba de los
 * servicios turísticos. Pertenece a la capa de datos.
 */
public class GestorServicios {

    public void mostrarServicios() {

        System.out.println("--- RUTAS GASTRONÓMICAS ---");
        RutaGastronomica ruta1 = new RutaGastronomica("Sabores del Lago", 4, 5);
        RutaGastronomica ruta2 = new RutaGastronomica("Ruta del Salmón Chilote", 6, 8);
        System.out.println(ruta1);
        System.out.println(ruta2);

        System.out.println("\n--- PASEOS LACUSTRES ---");
        PaseoLacustre paseo1 = new PaseoLacustre("Navegación Lago Llanquihue", 3, "Catamarán");
        PaseoLacustre paseo2 = new PaseoLacustre("Recorrido Lago Todos los Santos", 5, "Lancha a motor");
        System.out.println(paseo1);
        System.out.println(paseo2);

        System.out.println("\n=== EXCURSIONES CULTURALES ===");
        ExcursionCultural excursion1 = new ExcursionCultural("Historia de Puerto Varas", 3, "Iglesia del Sagrado Corazón");
        ExcursionCultural excursion2 = new ExcursionCultural("Legado Alemán en Los Lagos", 4, "Museo Colonial Alemán de Frutillar");
        System.out.println(excursion1);
        System.out.println(excursion2);
    }
}
