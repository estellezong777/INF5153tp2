package uqam.inf5153.gestionExamensMed.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import uqam.inf5153.gestionExamensMed.interf.IExaMedicalHandler;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoireController;
import uqam.inf5153.gestionExamensMed.testModel.DefaultExaMedHandler;
import uqam.inf5153.gestionExamensMed.testModel.DefaultLaboratoireController;

/**
 * 
 * Classe principale qui implémente l'interface graphique et fait la création 
 * d'un modèle de données fictif. 
 *    
 * Il y a une autre classe principale () dans laquel il faut créer les objets de 
 * votre modèle   
 * 
 */
public class GestionExaMedicalMainGUI {

	private JFrame frame;
	private LaboratoireMainPanel laboratoireMainPanel;
	private NotificationPanel notificationPanel;
	private ExaMedicalPrescritPanel exaMedPrescritPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionExaMedicalMainGUI window = new GestionExaMedicalMainGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionExaMedicalMainGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame
	 * 
	 * Fait la création des objets racines du domaine que l'UI utilise.
	 * 
	 * 
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1250, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		IExaMedicalHandler examHandler = null ; 
		
		
		exaMedPrescritPanel = new ExaMedicalPrescritPanel(examHandler);
		frame.getContentPane().add(exaMedPrescritPanel, BorderLayout.WEST);
		
		ILaboratoireController defaultLabController = null ; 
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.35);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		laboratoireMainPanel = new LaboratoireMainPanel(defaultLabController);
		splitPane.setLeftComponent(laboratoireMainPanel);
		
		notificationPanel = new NotificationPanel();
		splitPane.setRightComponent(notificationPanel);
		
		notificationPanel.ajouteNotificationMsgMedecin("Ici, affichage des notifications pour le médecin" );
		notificationPanel.ajouteNotificationMsgService("Ici, affichage des notifications pour le model.Service" );
		notificationPanel.ajouteNotificationMsgPatient("Ici, affichage des notifications pour le patient" );		
		
	}

}
