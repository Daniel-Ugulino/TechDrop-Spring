package br.edu.infnet.TechStore.restController;

import br.edu.infnet.TechStore.model.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restEnderecoController {
    @Autowired
    EnderecoService enderecoService;
    @GetMapping(value = "/getCep/{cep}")
    public Object getCep(@PathVariable String cep){
        return enderecoService.getByCep(cep);
    }

}
