package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Headset;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.service.HeadsetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HeadsetController {

    @Autowired
    private HeadsetService headsetService;

    @GetMapping(value = "/headset/cadastro")
    public String telaCadastro(){
        return "/headset/cadastro";
    }

    @GetMapping(value = "/headset")
    public String telaLista(Model model,@SessionAttribute("usuario") Usuario usuario){

        model.addAttribute("headset", headsetService.obterLista(usuario.getId()));

        return "headset/lista";
    }

    @PostMapping(value = "/headset/incluir")
    public String incluir(Headset headset, MultipartFile file, @SessionAttribute("usuario") Usuario usuario){
        headset.setUsuario(usuario);

        if(file.isEmpty()) {
            headsetService.incluir(headset,null);
        }else{
            headsetService.incluir(headset,file);
        }

        return "redirect:/headset";
    }


    @PostMapping(value = "/headset/atualizar/{id}")
    public String atualizar(Headset headset, MultipartFile file, @SessionAttribute("usuario") Usuario usuario,@PathVariable Integer id){
        headset.setUsuario(usuario);

        if(file.isEmpty()) {
            headsetService.atualizar(headset,id,null);
        }else{
            headsetService.atualizar(headset,id,file);
        }

        return "redirect:/headset";
    }


    @GetMapping(value = "/headset/{id}")
    public String getUser(Model model,@PathVariable Integer id){

        Headset headset = headsetService.getById(id);

        try {
            model.addAttribute("headset", headset);
        }catch (Exception e){
            System.out.println(e);
        }

        return "headset/atualizar";
    }

    @GetMapping(value = "/headset/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        headsetService.excluir(id);

        return "redirect:/headset";
    }
}
