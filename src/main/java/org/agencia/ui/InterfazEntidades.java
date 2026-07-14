package org.agencia.ui;

import org.agencia.data.GestorEntidades;
import org.agencia.model.ColaboradorExterno;
import org.agencia.model.GuiaTuristico;
import org.agencia.model.Persona;
import org.agencia.model.Registrable;
import org.agencia.model.Vehiculo;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Dimension;

/**
 * Interfaz gráfica simple, basada en JOptionPane, que permite ingresar
 * nuevas entidades (Registrable) y visualizar el resumen de las existentes.
 */
public class InterfazEntidades {

    private final GestorEntidades gestor;

    public InterfazEntidades(GestorEntidades gestor) {
        this.gestor = gestor;
    }

    /**
     * Se lanza cuando el usuario cancela o cierra un cuadro de ingreso,
     * para poder abortar el registro en curso sin mostrar un error real.
     */
    private static class RegistroCanceladoException extends RuntimeException {
    }

    /**
     * Muestra el menú principal y repite hasta que el usuario elija salir
     * o cierre la ventana.
     */
    public void mostrarMenu() {
        String opcion;

        do {
            opcion = JOptionPane.showInputDialog(null,
                    "LLANQUIHUE TOUR - Menú de Entidades\n\n"
                            + "1. Registrar Guía Turístico\n"
                            + "2. Registrar Vehículo\n"
                            + "3. Registrar Colaborador Externo\n"
                            + "4. Ver entidades registradas\n"
                            + "5. Salir\n\n"
                            + "Ingrese el número de la opción:",
                    "Menú Principal",
                    JOptionPane.QUESTION_MESSAGE);

            if (opcion == null) {
                break;
            }

            switch (opcion.trim()) {
                case "1" -> registrarGuia();
                case "2" -> registrarVehiculo();
                case "3" -> registrarColaborador();
                case "4" -> verEntidades();
                case "5" -> JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida. Ingresa un número del 1 al 5.");
            }

        } while (!"5".equals(opcion));
    }

    /**
     * Pide por pantalla los datos de un {@link GuiaTuristico}, lo crea, lo agrega
     * al gestor y muestra el resultado usando {@link Registrable#mostrarResumen()}.
     */
    private void registrarGuia() {
        try {
            String nombre = pedirTexto("Nombre del guía (solo nombre y apellido paterno):",
                    Persona.MAX_LARGO_NOMBRE);
            String especialidad = pedirTexto("Especialidad:", GuiaTuristico.MAX_LARGO_ESPECIALIDAD);
            String telefono = pedirTelefono("Teléfono (ej. +56 9 1111 2222):");
            int aniosExperiencia = pedirEntero("Años de experiencia:",
                    GuiaTuristico.ANIOS_EXPERIENCIA_MINIMO, GuiaTuristico.ANIOS_EXPERIENCIA_MAXIMO);

            GuiaTuristico guia = new GuiaTuristico(nombre, especialidad, telefono, aniosExperiencia);
            gestor.agregarEntidad(guia);

            JOptionPane.showMessageDialog(null, "Guía registrado con éxito:\n\n" + guia.mostrarResumen());
        } catch (RegistroCanceladoException e) {
            JOptionPane.showMessageDialog(null, "Registro cancelado.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el guía: " + e.getMessage());
        }
    }

    /**
     * Pide por pantalla los datos de un {@link Vehiculo}, lo crea, lo agrega
     * al gestor y muestra el resultado usando {@link Registrable#mostrarResumen()}.
     */
    private void registrarVehiculo() {
        try {
            String tipo = pedirTexto("Tipo de vehículo (ej. Minibus, Lancha):");
            String patente = pedirPatente("Patente (formato FFTT-34):");
            int capacidad = pedirEntero("Capacidad (N° de pasajeros):",
                    Vehiculo.CAPACIDAD_MINIMA, Vehiculo.CAPACIDAD_MAXIMA);

            Vehiculo vehiculo = new Vehiculo(tipo, patente, capacidad);
            gestor.agregarEntidad(vehiculo);

            JOptionPane.showMessageDialog(null, "Vehículo registrado con éxito:\n\n" + vehiculo.mostrarResumen());
        } catch (RegistroCanceladoException e) {
            JOptionPane.showMessageDialog(null, "Registro cancelado.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el vehículo: " + e.getMessage());
        }
    }

    /**
     * Pide por pantalla los datos de un {@link ColaboradorExterno}, lo crea, lo agrega
     * al gestor y muestra el resultado usando {@link Registrable#mostrarResumen()}.
     */
    private void registrarColaborador() {
        try {
            String nombre = pedirTexto("Nombre de contacto:", Persona.MAX_LARGO_NOMBRE);
            String telefono = pedirTelefono("Teléfono (ej. +56 9 1111 2222):");
            String empresa = pedirTexto("Empresa que representa:");
            String tipoServicio = pedirTexto("Tipo de servicio (ej. Alojamiento, Alimentación):");

            ColaboradorExterno colaborador = new ColaboradorExterno(nombre, telefono, empresa, tipoServicio);
            gestor.agregarEntidad(colaborador);

            JOptionPane.showMessageDialog(null, "Colaborador registrado con éxito:\n\n" + colaborador.mostrarResumen());
        } catch (RegistroCanceladoException e) {
            JOptionPane.showMessageDialog(null, "Registro cancelado.");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el colaborador: " + e.getMessage());
        }
    }

