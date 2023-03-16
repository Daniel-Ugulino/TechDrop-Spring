package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Cliente;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/cliente/cadastro")
    public String telaCadastro() {
        return "cliente/cadastro";
    }

    @GetMapping(value = "/cliente")
    public String telaLista(Model model) {

        model.addAttribute("cliente", clienteService.obterLista());

        return "cliente/lista";
    }

    @PostMapping(value = "/cliente/incluir")
    public String incluir(Cliente cliente, @SessionAttribute("usuario") Usuario usuario) {

        cliente.setUsuario(usuario);

        clienteService.incluir(cliente);

        return "redirect:/cliente";
    }

    @GetMapping(value = "/cliente/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        clienteService.excluir(id);

        return "redirect:/cliente";
    }

    @PostMapping(value = "/cliente/{id}/atualizar")
    public String Update(Cliente cliente, @SessionAttribute("usuario") Usuario usuario){
        cliente.setUsuario(usuario);
        clienteService.atualizar(cliente);
        return "redirect:/cliente";
    }

    @GetMapping(value = "/cliente/{id}")
    public String getUser(Model model,@PathVariable Integer id){

        Cliente cliente = clienteService.getById(id);

        try {
            model.addAttribute("cliente", cliente);
        }catch (Exception e){
            System.out.println(e);
        }

        return "cliente/atualizar";
    }

}
