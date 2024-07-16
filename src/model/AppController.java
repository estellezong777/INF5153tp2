package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import examen.Examen;
import laboratoire.*;
import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;

public class AppController {
    private ArrayList<Examen> listExamensElementaires;
    private ArrayList<Examen> listExamensCompose;

    private Hashtable< String ,ArrayList<PrescriptionExamen>> listPrescriptions;
    private ArrayList<Medecin> listMedecin;
    private ArrayList<Patient> listPatient;
    private ArrayList<Laboratoire> listLabo;

    private RDVController rdvController;

    private LaboController laboController;
//    private CentreDeSoinController centreDeSoinController;
//    private RdvController rdvController;

    public AppController() {
        this.listExamensElementaires = new ArrayList<>();
        this.listExamensCompose = new ArrayList<>();
        this.listPrescriptions = new Hashtable<>();
        this.listMedecin = new ArrayList<>();
        this.listPatient = new ArrayList<>();

        this.listLabo = new ArrayList<>();

        this.laboController = new LaboController();

//        this.centreDeSoinController = new CentreDeSoinController();
        this.rdvController = new RDVController();
    }

    public void enreExamensPatient(PrescriptionExamen prescriptionExamen) {
        // Implement the logic for registering exams for a patient
        // Assuming adding to the listExamensElementaires for this example
        // This should be based on the actual logic of the application
        listExamensElementaires.add(prescriptionExamen.getExamen());
    }

    public void enrePatients(Patient patient) {
        listPatient.add(patient);
    }

    public void enreMedecin(Medecin medecin) {
        listMedecin.add(medecin);
    }

    public void enreLabo(Laboratoire labo) {
        listLabo.add(labo);
    }

    // Getters and setters for the lists and controllers if necessary

    public ArrayList<Laboratoire> getListLabo() {
        return listLabo;
    }

    public void enrePresTable(PrescriptionExamen prescriptionExamen, String codePatient){

        // Check if the patient code exists in the hashtable
        ArrayList<PrescriptionExamen> prescriptions = listPrescriptions.get(codePatient);

        if (prescriptions == null) {

            prescriptions = new ArrayList<>();

            prescriptions.add(prescriptionExamen);

            listPrescriptions.put(codePatient, prescriptions);
        } else {
            prescriptions.add(prescriptionExamen);
        }

    }

    //TODO Envoir listLAb to Labocontroller
    public RDVController getRdvController() {
        return rdvController;
    }

    public Hashtable<String, ArrayList<PrescriptionExamen>> getListPrescriptions() {
        return listPrescriptions;
    }


    public String envoyerDemandeRDV(HashMap<String,ArrayList<IDemandeRDV>> mapDemandeRDV){
//        for (Map.Entry<String,ArrayList<IDemandeRDV>> entry : mapDemandeRDV.entrySet()){
//           // Map<Examen,Laboratoire> examenLabo = new HashMap<>();
//            String codeLab = entry.getKey();
//            ArrayList<IDemandeRDV> listDemandrdv= entry.getValue();
//
//            laboController.recevoirToutDemandeRDV();
//        }
        laboController.recevoirToutDemandeRDV( mapDemandeRDV);
        return "App Controller envoyer MapDemandeRDV to LaboController ";

    }

}