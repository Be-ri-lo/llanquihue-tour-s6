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
 */
public class GestorServicios {

    /**
     * Crea y retorna una colección polimórfica de servicios turísticos
     * En el paquete data/, modifica o crea la clase GestorServicios:
     * Declara una colección de tipo List<ServicioTuristico>.
     * Carga en la lista al menos cinco objetos combinando instancias de las distintas
     * subclases.
     * Puedes crear los objetos manualmente; no es necesario leerlos desde archivo.
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
     * Recorre y muestra los objetos aplicando polimorfismo
     * Desde GestorServicios o Main, recorre la colección usando un bucle for-each.
     * Llama al método mostrarInformacion() desde la referencia de tipo
     * ServicioTuristico.
     * No es necesario ni obligatorio usar instanceof
     */
    public void mostrarServicios() {
        List<ServicioTuristico> servicios = crearServicios();

        for (ServicioTuristico servicio : servicios) {
            servicio.mostrarInformacion();
            System.out.println("--------------------------------------------");
        }
    }
}
