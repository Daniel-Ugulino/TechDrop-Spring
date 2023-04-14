package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.enums.user.userPermissions;
import br.edu.infnet.TechStore.model.domain.Headset;
import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.domain.Teclado;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.service.HeadsetService;
import br.edu.infnet.TechStore.model.service.MouseService;
import br.edu.infnet.TechStore.model.service.ProdutoService;
import br.edu.infnet.TechStore.model.service.TecladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.Collection;

@Controller
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping(value = "/produto")
    public String telaLista(Model model, @SessionAttribute("usuario") Usuario usuario){
        try {
            if (usuario.getPermission() == userPermissions.ADMINISTRATOR){
                model.addAttribute("produto", produtoService.obterLista());
            }
            else {
                model.addAttribute("produto", produtoService.obterLista(usuario.getId()));
            }
        } catch (Exception e){
            System.out.println(e);
        }

        return "produto/lista";
    }

    @GetMapping(value = "/produto/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        try {
            produtoService.excluir(id);
        }catch (Exception e){
            System.out.println(e);
        }


        return "redirect:/mouse";
    }

}
