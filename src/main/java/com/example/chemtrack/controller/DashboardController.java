package com.example.chemtrack.controller;

import com.example.chemtrack.model.Exercicio;
import com.example.chemtrack.model.Usuario;
import com.example.chemtrack.service.ExercicioService;
import com.example.chemtrack.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.chemtrack.model.Conteudo;
import com.example.chemtrack.service.ConteudoService;

import java.util.List;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final UsuarioService usuarioService;
    private final ExercicioService exercicioService;
    private final ConteudoService conteudoService;

    public DashboardController(UsuarioService usuarioService, ExercicioService exercicioService, ConteudoService conteudoService) {
        this.usuarioService = usuarioService;
        this.exercicioService = exercicioService;
        this.conteudoService = conteudoService;
    }

    @GetMapping
    public String dashboard(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }

        List<Exercicio> exercicios = exercicioService.listarTodos();
        List<Conteudo> conteudos = conteudoService.listarTodos();
        model.addAttribute("usuario", usuario);
        model.addAttribute("exercicios", exercicios);
        model.addAttribute("conteudos",conteudos);

        return "dashboard";
    }

    @PostMapping("/responder/{id}")
    public String responderExercicio(@PathVariable Long id,
                                     @RequestParam String resposta,
                                     HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        if (usuario == null) {
            return "redirect:/login";
        }

        Exercicio exercicio = exercicioService.buscarPorId(id);
        if (exercicio != null && exercicio.getAlternativaCorreta().equalsIgnoreCase(resposta.trim())) {
            usuario.setPontos(usuario.getPontos() + exercicio.getPontos()+10);
            usuarioService.salvar(usuario);
            session.setAttribute("usuarioLogado", usuario);
        }

        return "redirect:/dashboard";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

