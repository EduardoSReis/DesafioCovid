package br.com.dbserver.uhpoa.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
public class Triagem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	@JsonManagedReference
	private Atendimento atendimento;
	
	@NotNull
	@Valid
	@NotBlank(message = "Por favor, descreva os sintomas relatadas pelo paciente")
	private String sintomasRelatadosPeloCliente;
	
	@DecimalMax("30.0") @DecimalMin("1.0") 
	private double pressao;
	
	@DecimalMax("45.0") @DecimalMin("20.0") 
	private double temperatura;
	
	@NotNull	
	private boolean corisa;
	
	@NotNull	
	private boolean dorDeGarganta;
	
	@NotNull	
	private boolean dificuldadeRespiratoria;

	@NotNull	
	private boolean tosse;
	
	@NotNull	
	private boolean perdaDoPaladar;
	
	@NotNull	
	private LocalDateTime dataDeEntrada = LocalDateTime.now();
	
	@NotNull	
	private UnidadeDeAtendimentoMedico unidadeDeAtendimentoMedico;
	

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

	public LocalDateTime getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(LocalDateTime dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public UnidadeDeAtendimentoMedico getUnidadeDeAtendimentoMedico() {
		return unidadeDeAtendimentoMedico;
	}

	public void setUnidadeDeAtendimentoMedico(UnidadeDeAtendimentoMedico unidadeDeAtendimentoMedico) {
		this.unidadeDeAtendimentoMedico = unidadeDeAtendimentoMedico;
	}
	
	
	
}
