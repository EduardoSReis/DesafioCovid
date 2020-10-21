package br.com.dbserver.uhpoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.dbserver.uhpoa.models.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, String> {
	
	Atendimento findById (long id);
	
		
}
