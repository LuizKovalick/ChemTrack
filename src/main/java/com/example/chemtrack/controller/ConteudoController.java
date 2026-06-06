package com.example.chemtrack.controller;
import com.example.chemtrack.utils.UrlUtil;

import com.example.chemtrack.model.Conteudo;
import com.example.chemtrack.service.ConteudoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/conteudos")
public class ConteudoController {

    private final ConteudoService conteudoService;

    public ConteudoController(ConteudoService conteudoService) {
        this.conteudoService = conteudoService;
    }

    @GetMapping("/{id}")
    public String exibirConteudo(@PathVariable Long id, Model model) {
        Conteudo conteudo = conteudoService.buscarPorId(id);
        if (conteudo == null) {
            return "redirect:/dashboard";
        }
        String videoId = UrlUtil.extractVideoId(conteudo.getUrlVideo());
        model.addAttribute("videoId", videoId);
        
        model.addAttribute("conteudo", conteudo);
        return "conteudo"; 
    }
}