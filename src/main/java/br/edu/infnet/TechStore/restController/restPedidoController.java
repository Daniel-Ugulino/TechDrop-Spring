package br.edu.infnet.TechStore.restController;
import br.edu.infnet.TechStore.model.domain.Produto;
import br.edu.infnet.TechStore.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class restPedidoController {
    @Autowired
    private ProdutoService produtoService;
    @GetMapping(value = "/getProdutos/{type}")
    public Collection excluir(@PathVariable String type) {
        Collection<Produto> products = produtoService.obterListaByType(type);
        return products;
    }
}
