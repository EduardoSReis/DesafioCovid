package br.com.dbserver.uhpoa.models;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AtendimentoEspecialPandemia extends Atendimento {
		
	@Column
	private boolean exameDeSorologia;
	
	@Column
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
