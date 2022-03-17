package br.com.rodolfo.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodolfo.projeto.modelo.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer>{

}
