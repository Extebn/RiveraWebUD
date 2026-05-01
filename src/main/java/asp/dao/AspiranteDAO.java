package asp.dao;

import java.util.ArrayList;
import java.util.List;

import asp.dto.AspiranteDTO;

/*
 * David Esteban Rivera Sandoval| Programacion avanzada | Grupo 302 | Universidad Distrital Francisco Jose de Caldas | 2026
 */
public class AspiranteDAO {

    public static final List<AspiranteDTO> ASPIRANTES = new ArrayList<>();

    private AspiranteDAO() {
    }

    public static List<AspiranteDTO> listarAspirantes() {
        return ASPIRANTES;
    }

    public static boolean existePorIdentificacion(Long numeroIdentificacion) {
        for (AspiranteDTO aspirante : ASPIRANTES) {
            if (aspirante.getNumeroIdentificacion().equals(numeroIdentificacion)) {
                return true;
            }
        }
        return false;
    }

    public static void guardar(AspiranteDTO aspirante) {
        ASPIRANTES.add(aspirante);
    }
}
