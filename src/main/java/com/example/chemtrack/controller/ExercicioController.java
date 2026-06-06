package com.example.chemtrack.controller;

import com.example.chemtrack.model.Exercicio;
import com.example.chemtrack.model.Resposta;
import com.example.chemtrack.model.Usuario;
import com.example.chemtrack.repository.RespostaRepository;
import com.example.chemtrack.service.ExercicioService;
import com.example.chemtrack.service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/exercicios")
public class ExercicioController {

    private final ExercicioService exercicioService;
    private final UsuarioService usuarioService;
    private final RespostaRepository respostaRepository;

    public ExercicioController(ExercicioService exercicioService, UsuarioService usuarioService, RespostaRepository respostaRepository) {
        this.exercicioService = exercicioService;
        this.usuarioService = usuarioService;
        this.respostaRepository = respostaRepository;
    }

    @GetMapping("/{id}")
    public String exibirExercicio(@PathVariable Long id, Model model) {
        Exercicio exercicio = exercicioService.buscarPorId(id);
        if (exercicio == null) {
            return "redirect:/dashboard";
        }
        model.addAttribute("exercicio", exercicio);
        return "exercicio"; 
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

        Resposta novaResposta = new Resposta();
        novaResposta.setUsuario(usuario);
        novaResposta.setExercicio(exercicio);
        novaResposta.setRespostaUsuario(resposta.trim());
        novaResposta.setDataResposta(LocalDateTime.now());
        
        boolean acertou = false;
        if (exercicio != null && exercicio.getAlternativaCorreta().equalsIgnoreCase(resposta.trim())) {
            usuario.setPontos(usuario.getPontos() + exercicio.getPontos()); 
            usuarioService.salvar(usuario);
            session.setAttribute("usuarioLogado", usuario); 
            acertou = true;
        }

        novaResposta.setAcertou(acertou);
        respostaRepository.save(novaResposta);

        return "redirect:/dashboard"; 
    }
}