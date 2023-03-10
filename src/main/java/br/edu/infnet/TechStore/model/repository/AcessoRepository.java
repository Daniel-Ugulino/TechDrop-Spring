package br.edu.infnet.TechStore.model.repository;

import br.edu.infnet.TechStore.model.domain.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public class AcessoRepository {

	public static Usuario autenticar(Usuario usuario) {

		if(usuario.getEmail().equalsIgnoreCase(usuario.getPassword())) {
			return new Usuario("Administrador", usuario.getEmail(), usuario.getPassword());
		}

		return null;
	}
}
