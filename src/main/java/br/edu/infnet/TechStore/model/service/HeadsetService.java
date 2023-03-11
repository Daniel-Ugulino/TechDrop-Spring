package br.edu.infnet.TechStore.model.service;

import br.edu.infnet.TechStore.model.domain.Headset;
import br.edu.infnet.TechStore.model.repository.HeadsetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class HeadsetService {
    @Autowired
    private HeadsetRepository headsetRepository;
    public boolean incluir(Headset headset){
        return headsetRepository.incluir(headset);
    }
    public Headset excluir(Integer key){
        return headsetRepository.excluir(key);
    }

    public Collection<Headset> obterLista(){
        return headsetRepository.obterLista();
    }
}
