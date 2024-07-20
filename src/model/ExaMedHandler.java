package model;
import java.util.ArrayList;
import java.util.Hashtable;

import examen.Examen;
import uqam.inf5153.gestionExamensMed.interf.IExaMedicalHandler;

import uqam.inf5153.gestionExamensMed.interf.IPatient;

public class ExaMedHandler implements IExaMedicalHandler {

        private Hashtable<String , ArrayList<Examen>> examenPrescritTable ;

        private  ArrayList<IPatient> patientListWithI=new ArrayList<>();


        public ExaMedHandler(ArrayList<Patient> patientList, Hashtable<String , ArrayList<PrescriptionExamen>> prescritTable) {

            this.examenPrescritTable = new Hashtable<>();
            for (Patient patient:patientList) {
                this.patientListWithI.add((IPatient) patient);
            }
            for (String key :prescritTable.keySet()) {
                ArrayList<PrescriptionExamen> prescriptionExamens = prescritTable.get(key);
                ArrayList<Examen> examens = new ArrayList<>();

                // Parcourez la liste ArrayList de PrescriptionExamen et extrayez Examen
                for (PrescriptionExamen prescriptionExamen : prescriptionExamens) {
                    examens.add(prescriptionExamen.getExamen());
                }

                // Mettre la nouvelle ArrayList of Examen dans la table de hachage transformée
                examenPrescritTable.put(key, examens);

        }



        }
        @Override
        public ArrayList<IPatient> examPatientList() {
            // TODO Auto-generated method stub
            return patientListWithI;
        }

        @Override
        public ArrayList<Examen> examenPrescritList(String codePatient) {
            return examenPrescritTable.get(codePatient) ;
        }


}



