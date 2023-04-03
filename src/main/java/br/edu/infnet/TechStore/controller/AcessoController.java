package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Usuario;
import br.edu.infnet.TechStore.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("usuario")
public class AcessoController {

	@Autowired
	UsuarioService usuarioService;

	@GetMapping(value = "/login")
	public String telaLogin() {
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String login(Model model,@RequestParam String email, @RequestParam String senha) {

		try {
			Usuario user = new Usuario(email, senha);

			user = usuarioService.autenticar(user);

			if(user != null) {
				model.addAttribute("usuario", user);
				System.out.println(user.getPermission().toString());
				return "redirect:/home";
			}

			model.addAttribute("msg", "Login Invalido");
		} catch (Exception e){
			System.out.println(e);
		}

		return telaLogin();
	}

	@GetMapping(value = "/logout")
	public String logout(HttpSession session, SessionStatus status) {

		try {
			status.setComplete();
			session.removeAttribute("usuario");
		} catch (Exception e){
			System.out.println(e);
		}

		return "redirect:/login";
	}
}
