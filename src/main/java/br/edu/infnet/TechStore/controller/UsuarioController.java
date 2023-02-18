package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.repository.UsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

	@GetMapping(value = "/usuario")
	public String telaCadastro() {
		return "usuarios/cadastro";
	}

	@GetMapping(value = "/usuario/lista")
	public String telaLista() {

		List<Usuario> lista = UsuarioRepository.obterLista();
		
		System.out.println("Quantidade de usuários = " + lista.size());

		for(Usuario user : lista) {
			System.out.printf("%s - %s\n", user.getUsername(), user.getEmail());
		}		
		
		return "usuarios/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(Usuario usuario) {

		UsuarioRepository.incluir(usuario);
		
		return "redirect:/usuario/lista";
	}
}