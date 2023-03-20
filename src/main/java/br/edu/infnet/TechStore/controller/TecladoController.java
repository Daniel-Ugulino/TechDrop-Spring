package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.domain.Teclado;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.service.TecladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class TecladoController {

    @Autowired
    private TecladoService tecladoService;

    @GetMapping(value = "/teclado/cadastro")
    public String telaCadastro(){
        return "/teclado/cadastro";
    }

    @GetMapping(value = "/teclado")
    public String telaLista(Model model,@SessionAttribute("usuario") Usuario usuario){

        model.addAttribute("teclado", tecladoService.obterLista(usuario.getId()));
        return "teclado/lista";
    }

    @PostMapping(value = "/teclado/incluir")
    public String incluir(Teclado teclado, MultipartFile file, @SessionAttribute("usuario") Usuario usuario){
        teclado.setUsuario(usuario);

        if(file.isEmpty()) {
            tecladoService.incluir(teclado,null);
        }else{
            tecladoService.incluir(teclado,file);
        }

        return "redirect:/teclado";
    }


    @PostMapping(value = "/teclado/atualizar/{id}")
    public String atualizar(Teclado teclado, MultipartFile file, @SessionAttribute("usuario") Usuario usuario,@PathVariable Integer id){
        teclado.setUsuario(usuario);

        if(file.isEmpty()) {
            tecladoService.atualizar(teclado,id,null);
        }else{
            tecladoService.atualizar(teclado,id,file);
        }

        return "redirect:/teclado";
    }


    @GetMapping(value = "/teclado/{id}")
    public String getUser(Model model,@PathVariable Integer id){

        Teclado teclado = tecladoService.getById(id);

        try {
            model.addAttribute("teclado", teclado);
        }catch (Exception e){
            System.out.println(e);
        }

        return "teclado/atualizar";
    }

    @GetMapping(value = "/teclado/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        tecladoService.excluir(id);

        return "redirect:/teclado";
    }
}
