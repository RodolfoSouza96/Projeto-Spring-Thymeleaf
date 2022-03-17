package br.com.rodolfo.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rodolfo.projeto.modelo.Escola;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Integer>{

}
