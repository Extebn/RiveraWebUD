package asp.dto;

import java.io.Serializable;
import java.util.Objects;

/*
 * David Esteban Rivera Sandoval| Programacion avanzada | Grupo 302 | Universidad Distrital Francisco Jose de Caldas | 2026
 */
public class PersonaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;

    public PersonaDTO() {
    }

    public PersonaDTO(Long numeroIdentificacion, String nombres, String apellidos, String telefono, String correo) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Long getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(Long numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(apellidos, correo, nombres, numeroIdentificacion, telefono);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersonaDTO other)) {
            return false;
        }
        return Objects.equals(apellidos, other.apellidos)
                && Objects.equals(correo, other.correo)
                && Objects.equals(nombres, other.nombres)
                && Objects.equals(numeroIdentificacion, other.numeroIdentificacion)
                && Objects.equals(telefono, other.telefono);
    }
}
