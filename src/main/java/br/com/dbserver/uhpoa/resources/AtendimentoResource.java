package br.com.dbserver.uhpoa.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.uhpoa.models.Atendimento;
import br.com.dbserver.uhpoa.repository.AtendimentoRepository;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoResource {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
//	@GetMapping
//	public
	
	@PostMapping()
	public Atendimento registraAtendimento(@RequestBody  @Valid Atendimento atendimento){
		return atendimentoRepository.save(atendimento);
	}
	
	
}
