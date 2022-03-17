package br.com.rodolfo.projeto.controller;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rodolfo.projeto.controller.form.AlunoForm;
import br.com.rodolfo.projeto.modelo.Aluno;
import br.com.rodolfo.projeto.repository.AlunoRepository;

@Controller
@RequestMapping("/aluno")
public class AlunoController2 {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping("/formulario")
	public String formulario(AlunoForm form) {
		return "aluno/formulario";
	}
		
	@PostMapping("/novo")
	public String novo(@Valid AlunoForm form, BindingResult result) {
		
		if(result.hasErrors()) {
			return "aluno/formulario";
		}
		
		Aluno aluno = form.converter();
		alunoRepository.save(aluno);
		
		return "redirect:/home";
	}
	
	@GetMapping("/listarPorId")
	public String listarPorId(Aluno formData) {
		return "aluno/listarPorId";
	}
	
	@PostMapping("/listarPorId")
    public String listaPorId(Aluno formData, Model model, Integer id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		if(!aluno.isPresent()) {
			return "redirect:/aluno/listarPorId";
		} else {
			model.addAttribute("aluno", aluno.get());
			return "aluno/listarPorId";
		}
    }
	
	@GetMapping("/atualiza")
	public String atualizar(Aluno formData, AlunoForm form) {
			return "aluno/atualiza";
	}
	
	@PostMapping("/atualiza")
	@Transactional
    public String atualizar(@Valid Aluno formData, AlunoForm form,  Model model, Integer id) {
		
		Optional<Aluno> optional = alunoRepository.findById(id);
		if(!optional.isPresent()) {
			return "redirect:/home";
		} else {
			model.addAttribute("aluno", optional.get());
			form.atualizar(id, alunoRepository);
		}
		return "aluno/atualiza";
    }
	
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
	
	

	
	
	
}
