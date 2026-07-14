![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# Actividad Sumativa – Semana 8
## Integrando interfaces, polimorfismo y estructuras dinámicas

### Proyecto: Llanquihue Tour

---

## Autor del proyecto

| Campo | Detalle |
|---|---|
| **Nombre completo** | Beatriz López Casanova |
| **Asignatura** | Desarrollo Orientado a Objetos I |
| **Carrera** | Analista Programador Computacional |
| **Sede** | Virtual |

---

## Descripción general del sistema

**Llanquihue Tour** es una agencia de turismo ubicada en la Región de Los Lagos, especializada en rutas gastronómicas, paseos lacustres y excursiones culturales. En esta etapa, el sistema se amplía para gestionar además a los **guías turísticos**, los **vehículos** y los **colaboradores externos** de la agencia, aplicando un contrato de comportamiento común entre todas estas entidades.

Para lograrlo, se define la interfaz `Registrable`, que declara el método `mostrarResumen()`. Tanto la jerarquía de servicios turísticos (`ServicioTuristico`) como la nueva jerarquía de personas (`Persona`) y la clase `Vehiculo` implementan esta interfaz, lo que permite almacenar objetos de **distintas ramas de herencia** dentro de una misma colección genérica (`ArrayList<Registrable>`) y diferenciarlos en tiempo de ejecución mediante `instanceof`.

Adicionalmente, se incorpora una **interfaz gráfica simple** (basada en `JOptionPane`) que permite ingresar nuevos guías, vehículos y colaboradores desde un menú, y visualizar el resumen de todas las entidades registradas.

---

## Estructura de paquetes y clases

```
src/main/java/org/agencia/
├── model/
│   ├── Registrable.java        → Interfaz común: declara mostrarResumen()
│   ├── ServicioTuristico.java  → Clase abstracta base de los servicios turísticos
│   ├── RutaGastronomica.java   → Subclase de ServicioTuristico
│   ├── PaseoLacustre.java      → Subclase de ServicioTuristico
│   ├── ExcursionCultural.java  → Subclase de ServicioTuristico
│   ├── Persona.java            → Clase abstracta base de las entidades tipo persona
│   ├── GuiaTuristico.java      → Subclase de Persona (especialidad, años de experiencia)
│   ├── ColaboradorExterno.java → Subclase de Persona (empresa, tipo de servicio)
│   └── Vehiculo.java           → Implementa Registrable directamente (no es una Persona)
├── data/
│   ├── GestorServicios.java    → Crea y recorre la colección polimórfica List<ServicioTuristico>
│   └── GestorEntidades.java    → Colección ArrayList<Registrable>; recorrido con instanceof
└── ui/
    ├── Main.java                → Clase principal; orquesta la ejecución del sistema
    └── InterfazEntidades.java   → GUI simple con JOptionPane para ingresar y visualizar entidades
```

> No se requiere lectura de archivos externos ni persistencia: los objetos de ejemplo se crean directamente en código, y los nuevos se ingresan a través de la interfaz gráfica.

---

## Relaciones entre clases

| Relación | Tipo | Descripción |
|---|---|---|
| `RutaGastronomica`, `PaseoLacustre`, `ExcursionCultural` → `ServicioTuristico` | **Herencia** | Heredan `nombre` y `duracionHoras`, y sobrescriben `mostrarInformacion()` |
| `GuiaTuristico`, `ColaboradorExterno` → `Persona` | **Herencia** | Heredan `nombre` y `telefono` con sus validaciones |
| `ServicioTuristico` → `Registrable` | **Interfaz** | Aporta el contrato común `mostrarResumen()` a toda la jerarquía de servicios |
| `Persona` → `Registrable` | **Interfaz** | Aporta el contrato común `mostrarResumen()` a toda la jerarquía de personas |
| `Vehiculo` → `Registrable` | **Interfaz** | Implementa el contrato sin heredar de ninguna clase base |
| `GestorEntidades` → `Registrable` | **Agregación / Polimorfismo** | Colección `ArrayList<Registrable>` que almacena objetos de las tres ramas anteriores |
| `Main` → `GestorServicios` | Uso | Crea la colección de servicios y muestra su información por consola |
| `Main` → `GestorEntidades` | Uso | Crea la colección de entidades y muestra su resumen por consola |
| `Main` → `InterfazEntidades` | Uso | Lanza la interfaz gráfica para ingresar y visualizar entidades |

---

## Instrucciones para ejecutar el programa

### Requisitos previos

- Java JDK 17 o superior
- Maven 3.x (o abrir directamente en IntelliJ IDEA)

### Opción A – Desde IntelliJ IDEA

1. Abrir el proyecto como proyecto Maven en IntelliJ IDEA.
2. Navegar a `src/main/java/org/agencia/ui/Main.java`.
3. Hacer clic derecho → **Run 'Main.main()'**.

### Opción B – Desde terminal con Maven

```bash
# Desde la raíz del proyecto
mvn compile
mvn exec:java -Dexec.mainClass="org.agencia.ui.Main"
```

> **Nota sobre la GUI:** al finalizar la salida por consola se abrirá una ventana de `JOptionPane` con el menú de entidades. Desde ahí puedes registrar un Guía Turístico, un Vehículo o un Colaborador Externo, y elegir la opción "Ver entidades registradas" para ver el resumen de todas ellas (las de ejemplo más las que acabas de ingresar). Selecciona "Salir" o cierra la ventana para terminar la ejecución.

---

## Salida esperada por consola

```
   LLANQUIHUE TOUR - Servicios Turísticos  
Nombre: Sabores del Lago | Duración: 4 horas
Tipo: Ruta Gastronómica | N° de paradas: 5
--------------------------------------------
...
          Fin del catálogo de servicios     

   LLANQUIHUE TOUR - Entidades Registrables  
[Guía Turístico] Juan Pérez | Especialidad: Español/Inglés | Teléfono: +56 9 1111 2222 | Experiencia: 5 años
   -> Especialidad: Español/Inglés
--------------------------------------------
[Vehículo] Minibus | Patente: PPU-1234 | Capacidad: 15 pasajeros
   -> Capacidad: 15 pasajeros
--------------------------------------------
[Colaborador Externo] María Soto | Empresa: Hotel Frutillar | Servicio: Alojamiento | Teléfono: +56 9 3333 4444
   -> Tipo de servicio: Alojamiento
--------------------------------------------
[Ruta Gastronómica] Nombre: Sabores del Lago | Duración: 4 horas | Paradas: 5
--------------------------------------------
          Fin del listado de entidades      
```

A continuación se abre la ventana gráfica (`JOptionPane`) con el menú de entidades descrito arriba.

---

## Buenas prácticas aplicadas

- Interfaz `Registrable` como contrato de comportamiento común entre clases sin relación de herencia directa.
- Herencia y polimorfismo aplicados en dos jerarquías independientes (`ServicioTuristico` y `Persona`), ambas unificadas mediante la misma interfaz.
- Uso de `instanceof` para diferenciar el tipo real de cada objeto al recorrer la colección genérica.
- Colección genérica `ArrayList<Registrable>` para almacenar objetos heterogéneos.
- Clases abstractas (`ServicioTuristico`, `Persona`) que obligan a las subclases a implementar su propio comportamiento.
- Atributos `private` en todas las clases del modelo, con getters y setters validados.
- Manejo de excepciones (`IllegalArgumentException`, `NumberFormatException`) tanto en los setters del modelo como en la interfaz gráfica.
- Interfaz gráfica simple con `JOptionPane` para el ingreso y visualización de datos, orientada a usuarios no técnicos.
- Separación de responsabilidades mediante paquetes funcionales (`model`, `data`, `ui`).

---

**Repositorio GitHub:** https://github.com/Be-ri-lo/llanquihue-tour-s6

**Fecha de entrega:** Semana 8 – Julio 2026

© Duoc UC | Escuela de Informática y Telecomunicaciones
