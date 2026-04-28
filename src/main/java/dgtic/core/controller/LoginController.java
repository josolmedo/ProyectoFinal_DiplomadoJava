package dgtic.core.controller;

import dgtic.core.model.entity.Usuarios;
import dgtic.core.security.JWTTokenProvider;
import dgtic.core.service.UsuarioService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private JWTTokenProvider jwtTokenProvider;
    @Autowired private UserDetailsService userDetailsService;
    @Autowired private UsuarioService usuarioService;

    @GetMapping("/login")
    public String mostrarLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam("email") String email,
                                @RequestParam("password") String password,
                                HttpServletResponse response,
                                HttpSession session,
                                Model model) {
        try {
            // Autenticar credenciales
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

            // Generar Tokens
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
            String accessToken = jwtTokenProvider.generateJwtToken(userDetails);
            String refreshToken = jwtTokenProvider.generateRefreshToken(userDetails);

            // Crear Cookie para el Access Token (Segura y HttpOnly)
            Cookie accessCookie = new Cookie("accessToken", accessToken);
            accessCookie.setHttpOnly(true);
            accessCookie.setPath("/");
            accessCookie.setMaxAge(15 * 60); // 15 minutos (Debe coincidir con properties)

            // Crear Cookie para el Refresh Token
            Cookie refreshCookie = new Cookie("refreshToken", refreshToken);
            refreshCookie.setHttpOnly(true);
            refreshCookie.setPath("/");
            refreshCookie.setMaxAge(7 * 24 * 60 * 60); // 7 días

            response.addCookie(accessCookie);
            response.addCookie(refreshCookie);

            // Variables de vista para Thymeleaf
            Usuarios usuarioDB = usuarioService.autenticarUsuario(email, password);
            session.setAttribute("usuarioId", usuarioDB.getId());
            session.setAttribute("usuarioLogueado", usuarioDB.getNombre());

            String rol = usuarioDB.getRol().getNombre().toUpperCase();
            if(rol.equals("ADMINISTRADOR")) session.setAttribute("rol", "ADMIN");
            else session.setAttribute("rol", rol);

            return "redirect:/principal";

        } catch (Exception e) {
            model.addAttribute("error", "Credenciales inválidas. Verifica tu correo y contraseña.");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String cerrarSesion(HttpServletResponse response, HttpSession session) {
        // Limpiar Cookies
        Cookie accessCookie = new Cookie("accessToken", null);
        accessCookie.setMaxAge(0);
        accessCookie.setPath("/");

        Cookie refreshCookie = new Cookie("refreshToken", null);
        refreshCookie.setMaxAge(0);
        refreshCookie.setPath("/");

        response.addCookie(accessCookie);
        response.addCookie(refreshCookie);
        session.invalidate();

        return "redirect:/login?logout";
    }
}