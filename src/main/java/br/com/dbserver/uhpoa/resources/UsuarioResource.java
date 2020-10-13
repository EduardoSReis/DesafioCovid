package br.com.dbserver.uhpoa.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.uhpoa.models.Atendimento;
import br.com.dbserver.uhpoa.models.Triagem;
import br.com.dbserver.uhpoa.models.Usuario;
import br.com.dbserver.uhpoa.repository.UsuarioRepository;
import io.swagger.annotations.ApiOperation;

@RestController
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/usuarios")
	@ApiOperation(value="Retorna lista com todos os usuarios")
	public List<Usuario> listaUsuario (){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	@ApiOperation(value="Retorna usuário coforme ID")
	public Usuario usuarioById (@PathVariable(value="id") long id){
		return usuarioRepository.findById(id);
	}
	
	@PostMapping("/registrarUsuario")
	@ApiOperation(value="Salva usuário no banco")
	public Usuario registraUsuario(@RequestBody  @Valid Usuario	usuario){
		return usuarioRepository.save(usuario);
	}
	
	@DeleteMapping("/usuario")
	@ApiOperation(value="Deleta usuário do banco")
	public void deletaUsuario(@RequestBody Usuario usuario){
		usuarioRepository.delete(usuario);
	}
}
