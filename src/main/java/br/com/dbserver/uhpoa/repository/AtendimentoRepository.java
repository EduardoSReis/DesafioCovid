package br.com.dbserver.uhpoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dbserver.uhpoa.models.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, String> {
	
	Atendimento findById (long id);
	
}
