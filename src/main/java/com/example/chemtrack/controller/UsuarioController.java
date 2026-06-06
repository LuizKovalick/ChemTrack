package com.example.chemtrack.controller;

import com.example.chemtrack.model.Usuario;
import com.example.chemtrack.service.UsuarioService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/cadastro")
    public String mostrarFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.salvar(usuario);
        return "redirect:/login";
    }

    @GetMapping("/lista")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.listarPorPontos());
        return "usuario-lista";
    }
    @GetMapping("/perfil/{id}")
    public String mostrarPerfil(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id);
        model.addAttribute("usuario", usuario);
        return "perfil"; // 
    }

   
    @PostMapping("/perfil/atualizar")
    public String atualizarPerfil(@ModelAttribute Usuario usuario) {
       
        Usuario usuarioExistente = usuarioService.buscarPorId(usuario.getId());

        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setEmail(usuario.getEmail());

        if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()) {
            usuarioExistente.setSenha(usuario.getSenha());
        }

        usuarioService.atualizar(usuarioExistente);
        return "redirect:/usuarios/perfil/" + usuario.getId();
    }
   
    @PostMapping("/deletar")
    public String deletarPerfil(HttpSession session) {
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");

        if (usuario == null) {
            return "redirect:/login";
        }

        usuarioService.deletar(usuario.getId());

        session.invalidate();

        return "redirect:/login";
    }
}
