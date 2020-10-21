package br.com.dbserver.uhpoa.resources;

import java.time.Duration;
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
import br.com.dbserver.uhpoa.repository.AtendimentoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="API REST Atendimento")
@CrossOrigin(origins="*")
public class AtendimentoResource {

	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
		
	@GetMapping("/atendimentos")
	@ApiOperation(value="Retorna lista com todos os atendimentos")
	public List<Atendimento> listaAtendimento (){
		return atendimentoRepository.findAll();
	}
	
	@GetMapping("/atendimento/{id}")
	@ApiOperation(value="Retorna atendimento conforme seu ID")
	public Atendimento atendimentoById (@PathVariable(value="id") long id){
		return atendimentoRepository.findById(id);
	}
		
	
	@PostMapping("/atendimento/{id}")
	@ApiOperation(value="Atualiza um atendimento no banco de dados")
	public Atendimento atualizaAtendimento(@PathVariable(value="id") long id, @RequestBody  @Valid AtendimentoEspecialPandemia atendimento){
		Atendimento atendimentodto = atendimentoRepository.findById(id);
		atendimentodto.setDescricaoDoTratamento(atendimento.getDescricaoDoTratamento());
		if(atendimentodto instanceof AtendimentoEspecialPandemia){
			((AtendimentoEspecialPandemia) atendimentodto).setExameDeBiologiaMolecular(((AtendimentoEspecialPandemia) atendimento).isExameDeBiologiaMolecular());
			((AtendimentoEspecialPandemia) atendimentodto).setExameDeSorologia(((AtendimentoEspecialPandemia) atendimento).isExameDeSorologia());
			
		}
		atendimentodto.setDataDeSaida(atendimento.getDataDeSaida());				
		Duration duration = Duration.between(atendimentodto.getTriagem().getDataDeEntrada(), atendimento.getDataDeSaida());
		atendimentodto.setDuracaoDoAtendimento(duration.toHours());		
		return atendimentoRepository.save(atendimentodto);
				
	}
	
	
}
