package com.example.chemtrack.controller;

import com.example.chemtrack.model.Usuario;
import com.example.chemtrack.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";  
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String senha,
                        HttpSession session,
                        Model model) {
        Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);

        if (usuario != null) {
            session.setAttribute("usuarioLogado", usuario);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("erro", "Email ou senha inválidos!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
