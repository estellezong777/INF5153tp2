package uqam.inf5153.gestionExamensMed.interf;

import java.util.ArrayList;

/**
 * 
 */
public interface IExaMedicalHandler {
	
	public ArrayList<IPatient> examPatientList() ; 
	public ArrayList<IExamenMedical> examenPrescritList(String codePatient); 
}
