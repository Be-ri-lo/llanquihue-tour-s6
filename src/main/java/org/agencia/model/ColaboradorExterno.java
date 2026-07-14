package org.agencia.model;

/**
 * Representa a un colaborador externo de la agencia (hoteles, restaurantes,
 * transportistas, etc.). Hereda de {@link Persona} el nombre y teléfono de
 * contacto, y agrega la empresa que representa y el tipo de servicio que presta.
 */
public class ColaboradorExterno extends Persona {

    private String empresa;
    private String tipoServicio;

    public ColaboradorExterno(String nombre, String telefono, String empresa, String tipoServicio) {
        super(nombre, telefono);
        setEmpresa(empresa);
        setTipoServicio(tipoServicio);
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        if (empresa == null || empresa.isBlank()) {
            throw new IllegalArgumentException("La empresa no puede estar vacía.");
        }
        this.empresa = empresa.trim();
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        if (tipoServicio == null || tipoServicio.isBlank()) {
            throw new IllegalArgumentException("El tipo de servicio no puede estar vacío.");
        }
        this.tipoServicio = tipoServicio.trim();
    }

    /**
     * Implementa el método de la interfaz {@link Registrable}, retornando
     * un resumen con los datos propios de un colaborador externo.
     *
     * @return resumen del colaborador con nombre, empresa, servicio y teléfono.
     */
    @Override
    public String mostrarResumen() {
        return "[Colaborador Externo] " + getNombre() +
                " | Empresa: " + empresa +
                " | Servicio: " + tipoServicio +
                " | Teléfono: " + getTelefono();
    }

    @Override
    public String toString() {
        return "ColaboradorExterno{" +
                "nombre='" + getNombre() + '\'' +
                ", empresa='" + empresa + '\'' +
                ", tipoServicio='" + tipoServicio + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                '}';
    }
}
