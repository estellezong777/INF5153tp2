package model;

import examen.Examen;
import examen.ExamenCompose;
import examen.ExamenElem;
import laboratoire.Laboratoire;
import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;

import java.util.*;

public class RDVController {

    private AppController appController;
    private HashMap<String, List<IDemandeRDV>> demandeRDVList;

    public RDVController() {
        this.demandeRDVList = new HashMap<>();
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }


    /**
     * Cette fonction prend un examen comme paramètre. Nous parcourons la laboList
     * et ajoutons le labo qui peut faire cet examen à labExamensCanDo. S'il y a plusieurs
     * laboratoires qui peuvent faire cet examen, utilisons la fonction randon
     * pour en sélectionner un au hasard.
     */
    public Laboratoire choisirLabo(Examen examenAFaire) {
        ArrayList<ILaboratoire> labList = appController.getListLabo();

        ArrayList<ILaboratoire> labExamensCanDo = new ArrayList<>();
        for (ILaboratoire lab : labList) {
            if (lab.getListExamensProvide().contains(examenAFaire)) {
                labExamensCanDo.add(lab);
            }
        }

        // Choisissons un laboratoire au hasard parmi labExamensCanDo
        Random rand = new Random();

        if (labExamensCanDo.isEmpty()) {
            return null;
        }

        ILaboratoire chosenLab = labExamensCanDo.get(rand.nextInt(labExamensCanDo.size()));
        return (Laboratoire) chosenLab;
    }

    // Créer un object de DemandeRDV
    public DemandeRDV creatDemandeRDV(String namePa, String codeP, ExamenElem examen) {
        String description = examen.getName() + examen.getType();
        return new DemandeRDV(namePa, codeP, description);

    }


    /**
     * Attribuons l'examen que le patient doit faire au laboratoire sélectionné en appelant la fonction choisirLabo
    */
    public HashMap<String, List<IDemandeRDV>> distribuerExamenAlabo(Hashtable<String, ArrayList<PrescriptionExamen>> hashtablePrescriptions) {

        /**
         * Nous parcourons la hashTable qui stocke la description. La clé est codepatient
         * et la valeur est descriptionExamen.
        */
        for (Map.Entry<String, ArrayList<PrescriptionExamen>> entry : hashtablePrescriptions.entrySet()) {
            String codepatient = entry.getKey();
            ArrayList<PrescriptionExamen> listprescriptions = entry.getValue();

            //Nous parcourons la prescriptionList pour obtenir chaque examen.
            for (PrescriptionExamen prescription : listprescriptions) {
                Examen examen = prescription.getExamen();

                /**
                 * Si l'examen est de type compose, nous obtenons la valeur de chaque examen élémentaire
                 * de l'examen compose, créons une demandeRDV, puis envoyons cette instance au laboratoire sélectionné.
                */
                if (examen instanceof ExamenCompose) {
                    for (Examen exam : ((ExamenCompose) examen).getListExamensElem()) {
                        String nameP = prescription.getPatient().getNomPatient();

                        Laboratoire labChoisit = choisirLabo(exam);

                        DemandeRDV demandeRDV = creatDemandeRDV(nameP, codepatient, (ExamenElem) exam);
                        addDemandRDVtoList(demandeRDV, labChoisit);
                    }
                    //s'il s'agit d'un examen élémentaire, envoyons-le directement.
                } else {
                    Laboratoire labChoisit = choisirLabo(examen);
                    String nameP = prescription.getPatient().getNomPatient();

                    DemandeRDV demandeRDV = creatDemandeRDV(nameP, codepatient, (ExamenElem) examen);
                    addDemandRDVtoList(demandeRDV, labChoisit);
                }
            }
        }
        return demandeRDVList;

    }


    //Ajoutons DemandRdv à la liste de demandes RDV du laboratoire correspondant
    public void addDemandRDVtoList(IDemandeRDV demandeRDV, Laboratoire lab) {
        String labCode = lab.getCodeLaboratoire();
        /**
         * Si ce laboratoire n'a pas encore de liste de demandeRDV, nous en créons d'abord
         *  une, puis stockons demandeRDV dans cette liste
         * */
        if (!demandeRDVList.containsKey(labCode)) {
            demandeRDVList.put(labCode, new ArrayList<IDemandeRDV>());
        }
        // Sinon, stockons simplement demandeRDV directement.
        demandeRDVList.get(labCode).add(demandeRDV);

    }

}