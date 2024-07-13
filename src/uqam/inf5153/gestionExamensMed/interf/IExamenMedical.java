package uqam.inf5153.gestionExamensMed.interf;

import java.util.ArrayList;

/**
 * 
 */
public interface IExamenMedical {
	public int getNumeroExamen(); 
	public String getNomExamen(); 
	public boolean isExamenElementaire() ; 
	public ArrayList<IExamenMedical>  getComposantExamenList(); 
	public ArrayList<String> getParametreExamenList() ; 
	public String paramsToString() ; 
	
}
