package uqam.inf5153.gestionExamensMed.interf;

import examen.Examen;

import java.util.ArrayList;

/**
 * 
 */
public interface IExaMedicalHandler {
	
	public ArrayList<IPatient> examPatientList() ;
	public ArrayList<Examen> examenPrescritList(String codePatient);
}
