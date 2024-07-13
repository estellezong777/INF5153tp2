package uqam.inf5153.gestionExamensMed.interf;

/**
 * 
 */
public interface IDemandeRDV {
	
 	
	public String getCodePatient() ; 
	public int getNumDemande() ; 
	public String getNomPatient() ; 
	
	
	/**
	 * Cette méthode construit une chaine de caractères composée
	 * des données de la demande RDV
	 * @return
	 */
	public String getLabelExamen() ; 
}
