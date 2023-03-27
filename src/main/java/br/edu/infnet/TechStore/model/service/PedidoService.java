package br.edu.infnet.TechStore.model.service;

import br.edu.infnet.TechStore.model.domain.Pedido;
import br.edu.infnet.TechStore.model.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public void incluir(Pedido pedido){
        pedidoRepository.save(pedido);
    }

    public void excluir(Integer key){
        pedidoRepository.deleteById(key);
    }

    public void atualizar(Pedido pedido,Integer id){
        Pedido pedidoDB = pedidoRepository.findById(id).get();
        pedido.setId(pedidoDB.getId());
        pedidoRepository.save(pedido);
    }

    public Collection<Pedido> obterLista(){
        return pedidoRepository.findAll();
    }
    public Collection<Pedido> obterLista(Integer id){
        return pedidoRepository.findAll(id);
    }
    public Pedido getById(Integer id){
        return pedidoRepository.findById(id).get();
    }
}