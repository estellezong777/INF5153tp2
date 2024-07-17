package model;

import examen.*;
import examen.types.AnalyseDeSangParameter;
import examen.types.EchographiePart;
import examen.types.RadiographieIRMPart;
import examen.types.RadiographieRayonXPart;
import laboratoire.LaboController;
import laboratoire.Laboratoire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class InitApp {
    public void ModelInitialisation(){
        AppController appcontroller = new AppController();
        Patient patient1 = new Patient("Paul","5141234567","paul123@gmail.com");
        appcontroller.enrePatients(patient1);
        Patient patient2= new Patient("Anne","5141234568","anne123@gmail.com");
        appcontroller.enrePatients(patient2);
        Patient patient3= new Patient("Luc","5141234569","luc123@gmail.com");
        appcontroller.enrePatients(patient3);

        //initier medecins
        Medecin medecin1 = new Medecin("Marc","5148888888", "marc123@gmail.com");
        Medecin medecin2 = new Medecin("Marie","5148888887", "marie123@gmail.com");
        Medecin.setAppController(appcontroller);
        appcontroller.enreMedecin(medecin1);
        appcontroller.enreMedecin(medecin2);

        //initier examen
        Examen adsBASE = new AnalyseDeSang(AnalyseDeSangParameter.BASE) ;
        ExamenCompose examenAnemie = new ExamenAnemie();
        Examen echoCERVEAU = new Echographie(EchographiePart.CERVEAU);

        //Medecin1 prescrit des examens
        PrescriptionExamen pres10= medecin1.prescrireExamen(patient1,adsBASE);
        PrescriptionExamen pres11=medecin1.prescrireExamen(patient1,examenAnemie);
        PrescriptionExamen pres12=medecin1.prescrireExamen(patient2,echoCERVEAU);

        //Medecin2 prescrit des examens
        Examen IRMHanche = new RadiographieIRM(RadiographieIRMPart.HANCHE);
        Examen RayonXpoum = new RadiographieRayonX(RadiographieRayonXPart.POUMON);
        PrescriptionExamen pres21=medecin2.prescrireExamen(patient3,IRMHanche);
        PrescriptionExamen pres22=medecin2.prescrireExamen(patient3,RayonXpoum);

        //add prescription to listprescription（HashTable）dans appController
        appcontroller.enreExamensPatient(pres10);
        appcontroller.enreExamensPatient(pres11);
        appcontroller.enreExamensPatient(pres12);
        appcontroller.enreExamensPatient(pres21);
        appcontroller.enreExamensPatient(pres22);



        ArrayList lab1ListExamen = new ArrayList<>();
        lab1ListExamen.add(IRMHanche);
        lab1ListExamen.add(RayonXpoum);
        lab1ListExamen.add(examenAnemie.getListExamensElem().get(0));
        lab1ListExamen.add(examenAnemie.getListExamensElem().get(1));


        Laboratoire lab1 = new Laboratoire("lab1",lab1ListExamen);

        ArrayList lab2ListExamen = new ArrayList<>();
        lab2ListExamen.add(adsBASE);
        lab2ListExamen.add(echoCERVEAU);
        lab2ListExamen.add(examenAnemie.getListExamensElem().get(2));
        lab2ListExamen.add(examenAnemie.getListExamensElem().get(3));

        Laboratoire lab2 = new Laboratoire("lab2",lab2ListExamen);



        //add labo into labolist
        appcontroller.enreLabo(lab2);
        appcontroller.enreLabo(lab1);

        //TEST
        System.out.println(appcontroller.gethtablePrescriptions().get("Pat000003").get(0).getExamen().getName());
        System.out.println(examenAnemie.getListExamensElem());

        RDVController rdvController = new RDVController();
        rdvController.setAppController(appcontroller);

        HashMap mapDemandeRDV  =rdvController.distribuerExamenAlabo(appcontroller.gethtablePrescriptions());
        System.out.println(mapDemandeRDV);

        //new labocontroller
        LaboController laboController = new LaboController();
        appcontroller.setLaboController(laboController);

        appcontroller.envoyerDemandeRDV(mapDemandeRDV);
        System.out.println(laboController.getDemandeRDVsMap());

        //appcontroller envoyer list labo a labocontroller
        appcontroller.envoyerListLabo();
        System.out.println("getlistlABO"+ laboController.getListLaboratoire());

        //distribueDemandeRDV a chaque labo
        laboController.distribueDemandeRDV();
        System.out.println("lab1"+lab1.getListDemandeRDV());





    }




}