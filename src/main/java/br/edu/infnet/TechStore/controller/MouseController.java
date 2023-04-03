package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.domain.Teclado;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.dtos.mouseDto;
import br.edu.infnet.TechStore.model.service.MouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class MouseController {
    @Autowired
    private MouseService mouseService;

    private String msg;


    @GetMapping(value = "/mouse/cadastro")
    public String telaCadastro(){
        return "/mouse/cadastro";
    }

    @GetMapping(value = "/mouse")
    public String telaLista(Model model,@SessionAttribute("usuario") Usuario usuario){

        try {
            model.addAttribute("mouse", mouseService.obterLista(usuario.getId()));
            model.addAttribute("msg", msg);
        } catch (Exception e){
            System.out.println(e);
        }

        return "mouse/lista";
    }

    @PostMapping(value = "/mouse/incluir")
    public String incluir(@Valid mouseDto mouseDto, MultipartFile file, @SessionAttribute("usuario") Usuario usuario){

        try {
           Mouse mouseModel = new Mouse();
           BeanUtils.copyProperties(mouseDto,mouseModel);
           mouseModel.setUsuario(usuario);

           if(file.isEmpty()) {
               mouseService.incluir(mouseModel,null);
           }else{
               mouseService.incluir(mouseModel,file);
           }

           msg = "Mouse cadastrado com sucesso";
       } catch (Exception e){
           System.out.println(e);
       }

        return "redirect:/mouse";
    }

    @PostMapping(value = "/mouse/atualizar/{id}")
    public String atualizar(@Valid mouseDto mouseDto, MultipartFile file, @SessionAttribute("usuario") Usuario usuario,@PathVariable Integer id){

        try {
            Mouse mouseModel = new Mouse();
            BeanUtils.copyProperties(mouseDto,mouseModel);
            mouseModel.setUsuario(usuario);

            if(file.isEmpty()) {
                mouseService.atualizar(mouseModel,id,null);
            }else{
                mouseService.atualizar(mouseModel,id,file);
            }
            msg = "Mouse atualizado com sucesso";
        } catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/mouse";
    }


    @GetMapping(value = "/mouse/{id}")
    public String getUser(Model model,@PathVariable Integer id){

        try {
            Mouse mouse = mouseService.getById(id);
            model.addAttribute("mouse", mouse);
        } catch (Exception e){
            System.out.println(e);
        }

        return "mouse/atualizar";
    }

    @GetMapping(value = "/mouse/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        try {
            mouseService.excluir(id);
            msg = "Mouse excluido com sucesso";
        } catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/mouse";
    }
}
