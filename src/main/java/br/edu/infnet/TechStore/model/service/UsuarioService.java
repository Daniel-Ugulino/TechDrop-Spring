package br.edu.infnet.TechStore.model.service;

import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UsuarioService{
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Collection<Usuario> obterLista(){ return usuarioRepository.findAll(); }

    public Collection<Usuario> listaPaginada(Integer page){
        return usuarioRepository.findPaginated(page);
    }


    public Usuario incluir(Usuario usuario) {
        usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public void excluir(Integer key) {
        usuarioRepository.deleteById(key);
    }

    public Usuario autenticar(Usuario usuario){
        Usuario userFromDB = usuarioRepository.login(usuario.getEmail());
        if (bCryptPasswordEncoder.matches(usuario.getPassword(), userFromDB.getPassword())){
            return userFromDB;
        }
        return null;
    }

    public void atualizar(Usuario usuario, Integer id){
        Usuario user = usuarioRepository.findById(id).get();
        usuario.setPassword(user.getPassword());
        usuarioRepository.save(usuario);
    }

    public Usuario getById(Integer id){
        return usuarioRepository.findById(id).get();
    }

}
