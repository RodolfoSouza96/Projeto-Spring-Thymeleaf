package br.com.rodolfo.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodolfo.projeto.modelo.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>{

}
