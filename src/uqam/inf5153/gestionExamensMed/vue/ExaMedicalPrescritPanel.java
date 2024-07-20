package uqam.inf5153.gestionExamensMed.vue;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import uqam.inf5153.gestionExamensMed.interf.IExaMedicalHandler;
import uqam.inf5153.gestionExamensMed.interf.IExamenMedical;
import uqam.inf5153.gestionExamensMed.interf.IPatient;
import javax.swing.JScrollPane;
import javax.swing.tree.TreeModel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Implémente la panneau qui affiche la liste des examens prescrits pour chaque model.Patient
 * 
 * 
 */
@SuppressWarnings("serial")
public class ExaMedicalPrescritPanel extends JPanel {
	
	private IExaMedicalHandler examenHandler ; 
	private JButton demandeRDVButton;

	private DemandeRDVLaboratoirePanel demandeRDVLaboratoirePanel;



	/**
	 * Create the panel.
	 */
	public ExaMedicalPrescritPanel( IExaMedicalHandler examenHandler ) {
		this.examenHandler  = examenHandler ;

		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		JTree tree = new JTree(construireModel());
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}

		scrollPane.setViewportView(tree);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel, BorderLayout.SOUTH);

		demandeRDVButton = new JButton("Demandez les RDV");
		demandeRDVButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generationDemandesRDV() ; 
			}
		});
		panel.add(demandeRDVButton);
	}

	/**
	 * Construit le modèle de données de l'arbre (JTree) : les noeuds 
	 * 
	 * @return
	 */
	private DefaultTreeModel construireModel() {


		DefaultMutableTreeNode root = new DefaultMutableTreeNode(new ExamenNode(null)) ;
		DefaultTreeModel model = new DefaultTreeModel(root) ;

		// parcours des patients
		if (examenHandler != null) {
			ArrayList<IPatient> patientList = examenHandler.examPatientList() ; 
			for (IPatient unPatient : patientList) {
				System.out.println ("Un Patient : " + unPatient.getCodePatient() +
						"Nom : " + unPatient.getNomPatient()) ; 

				DefaultMutableTreeNode patientNode = new DefaultMutableTreeNode(new ExamenNode(unPatient)) ;

				root.add(patientNode);	

				ArrayList<IExamenMedical> examenList = examenHandler.examenPrescritList(unPatient.getCodePatient()) ;
				for (IExamenMedical unExamen : examenList) {
					System.out.println ("Un Examen : " + unExamen.getNomExamen()) ; 								
					DefaultMutableTreeNode examenNode = new DefaultMutableTreeNode(new ExamenNode(unExamen)) ;				
					patientNode.add(examenNode);

					if (!unExamen.isExamenElementaire()) {
						populateNode(examenNode , unExamen) ; 
					}				
				}		
			}
		}

		return model ; 
	}

	public void setDemandeRDVLaboratoirePanel(DemandeRDVLaboratoirePanel demandeRDVLaboratoirePanel) {
		this.demandeRDVLaboratoirePanel = demandeRDVLaboratoirePanel;
	}

	/**
	 * 
	 * @param examenNode
	 * @param examenMedical
	 */
	private static void populateNode(DefaultMutableTreeNode examenNode ,IExamenMedical examenMedical) {
		ArrayList<IExamenMedical> examList = examenMedical.getComposantExamenList() ;

		for (IExamenMedical unExamen : examList) {		
			DefaultMutableTreeNode examenChildNode = new DefaultMutableTreeNode(new ExamenNode(unExamen)) ;
			examenNode.add(examenChildNode); 

			if (!unExamen.isExamenElementaire()) {
				populateNode(examenChildNode , unExamen ) ; 
			}
		}
	}	

	/**
	 * Callback du bouton Demande de RDV
	 * Doit lancer la méthode de votre modèle qui génére les demandes de model.RDV
	 * 
	 */
	private void generationDemandesRDV() {
		demandeRDVLaboratoirePanel.getDemandeRDVtable().setModel(demandeRDVLaboratoirePanel.buildTableModel()) ;
	}
	
}
// ============================================================================
/**
 * Contient les données d'un noeud du JTree
 */
class ExamenNode {
	private Object dataNode ;


	public ExamenNode(Object data ) {
		this.dataNode = data;
	}

	@Override
	public String toString() {

		String res = null ;  

		if (dataNode != null) {
			if (dataNode instanceof IExamenMedical) {				
				res = ((IExamenMedical)dataNode).getNomExamen() ;

				res += " " + ((IExamenMedical)dataNode).paramsToString();

			} else if (dataNode instanceof IPatient) {
				res = ((IPatient)dataNode).getNomPatient() ; 
			}

		} else {
			res = "Centre_Soin" ;
		}
		return res ; 
	} 
}


