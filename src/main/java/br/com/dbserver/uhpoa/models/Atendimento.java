package br.com.dbserver.uhpoa.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;
import org.joda.time.Interval;

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
	
	private DateTime dataDaSaida;
	
	

	public Long duracaoDoAtendimento(Triagem triagem){		
		 Interval interval = new Interval(triagem.getDataDaEntrada(), this.getDataDaSaida());
		 return interval.toDurationMillis();
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


	public DateTime getDataDaSaida() {
		return dataDaSaida;
	}


	public void setDataDaSaida(DateTime dataDaSaida) {
		this.dataDaSaida = dataDaSaida;
	}

	

	
	
}
