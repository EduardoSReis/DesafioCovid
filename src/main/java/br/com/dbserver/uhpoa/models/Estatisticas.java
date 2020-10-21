package br.com.dbserver.uhpoa.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estatisticas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private UnidadeDeAtendimentoMedico unidadeDeAtendimento;
	private Long tempoMaximoDeAtendimento;
	private Long tempoMinimoDeAtendimento;
	private Long tempoMedioDeAtendimento;
	private Long atendimentosDeCovid;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public UnidadeDeAtendimentoMedico getUnidadeDeAtendimento() {
		return unidadeDeAtendimento;
	}
	public void setUnidadeDeAtendimento(UnidadeDeAtendimentoMedico unidadeDeAtendimento) {
		this.unidadeDeAtendimento = unidadeDeAtendimento;
	}
	public Long getTempoMaximoDeAtendimento() {
		return tempoMaximoDeAtendimento;
	}
	public void setTempoMaximoDeAtendimento(Long tempoMaximoDeAtendimento) {
		this.tempoMaximoDeAtendimento = tempoMaximoDeAtendimento;
	}
	public Long getTempoMinimoDeAtendimento() {
		return tempoMinimoDeAtendimento;
	}
	public void setTempoMinimoDeAtendimento(Long tempoMinimoDeAtendimento) {
		this.tempoMinimoDeAtendimento = tempoMinimoDeAtendimento;
	}
	public Long getTempoMedioDeAtendimento() {
		return tempoMedioDeAtendimento;
	}
	public void setTempoMedioDeAtendimento(Long tempoMedioDeAtendimento) {
		this.tempoMedioDeAtendimento = tempoMedioDeAtendimento;
	}
	public Long getAtendimentosDeCovid() {
		return atendimentosDeCovid;
	}
	public void setAtendimentosDeCovid(Long atendimentosDeCovid) {
		this.atendimentosDeCovid = atendimentosDeCovid;
	}
	
	
	
}
