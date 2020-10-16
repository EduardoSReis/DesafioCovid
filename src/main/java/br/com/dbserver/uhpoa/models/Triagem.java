package br.com.dbserver.uhpoa.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Triagem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JsonManagedReference
	private Atendimento atendimento;

	private String sintomasRelatadosPeloCliente;

	private double pressao;

	private double temperatura;

	private boolean corisa;

	private boolean dorDeGarganta;

	private boolean dificuldadeRespiratoria;

	private boolean tosse;

	private boolean perdaDoPaladar;
	
	private DateTime dataDaEntrada;
	
	public Triagem() {
		super();
		
	}
	

	public Atendimento registraAtendimento(Triagem triagem) {

		int counter = 0;
		if (triagem.isCorisa()) {
			counter++;
		}
		if (triagem.isDificuldadeRespiratoria()) {
			counter++;
		}
		if (triagem.isDorDeGarganta()) {
			counter++;
		}
		if (triagem.isPerdaDoPaladar()) {
			counter++;
		}
		if (triagem.isTosse()) {
			counter++;
		}

		if (counter > 3) {
			AtendimentoEspecialPandemia atendimentoEspecial = new AtendimentoEspecialPandemia();		
			triagem.setAtendimento(atendimentoEspecial);
			atendimentoEspecial.setTriagem(triagem);
			return atendimentoEspecial;

		} else {
			Atendimento atendimento = new Atendimento();
			triagem.setAtendimento(atendimento);
			atendimento.setTriagem(triagem);
			return atendimento;
		}
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSintomasRelatadosPeloCliente() {
		return sintomasRelatadosPeloCliente;
	}

	public void setSintomasRelatadosPeloCliente(String sintomasRelatadosPeloCliente) {
		this.sintomasRelatadosPeloCliente = sintomasRelatadosPeloCliente;
	}

	public double getPressao() {
		return pressao;
	}

	public void setPressao(double pressao) {
		this.pressao = pressao;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public boolean isCorisa() {
		return corisa;
	}

	public void setCorisa(boolean corisa) {
		this.corisa = corisa;
	}

	public boolean isDorDeGarganta() {
		return dorDeGarganta;
	}

	public void setDorDeGarganta(boolean dorDeGarganta) {
		this.dorDeGarganta = dorDeGarganta;
	}

	public boolean isDificuldadeRespiratoria() {
		return dificuldadeRespiratoria;
	}

	public void setDificuldadeRespiratoria(boolean dificuldadeRespiratoria) {
		this.dificuldadeRespiratoria = dificuldadeRespiratoria;
	}

	public boolean isTosse() {
		return tosse;
	}

	public void setTosse(boolean tosse) {
		this.tosse = tosse;
	}

	public boolean isPerdaDoPaladar() {
		return perdaDoPaladar;
	}

	public void setPerdaDoPaladar(boolean perdaDoPaladar) {
		this.perdaDoPaladar = perdaDoPaladar;
	}


	public DateTime getDataDaEntrada() {
		return dataDaEntrada;
	}


	public void setDataDaEntrada(DateTime dataDaEntrada) {
		this.dataDaEntrada = dataDaEntrada;
	}


	
	
	
}
