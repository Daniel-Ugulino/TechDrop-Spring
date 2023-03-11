package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Cliente;
import br.edu.infnet.TechStore.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String incluir(Cliente cliente) {

        clienteService.incluir(cliente);

        return "redirect:/cliente";
    }

    @GetMapping(value = "/cliente/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        clienteService.excluir(id);

        return "redirect:/cliente";
    }

}
