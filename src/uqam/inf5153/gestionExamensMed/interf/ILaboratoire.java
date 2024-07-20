package uqam.inf5153.gestionExamensMed.interf;

import examen.Examen;

import java.util.ArrayList;

public interface ILaboratoire {
	public String getCodeLaboratoire() ; 
	public String getNomLaboratoire() ;

	public ArrayList<Examen> getListExamensProvide();

	public void setListDemandeRDV(ArrayList<IDemandeRDV> listDemandeRDV);
	public ArrayList<IDemandeRDV> getListDemandeRDV();
}
