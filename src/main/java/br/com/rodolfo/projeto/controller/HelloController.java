package br.com.rodolfo.projeto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	@GetMapping
	public String hello(Model model) {
		model.addAttribute("nome", "mundo!");
		return "hello";
	}
	
}
