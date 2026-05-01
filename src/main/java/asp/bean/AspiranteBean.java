package asp.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import asp.dao.AspiranteDAO;
import asp.dao.ProgramaAcademicoDAO;
import asp.dto.AspiranteDTO;
import asp.dto.ProgramaAcademicoDTO;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
/*
 * David Esteban Rivera Sandoval| Programacion avanzada | Grupo 302 | Universidad Distrital Francisco Jose de Caldas | 2026
 */

@Named("asp")
@ViewScoped
public class AspiranteBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private AspiranteDTO aspirante = new AspiranteDTO();

    public AspiranteDTO getAspirante() {
        return aspirante;
    }

    public void setAspirante(AspiranteDTO aspirante) {
        this.aspirante = aspirante;
    }

    public List<AspiranteDTO> getAspirantesRegistrados() {
        return AspiranteDAO.listarAspirantes();
    }

    public List<ProgramaAcademicoDTO> getProgramasAcademicos() {
        return ProgramaAcademicoDAO.listarProgramas();
    }

    public void registrar() {
        FacesContext context = FacesContext.getCurrentInstance();

        if (aspirante.getCodigoPrograma() == null) {
            context.addMessage("formAspirante:programa", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Debe seleccionar un programa academico.", null));
            context.validationFailed();
            return;
        }

        if (AspiranteDAO.existePorIdentificacion(aspirante.getNumeroIdentificacion())) {
            context.addMessage("formAspirante:numeroIdentificacion",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Ya existe un aspirante registrado con esa identificacion.", null));
            context.validationFailed();
            return;
        }

        ProgramaAcademicoDTO programaSeleccionado = ProgramaAcademicoDAO.buscarPorCodigo(aspirante.getCodigoPrograma());

        AspiranteDTO nuevoAspirante = new AspiranteDTO(
                aspirante.getNumeroIdentificacion(),
                limpiar(aspirante.getNombres()),
                limpiar(aspirante.getApellidos()),
                limpiar(aspirante.getTelefono()),
                limpiar(aspirante.getCorreo()),
                LocalDate.now(),
                aspirante.getCodigoPrograma(),
                programaSeleccionado);

        AspiranteDAO.guardar(nuevoAspirante);

        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Registro exitoso", "El aspirante fue registrado correctamente."));

        aspirante = new AspiranteDTO();
    }

    private String limpiar(String valor) {
        return valor == null ? null : valor.trim();
    }
}
