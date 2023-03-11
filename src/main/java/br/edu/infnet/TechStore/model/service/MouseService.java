package br.edu.infnet.TechStore.model.service;


import br.edu.infnet.TechStore.model.domain.Mouse;
import br.edu.infnet.TechStore.model.repository.MouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MouseService {
    @Autowired
    private MouseRepository mouseRepository;
    public boolean incluir(Mouse mouse){
        return mouseRepository.incluir(mouse);
    }
    public Mouse excluir(Integer key){
        return mouseRepository.excluir(key);
    }

    public Collection<Mouse> obterLista(){
        return mouseRepository.obterLista();
    }
}
