package models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Triagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String sintomasRelatadosPeloCliente;
	private double pressao;
	private double temperatura;
	private boolean corisa;
	private boolean dorDeGarganta;
	private boolean dificuldadeRespiratoria;
	private boolean tosse;
	private boolean perdaDoPaladar;
	
	
	public Triagem(int id, String sintomasRelatadosPeloCliente, double pressao, double temperatura, boolean corisa,
			boolean dorDeGarganta, boolean dificuldadeRespiratoria, boolean tosse, boolean perdaDoPaladar) {
		super();
		this.id = id;
		this.sintomasRelatadosPeloCliente = sintomasRelatadosPeloCliente;
		this.pressao = pressao;
		this.temperatura = temperatura;
		this.corisa = corisa;
		this.dorDeGarganta = dorDeGarganta;
		this.dificuldadeRespiratoria = dificuldadeRespiratoria;
		this.tosse = tosse;
		this.perdaDoPaladar = perdaDoPaladar;
	}
	
	
	
	
}
