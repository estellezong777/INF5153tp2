package uqam.inf5153.gestionExamensMed.testModel;

import uqam.inf5153.gestionExamensMed.interf.IPatient;

public class DefaultPatient  implements IPatient {
	private String codePatient ;
	private String nomPatient ;
	
	
	public DefaultPatient(String codePatient, String nomPatient) {
		super();
		this.codePatient = codePatient;
		this.nomPatient = nomPatient;
	}

	@Override
	public String getCodePatient() {
		
		return codePatient;
	}

	@Override
	public String getNomPatient() {
		return nomPatient;
	}

	@Override
	public String toString() {
		
		return "[" + codePatient + "] " + nomPatient ;
	}
	
	
}
