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
    public Cliente incluir(Cliente cliente){
        return clienteRepository.save( cliente);
    }
    public void atualizar(Cliente cliente){
        clienteRepository.save(cliente);
    }
    public void excluir(Integer key){
        clienteRepository.deleteById(key);
    }

    public Collection<Cliente> obterLista(){
        return clienteRepository.findAll();
    }

    public Collection<Cliente> listaPaginada(Integer page){
        return clienteRepository.findPaginated(page);
    }

    public Cliente getById(Integer id){
        return clienteRepository.findById(id).get();
    }

}
