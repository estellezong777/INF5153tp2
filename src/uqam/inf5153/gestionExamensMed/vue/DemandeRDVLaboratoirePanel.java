package uqam.inf5153.gestionExamensMed.vue;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.AppController;
import model.InitApp;
import model.Logger.Logger;
import model.Logger.loggerConsole;
import model.Logger.loggerFile;
import model.notifieur.AbstractNotifieur;
import model.notifieur.NotifieurCourriel;
import model.notifieur.NotifieurSMS;
import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoireController;
import uqam.inf5153.gestionExamensMed.interf.IObserver;

import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

/**
 * Implémente le panneau qui contient la table des demandes de model.RDV
 *  
 */
public class DemandeRDVLaboratoirePanel extends JPanel {
	ArrayList<String> resultExamList = new ArrayList<>();
	static ArrayList<PredefinedRDV> predefinedRDVList = new  ArrayList<PredefinedRDV>() ;

    private AppController appController;

	static {
		initPredefList() ; 
	}

	private ILaboratoireController laboratoireController ;


	private static final long serialVersionUID = 1L;
	private JTable demandeRDVtable;
	private JPanel panel;
	private JButton attribuerRDVButton;
	private JButton faireExamenButton;
	private JScrollPane scrollPane;

	private NotificationPanel notificationPanel;

	ArrayList<IObserver> listObserver = new ArrayList<>();

	private Logger loggerConsole = new loggerConsole();



	/**
	 * Create the panel.
	 */
	public DemandeRDVLaboratoirePanel(AppController appController) {
		this.appController = appController;
		this.laboratoireController = appController.getLaboController() ;
		setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		demandeRDVtable = new JTable();

		scrollPane.setViewportView(demandeRDVtable);

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBorder(new TitledBorder(null, "Traitements pr\u00E9d\u00E9finis", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(panel, BorderLayout.NORTH);

		attribuerRDVButton = new JButton("Attribuer RDV");
		attribuerRDVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attributionRDVPredefini() ;

				// Le bouton "Attribuer RDV " ne peut être cliqué qu'une seule fois
				attribuerRDVButton.setEnabled(false);
			}
		});
		panel.add(attribuerRDVButton);

