package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Headset;
import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.dtos.headsetDto;
import br.edu.infnet.TechStore.model.service.HeadsetService;
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
public class HeadsetController {

    @Autowired
    private HeadsetService headsetService;

    private String msg;


    @GetMapping(value = "/headset/cadastro")
    public String telaCadastro(){
        return "/headset/cadastro";
    }

    @GetMapping(value = "/headset")
    public String telaLista(Model model,@SessionAttribute("usuario") Usuario usuario){

        model.addAttribute("headset", headsetService.obterLista(usuario.getId()));
        model.addAttribute("msg", msg);

        return "headset/lista";
    }

    @PostMapping(value = "/headset/incluir")
    public String incluir(@Valid headsetDto headsetDto, MultipartFile file, @SessionAttribute("usuario") Usuario usuario){
        Headset headsetModel = new Headset();
        BeanUtils.copyProperties(headsetDto,headsetModel);
        headsetModel.setUsuario(usuario);

        if(file.isEmpty()) {
            headsetService.incluir(headsetModel,null);
        }else{
            headsetService.incluir(headsetModel,file);
        }

        msg = "Headset cadastrado com sucesso";


        return "redirect:/headset";
    }


    @PostMapping(value = "/headset/atualizar/{id}")
    public String atualizar(@Valid headsetDto headsetDto, MultipartFile file, @SessionAttribute("usuario") Usuario usuario,@PathVariable Integer id){
        Headset headsetModel = new Headset();
        BeanUtils.copyProperties(headsetDto,headsetModel);
        headsetModel.setUsuario(usuario);

        if(file.isEmpty()) {
            headsetService.atualizar(headsetModel,id,null);
        }else{
            headsetService.atualizar(headsetModel,id,file);
        }

        msg = "Headset atualizado com sucesso";


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
        msg = "Headset excluido com sucesso";

        return "redirect:/headset";
    }
}
