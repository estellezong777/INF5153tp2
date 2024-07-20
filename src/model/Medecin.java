package model;

import examen.Examen;

public class Medecin extends AbstractEcouteur {
    private String matriculeMed;
    private String nomMed;
    private String numTelMed;
    private String emailMed;

    private static AppController appController;

    // Constructeur
    public Medecin( String nomMed, String numTelMed, String emailMed) {
        this.nomMed = nomMed;
        this.matriculeMed = GenerateurCodeMedecin.getInstance().generate();
        this.numTelMed = numTelMed;
        this.emailMed = emailMed;
    }

    /**
    Les paramètres de cette méthode sont l'objet du patient et l'objet de l'examen.
    Le médecin utilise cette méthode pour prescrire une ordonnance à ce patient en obtenant le code patient.
     */
    public PrescriptionExamen prescrireExamen(Patient patient, Examen examen){
        PrescriptionExamen prescriptionExamen = new PrescriptionExamen(this,patient,examen);

        // Stocker la description dans la presTable dans AppController
        patient.getListPrescriptionExamen().add(prescriptionExamen);
        appController.enrePresTable(prescriptionExamen,patient.getCodePatient());
        return prescriptionExamen;
    }

    public static void setAppController(AppController appController) {
        Medecin.appController = appController;
    }


    // Utilisons un patron singleton pour générer un code unique pour la médecine
    private static class GenerateurCodeMedecin{
        private static Medecin.GenerateurCodeMedecin generateurCodeMedecin;
        private int counter;
        private GenerateurCodeMedecin(){
            counter = 0;
        }

        public static GenerateurCodeMedecin getInstance(){
            if (generateurCodeMedecin== null){
                generateurCodeMedecin= new GenerateurCodeMedecin();
            }return generateurCodeMedecin;
        }

        public String generate(){
            this.counter++;
            return "Med" + String.format("%06d", counter);
        }



    }


}