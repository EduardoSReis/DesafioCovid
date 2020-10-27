package br.com.dbserver.uhpoa.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.uhpoa.models.Status;
import br.com.dbserver.uhpoa.models.Usuario;
import br.com.dbserver.uhpoa.repository.StatusRepository;
import br.com.dbserver.uhpoa.repository.UsuarioRepository;
import io.swagger.annotations.Api;

@RestController
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Usuario registraUsuario(Usuario usuario){
		Status status = statusRepository.findByNome("ROLE_USER");
		usuario.setStatus(status);
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
		return usuarioRepository.save(usuario);
	}
	
	public Usuario findByLogin(String login){
		return usuarioRepository.findByLogin(login);
	}
	
	public Usuario findByLoginAndPassword(String login, String password){
		Usuario usuario = findByLogin(login);
		if(usuario != null){
			if(passwordEncoder.matches(password, usuario.getPassword()));{
				return usuario;
			}
		}
		return null;
	}
}
