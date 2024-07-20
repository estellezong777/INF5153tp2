package uqam.inf5153.gestionExamensMed.vue;

import javax.swing.JPanel;
import java.awt.BorderLayout;

import model.AppController;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * Panneau principale de l'interface graphique. 
 * Il contient tous les autres panneaux 
 */
public class LaboratoireMainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton transRDVButton;
	private JButton transExamenButton;
	private DemandeRDVLaboratoirePanel demandeRDVLaboratoirePanel;

	/**
	 * Create the panel.
	 */
	public LaboratoireMainPanel(AppController appController) {
		setLayout(new BorderLayout(0, 0));
		
		demandeRDVLaboratoirePanel = new DemandeRDVLaboratoirePanel(appController);


		add(demandeRDVLaboratoirePanel, BorderLayout.CENTER);

		
		JPanel controlLabPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) controlLabPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(controlLabPanel, BorderLayout.SOUTH);
		
		transRDVButton = new JButton("Transmettre RDV");
		transRDVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doTransmettreRDV() ;
			}
		});
		controlLabPanel.add(transRDVButton);
		
		transExamenButton = new JButton("Transmettre Examen");

		/**
		 * appelons la méthode doTransmettreResult
		 * */
		transExamenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doTransmettreResult();
			}
		});
		controlLabPanel.add(transExamenButton);
	}
	
	/**
	 * Envoyer les informations RDV au panneau de notification
	 */
	private void doTransmettreRDV() {
		demandeRDVLaboratoirePanel.doTransmettreRDV() ;
	}
	/**
	 * Envoyer les résultats d'examen au panneau de notification
	 */
	private void doTransmettreResult(){demandeRDVLaboratoirePanel.doTransmettreResult() ;
	}

	public DemandeRDVLaboratoirePanel getDemandeRDVLaboratoirePanel() {
		return demandeRDVLaboratoirePanel;
	}
}
