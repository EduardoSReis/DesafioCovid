package br.com.dbserver.uhpoa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.dbserver.uhpoa.models.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {

	Status findByNome(String nome);
}
