package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Pedido;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.service.ClienteService;
import br.edu.infnet.TechStore.model.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    private String msg;

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/pedido/cadastro")
    public String telaCadastro(Model model,@SessionAttribute("usuario") Usuario usuario){

        try {
            model.addAttribute("cliente", clienteService.obterLista(usuario.getId()));
        }
        catch (Exception e){
            System.out.println(e);
        }

        return "/pedido/cadastro";
    }

    @GetMapping(value = "/pedido")
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario){

        try {
            model.addAttribute("pedido", pedidoService.obterLista(usuario.getId()));
            model.addAttribute("msg", msg);
        }catch (Exception e){
            System.out.println(e);
        }

        return "pedido/lista";
    }

    @PostMapping(value = "/pedido/incluir")
    public String incluir(Pedido pedido,@SessionAttribute("usuario") Usuario usuario){
        try {
            pedido.setUsuario(usuario);
            pedido.calcularValorTotal();
            pedidoService.incluir(pedido);
            msg = "Pedido realizado com sucesso";
        }catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/pedido";
    }

    @PostMapping(value = "/pedido/atualizar/{id}")
    public String atualizar(Pedido pedido, @SessionAttribute("usuario") Usuario usuario,@PathVariable Integer id){

        try {
            pedido.setUsuario(usuario);
            pedidoService.atualizar(pedido,id);
            msg = "Pedido atualizado com sucesso";
        }catch (Exception e){
            System.out.println(e);
        }

        return "redirect:/mouse";
    }

    @GetMapping(value = "/pedido/{id}")
    public String getUser(Model model,@PathVariable Integer id){

        try {
            Pedido pedido = pedidoService.getById(id);
            model.addAttribute("pedido", pedido);
        }catch (Exception e){
            System.out.println(e);
        }
        return "pedido/atualizar";
    }

    @GetMapping(value = "/pedido/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
       try {
           pedidoService.excluir(id);
           msg = "Pedido excluido com sucesso";
       }catch (Exception e){
           System.out.println(e);
       }
        return "redirect:/pedido";
    }
}
