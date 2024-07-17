//package uqam.inf5153.gestionExamensMed.testModel;
//
//import java.util.ArrayList;
//import java.util.Hashtable;
//
//import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;
//import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;
//import uqam.inf5153.gestionExamensMed.interf.ILaboratoireController;
//
///**
// *
// */
//public class DefaultLaboratoireController implements ILaboratoireController {
//	private static NumRDVGenerator generator =new NumRDVGenerator() ;
//
//	private ArrayList<ILaboratoire> listLaboratoire ;
//	private Hashtable<String , ArrayList<IDemandeRDV>> demandeRDVTable ;
//
//
//
//	public DefaultLaboratoireController() {
//		listLaboratoire= new ArrayList<ILaboratoire> ();
//		demandeRDVTable = new Hashtable<String , ArrayList<IDemandeRDV>>() ;
//		defaultInitialisation() ;
//	}
//
//	@Override
//	public ArrayList<ILaboratoire> getListLaboratoire() {
//		return listLaboratoire;
//	}
//
//
//
//	@Override
//	public ArrayList<IDemandeRDV> listDemandeRDV(String codeLab) {
//		// TODO Auto-generated method stub
//		ArrayList<IDemandeRDV> res = null ;
//		ArrayList<IDemandeRDV> listDemandeRdvParLab = demandeRDVTable.get(codeLab) ;
//
//		res = listDemandeRdvParLab ;
////		if (listDemandeRdvParLab.size()!=0) {
////			res = listDemandeRdvParLab ;
////		}
//
//		return res ;
//	}
//
//
//
//
//	/**
//	 *
//	 */
//	private void defaultInitialisation() {
//		// création de laboratoire
//		DefaultLaboratoire lab ;
//		lab = new DefaultLaboratoire("X200", "Labo Viron") ;
//		listLaboratoire.add(lab) ;
//		lab = new DefaultLaboratoire("D201", "Analyse Lab") ;
//		listLaboratoire.add(lab) ;
//		lab = new DefaultLaboratoire("L202", "Imagerie Laval") ;
//		listLaboratoire.add(lab) ;
//
//
//		// Création de demandes de model.RDV
//		DefaultDemandeRDV demandeRDV ;
//
//		ArrayList<IDemandeRDV> listDenmande = new ArrayList<IDemandeRDV>() ;
//		// (int numDemandeRDV, String nomExamen,String nomPatient, String codePatient) {
//
//		demandeRDV = new DefaultDemandeRDV(generator.generate(), ConstanteExamen.ANALYSE_SANG,
//										   "Alice" , "ABC110") ;
//		listDenmande.add(demandeRDV);
//		demandeRDV = new DefaultDemandeRDV(generator.generate(), ConstanteExamen.Echographie,
//				                           "Alice", "ABC110") ;
//		listDenmande.add(demandeRDV);
//		demandeRDV = new DefaultDemandeRDV(generator.generate(), ConstanteExamen.Endoscopie ,
//				"Bob" , "ALL120") ;
//		listDenmande.add(demandeRDV);
//
//		demandeRDVTable.put("X200", listDenmande) ;
//
//		listDenmande = new ArrayList<IDemandeRDV>() ;
//
//		demandeRDV = new DefaultDemandeRDV(generator.generate(), ConstanteExamen.Myelogramme, "Bob" , "ALL120") ;
//		listDenmande.add(demandeRDV);
//		demandeRDV = new DefaultDemandeRDV(generator.generate(), ConstanteExamen.AnalyseUrine,
//				                           "Alice","ABC110") ;
//		listDenmande.add(demandeRDV);
//
//		demandeRDVTable.put("L202", listDenmande);
//
//
//	}
//
//	private static class NumRDVGenerator  {
//		int cpt = 99 ;
//
//		private NumRDVGenerator() {
//
//		}
//		public int generate() {
//			cpt++;
//			return cpt ;
//		}
//
//	}
//
//}
