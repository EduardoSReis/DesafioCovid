package br.com.dbserver.uhpoa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.dbserver.uhpoa.models.Usuario;
import br.com.dbserver.uhpoa.resources.UsuarioResource;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    
	@Autowired
    private UsuarioResource usuarioResource;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario userEntity = usuarioResource.findByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}

