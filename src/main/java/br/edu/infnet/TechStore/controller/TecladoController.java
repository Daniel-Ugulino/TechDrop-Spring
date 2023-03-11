package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Teclado;
import br.edu.infnet.TechStore.model.service.TecladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TecladoController {

    @Autowired
    private TecladoService tecladoService;

    @GetMapping(value = "/teclado/cadastro")
    public String telaCadastro(){
        return "/teclado/cadastro";
    }

    @GetMapping(value = "/teclado")
    public String telaLista(Model model){

        model.addAttribute("teclado", tecladoService.obterLista());
        return "teclado/lista";
    }

    @PostMapping(value = "/teclado/incluir")
    public String incluir(Teclado teclado){

        tecladoService.incluir(teclado);

        return "redirect:/teclado";
    }

    @GetMapping(value = "/teclado/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        tecladoService.excluir(id);

        return "redirect:/teclado";
    }
}
