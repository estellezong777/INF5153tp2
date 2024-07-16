package model;

import java.util.ArrayList;
import examen.Examen;
import uqam.inf5153.gestionExamensMed.interf.IPatient;

public class Patient extends AbstractEcouteur implements IPatient{
    private ArrayList<Examen> listExamensFait;

    private ArrayList<PrescriptionExamen> listPrescriptionExamen;
    private ArrayList<RDV> listRDVaVenir;
    private String codePatient;

    private String nomPatient;
    private String numTelPatient;
    private String emailPatient;

    // Constructor
    public Patient(String nomPatient, String numTelPatient, String emailPatient) {
        this.codePatient = GenerateurCodePatient.getInstance().generate();
        this.numTelPatient = numTelPatient;
        this.nomPatient = nomPatient;
        this.emailPatient = emailPatient;
        this.listExamensFait = new ArrayList<>();
        this.listRDVaVenir = new ArrayList<>();
        this.listPrescriptionExamen = new ArrayList<>();
    }

    @Override
    public String getCodePatient() {
        return this.codePatient;
    }

    @Override
    public String getNomPatient() {
        return this.nomPatient;
    }

    public ArrayList<PrescriptionExamen> getListPrescriptionExamen() {
        return listPrescriptionExamen;
    }

    public void setListPrescriptionExamen(ArrayList<PrescriptionExamen> listPrescriptionExamen) {
        this.listPrescriptionExamen = listPrescriptionExamen;
    }

    private static class GenerateurCodePatient{
        private static GenerateurCodePatient generateurCodePatient;
        private int counter;
        private GenerateurCodePatient(){
            counter = 0;
        }

        public static GenerateurCodePatient getInstance(){
            if (generateurCodePatient == null){
                generateurCodePatient = new GenerateurCodePatient();
            }return generateurCodePatient;
        }

        public String generate(){
            this.counter++;
            return "Pat" + String.format("%06d", counter);
        }



    }
}

