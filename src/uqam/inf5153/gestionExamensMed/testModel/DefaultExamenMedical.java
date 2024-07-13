package uqam.inf5153.gestionExamensMed.testModel;

import java.util.ArrayList;

import uqam.inf5153.gestionExamensMed.interf.IExamenMedical;

public class DefaultExamenMedical implements IExamenMedical {

	private int    numExamen ; 
	private String nomExamen ; 
	private ArrayList<IExamenMedical>  composantExamen ;
	private ArrayList<String> parametreExamenList ; 


	public DefaultExamenMedical(int numExamen , String nomExamen) {
		this.numExamen = numExamen ; 
		this.nomExamen = nomExamen;
		composantExamen = new ArrayList<IExamenMedical>() ; 
		parametreExamenList = new ArrayList<String>() ; 
	} 

	@Override
	public ArrayList<IExamenMedical> getComposantExamenList() {
		return composantExamen ; 
	}

	/**
	 * 
	 * @return
	 */
	public String getNomExamen() {
		return nomExamen ; 
	}
	
	@Override
	public int getNumeroExamen() {
		return numExamen ;
	}

	/**
	 * 
	 * @param exaMed
	 */
	public void addExamenChild(IExamenMedical exaMed) {
		composantExamen.add(exaMed); 
	}

	public void addExamenParametre(String parametre) {
		parametreExamenList.add(parametre) ; 
	}

	@Override
	public boolean isExamenElementaire() {
		return composantExamen.size()==0 ? true : false ; 
	}

	@Override
	public ArrayList<String> getParametreExamenList() {
		return parametreExamenList;
	}

	@Override
	public String paramsToString() {
		String res = "" ; 
		//		if (parametreExamenList.size()==0) {
		//			res = "" ; 
		//		} else {
		//			res = "" ; 
		//			for (String unParam : parametreExamenList) {
		//				if (res.length()==0) {
		//					res = "["+unParam ; 
		//				} else {
		//					res += ", " + unParam ; 
		//				}
		//			}
		//			if (res.length() !=0) {
		//				res += "]" ; 
		//			}
		//		}



		res = "" ; 
		for (String unParam : parametreExamenList) {
			if (res.length()==0) {
				res = "["+unParam ; 
			} else {
				res += ", " + unParam ; 
			}
		}
		if (res.length() !=0) {
			res += "]" ; 
		}		
		return res ;
	}


}
