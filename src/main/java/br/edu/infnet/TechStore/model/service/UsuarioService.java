package br.edu.infnet.TechStore.model.service;

import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public boolean incluir(Usuario usuario){
        return usuarioRepository.incluir(usuario);
    }
    public Usuario excluir(Integer key){
        return usuarioRepository.excluir(key);
    }

    public Usuario autenticar(Usuario usuario){
        return usuarioRepository.autenticar(usuario);
    }

    public Collection<Usuario> obterLista(){
        return usuarioRepository.obterLista();
    }
}
