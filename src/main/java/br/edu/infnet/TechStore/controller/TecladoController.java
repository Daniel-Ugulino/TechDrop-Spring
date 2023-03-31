package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Mouse;
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

        model.addAttribute("teclado", tecladoService.obterLista(usuario.getId()));
        model.addAttribute("msg", msg);

        return "teclado/lista";
    }

    @PostMapping(value = "/teclado/incluir")
    public String incluir(@Valid tecladoDto tecladoDto, MultipartFile file, @SessionAttribute("usuario") Usuario usuario){
        Teclado tecladoModel = new Teclado();
        BeanUtils.copyProperties(tecladoDto,tecladoModel);
        tecladoModel.setUsuario(usuario);

        if(file.isEmpty()) {
            tecladoService.incluir(tecladoModel,null);
        }else{
            tecladoService.incluir(tecladoModel,file);
        }

        msg = "Teclado cadastrado com sucesso";

        return "redirect:/teclado";
    }

    @PostMapping(value = "/teclado/atualizar/{id}")
    public String atualizar(@Valid tecladoDto tecladoDto, MultipartFile file, @SessionAttribute("usuario") Usuario usuario,@PathVariable Integer id){
        Teclado tecladoModel = new Teclado();
        BeanUtils.copyProperties(tecladoDto,tecladoModel);
        tecladoModel.setUsuario(usuario);

        if(file.isEmpty()) {
            tecladoService.atualizar(tecladoModel,id,null);
        }else{
            tecladoService.atualizar(tecladoModel,id,file);
        }

        msg = "Teclado atualizado com sucesso";

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
        msg = "Teclado excluido com sucesso";

        return "redirect:/teclado";
    }
}
