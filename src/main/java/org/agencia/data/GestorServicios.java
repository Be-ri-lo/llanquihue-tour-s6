package org.agencia.data;

import org.agencia.model.ExcursionCultural;
import org.agencia.model.PaseoLacustre;
import org.agencia.model.RutaGastronomica;
import org.agencia.model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de crear instancias de los servicios turísticos
 * y de administrarlos como una colección polimórfica.
 * Pertenece a la capa de datos.
 */
public class GestorServicios {

    /**
     * Crea y retorna una colección polimórfica de servicios turísticos,
     * combinando distintas subclases de ServicioTuristico.
     */
    public List<ServicioTuristico> crearServicios() {
        List<ServicioTuristico> servicios = new ArrayList<>();

        servicios.add(new RutaGastronomica("Sabores del Lago", 4, 5));
        servicios.add(new RutaGastronomica("Ruta del Salmón Chilote", 6, 8));
        servicios.add(new PaseoLacustre("Navegación Lago Llanquihue", 3, "Catamarán"));
        servicios.add(new PaseoLacustre("Recorrido Lago Todos los Santos", 5, "Lancha a motor"));
        servicios.add(new ExcursionCultural("Historia de Puerto Varas", 3, "Iglesia del Sagrado Corazón"));
        servicios.add(new ExcursionCultural("Legado Alemán en Los Lagos", 4, "Museo Colonial Alemán de Frutillar"));

        return servicios;
    }

    /**
     * Recorre la colección de servicios y muestra la información de cada uno.
     * Al invocar mostrarInformacion() desde la referencia ServicioTuristico,
     * cada objeto ejecuta su propia versión sobrescrita (polimorfismo).
     */
    public void mostrarServicios() {
        List<ServicioTuristico> servicios = crearServicios();

        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
            System.out.println("--------------------------------------------");
        }
    }
}
