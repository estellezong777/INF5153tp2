package uqam.inf5153.gestionExamensMed.testModel;

import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;


public class DefaultDemandeRDV implements IDemandeRDV{

	private int numDemandeRDV ; 
	private String nomPatient ; 
	private String codePatient ; 
	private String labelExamen ; 
	
	public DefaultDemandeRDV(int numDemandeRDV, String labelExamen,
			                 String nomPatient, String codePatient ) {
		this.numDemandeRDV = numDemandeRDV;
		this.nomPatient = nomPatient;
		this.codePatient = codePatient ; 
		this.labelExamen = labelExamen ; 
	}

	@Override
	public String getCodePatient() {
		return codePatient;
	}

	@Override
	public int getNumDemande() {
		return numDemandeRDV;
	}

	@Override
	public String getLabelExamen() {
		return labelExamen;
	}

	@Override
	public String getNomPatient() {
		return nomPatient;
	}

}
