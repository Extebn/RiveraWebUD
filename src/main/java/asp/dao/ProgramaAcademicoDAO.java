package asp.dao;

import java.util.ArrayList;
import java.util.List;

import asp.dto.ProgramaAcademicoDTO;

/*
 * David Esteban Rivera Sandoval| Programacion avanzada | Grupo 302 | Universidad Distrital Francisco Jose de Caldas | 2026
 */
public class ProgramaAcademicoDAO {

    public static final List<ProgramaAcademicoDTO> PROGRAMAS = new ArrayList<>();

    static {
        cargarProgramas();
    }

    private ProgramaAcademicoDAO() {
    }

    public static void cargarProgramas() {
        if (PROGRAMAS.isEmpty()) {
            PROGRAMAS.add(new ProgramaAcademicoDTO(10, "Ingenieria de Sistemas"));
            PROGRAMAS.add(new ProgramaAcademicoDTO(20, "Ingenieria Industrial"));
            PROGRAMAS.add(new ProgramaAcademicoDTO(30, "Ingenieria Telematica"));
            PROGRAMAS.add(new ProgramaAcademicoDTO(40, "Ingenieria Electronica"));
            PROGRAMAS.add(new ProgramaAcademicoDTO(50, "Derecho"));
            PROGRAMAS.add(new ProgramaAcademicoDTO(60, "Administracion Ambiental"));
        }
    }

    public static List<ProgramaAcademicoDTO> listarProgramas() {
        return PROGRAMAS;
    }

    public static ProgramaAcademicoDTO buscarPorCodigo(Integer codigo) {
        for (ProgramaAcademicoDTO programa : PROGRAMAS) {
            if (programa.getCodigo().equals(codigo)) {
                return programa;
            }
        }
        return null;
    }
}
