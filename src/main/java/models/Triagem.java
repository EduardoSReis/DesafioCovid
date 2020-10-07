package models;


public class Triagem {
	
	int id;
	String sintomasRelatadosPeloCliente;
	double pressao;
	double temperatura;
	boolean corisa;
	boolean dorDeGarganta;
	boolean dificuldadeRespiratoria;
	boolean tosse;
	boolean perdaDoPaladar;
	
	
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
