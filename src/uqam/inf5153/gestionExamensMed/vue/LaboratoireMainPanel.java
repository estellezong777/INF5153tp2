package uqam.inf5153.gestionExamensMed.vue;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoireController;
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
	public LaboratoireMainPanel(ILaboratoireController laboratoireController) {
		setLayout(new BorderLayout(0, 0));
		
		demandeRDVLaboratoirePanel = new DemandeRDVLaboratoirePanel(laboratoireController);
		add(demandeRDVLaboratoirePanel, BorderLayout.CENTER);
		
		JPanel controlLabPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) controlLabPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(controlLabPanel, BorderLayout.SOUTH);
		
		transRDVButton = new JButton("Transmettre model.RDV");
		transRDVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doTransmettreRDV() ; 
			}
		});
		controlLabPanel.add(transRDVButton);
		
		transExamenButton = new JButton("Transmettre Examen");
		transExamenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Do Something
			}
		});
		controlLabPanel.add(transExamenButton);
	}
	
	/**
	 * 
	 */
	private void doTransmettreRDV() {
		demandeRDVLaboratoirePanel.doTransmettreRDV() ;
	}
	

}
