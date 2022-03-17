package br.com.rodolfo.projeto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rodolfo.projeto.modelo.Endereco;
import br.com.rodolfo.projeto.modelo.Escola;

public class EscolaDto {

	
	private Integer id;
	private String nome;
	private Endereco endereco;
	
	
	public EscolaDto(Escola escola) {
		this.id = escola.getId();
		this.nome = escola.getNome();
		
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}		
	
	public static List<EscolaDto> converter(List<Escola> escolas) {
		return escolas.stream().map(EscolaDto::new).collect(Collectors.toList());
	}

}
