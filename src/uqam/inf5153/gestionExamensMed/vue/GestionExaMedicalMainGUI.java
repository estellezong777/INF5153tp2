package uqam.inf5153.gestionExamensMed.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

import model.AppController;
import model.InitApp;

import uqam.inf5153.gestionExamensMed.interf.IExaMedicalHandler;



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

					InitApp initApp = new InitApp();
					initApp.ModelInitialisation();
					AppController appController = initApp.appController;

					GestionExaMedicalMainGUI window = new GestionExaMedicalMainGUI(appController);
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
	public GestionExaMedicalMainGUI(AppController appController) {
		initialize(appController);

	}

	/**
	 * Initialize the contents of the frame
	 * 
	 * Fait la création des objets racines du domaine que l'UI utilise.
	 * 
	 * 
	 */
	private void initialize(AppController appController) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1250, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		IExaMedicalHandler examHandler = null ; 
		
		
		exaMedPrescritPanel = new ExaMedicalPrescritPanel(examHandler);
		frame.getContentPane().add(exaMedPrescritPanel, BorderLayout.WEST);


		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.35);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);


		/**
		 * Ici，nous associons exaMedPrescritPanel et demandeRDVPanel pour que lorsque le bouton DemandeRDV
		 * est cliqué dans exaMedicalPrescritPanel, la méthode dans DemandeRdv soit appelée pour afficher
		 * les informations correspondantes dans le tableau
		 * */
		laboratoireMainPanel = new LaboratoireMainPanel(appController);

		exaMedPrescritPanel.setDemandeRDVLaboratoirePanel(laboratoireMainPanel.getDemandeRDVLaboratoirePanel());
		splitPane.setLeftComponent(laboratoireMainPanel);

		 notificationPanel = new NotificationPanel();
		setNotificationPanel(notificationPanel);
		laboratoireMainPanel.getDemandeRDVLaboratoirePanel().setNotificationPanel(notificationPanel);

		splitPane.setRightComponent(notificationPanel);

	}



	public void setNotificationPanel(NotificationPanel notificationPanel) {
		this.notificationPanel = notificationPanel;
	}
}
