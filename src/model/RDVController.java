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
private HashMap<String, List<IDemandeRDV>> demandeRDVList ;

    public RDVController( ) {

        this.demandeRDVList  = new HashMap<>();
    }

    public AppController getAppController() {
        return appController;
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }


    public Laboratoire choisirLabo(Examen examenAFaire){
        ArrayList<ILaboratoire> labList =appController.getListLabo();

        ArrayList<ILaboratoire> labExamensCanDo = new ArrayList<>();
        for (ILaboratoire lab:labList
             )
        {
            if (lab.getListExamensProvide().contains(examenAFaire)){
                 labExamensCanDo.add(lab);
        }
        }

         //choose a random lab from labExamensCanDo
        Random rand = new Random();

        if (labExamensCanDo.isEmpty()) {
            return null;
        }

        ILaboratoire chosenLab = labExamensCanDo.get(rand.nextInt(labExamensCanDo.size()));
        return (Laboratoire)chosenLab;
    }

    public  DemandeRDV creatDemandeRDV(String namePa,String codeP, ExamenElem examen){
        String description = examen.getName()+examen.getType();
        return new DemandeRDV(namePa,codeP,description);

    }

    //Hashtable<String>==CodePatient
    //distribuer chaque Examen A labo et faire la demande de RDV

    //Map<String<CodePatient>, Map< Labo,Examens>
    public HashMap<String,List<IDemandeRDV>> distribuerExamenAlabo(Hashtable<String,ArrayList<PrescriptionExamen>> hashtablePrescriptions){
        HashMap<String,Map> mapOfDistrubutionExaLa = new HashMap<>();
        for (Map.Entry<String,ArrayList<PrescriptionExamen>>entry : hashtablePrescriptions.entrySet()){
            Map<Laboratoire,ArrayList<Examen>> LaboExamens = new HashMap<>();
            String codepatient = entry.getKey();
            ArrayList<PrescriptionExamen> listprescriptions= entry.getValue();
            ArrayList<Examen> listExamenInHm = new ArrayList<>();
            for (PrescriptionExamen prescription:  listprescriptions) {
                Examen examen = prescription.getExamen();
                //maybe be replaced by visitor
                if (examen instanceof ExamenCompose) {
                    for (Examen exam: ((ExamenCompose) examen).getListExamensElem()) {
                        String nameP = prescription.getPatient().getNomPatient();
//                        listExamenInHm.add(exam);
                        Laboratoire labChoisit = choisirLabo(exam);
//                        LaboExamens.put(labChoisit,listExamenInHm);
                        DemandeRDV demandeRDV = creatDemandeRDV(nameP,codepatient, (ExamenElem) exam);
                        addDemandRDVtoList(demandeRDV,labChoisit);

                    }

                }else{Laboratoire labChoisit = choisirLabo(examen);
                    String nameP = prescription.getPatient().getNomPatient();
//                    listExamenInHm.add(examen);
//                    LaboExamens.put(labChoisit,listExamenInHm);
                    DemandeRDV demandeRDV = creatDemandeRDV(nameP,codepatient, (ExamenElem) examen);
                    addDemandRDVtoList(demandeRDV,labChoisit);

                }
    //-------add cerate

            }
        }

        return demandeRDVList;

    }

    public void addDemandRDVtoList(IDemandeRDV demandeRDV, Laboratoire lab){
        String labCode = lab.getCodeLaboratoire();
        if (!demandeRDVList .containsKey(labCode)) {
            // If not, create a new list for this labCode
            demandeRDVList.put(labCode, new ArrayList<IDemandeRDV>());
        }
        // Add the demandeRDV to the list for this labCode
        demandeRDVList.get(labCode).add(demandeRDV);

    }


}
