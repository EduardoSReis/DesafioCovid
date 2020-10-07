package resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import models.Atendimento;
import repositories.AtendimentoRepository;

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
