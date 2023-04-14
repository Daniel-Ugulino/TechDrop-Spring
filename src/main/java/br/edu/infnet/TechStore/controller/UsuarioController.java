package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.enums.user.userPermissions;
import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.dtos.usuarioDto;
import br.edu.infnet.TechStore.model.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
	public String telaLista(Model model,@SessionAttribute("usuario") Usuario usuario){

		try {
			if(usuario.getPermission() == userPermissions.ADMINISTRATOR){
				model.addAttribute("usuarios", usuarioService.getList());
				model.addAttribute("msg", msg);
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
		msg = null;
		return "usuarios/lista";
	}

	@GetMapping(value = "/usuario/page/{page}")
	public String listaPaginada(Model model,@PathVariable Integer page){

		try {
			model.addAttribute("usuarios", usuarioService.pagedList(page));
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

		return "usuarios/lista";
	}

	@PostMapping(value = "/usuario/incluir")
	public String incluir(@Valid usuarioDto usuarioDto){

		try {
			Usuario usuarioModel = new Usuario();
			BeanUtils.copyProperties(usuarioDto,usuarioModel);
			usuarioService.insert(usuarioModel);

			msg = "Usuario cadastrado com sucesso";

		} catch (Exception e){
			System.out.println(e.getMessage());
		}


		return "redirect:/usuario";
	}

	@GetMapping(value = "/usuario/{id}/excluir")
	public String excluir(@PathVariable Integer id){

		try {
			usuarioService.delete(id);
			msg = "Usuario excluido com sucesso";
		} catch (Exception e){
			msg = "Não foi possivel excluir o usuario";
		}

		return "redirect:/usuario";
	}

	@GetMapping(value = "/usuario/{id}/updateStatus")
	public String updateStatus(@PathVariable Integer id){

		try {
			usuarioService.changeStatus(id);
			msg = "Status do Usuario alterado com sucesso";
		} catch (Exception e){
			System.out.println(e.getMessage());
		}


		return "redirect:/usuario";
	}

	@PostMapping(value = "/usuario/{id}/atualizar")
	public String Update(Usuario usuario, @PathVariable Integer id){

		try {
			usuarioService.update(usuario, id);
			msg = "Usuario atualizado com sucesso";

		} catch (Exception e){
			System.out.println(e.getMessage());
		}


		return "redirect:/usuario";
	}

	@GetMapping(value = "/usuario/{id}")
	public String getUser(Model model,@PathVariable Integer id){

		try {
			Usuario usuario = usuarioService.getById(id);
			model.addAttribute("usuario", usuario);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

		return "usuarios/atualizar";
	}
}