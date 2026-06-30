# Llanquihue Tour – Semana 6

## Objetivo de esta semana

Implementar una jerarquía de clases con **herencia simple** en Java, representando los distintos tipos de servicios turísticos que ofrece la agencia Llanquihue Tour. Se aplican conceptos de atributos heredados, `super()` en constructores y sobreescritura del método `toString()`.

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
| `GestorServicios` | `data` | Crea y muestra dos instancias de cada subclase |
| `Main` | `ui` | Llama a `GestorServicios` y muestra resultados por consola |

---

## Conceptos aplicados

- **Herencia simple**: las tres subclases extienden `ServicioTuristico` con `extends`.
- **`super()`**: cada subclase llama al constructor de la superclase para inicializar `nombre` y `duracionHoras`.
- **Sobreescritura de `toString()`**: cada subclase muestra su información específica, llamando a `super.toString()` para incluir los atributos heredados.
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

=== RUTAS GASTRONÓMICAS ===
[Ruta Gastronómica] Nombre: Sabores del Lago | Duración: 4 horas | Paradas: 5
[Ruta Gastronómica] Nombre: Ruta del Salmón Chilote | Duración: 6 horas | Paradas: 8

=== PASEOS LACUSTRES ===
[Paseo Lacustre] Nombre: Navegación Lago Llanquihue | Duración: 3 horas | Embarcación: Catamarán
[Paseo Lacustre] Nombre: Recorrido Lago Todos los Santos | Duración: 5 horas | Embarcación: Lancha a motor

=== EXCURSIONES CULTURALES ===
[Excursión Cultural] Nombre: Historia de Puerto Varas | Duración: 3 horas | Lugar histórico: Iglesia del Sagrado Corazón
[Excursión Cultural] Nombre: Legado Alemán en Los Lagos | Duración: 4 horas | Lugar histórico: Museo Colonial Alemán de Frutillar

============================================
          Fin del catálogo de servicios
============================================
```

---

## Repositorio GitHub

[https://github.com/Be-ri-lo/Llanquihue-tour](https://github.com/Be-ri-lo/Llanquihue-tour)
