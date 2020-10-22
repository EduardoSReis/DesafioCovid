package br.com.dbserver.uhpoa.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.uhpoa.models.Atendimento;
import br.com.dbserver.uhpoa.models.AtendimentoEspecialPandemia;
import br.com.dbserver.uhpoa.models.Triagem;
import br.com.dbserver.uhpoa.repository.AtendimentoRepository;
import br.com.dbserver.uhpoa.repository.TriagemRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "API REST Triagem")
@CrossOrigin(origins = "*")
public class TriagemResource {

	@Autowired
	private TriagemRepository triagemRepository;
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@GetMapping("/triagens")
	@ApiOperation(value = "Retorna lista com todas as triagens")
	public List<Triagem> listaAtendimento() {
		return triagemRepository.findAll();
	}

	@GetMapping("/triagem/{id}")
	@ApiOperation(value = "Retorna triagem coforme ID")
	public Triagem triagemById(@PathVariable(value = "id") long id) {
		return triagemRepository.findById(id);
	}

	@PostMapping("/registrartriagem")
	@ApiOperation(value = "Salva triagem no banco")
	public Atendimento registraTriagem(@Valid @RequestBody Triagem triagem) {		
		triagemRepository.save(triagem);		
		return atendimentoRepository.save(triagem.registraAtendimento(triagem));

	}

}
