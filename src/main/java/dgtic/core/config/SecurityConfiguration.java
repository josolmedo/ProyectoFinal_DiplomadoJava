package dgtic.core.config;

import dgtic.core.model.entity.Usuarios;
import dgtic.core.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder; // ¡Faltaba este import!
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/bootstrap/**", "/iconos/**", "/tema/**", "/image/**", "/imagenes/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        // Interceptamos el login exitoso
                        .successHandler((request, response, authentication) -> {
                            String email = authentication.getName();
                            Usuarios usuario = usuarioRepository.findByEmail(email).orElse(null);

                            if (usuario != null) {
                                HttpSession session = request.getSession();
                                // 1. Guardamos el ID para tus reportes e inscripciones
                                session.setAttribute("usuarioId", usuario.getId());

                                // 2. Guardamos el nombre para tu navbar
                                String apellido = usuario.getApellido() != null ? " " + usuario.getApellido() : "";
                                session.setAttribute("usuarioLogueado", usuario.getNombre() + apellido);

                                // 3. Traducimos y guardamos el rol
                                String nombreRolBd = usuario.getRol().getNombre();
                                if (nombreRolBd.equalsIgnoreCase("Administrador")) {
                                    session.setAttribute("rol", "ADMIN");
                                } else if (nombreRolBd.equalsIgnoreCase("Profesor")) {
                                    session.setAttribute("rol", "PROFESOR");
                                } else if (nombreRolBd.equalsIgnoreCase("Alumno")) {
                                    session.setAttribute("rol", "ALUMNO");
                                } else if (nombreRolBd.equalsIgnoreCase("Padre de familia")) {
                                    session.setAttribute("rol", "PADRE");
                                }
                            }
                            // Mandamos al usuario a la pantalla principal
                            response.sendRedirect("/principal");
                        })
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .addLogoutHandler((request, response, authentication) -> {
                            HttpSession session = request.getSession(false);
                            if (session != null) {
                                session.invalidate(); // Limpiamos la sesión manual al salir
                            }
                        })
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> {
            Usuarios usuario = usuarioRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado en la BD: " + email));

            String nombreRolBd = usuario.getRol().getNombre();
            String rolSpring = "ROLE_USER";

            if (nombreRolBd.equalsIgnoreCase("Administrador")) {
                rolSpring = "ROLE_ADMIN";
            } else if (nombreRolBd.equalsIgnoreCase("Profesor")) {
                rolSpring = "ROLE_PROFESOR";
            } else if (nombreRolBd.equalsIgnoreCase("Alumno")) {
                rolSpring = "ROLE_ALUMNO";
            }

            return new User(
                    usuario.getEmail(),
                    usuario.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(rolSpring))
            );
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        // AQUÍ ESTÁ LA SOLUCIÓN: Pasamos userDetailsService() directo en los paréntesis
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Usamos NoOp porque en el archivo data.sql las contraseñas están en texto plano
        return NoOpPasswordEncoder.getInstance();
    }
}