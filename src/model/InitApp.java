package model;

import examen.*;
import examen.types.AnalyseDeSangParameter;
import examen.types.EchographiePart;
import examen.types.RadiographieIRMPart;
import examen.types.RadiographieRayonXPart;
import laboratoire.LaboController;
import laboratoire.Laboratoire;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;

import java.util.ArrayList;
import java.util.HashMap;


public class InitApp {

    public AppController appController;

    public InitApp( ) {
        this.appController =  new AppController();
    }

    public void ModelInitialisation(){

        // Définir les informations patient et les stocker dans l'AppController
        Patient patient1 = new Patient("Paul","5141234567","paul123@gmail.com");
        this.appController.enrePatients(patient1);
        Patient patient2= new Patient("Anne","5141234568","anne123@gmail.com");
        appController.enrePatients(patient2);
        Patient patient3= new Patient("Luc","5141234569","luc123@gmail.com");
        appController.enrePatients(patient3);

        // Définir les informations médecin et les stocker dans l'AppController
        Medecin medecin1 = new Medecin("Marc","5148888888", "marc123@gmail.com");
        Medecin medecin2 = new Medecin("Marie","5148888887", "marie123@gmail.com");
        Medecin.setAppController(appController);
        appController.enreMedecin(medecin1);
        appController.enreMedecin(medecin2);

        // Initier les examens
        Examen adsBASE = new AnalyseDeSang(AnalyseDeSangParameter.BASE) ;
        ExamenCompose examenAnemie = new ExamenAnemie();
        Examen echoCERVEAU = new Echographie(EchographiePart.CERVEAU);

        // Médecin1 prescrit des examens
        PrescriptionExamen pres10= medecin1.prescrireExamen(patient1,adsBASE);
        PrescriptionExamen pres11=medecin1.prescrireExamen(patient1,examenAnemie);
        PrescriptionExamen pres12=medecin1.prescrireExamen(patient2,echoCERVEAU);

        // Médecin2 prescrit des examens
        Examen IRMHanche = new RadiographieIRM(RadiographieIRMPart.HANCHE);
        Examen RayonXpoum = new RadiographieRayonX(RadiographieRayonXPart.POUMON);
        PrescriptionExamen pres21=medecin2.prescrireExamen(patient3,IRMHanche);
        PrescriptionExamen pres22=medecin2.prescrireExamen(patient3,RayonXpoum);

        /* Stocker la prescription dans la prescription de la liste de patients correspondante
        (HashTable) dans appController
         */
        appController.enreExamensPatient(pres10);
        appController.enreExamensPatient(pres11);
        appController.enreExamensPatient(pres12);
        appController.enreExamensPatient(pres21);
        appController.enreExamensPatient(pres22);



        /*
        Définition initiale des examens pouvant être dispensés dans chaque laboratoire
        et créons un nouvel objet pour chaque laboratoire
        */
        ArrayList lab1ListExamen = new ArrayList<>();
        lab1ListExamen.add(IRMHanche);
        lab1ListExamen.add(RayonXpoum);
        lab1ListExamen.add(examenAnemie.getListExamensElem().get(0));
        lab1ListExamen.add(examenAnemie.getListExamensElem().get(1));

        ILaboratoire lab1 = new Laboratoire("lab1",lab1ListExamen);

        ArrayList lab2ListExamen = new ArrayList<>();
        lab2ListExamen.add(adsBASE);
        lab2ListExamen.add(echoCERVEAU);
        lab2ListExamen.add(examenAnemie.getListExamensElem().get(2));
        lab2ListExamen.add(examenAnemie.getListExamensElem().get(3));

        ILaboratoire lab2 = new Laboratoire("lab2",lab2ListExamen);

        // Ajoutons le laboratoire existant à laboList dans AppController
        appController.enreLabo(lab2);
        appController.enreLabo(lab1);

        RDVController rdvController = new RDVController();
        rdvController.setAppController(appController);

        HashMap mapDemandeRDV  =rdvController.distribuerExamenAlabo(appController.gethtablePrescriptions());

        //new LaboController
        LaboController laboController = new LaboController();
        appController.setLaboController(laboController);

        // AppController envoie les informations RDV de la demande au LaboController
        appController.envoyerDemandeRDV(mapDemandeRDV);
        System.out.println(laboController.getDemandeRDVsMap());

        // Appcontroller envoyer la list de laboratoire à LaboController
        appController.envoyerListLabo();

        // Envoyer la demandeRDV au laboratoire correspondante
        laboController.distribueDemandeRDV();
    }
}