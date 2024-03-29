package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.enums.user.userPermissions;
import br.edu.infnet.TechStore.model.domain.Teclado;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.dtos.tecladoDto;
import br.edu.infnet.TechStore.model.service.TecladoService;
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
public class TecladoController {

    @Autowired
    private TecladoService tecladoService;
    private String msg;


    @GetMapping(value = "/teclado/cadastro")
    public String telaCadastro(){
        return "/teclado/cadastro";
    }

    @GetMapping(value = "/teclado")
    public String telaLista(Model model,@SessionAttribute("usuario") Usuario usuario){

        try {
            if(usuario.getPermission() == userPermissions.ADMINISTRATOR) {
                model.addAttribute("teclado", tecladoService.obterLista());
            }else{
                model.addAttribute("teclado", tecladoService.obterLista(usuario.getId()));
            }
            model.addAttribute("msg", msg);
        }catch (Exception e){
            System.out.println(e);
        }
        msg = null;

        return "teclado/lista";
    }

    @PostMapping(value = "/teclado/incluir")
    public String incluir(@Valid tecladoDto tecladoDto, MultipartFile file, @SessionAttribute("usuario") Usuario usuario){

        try {
            Teclado tecladoModel = new Teclado();
            BeanUtils.copyProperties(tecladoDto,tecladoModel);
            tecladoModel.setUsuario(usuario);

            if(file.isEmpty()) {
                tecladoService.incluir(tecladoModel,null);
            }else{
                tecladoService.incluir(tecladoModel,file);
            }

            msg = "Teclado cadastrado com sucesso";
        }catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/teclado";
    }

    @PostMapping(value = "/teclado/atualizar/{id}")
    public String atualizar(@Valid tecladoDto tecladoDto, MultipartFile file, @SessionAttribute("usuario") Usuario usuario,@PathVariable Integer id){

        try {
            Teclado tecladoModel = new Teclado();
            BeanUtils.copyProperties(tecladoDto,tecladoModel);
            tecladoModel.setUsuario(usuario);

            if(file.isEmpty()) {
                tecladoService.atualizar(tecladoModel,id,null);
            }else{
                tecladoService.atualizar(tecladoModel,id,file);
            }

            msg = "Teclado atualizado com sucesso";
        }catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/teclado";
    }


    @GetMapping(value = "/teclado/{id}")
    public String getUser(Model model,@PathVariable Integer id){

        try {
            Teclado teclado = tecladoService.getById(id);
            model.addAttribute("teclado", teclado);
        }catch (Exception e){
            System.out.println(e);
        }

        return "teclado/atualizar";
    }

    @GetMapping(value = "/teclado/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        try {
            tecladoService.excluir(id);
            msg = "Teclado excluido com sucesso";
        }catch (Exception e){
            msg = "Não foi possivel excluir o teclado, há um pedido vinculado";
        }


        return "redirect:/teclado";
    }

    @GetMapping(value = "/teclado/{id}/updateStatus")
    public String updateStatus(@PathVariable Integer id){

        try {
            tecladoService.updateStatus(id);
            msg = "Status do Teclado alterado com sucesso";
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return "redirect:/usuario";
    }
}
