package dgtic.core.service;

import dgtic.core.model.dto.UsuariosDTO;
import dgtic.core.model.entity.Usuarios;

public interface UsuarioService {
    Usuarios autenticarUsuario(String email, String password);

    Usuarios buscarPorId(Integer usuarioId);

    void registrarNuevoUsuario(UsuariosDTO dto, Integer tipoRol);
}
