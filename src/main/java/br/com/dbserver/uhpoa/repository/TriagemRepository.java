package br.com.dbserver.uhpoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dbserver.uhpoa.models.Atendimento;
import br.com.dbserver.uhpoa.models.Triagem;

public interface TriagemRepository extends JpaRepository<Triagem, Long>{
	
	Triagem findById (long id);

}
