# Llanquihue Tour – Semana 6

## Objetivo de esta semana

Aplicar **polimorfismo** sobre la jerarquía de clases construida previamente con herencia simple, representando los distintos tipos de servicios turísticos que ofrece la agencia Llanquihue Tour.

Lo desarrollado esta semana:

- Se sobrescribió el método `mostrarInformacion()` en cada subclase (`RutaGastronomica`, `PaseoLacustre`, `ExcursionCultural`), agregando su información específica a la de la superclase mediante `super.mostrarInformacion()`.
- Se creó en `GestorServicios` el método `crearServicios()`, que arma una **colección polimórfica** (`List<ServicioTuristico>`) con 6 objetos instanciados a partir de las 3 subclases.
- Se recorre la colección usando únicamente referencias de la superclase `ServicioTuristico`, invocando `mostrarInformacion()`: en tiempo de ejecución cada objeto ejecuta su propia versión sobrescrita según su tipo real (polimorfismo).
- La clase `Main` (paquete `ui`) llama a `crearServicios()` y recorre la lista como punto de entrada central del sistema, verificando el comportamiento esperado por consola.

---

## Estructura del proyecto

```
LlanquihueTourS6/
├── src/main/java/org/agencia/
│   ├── model/
│   │   ├── ServicioTuristico.java     ← Superclase base
│   │   ├── RutaGastronomica.java      ← Subclase
│   │   ├── PaseoLacustre.java         ← Subclase
│   │   └── ExcursionCultural.java     ← Subclase
│   ├── data/
│   │   └── GestorServicios.java       ← Crea instancias de prueba
│   └── ui/
│       └── Main.java                  ← Punto de entrada
├── pom.xml
└── README.md
```

---

## Clases implementadas

| Clase | Paquete | Descripción |
|---|---|---|
| `ServicioTuristico` | `model` | Superclase con atributos `nombre` y `duracionHoras` |
| `RutaGastronomica` | `model` | Hereda de `ServicioTuristico`, agrega `numeroDeParadas` |
| `PaseoLacustre` | `model` | Hereda de `ServicioTuristico`, agrega `tipoEmbarcacion` |
| `ExcursionCultural` | `model` | Hereda de `ServicioTuristico`, agrega `lugarHistorico` |
| `GestorServicios` | `data` | Crea la colección polimórfica (`crearServicios()`) y la recorre (`mostrarServicios()`) |
| `Main` | `ui` | Obtiene la lista desde `GestorServicios` y la recorre por polimorfismo, mostrando resultados por consola |

---

## Conceptos aplicados

- **Herencia simple**: las tres subclases extienden `ServicioTuristico` con `extends`.
- **`super()`**: cada subclase llama al constructor de la superclase para inicializar `nombre` y `duracionHoras`.
- **Sobreescritura de `toString()`** y de **`mostrarInformacion()`**: cada subclase agrega su información específica, llamando a `super.toString()` / `super.mostrarInformacion()` para incluir los atributos heredados.
- **Polimorfismo**: la colección se declara como `List<ServicioTuristico>` y se recorre con esa misma referencia; al invocar `mostrarInformacion()`, Java ejecuta la versión sobrescrita correspondiente al tipo real de cada objeto (enlace dinámico).
- **Encapsulamiento**: atributos privados con getters, setters y validaciones básicas.

---

## Instrucciones para ejecutar

### Desde IntelliJ IDEA
1. Abrir el proyecto `LlanquihueTourS6` en IntelliJ IDEA.
2. Esperar que Maven cargue las dependencias.
3. Navegar a `src/main/java/org/agencia/ui/Main.java`.
4. Hacer clic derecho sobre `Main.java` → **Run 'Main.main()'**.

### Desde terminal (Maven)
```bash
cd LlanquihueTourS6
mvn compile
mvn exec:java -Dexec.mainClass="org.agencia.ui.Main"
```

---

## Salida esperada por consola

```
============================================
   LLANQUIHUE TOUR - Servicios Turísticos
============================================

Nombre: Sabores del Lago | Duración: 4 horas
Tipo: Ruta Gastronómica | N° de paradas: 5
--------------------------------------------
Nombre: Ruta del Salmón Chilote | Duración: 6 horas
Tipo: Ruta Gastronómica | N° de paradas: 8
--------------------------------------------
Nombre: Navegación Lago Llanquihue | Duración: 3 horas
Tipo: Paseo Lacustre | Embarcación: Catamarán
--------------------------------------------
Nombre: Recorrido Lago Todos los Santos | Duración: 5 horas
Tipo: Paseo Lacustre | Embarcación: Lancha a motor
--------------------------------------------
Nombre: Historia de Puerto Varas | Duración: 3 horas
Tipo: Excursión Cultural | Lugar histórico: Iglesia del Sagrado Corazón
--------------------------------------------
Nombre: Legado Alemán en Los Lagos | Duración: 4 horas
Tipo: Excursión Cultural | Lugar histórico: Museo Colonial Alemán de Frutillar
--------------------------------------------

============================================
          Fin del catálogo de servicios
============================================
```

---

## Repositorio GitHub

[https://github.com/Be-ri-lo/Llanquihue-tour](https://github.com/Be-ri-lo/Llanquihue-tour)
