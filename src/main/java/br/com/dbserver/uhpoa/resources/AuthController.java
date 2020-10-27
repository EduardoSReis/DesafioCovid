package br.com.dbserver.uhpoa.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.uhpoa.config.jwt.JwtProvider;
import br.com.dbserver.uhpoa.models.Usuario;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api")
@Api(value = "API REST Triagem")
@CrossOrigin(origins = "*")
public class AuthController {
   
	@Autowired
    private UsuarioResource usuarioResource;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
    	Usuario u = new Usuario();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        usuarioResource.registraUsuario(u);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        Usuario userEntity = usuarioResource.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }
}
