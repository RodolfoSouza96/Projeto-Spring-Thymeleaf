package br.com.rodolfo.projeto.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rodolfo.projeto.controller.dto.AlunoDto;
import br.com.rodolfo.projeto.controller.form.AlunoForm;
import br.com.rodolfo.projeto.modelo.Aluno;
import br.com.rodolfo.projeto.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<AlunoDto> lista() {
		List<Aluno> alunos = alunoRepository.findAll();
		return AlunoDto.converter(alunos);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AlunoDto> detalhar(@PathVariable Integer id) {
		
		Optional<Aluno> aluno =  alunoRepository.findById(id);
		if (aluno.isPresent()) {
			return ResponseEntity.ok(new AlunoDto(aluno.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AlunoDto> cadastrar(@RequestBody @Valid AlunoForm form, UriComponentsBuilder uriBuilder) {
		Aluno aluno = form.converter();
		alunoRepository.save(aluno);
		URI uri = uriBuilder.path("/aluno/{id}").buildAndExpand(aluno.getId()).toUri() ;
		return ResponseEntity.created(uri).body(new AlunoDto(aluno));
	}
	
//	@PutMapping("/{id}")
//	@Transactional
//	public ResponseEntity<AlunoDto> atualizar(@PathVariable Integer id, @RequestBody @Valid AtualizacaoAlunoForm form) {
//		Optional<Aluno> optional =  alunoRepository.findById(id);
//		if (optional.isPresent()) {
//			Aluno aluno = form.atualizar(id, alunoRepository);				
//			return ResponseEntity.ok((new AlunoDto(aluno)));
//		}
//		
//		return ResponseEntity.notFound().build();
//	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<String> remover(@PathVariable Integer id) {
		Optional<Aluno> optional =  alunoRepository.findById(id);
		if (optional.isPresent()) {
			alunoRepository.deleteById(id);
			return ResponseEntity.ok().body("Aluno excluido com sucesso!");
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
}
