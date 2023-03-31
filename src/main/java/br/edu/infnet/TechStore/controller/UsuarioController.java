package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.dtos.usuarioDto;
import br.edu.infnet.TechStore.model.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Id;
import javax.validation.Valid;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	private String msg;


	@GetMapping(value = "/usuario/cadastro")
	public String telaCadastro() {
		return "usuarios/cadastro";
	}

	@GetMapping(value = "/usuario")
	public String telaLista(Model model) {

		try {
			model.addAttribute("usuarios", usuarioService.listaPaginada(0));
			model.addAttribute("msg", msg);
		}catch (Exception e){
			System.out.println(e);
		}

		return "usuarios/lista";
	}

	@GetMapping(value = "/usuario/page/{page}")
	public String listaPaginada(Model model,@PathVariable Integer page){
		try {
			model.addAttribute("usuarios", usuarioService.listaPaginada(page));
		}catch (Exception e){
			System.out.println(e);
		}
		System.out.println(usuarioService.listaPaginada(page));

		return "usuarios/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(@Valid usuarioDto usuarioDto) {

		Usuario usuarioModel = new Usuario();
		BeanUtils.copyProperties(usuarioDto,usuarioModel);
		usuarioService.incluir(usuarioModel);

		msg = "Usuario cadastrado com sucesso";

		return "redirect:/usuario";
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id) {

		usuarioService.excluir(id);
		msg = "Usuario excluido com sucesso";

		return "redirect:/usuario";
	}

	@PostMapping(value = "/usuario/{id}/atualizar")
	public String Update(@Valid usuarioDto usuarioDto, @PathVariable Integer id){

		Usuario usuarioModel = new Usuario();
		BeanUtils.copyProperties(usuarioDto,usuarioModel);
		usuarioService.atualizar(usuarioModel, id);

		msg = "Usuario atualizado com sucesso";

		return "redirect:/usuario";
	}

	@GetMapping(value = "/usuario/{id}")
	public String getUser(Model model,@PathVariable Integer id){

		Usuario usuario = usuarioService.getById(id);

		try {
			model.addAttribute("usuario", usuario);
		}catch (Exception e){
			System.out.println(e);
		}

		return "usuarios/atualizar";
	}
}