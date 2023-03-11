package br.edu.infnet.TechStore.model.service;

import br.edu.infnet.TechStore.model.domain.Teclado;
import br.edu.infnet.TechStore.model.repository.TecladoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TecladoService {
    @Autowired
    private TecladoRepository tecladoRepository;
    public boolean incluir(Teclado teclado){
        return tecladoRepository.incluir(teclado);
    }
    public Teclado excluir(Integer key){
        return tecladoRepository.excluir(key);
    }

    public Collection<Teclado> obterLista(){
        return tecladoRepository.obterLista();
    }
}
