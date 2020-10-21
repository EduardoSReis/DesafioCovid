package br.com.dbserver.uhpoa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbserver.uhpoa.models.Atendimento;
import br.com.dbserver.uhpoa.models.AtendimentoEspecialPandemia;
import br.com.dbserver.uhpoa.models.Estatisticas;
import br.com.dbserver.uhpoa.models.Triagem;
import br.com.dbserver.uhpoa.models.UnidadeDeAtendimentoMedico;
import br.com.dbserver.uhpoa.repository.AtendimentoRepository;
import br.com.dbserver.uhpoa.repository.EstatisticasRepository;
import br.com.dbserver.uhpoa.repository.TriagemRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "API REST Estatísticas")
@CrossOrigin(origins = "*")
public class EstatisticasResource {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private TriagemRepository triagemRepository;

	@Autowired
	private EstatisticasRepository estatisticasRepository;

	@GetMapping("/estatisticas")
	@ApiOperation(value = "Retorna lista com todas as estatísticas")
	public List<Estatisticas> listaEstatisticas() {
		
		for(int i = 0; i < UnidadeDeAtendimentoMedico.values().length; i++){
			if(estatisticasRepository.findAll() == null){			
				
			}
			Estatisticas estatisticas = new Estatisticas();
			estatisticas.setUnidadeDeAtendimento(UnidadeDeAtendimentoMedico.values()[i]);
			estatisticas.setTempoMaximoDeAtendimento(atendimentoMaisLongo(i));
			estatisticas.setTempoMinimoDeAtendimento(atendimentoMaisRapido(i));
			estatisticas.setTempoMedioDeAtendimento(tempoMedioDeAtendimento(i));
			estatisticas.setAtendimentosDeCovid(atendimentosDeCovid(i));
			estatisticasRepository.save(estatisticas);
		}
		
		return estatisticasRepository.findAll();
	}
	
	public Long atendimentoMaisLongo(int id) {
		Long atendimentoMaisLongo = (long) 0;
		List<Triagem> triagens = triagemRepository.findByUnidadeDeAtendimento(id);
		for(Triagem triagem :triagens){
			if(atendimentoMaisLongo < triagem.getAtendimento().getDuracaoDoAtendimento()){
				atendimentoMaisLongo = triagem.getAtendimento().getDuracaoDoAtendimento();
			}
		}
		return atendimentoMaisLongo;
	}
	
	public Long atendimentoMaisRapido(int id) {
		Long atendimentoMaisRapido = (long) 20000;
		List<Triagem> triagens = triagemRepository.findByUnidadeDeAtendimento(id);
		for(Triagem triagem :triagens){
			if(atendimentoMaisRapido > triagem.getAtendimento().getDuracaoDoAtendimento()){
				atendimentoMaisRapido = triagem.getAtendimento().getDuracaoDoAtendimento();
			}
		}
		return atendimentoMaisRapido;
	}
	
	public Long tempoMedioDeAtendimento(int id) {
		Long tempoMedioDeAtendimento = (long)0;
		List<Triagem> triagens = triagemRepository.findByUnidadeDeAtendimento(id);
		for(Triagem triagem :triagens){
			tempoMedioDeAtendimento += triagem.getAtendimento().getDuracaoDoAtendimento();
		}
		return tempoMedioDeAtendimento/triagens.size();
	}
	
	public Long atendimentosDeCovid(int id){
		Long totalAtendimentosCovid = (long)0;
		List<Triagem> triagens = triagemRepository.findByUnidadeDeAtendimento(id);
		for(Triagem triagem :triagens){
			if(triagem.getAtendimento() instanceof AtendimentoEspecialPandemia){
				if(((AtendimentoEspecialPandemia) triagem.getAtendimento()).isExameDeBiologiaMolecular() || ((AtendimentoEspecialPandemia) triagem.getAtendimento()).isExameDeSorologia()){
					totalAtendimentosCovid ++;
				}
			}
		}
		return totalAtendimentosCovid;
	}
}