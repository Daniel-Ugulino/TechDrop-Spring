package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.service.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
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
    public String telaLista(Model model,@SessionAttribute("usuario") Usuario usuario){

        model.addAttribute("mouse", mouseService.obterLista(usuario.getId()));
        return "mouse/lista";
    }

    @PostMapping(value = "/mouse/incluir")
    public String incluir(Mouse mouse, MultipartFile file, @SessionAttribute("usuario") Usuario usuario){
        mouse.setUsuario(usuario);

        if(file.isEmpty()) {
            mouseService.incluir(mouse,null);
        }else{
            mouseService.incluir(mouse,file);
        }

        return "redirect:/mouse";
    }


    @PostMapping(value = "/mouse/atualizar/{id}")
    public String atualizar(Mouse mouse, MultipartFile file, @SessionAttribute("usuario") Usuario usuario,@PathVariable Integer id){
        mouse.setUsuario(usuario);

        if(file.isEmpty()) {
            mouseService.atualizar(mouse,id,null);
        }else{
            mouseService.atualizar(mouse,id,file);
        }

        return "redirect:/mouse";
    }


    @GetMapping(value = "/mouse/{id}")
    public String getUser(Model model,@PathVariable Integer id){

        Mouse mouse = mouseService.getById(id);

        try {
            model.addAttribute("mouse", mouse);
        }catch (Exception e){
            System.out.println(e);
        }

        return "mouse/atualizar";
    }

    @GetMapping(value = "/mouse/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        mouseService.excluir(id);

        return "redirect:/mouse";
    }
}
