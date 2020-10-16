package br.com.dbserver.uhpoa.models;

public class AtendimentoEspecialPandemia extends Atendimento {
		

	private boolean exameDeSorologia;
	private boolean exameDeBiologiaMolecular;
	
			

	public boolean isExameDeSorologia() {
		return exameDeSorologia;
	}

	public void setExameDeSorologia(boolean exameDeSorologia) {
		this.exameDeSorologia = exameDeSorologia;
	}

	public boolean isExameDeBiologiaMolecular() {
		return exameDeBiologiaMolecular;
	}

	public void setExameDeBiologiaMolecular(boolean exameDeBiologiaMolecular) {
		this.exameDeBiologiaMolecular = exameDeBiologiaMolecular;
	}
	
	
	

}
