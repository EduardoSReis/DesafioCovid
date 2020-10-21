package br.com.dbserver.uhpoa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dbserver.uhpoa.models.Atendimento;
import br.com.dbserver.uhpoa.models.Estatisticas;

public interface EstatisticasRepository extends JpaRepository<Estatisticas, String> {
	
	Estatisticas findById (long id);
	
	
	
}
