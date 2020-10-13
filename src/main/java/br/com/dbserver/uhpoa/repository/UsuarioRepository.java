package br.com.dbserver.uhpoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dbserver.uhpoa.models.Triagem;
import br.com.dbserver.uhpoa.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findById (long id);

}