		faireExamenButton = new JButton("Faire Examen");
		faireExamenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				faireExamenPredefini() ; 
			}
		});
		panel.add(faireExamenButton);

	}

	public JTable getDemandeRDVtable() {
		return demandeRDVtable;
	}

	/**
	 * Construction du Model de la table des RDV
	 * @return
	 */
	public DefaultTableModel buildTableModel() {
		DefaultTableModel res = new DefaultTableModel(); 

		res.addColumn("Laboratoire");
		res.addColumn("Demande RDV");
		res.addColumn("Date RDV (JJ-MM-AAAA)");
		res.addColumn("Heure RDV ( HH:MI)");
		res.addColumn("Examen (Oui/Non)");

		// Nous transmettons les données laboList à la page interactive
		if (laboratoireController != null) {
			ArrayList<ILaboratoire> listLabs = laboratoireController.getListLaboratoire() ;
			int ind = 0 ; 
			for (ILaboratoire unLab : listLabs) {

				ArrayList<IDemandeRDV> listDemande = laboratoireController.listDemandeRDV(unLab.getCodeLaboratoire()) ; 

				if (listDemande != null) {
					for (IDemandeRDV uneDemande : listDemande) {
						Object[] row = new Object[5] ;

						DataRDV dataRDV = new DataRDV(uneDemande.getNumDemande() ,
								uneDemande.getCodePatient() , uneDemande.getNomPatient(), 
								uneDemande.getLabelExamen());

						row[0] = unLab.getNomLaboratoire() ; 
						row[1] = dataRDV  ; // Mettre un objet 
						row[2] = "" ; 
						row[3] = "" ;
						row[4] = "Non"  ; 
						res.insertRow(ind, row);
						ind++ ; 
					}
				}
			}	
		}
		return res ; 
	}

	/**
	 * Obtenons les informations dans la table de rendez-vous assignée et
	 * déclenchons des événements via AppController pour informer la personne correspondante par e-mail et message,
	 * c'est-à-dire transmettre des messages entre le laboratoire et les patients, les médecins et les services.
	 */
	public void doTransmettreRDV() {
		ArrayList<String> RDVaTransmettre = new ArrayList<String>() ;  
		DefaultTableModel tableRDV = (DefaultTableModel) demandeRDVtable.getModel() ;

		int nbRows = tableRDV.getRowCount();
		int nbCols = tableRDV.getColumnCount() ;

		for (int i=0 ; i < nbRows ; i++) {
			String labName = (String)tableRDV.getValueAt(i, 0) ; 
			DataRDV dataRDV = (DataRDV)tableRDV.getValueAt(i, 1) ;
			String dateRDV = (String)tableRDV.getValueAt(i, 2) ;
			String hRDV    = (String)tableRDV.getValueAt(i, 3) ; 

			System.out.print ("Demande RDV : " + labName + "\t" +
					"Desc. : " + dataRDV + "\t" + dateRDV ) ;

			if (dateRDV != null && dateRDV.length() != 0) {

				String unRDV = "codePatient = " + dataRDV.codePatient  + 
						" , numDemande = " + dataRDV.numDemande + 
						" , dateRDV = " + dateRDV + 
						" , heureRDV = " + hRDV ; 
				System.out.println ("#\t" + unRDV) ; 
				RDVaTransmettre.add(unRDV) ;

			} 

		}

		/**
		 * Recevons la réponse du labo à demandeaRDV via appController, et appController traite
		 * ces réponses et déclenche un événement pour avertir la personne qui doit être avertie.
		 * Et les informations qui doivent être notifiées seront affichées dans le panneau de notification.
		 */
		appController.recevoirReponseLaboRdv(RDVaTransmettre);

		NotificationPanel notificationPanel = this.notificationPanel;

		AbstractNotifieur emailObserver= new NotifieurCourriel(notificationPanel,loggerConsole);
		AbstractNotifieur smsObserver= new NotifieurSMS(notificationPanel, loggerConsole);

		listObserver.add(emailObserver);
		listObserver.add(smsObserver);
		appController.traiterResponseLaboRDV(listObserver);

	}

	/**
	 *Recevons les résultats de l'examen  et transmettons-les au médecin et au service.
	 * Les panneaux du médecin et du service dans la notification afficheront les résultats.
	 * */
	public void doTransmettreResult(){
		appController.getLaboController().recevoirReponseResultExamen(resultExamList);
		appController.recevoirResultExamen( );
		appController.traiterResultExamen(listObserver);
	}


	public void setNotificationPanel(NotificationPanel notificationPanel) {
		this.notificationPanel = notificationPanel;
	}

	/**
	 * Callback du bouton  Attribuer RDV
	 * 
	 * Attribut des RDV (aléatoire) aux 80% des demandes
	 * Attribuer des RDV
	 * 
	 */
	private void attributionRDVPredefini() {
		DefaultTableModel tableRDV = (DefaultTableModel)demandeRDVtable.getModel() ;

		if (tableRDV != null ) {
			int nbreDemandeRDV = tableRDV.getRowCount() ; 
			if (nbreDemandeRDV != 0) {
				for (int i=0 ; i < nbreDemandeRDV ; i++) {

					// 80% des demandes de model.RDV auront un model.RDV
					if (Math.random()>0.2) {
						PredefinedRDV rdv = rdvAleatoire() ; 

						tableRDV.setValueAt(rdv.date ,  i , 2 );
						tableRDV.setValueAt(rdv.heure , i , 3);
					}
				}
			}
		}

	}

	/**
	 *  Callback du bouton "Faire examen "
	 *  Après avoir cliqué sur le bouton « faire examen », les données de la quatrième colonne du
	 *  tableau RDV (C'est résultat d'examen) seront mises à jour. Nous obtenons les données mises à jour dans
	 *  cette colonne et envoyons les résultats au médecin et au service.
	 */
	private void faireExamenPredefini() {
		DefaultTableModel tableRDV = (DefaultTableModel)demandeRDVtable.getModel() ;
		String examReponse = null; // initier la réponse de laboratoire

		if (tableRDV != null ) {
			int nbreDemandeRDV = tableRDV.getRowCount() ; 
			for (int i=0 ; i < nbreDemandeRDV ; i++) {

				if (tableRDV.getValueAt(i, 2) != null &&  
						tableRDV.getValueAt(i, 2).toString().length()!=0)  {

					tableRDV.setValueAt("Oui" , i , 4 );
				}
				 examReponse =  "Exam Result:"+"\n"+"CodePatient est : "+ tableRDV.getValueAt(i,1).toString()+ ", Exam Result: " +tableRDV.getValueAt(i,4).toString();
				 resultExamList.add(examReponse);
			}

		}

	}

	/**
	 * Retourne un RDV prédéfini aléatoirement parmi
	 * la liste des RDV
	 * @return
	 */
	private static PredefinedRDV rdvAleatoire() {
		PredefinedRDV res ; 
		int nb = predefinedRDVList.size() ; 

		int ind = (int)(Math.random()*nb)  ; 
		res = predefinedRDVList.get(ind) ; 
		return res ; 
	}

	/**
	 * Méthode utilitaire pour créer des dates de RDV
	 * afin d'attribuer des RDV automatiquement
	 */
	private static void initPredefList() {
		PredefinedRDV prefRDV ; 
		prefRDV = new PredefinedRDV("15-09-2024" , "10:45" ) ; 
		predefinedRDVList.add(prefRDV) ;

		prefRDV = new PredefinedRDV("19-09-2024" , "09:30" ) ; 
		predefinedRDVList.add(prefRDV) ;

		prefRDV = new PredefinedRDV("04-09-2024" , "09:00" ) ; 
		predefinedRDVList.add(prefRDV) ;

		prefRDV = new PredefinedRDV("05-10-2024" , "12:15" ) ; 
		predefinedRDVList.add(prefRDV) ; 

		prefRDV = new PredefinedRDV("07-10-2024" , "14:35" ) ; 
		predefinedRDVList.add(prefRDV) ;

		prefRDV = new PredefinedRDV("15-11-2024" , "15:20" ) ; 
		predefinedRDVList.add(prefRDV) ;

		prefRDV = new PredefinedRDV("13-11-2024" , "11:30" ) ; 
		predefinedRDVList.add(prefRDV) ; 

		prefRDV = new PredefinedRDV("01-12-2024" , "13:45" ) ; 
		predefinedRDVList.add(prefRDV) ; 

	}


	/**
	 * Classe locale pour stocker les data d'un model.RDV
	 *  
	 */
	static class  DataRDV {
		private int numDemande ; 
		private String codePatient ; 
		private String nomPatien ;
		private String labelExamen ; 

		public DataRDV(int numDemande, String codePatient, String nomPatien , String labelExamen) {
			super();
			this.numDemande = numDemande;
			this.codePatient = codePatient;
			this.nomPatien = nomPatien;
			this.labelExamen = labelExamen ; 
		}
		@Override
		public String toString() {
			return  numDemande + " - " + labelExamen + " [" + codePatient + " - " + 
					nomPatien + 	"]" ;
		} 
	}
}
/**
 * Data class pour stocker des données d'un model.RDV
 * 
 */
class PredefinedRDV { 
	final String date ;
	final String heure ;

	public PredefinedRDV(String date, String heure) {
		this.date = date;
		this.heure = heure;
	} 


}
