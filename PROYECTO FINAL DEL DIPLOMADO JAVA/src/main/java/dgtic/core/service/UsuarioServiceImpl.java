package dgtic.core.service;

import dgtic.core.model.dto.UsuariosDTO;
import dgtic.core.model.entity.Alumnos;
import dgtic.core.model.entity.Profesores;
import dgtic.core.model.entity.Roles;
import dgtic.core.model.entity.Usuarios;
import dgtic.core.repository.AlumnoRepository;
import dgtic.core.repository.ProfesorRepository;
import dgtic.core.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public Usuarios autenticarUsuario(String email, String password) {

        // Busca en la BD, si lo encuentra devuelve el usuario, si no, devuelve null
        return usuarioRepository.findByEmailAndPassword(email, password).orElse(null);
    }

    @Override
    public Usuarios buscarPorId(Integer usuarioId) {
        return usuarioRepository.findById(usuarioId).orElse(null);
    }

    @Override
    public void registrarNuevoUsuario(UsuariosDTO dto, Integer tipoRol) {

        // ANTI-DUPLICADOS
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalStateException("El correo " + dto.getEmail() + " ya está registrado en el sistema.");
        }

        // Crear el Usuario base
        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setNombre(dto.getNombre());
        nuevoUsuario.setApellido(dto.getApellido());
        nuevoUsuario.setEmail(dto.getEmail());
        nuevoUsuario.setPassword(dto.getPassword()); // En un sistema real aquí iría un PasswordEncoder

        Roles rol = new Roles();
        rol.setId(tipoRol);
        nuevoUsuario.setRol(rol);

        usuarioRepository.save(nuevoUsuario);

        // Lo insertamos en su tabla correspondiente según el rol
        if (tipoRol == 3) { // 3 = Alumno en tu SQL
            Alumnos nuevoAlumno = new Alumnos();
            nuevoAlumno.setUsuario(nuevoUsuario);
            alumnoRepository.save(nuevoAlumno);
        } else if (tipoRol == 2) { // 2 = Profesor en tu SQL
            Profesores nuevoProfesor = new Profesores();
            nuevoProfesor.setUsuario(nuevoUsuario);
            profesorRepository.save(nuevoProfesor);
        }
    }






}