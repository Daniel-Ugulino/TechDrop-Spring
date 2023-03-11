package br.edu.infnet.TechStore.model.service;

import br.edu.infnet.TechStore.model.domain.Cliente;
import br.edu.infnet.TechStore.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public boolean incluir(Cliente cliente){
        return clienteRepository.incluir(cliente);
    }
    public Cliente excluir(Integer key){
        return clienteRepository.excluir(key);
    }

    public Collection<Cliente> obterLista(){
        return clienteRepository.obterLista();
    }
}
