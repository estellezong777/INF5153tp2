package uqam.inf5153.gestionExamensMed.interf;

import java.util.ArrayList;

/**
 * Définie l'interface du controlleur des Laboratoires 
 * 
 */
public interface ILaboratoireController {
	public ArrayList<ILaboratoire> getListLaboratoire() ;  
	public ArrayList<IDemandeRDV> listDemandeRDV(String codeLab) ;  
}
