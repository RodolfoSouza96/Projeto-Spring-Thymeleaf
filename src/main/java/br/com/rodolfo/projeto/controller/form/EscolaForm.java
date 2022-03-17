package br.com.rodolfo.projeto.controller.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import br.com.rodolfo.projeto.modelo.Endereco;
import br.com.rodolfo.projeto.modelo.Escola;

public class EscolaForm {

	@NotBlank(message = "O Campo deve ser preenchido")
	@Length(min = 4, message = "O Campo deve ser preenchido no minimo com 4 letras")
	private String nome;
	@NotBlank(message = "O Campo deve ser preenchido")
	@Length(min = 4, message = "O Campo deve ser preenchido no minimo com 4 letras")
	private Endereco endereco;
	
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

	public Escola converter() {
		return new Escola(nome, endereco);
	}
	
}
