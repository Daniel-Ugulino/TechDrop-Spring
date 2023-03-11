package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UsuarioRepository {

	private static Integer id = 1;

	private static Map<Integer, Usuario> mapaUsuario = new HashMap<Integer, Usuario>();

	public boolean incluir(Usuario usuario) {

		usuario.setId(id++);

		try {
			mapaUsuario.put(usuario.getId(), usuario);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Usuario excluir(Integer key) {

		return mapaUsuario.remove(key);
	}

	public Collection<Usuario> obterLista(){
		return mapaUsuario.values();
	}

	public Usuario autenticar(Usuario usuario){
		if(usuario.getEmail().equals(usuario.getPassword())){
			return usuario;
		}
		return null;
	}

}
