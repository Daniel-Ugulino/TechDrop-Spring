package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Headset;
import br.edu.infnet.TechStore.model.service.HeadsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HeadsetController {

    @Autowired
    private HeadsetService headsetService;

    @GetMapping(value = "/headset/cadastro")
    public String telaCadastro(){
        return "/headset/cadastro";
    }

    @GetMapping(value = "/headset")
    public String telaLista(Model model){

        System.out.println(headsetService.obterLista());
        model.addAttribute("headset", headsetService.obterLista());
        return "headset/lista";
    }

    @PostMapping(value = "/headset/incluir")
    public String incluir(Headset headset){

        headsetService.incluir(headset);
        System.out.println(headset);
        return "redirect:/headset";
    }

    @GetMapping(value = "/headset/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        headsetService.excluir(id);

        return "redirect:/headset";
    }
}
