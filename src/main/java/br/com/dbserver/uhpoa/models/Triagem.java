package br.com.dbserver.uhpoa.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="TRIAGEM")
public class Triagem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private String sintomasRelatadosPeloCliente;
	
	private double pressao;
	
	private double temperatura;

	private boolean corisa;

	private boolean dorDeGarganta;

	private boolean dificuldadeRespiratoria;

	private boolean tosse;

	private boolean perdaDoPaladar;
	
	
	
	
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
	
		
	
	
	
}