    /**
     * Pide un texto obligatorio, sin límite de largo. Vuelve a preguntar si
     * el campo llega vacío y aborta el registro con RegistroCanceladoException
     * si el usuario cierra el cuadro o presiona "Cancelar".
     */
    private String pedirTexto(String mensaje) {
        return pedirTexto(mensaje, Integer.MAX_VALUE);
    }

    /**
     * Igual que {@link #pedirTexto(String)}, pero además rechaza textos que
     * superen el largo máximo indicado, volviendo a preguntar hasta que el
     * valor sea válido.
     */
    private String pedirTexto(String mensaje, int maxCaracteres) {
        while (true) {
            String valor = JOptionPane.showInputDialog(mensaje);

            if (valor == null) {
                throw new RegistroCanceladoException();
            }

            valor = valor.trim();
            if (valor.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Este campo no puede quedar vacío. Intenta nuevamente.");
                continue;
            }

            if (valor.length() > maxCaracteres) {
                JOptionPane.showMessageDialog(null, "Este campo no puede superar los " + maxCaracteres + " caracteres.");
                continue;
            }

            return valor;
        }
    }

    /**
     * Pide un teléfono válido según el formato de {@link Persona#TELEFONO_REGEX}
     * (solo números y espacios, con un '+' opcional al inicio). Vuelve a
     * preguntar mientras el formato no sea correcto.
     */
    private String pedirTelefono(String mensaje) {
        while (true) {
            String valor = pedirTexto(mensaje);

            if (!valor.matches(Persona.TELEFONO_REGEX)) {
                JOptionPane.showMessageDialog(null,
                        "El teléfono debe contener solo números y espacios (puede iniciar con '+'), "
                                + "entre 8 y 15 caracteres. Ej: +56 9 1111 2222");
                continue;
            }

            return valor;
        }
    }

    /**
     * Pide una patente con formato chileno válido (4 letras, un guion y
     * 2 números, ej. "FFTT-34"). Acepta minúsculas y las normaliza a
     * mayúsculas antes de validar. Vuelve a preguntar mientras el formato
     * no sea correcto.
     */
    private String pedirPatente(String mensaje) {
        while (true) {
            String valor = pedirTexto(mensaje).toUpperCase();

            if (!valor.matches(Vehiculo.PATENTE_REGEX)) {
                JOptionPane.showMessageDialog(null,
                        "La patente debe tener el formato chileno de 4 letras, un guion y 2 números. Ej: FFTT-34");
                continue;
            }

            return valor;
        }
    }

    /**
     * Pide un número entero mayor o igual al mínimo indicado, sin límite
     * superior.
     */
    private int pedirEntero(String mensaje, int minimo) {
        return pedirEntero(mensaje, minimo, Integer.MAX_VALUE);
    }

    /**
     * Pide un número entero dentro del rango [minimo, maximo]. Vuelve a
     * preguntar si el usuario escribe texto no numérico o un valor fuera
     * de rango.
     */
    private int pedirEntero(String mensaje, int minimo, int maximo) {
        while (true) {
            String texto = pedirTexto(mensaje);

            try {
                int valor = Integer.parseInt(texto);
                if (valor < minimo || valor > maximo) {
                    JOptionPane.showMessageDialog(null, "El valor debe estar entre " + minimo + " y " + maximo + ".");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debes ingresar un número entero válido.");
            }
        }
    }

    /**
     * Recorre la colección de {@link Registrable} y llama a
     * {@link Registrable#mostrarResumen()} sobre cada objeto, agregando un
     * dato extra según su tipo real mediante instanceof. El resultado se
     * muestra en un área de texto con scroll, para que la lista sea legible
     * aunque haya muchas entidades registradas.
     */
    private void verEntidades() {
        if (gestor.getEntidades().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todavía no hay entidades registradas.");
            return;
        }

        StringBuilder resumen = new StringBuilder();

        for (Registrable entidad : gestor.getEntidades()) {
            resumen.append(entidad.mostrarResumen());

            if (entidad instanceof GuiaTuristico guia) {
                resumen.append("\n   -> Especialidad: ").append(guia.getEspecialidad());
            } else if (entidad instanceof Vehiculo vehiculo) {
                resumen.append("\n   -> Capacidad: ").append(vehiculo.getCapacidad()).append(" pasajeros");
            } else if (entidad instanceof ColaboradorExterno colaborador) {
                resumen.append("\n   -> Tipo de servicio: ").append(colaborador.getTipoServicio());
            }

            resumen.append("\n\n");
        }

        JTextArea areaTexto = new JTextArea(resumen.toString());
        areaTexto.setEditable(false);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setPreferredSize(new Dimension(450, 300));

        JOptionPane.showMessageDialog(null, scroll, "Entidades registradas", JOptionPane.INFORMATION_MESSAGE);
    }
}
