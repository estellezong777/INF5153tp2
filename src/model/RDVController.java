package model;

import examen.Examen;
import examen.ExamenCompose;
import examen.ExamenElem;
import laboratoire.Laboratoire;
import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;

import java.util.*;

public class RDVController extends AppController{
private HashMap<String, List<IDemandeRDV>> demandeRDVList = new HashMap<>();

    public Laboratoire choisirLabo(Examen examenAFaire){
        ArrayList<Laboratoire> labList = getListLabo();
        ArrayList<Laboratoire> labExamensCanDo = new ArrayList<>();
        for (Laboratoire lab:labList
             ) {if (lab.getListExamensProvide().contains(examenAFaire)){
                 labExamensCanDo.add(lab);
        }
        }
         //choose a random lab from labExamensCanDo
        Random rand = new Random();
        Laboratoire chosenLab = labExamensCanDo.get(rand.nextInt(labExamensCanDo.size()));
        return chosenLab;
    }

    public  DemandeRDV creatDemandeRDV(String namePa,String codeP, ExamenElem examen){
        String description = examen.getName()+examen.getType();
        return new DemandeRDV(namePa,codeP,description);

    }
    public Map<String,Map> distribuerExamenAlabo(Hashtable<String,ArrayList> hashtablePrescriptions){
        Map<String,Map> mapOfDistrubutionExaLa = new HashMap<>();
        for (Map.Entry<String,ArrayList>entry : hashtablePrescriptions.entrySet()){
            Map<Examen,Laboratoire> examenLabo = new HashMap<>();
            String codepatient = entry.getKey();
            ArrayList<PrescriptionExamen> listprescriptions= entry.getValue();
            for (PrescriptionExamen prescription:  listprescriptions) {
                Examen examen = prescription.getExamen();
                //maybe be replaced by visitor
                if (examen instanceof ExamenCompose) {
                    for (Examen exam: ((ExamenCompose) examen).getListExamensElem()) {
                        String nameP = prescription.getPatient().getNomPatient();
                        Laboratoire labChoisit = choisirLabo(examen);
                        //Potentiel BUGS
                        examenLabo.put(examen,labChoisit);
                        DemandeRDV demandeRDV = creatDemandeRDV(nameP,codepatient,(ExamenElem)exam);
                        addDemandRDVtoList(demandeRDV,labChoisit);
                    }

                }else{Laboratoire labChoisit = choisirLabo(examen);
                    String nameP = prescription.getPatient().getNomPatient();
                    examenLabo.put(examen,labChoisit);
                    DemandeRDV demandeRDV = creatDemandeRDV(nameP,codepatient, (ExamenElem) examen);
                    addDemandRDVtoList(demandeRDV,labChoisit);
                }


    //-------add cerate
                mapOfDistrubutionExaLa.put(codepatient,examenLabo);
            }
        }

        return mapOfDistrubutionExaLa;

    }

    public String addDemandRDVtoList(IDemandeRDV demandeRDV, Laboratoire lab){
        String labCode = lab.getCodeLaboratoire();
        if (!demandeRDVList .containsKey(labCode)) {
            // If not, create a new list for this labCode
            demandeRDVList.put(labCode, new ArrayList<IDemandeRDV>());
        }
        // Add the demandeRDV to the list for this labCode
        demandeRDVList.get(labCode).add(demandeRDV);
        return "envoyer a appcontroller";
    }


}
