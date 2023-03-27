package br.edu.infnet.TechStore.controller;

import br.edu.infnet.TechStore.model.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class AppController {
	
	@GetMapping(value = "/")
	public String telaIndex() {
		return "redirect:/login";
	}

	@GetMapping(value = "/home")
	public String telaHome() {
		return "index";
	}
}