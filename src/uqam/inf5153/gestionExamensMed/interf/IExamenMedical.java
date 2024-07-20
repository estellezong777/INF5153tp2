package uqam.inf5153.gestionExamensMed.interf;

import examen.Examen;

import java.util.ArrayList;

/**
 * 
 */
public interface IExamenMedical {

	public String getNomExamen(); 
	public boolean isExamenElementaire() ; 
	public ArrayList<IExamenMedical>  getComposantExamenList();
	public ArrayList<Examen> getListExamensElem();
	
}
