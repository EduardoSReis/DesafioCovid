package br.com.dbserver.uhpoa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.dbserver.uhpoa.models.Triagem;

public interface TriagemRepository extends JpaRepository<Triagem, Long>{
	
	Triagem findById (long id);
	
	@Query(value = "SELECT * FROM triagem WHERE unidade_de_atendimento_medico = ?1", nativeQuery = true)
	List<Triagem> findByUnidadeDeAtendimento(int id);

}
