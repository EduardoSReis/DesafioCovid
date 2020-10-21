package br.com.dbserver.uhpoa.models;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Atendimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JsonBackReference
	private Triagem triagem;	
	
	private String descricaoDoTratamento;
	
	private LocalDateTime dataDeSaida;
	
	private Long duracaoDoAtendimento;
	
	
	
	public void setDuracaoDoAtendimento(Long duracaoDoAtendimento) {
		this.duracaoDoAtendimento = duracaoDoAtendimento;
	}


	public Long getDuracaoDoAtendimento() {
		return duracaoDoAtendimento;
	}	
	

	public void setDataDeSaida(LocalDateTime dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}
	
	public LocalDateTime getDataDeSaida() {
		return dataDeSaida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Triagem getTriagem() {
		return triagem;
	}

	public void setTriagem(Triagem triagem) {
		this.triagem = triagem;
	}
	
	public String getDescricaoDoTratamento() {
		return descricaoDoTratamento;
	}

	public void setDescricaoDoTratamento(String descricaoDoTratamento) {
		this.descricaoDoTratamento = descricaoDoTratamento;
	}	
}
