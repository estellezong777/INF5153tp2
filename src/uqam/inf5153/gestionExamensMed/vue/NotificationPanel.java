package uqam.inf5153.gestionExamensMed.vue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 * Implémente le panneau qui contient les zones de texte pour les messages 
 * de notifications
 */
public class NotificationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea notifMedecinTextArea;
	private JTextArea notifPatientTextArea;
	private JTextArea notifServiceTextArea;

	/**
	 * Create the panel.
	 */
	public NotificationPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.33);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		notifServiceTextArea = new JTextArea();
		notifServiceTextArea.setEditable(false);
		notifServiceTextArea.setBorder(new TitledBorder(null, "Notification Service", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane_1.setLeftComponent(notifServiceTextArea);
		
		notifPatientTextArea = new JTextArea();
		notifPatientTextArea.setEditable(false);
		notifPatientTextArea.setBorder(new TitledBorder(null, "Notification Patient", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane_1.setRightComponent(notifPatientTextArea);
		
		notifMedecinTextArea = new JTextArea();
		notifMedecinTextArea.setEditable(false);
		notifMedecinTextArea.setBorder(new TitledBorder(null, "Notification Medecin", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		splitPane.setLeftComponent(notifMedecinTextArea);
	}
	
	/**
	 * Ajoute un message (à la fin) dans le panneau de notification pour le médecin
	 * 
	 * @param msg
	 */
	public void ajouteNotificationMsgMedecin(String msg) {
		notifMedecinTextArea.append(msg + "\n");
	}

	/**
	 * Ajoute un message (à la fin) dans le panneau de notification pour le patient
	 * 
	 * @param msg
	 */
	public void ajouteNotificationMsgPatient(String msg) {
		notifPatientTextArea.append(msg + "\n");
	}

	/**
	 * Ajoute un message (à la fin) dans le panneau de notification pour le service
	 * 
	 * @param msg
	 */
	public void ajouteNotificationMsgService(String msg) {
		notifServiceTextArea.append(msg + "\n");
	}

}
