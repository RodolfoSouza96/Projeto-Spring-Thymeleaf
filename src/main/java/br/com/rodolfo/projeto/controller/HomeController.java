package br.com.rodolfo.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rodolfo.projeto.controller.dto.AlunoDto;
import br.com.rodolfo.projeto.modelo.Aluno;
import br.com.rodolfo.projeto.repository.AlunoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public String home(Model model) {
		
			List<Aluno> alunos = alunoRepository.findAll();
			List<AlunoDto> converter = AlunoDto.converter(alunos);
			model.addAttribute("alunos", converter);
		
		return "home";
	}
	
	
	
	
}
