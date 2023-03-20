package br.edu.infnet.TechStore.model.service;

import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.domain.Produto;
import br.edu.infnet.TechStore.model.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Collection<Produto> obterLista(){
        return produtoRepository.findAll();
    }

    public Collection<Produto> getByUserId(Integer id){
        return produtoRepository.findAll(id);
    }

    public Collection<Produto> obterLista(Integer id){
        return produtoRepository.findAll(id);
    }


    public Produto getById(Integer id){
        return produtoRepository.findById(id).get();
    }

    public void excluir(Integer key){
        produtoRepository.deleteById(key);
    }


}
