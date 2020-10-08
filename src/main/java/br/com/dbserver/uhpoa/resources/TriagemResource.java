package br.com.dbserver.uhpoa.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.uhpoa.models.Triagem;
import br.com.dbserver.uhpoa.repository.TriagemRepository;


@RestController
@RequestMapping("/triagem")
public class TriagemResource {
	
	@Autowired
	private TriagemRepository triagemRepository;
	
	@PostMapping()
	public Triagem registraTriagem(@RequestBody  @Valid Triagem	triagem){
		return triagemRepository.save(triagem);
	}

}
