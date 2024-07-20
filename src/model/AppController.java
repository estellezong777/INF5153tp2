package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import examen.Examen;
import laboratoire.*;
import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;
import uqam.inf5153.gestionExamensMed.interf.IEvenement;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;
import uqam.inf5153.gestionExamensMed.interf.IObserver;

public class AppController {
    private ArrayList<Examen> listExamensElementaires;

    /**
    * Utilisons une table de hachage pour stocker les examens dans la description d'un patient.
    * La clé de cette table de hachage est codePatient et la valeur est l'objet de PrescriptionExamen.
    */
    private Hashtable< String ,ArrayList<PrescriptionExamen>> htablePrescriptions;
    private ArrayList<Medecin> listMedecin;
    private ArrayList<Patient> listPatient;
    private ArrayList<ILaboratoire> listLabo;

    private LaboController laboController;

    // La liste est utilisée pour stocker les résultats de la réponse du laboratoire à la demande de rendez-vous
    private ArrayList<String> listReponseLabo;

    private ArrayList<String> examenResultList ;// Liste des résultats des examens des patients

    // Constructeur
    public AppController() {
        this.listExamensElementaires = new ArrayList<>();
        //this.listExamensCompose = new ArrayList<>();
        this.htablePrescriptions = new Hashtable<>();
        this.listMedecin = new ArrayList<>();
        this.listPatient = new ArrayList<>();
        this.listLabo = new ArrayList<>();
        this.listReponseLabo = new ArrayList<>();
        this.examenResultList = new ArrayList<>();

    }

    // Ajoutons tous les examens dont le patient a besoin à la listeExamensElementaires
    public void enreExamensPatient(PrescriptionExamen prescriptionExamen) {
        listExamensElementaires.add(prescriptionExamen.getExamen());
    }

    // Ajoutons un nouveau patient enregistré à la listPatient
    public void enrePatients(Patient patient) {
        listPatient.add(patient);
    }

    // Ajoutons un nouveau médecin enregistré à la listMedecin
    public void enreMedecin(Medecin medecin) {
        listMedecin.add(medecin);
    }

    // Ajoutons un nouveau laboratoire enregistré à la listLabo
    public void enreLabo(ILaboratoire labo) {
        listLabo.add(labo);
    }

    // Getters et setters pour les listes et contrôleurs si nécessaire
    public ArrayList<ILaboratoire> getListLabo() {
        return listLabo;
    }


    public void enrePresTable(PrescriptionExamen prescriptionExamen, String codePatient){

        //Vérifions si le code patient existe dans la table de hachage qui stocke des prescriptions
        ArrayList<PrescriptionExamen> prescriptions = htablePrescriptions.get(codePatient);

        /**
         * Si le patient n'a pas créé sa liste de prescriptions, nous créons d'abord sa liste de prescriptions
         * puis ajoutons sa prescription à cette liste.
        */
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



    public Hashtable<String, ArrayList<PrescriptionExamen>> gethtablePrescriptions() {
        return htablePrescriptions;
    }


    /**
     * Envoyons les données de DemandeRDV à labController via AppController
    */
    public String envoyerDemandeRDV(HashMap<String,ArrayList<IDemandeRDV>> mapDemandeRDV){

        laboController.recevoirToutDemandeRDV(mapDemandeRDV);
        return "App Controller envoyer MapDemandeRDV to LaboController ";

    }

    /**
     * Transférons la liste des laboratoires d'Appcontroller vers labController
    */
    public void envoyerListLabo(){
        laboController.setListLabo(listLabo);
    }

    /**
    * Recevoir les résultats de l'examen médicaux des patients envoyés par le laboratoire
    **/
    public void recevoirReponseLaboRdv(ArrayList<String> reponseRDV){
        this.listReponseLabo = reponseRDV;

    }

    /**
    * Parcourons la liste des réponses du labo pour DemandeRDV. eacheRponse est une chaîne
    * qui contient des informations telles que CodePatient, numDemande, date, RDV et heureRDv
    * respectivement, puis créons un nouvel objet RDV pour chaque rendez-vous.
    * Un événement sera déclenché lors du traitement de la réponse et la personne correspondante sera avertie en
    * fonction du type d'événement.
     */
    public void traiterResponseLaboRDV(ArrayList<IObserver> listObservers){

        String codePatient = null;
        String numDemande = null;
        String dateRDV=null;
        String heureRDV=null;

        // eachReponse example：[codePatient = Alie14325, numDemande = 453623, dateRDV = 15-07-2024, heureRDV = 14 :30]
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

    /**
     * Obtenons des informations sur ResultExamenlist à partir de laboController
    */
    public void recevoirResultExamen( ){
        this.examenResultList = laboController.getResultExamenlist();
    }


    /**
     * Au cours du processus de traitement du résultat de l'examen, un événement sera
     * déclenché et les informations sur résultats d'examen seront envoyées au service et
     * au patient correspondant.
    */
    public void traiterResultExamen(ArrayList<IObserver> listObservers){

        for (String eachResult:examenResultList) {

            IEvenement evenement = new Evenement(eachResult,listObservers);
            evenement.notifierObserver();
        }
    }
    }


