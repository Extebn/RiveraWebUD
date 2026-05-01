package asp.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/*
 * David Esteban Rivera Sandoval| Programacion avanzada | Grupo 302 | Universidad Distrital Francisco Jose de Caldas | 2026
 */
public class AspiranteDTO extends PersonaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private LocalDate fechaRegistro;
    private Integer codigoPrograma;
    private ProgramaAcademicoDTO programaAcademico;

    public AspiranteDTO() {
    }

    public AspiranteDTO(Long numeroIdentificacion, String nombres, String apellidos, String telefono, String correo,
            LocalDate fechaRegistro, Integer codigoPrograma, ProgramaAcademicoDTO programaAcademico) {
        super(numeroIdentificacion, nombres, apellidos, telefono, correo);
        this.fechaRegistro = fechaRegistro;
        this.codigoPrograma = codigoPrograma;
        this.programaAcademico = programaAcademico;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getCodigoPrograma() {
        return codigoPrograma;
    }

    public void setCodigoPrograma(Integer codigoPrograma) {
        this.codigoPrograma = codigoPrograma;
    }

    public ProgramaAcademicoDTO getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(ProgramaAcademicoDTO programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), codigoPrograma, fechaRegistro, programaAcademico);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AspiranteDTO other) || !super.equals(obj)) {
            return false;
        }
        return Objects.equals(codigoPrograma, other.codigoPrograma)
                && Objects.equals(fechaRegistro, other.fechaRegistro)
                && Objects.equals(programaAcademico, other.programaAcademico);
    }
}
