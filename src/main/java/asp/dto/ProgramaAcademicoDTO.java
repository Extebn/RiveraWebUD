package asp.dto;

import java.io.Serializable;
import java.util.Objects;

/*
 * David Esteban Rivera Sandoval| Programacion avanzada | Grupo 302 | Universidad Distrital Francisco Jose de Caldas | 2026
 */
public class ProgramaAcademicoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer codigo;
    private String nombre;

    public ProgramaAcademicoDTO() {
    }

    public ProgramaAcademicoDTO(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProgramaAcademicoDTO other)) {
            return false;
        }
        return Objects.equals(codigo, other.codigo) && Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
