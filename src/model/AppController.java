package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import examen.Examen;
import laboratoire.*;
import model.notifieur.AbstractNotifieur;
import model.notifieur.NotifieurCourriel;
import model.notifieur.NotifieurSMS;
import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;
import uqam.inf5153.gestionExamensMed.interf.IEvenement;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;
import uqam.inf5153.gestionExamensMed.interf.IObserver;

public class AppController {
    //
    private ArrayList<Examen> listExamensElementaires;
    private ArrayList<Examen> listExamensCompose;

    private Hashtable< String ,ArrayList<PrescriptionExamen>> htablePrescriptions;
    private ArrayList<Medecin> listMedecin;
    private ArrayList<Patient> listPatient;
    private ArrayList<ILaboratoire> listLabo;

    private RDVController rdvController;

    private LaboController laboController;
//    private CentreDeSoinController centreDeSoinController;
//    private RdvController rdvController;

    //listReponseLabo = rdv reponse
    private ArrayList<String> listReponseLabo;

    private ArrayList<String> examenResultList ;

    public AppController() {
        this.listExamensElementaires = new ArrayList<>();
        this.listExamensCompose = new ArrayList<>();
        this.htablePrescriptions = new Hashtable<>();
        this.listMedecin = new ArrayList<>();
        this.listPatient = new ArrayList<>();

        this.listLabo = new ArrayList<>();
        this.listReponseLabo = new ArrayList<>();
        this.examenResultList = new ArrayList<>();

        //this.laboController = new LaboController();

//        this.centreDeSoinController = new CentreDeSoinController();
       // this.rdvController = new RDVController();
    }

    public void enreExamensPatient(PrescriptionExamen prescriptionExamen) {
        listExamensElementaires.add(prescriptionExamen.getExamen());
    }

    public void enrePatients(Patient patient) {
        listPatient.add(patient);
    }

    public void enreMedecin(Medecin medecin) {
        listMedecin.add(medecin);
    }

    public void enreLabo(ILaboratoire labo) {
        listLabo.add(labo);
    }

    // Getters and setters for the lists and controllers if necessary

    public ArrayList<ILaboratoire> getListLabo() {
        return listLabo;
    }

    public void enrePresTable(PrescriptionExamen prescriptionExamen, String codePatient){

        // Check if the patient code exists in the hashtable
        ArrayList<PrescriptionExamen> prescriptions = htablePrescriptions.get(codePatient);

        if (prescriptions == null) {

            prescriptions = new ArrayList<>();

            prescriptions.add(prescriptionExamen);

            htablePrescriptions.put(codePatient, prescriptions);
        } else {
            prescriptions.add(prescriptionExamen);
        }

    }

    public void setLaboController(LaboController laboController) {
        this.laboController = laboController;
    }

    public LaboController getLaboController() {
        return laboController;
    }

    //TODO Envoir listLAb to Labocontroller
    public void envoyerListLab(){
        laboController.setListLabo(listLabo);
    }

//    public RDVController getRdvController() {
//        return rdvController;
//    }

    public Hashtable<String, ArrayList<PrescriptionExamen>> gethtablePrescriptions() {
        return htablePrescriptions;
    }


    public String envoyerDemandeRDV(HashMap<String,ArrayList<IDemandeRDV>> mapDemandeRDV){
//        for (Map.Entry<String,ArrayList<IDemandeRDV>> entry : mapDemandeRDV.entrySet()){
//           // Map<Examen,Laboratoire> examenLabo = new HashMap<>();
//            String codeLab = entry.getKey();
//            ArrayList<IDemandeRDV> listDemandrdv= entry.getValue();
//
//            laboController.recevoirToutDemandeRDV();
//        }
        laboController.recevoirToutDemandeRDV(mapDemandeRDV);
        return "App Controller envoyer MapDemandeRDV to LaboController ";

    }

    public RDVController getRdvController() {
        return rdvController;
    }

    public void envoyerListLabo(){
        laboController.setListLabo(listLabo);
    }


    public void recevoirReponseLaboRdv(ArrayList<String> reponseRDV){
        this.listReponseLabo = reponseRDV;

    }



    //TODO 换一换
    public void traiterResponseLaboRDV(ArrayList<IObserver> listObservers){
        //String codePatient = parts[0].split("=")[1];

        String codePatient = null;
        String numDemande = null;
        String dateRDV=null;
        String heureRDV=null;
        for (String eachReponse:listReponseLabo) {
            String[] parts = eachReponse.split(",");
            for (String part : parts) {
                    String[] keyValue = part.split("=");
                    String key = keyValue[0].trim();
                    String value = keyValue[1].trim();

                    switch (key) {
                        case "codePatient":
                            codePatient = value;
                            break;
                        case "numDemande":
                            numDemande = value;
                            break;
                        case "dateRDV":
                            dateRDV = value;
                            break;
                        case "heureRDV":
                            heureRDV = value;
                            break;
                    }
                }

            RDV rdv = new RDV(codePatient,numDemande,dateRDV,heureRDV);
            IEvenement evenement = new Evenement(eachReponse,listObservers);
            evenement.notifierObserver();




            }

        }

    public void recevoirResultExamen( ){
        this.examenResultList = laboController.getResultExamenlist();
        System.out.println("examenResultList: "+ examenResultList);
    }


    public void traiterResultExamen(ArrayList<IObserver> listObservers){

        for (String eachResult:examenResultList) {

            IEvenement evenement = new Evenement(eachResult,listObservers);
            System.out.println("eachResult:"+eachResult);
            evenement.notifierObserver();
        }
    }




    }


