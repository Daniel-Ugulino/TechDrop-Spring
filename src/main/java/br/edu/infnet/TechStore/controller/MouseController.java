package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.service.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MouseController {
    @Autowired
    private MouseService mouseService;

    @GetMapping(value = "/mouse/cadastro")
    public String telaCadastro(){
        return "/mouse/cadastro";
    }

    @GetMapping(value = "/mouse")
    public String telaLista(Model model){

        model.addAttribute("mouse", mouseService.obterLista());
        return "mouse/lista";
    }

    @PostMapping(value = "/mouse/incluir")
    public String incluir(Mouse mouse, MultipartFile file){
        System.out.println(file.getOriginalFilename());
        mouseService.incluir(mouse,file);

        return "redirect:/mouse";
    }

    @GetMapping(value = "/mouse/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        mouseService.excluir(id);

        return "redirect:/mouse";
    }
}
