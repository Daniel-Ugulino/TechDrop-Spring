package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Cliente;
import br.edu.infnet.TechStore.model.domain.Endereco;
import br.edu.infnet.TechStore.model.domain.Headset;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.dtos.clienteDto;
import br.edu.infnet.TechStore.model.dtos.enderecoDto;
import br.edu.infnet.TechStore.model.service.ClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    private String msg;


    @GetMapping(value = "/cliente/cadastro")
    public String telaCadastro() {
        return "cliente/cadastro";
    }

    @GetMapping(value = "/cliente")
    public String telaLista(Model model,@SessionAttribute("usuario") Usuario usuario) {
        try {
            if(usuario.getPermission().toString() == "ADMINISTRATOR"){
                model.addAttribute("cliente", clienteService.obterLista());
            }
            else {
                model.addAttribute("cliente", clienteService.obterLista(usuario.getId()));
            }

            model.addAttribute("msg", msg);
        }
        catch (Exception e){
            System.out.println(e);
        }

        return "cliente/lista";
    }

    @PostMapping(value = "/cliente/incluir")
    public String incluir(@Valid clienteDto clienteDto,@Valid enderecoDto enderecoDto, MultipartFile file, @SessionAttribute("usuario") Usuario usuario) {
        try {
            Cliente clienteModel = new Cliente();
            Endereco enderecoModel = new Endereco();

            BeanUtils.copyProperties(clienteDto,clienteModel);
            BeanUtils.copyProperties(enderecoDto,enderecoModel);

            clienteModel.setUsuario(usuario);
            clienteModel.setEndereco(enderecoModel);

            if(file.isEmpty()) {
                clienteService.incluir(clienteModel,null);
            }else{
                clienteService.incluir(clienteModel,file);
            }

            msg = "Cliente cadastrado com sucesso";
        } catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/cliente";
    }

    @GetMapping(value = "/cliente/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        try {
            clienteService.excluir(id);
            msg = "Cliente excluido com sucesso";
        } catch (Exception e){
            System.out.println(e);
        }


        return "redirect:/cliente";
    }

    @PostMapping(value = "/cliente/{id}/atualizar")
    public String Update(@Valid clienteDto clienteDto,@Valid enderecoDto enderecoDto, MultipartFile file, @PathVariable Integer id,@SessionAttribute("usuario") Usuario usuario){

        try {
            Cliente clienteModel = new Cliente();
            Endereco enderecoModel = new Endereco();

            BeanUtils.copyProperties(clienteDto,clienteModel);
            BeanUtils.copyProperties(enderecoDto,enderecoModel);

            clienteModel.setUsuario(usuario);
            clienteModel.setEndereco(enderecoModel);

            if(file.isEmpty()) {
                clienteService.atualizar(clienteModel,id,null);
            }else{
                clienteService.atualizar(clienteModel,id,file);
            }
            msg = "Cliente atualizado com sucesso";
        } catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/cliente";
    }

    @GetMapping(value = "/cliente/{id}")
    public String getUser(Model model,@PathVariable Integer id){


        try {
            Cliente cliente = clienteService.getById(id);
            model.addAttribute("cliente", cliente);
        } catch (Exception e){
            System.out.println(e);
        }

        return "cliente/atualizar";
    }

}
