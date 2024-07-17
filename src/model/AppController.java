package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import examen.Examen;
import laboratoire.*;
import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;

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

    public AppController() {
        this.listExamensElementaires = new ArrayList<>();
        this.listExamensCompose = new ArrayList<>();
        this.htablePrescriptions = new Hashtable<>();
        this.listMedecin = new ArrayList<>();
        this.listPatient = new ArrayList<>();

        this.listLabo = new ArrayList<>();

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

    public void enreLabo(Laboratoire labo) {
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
}