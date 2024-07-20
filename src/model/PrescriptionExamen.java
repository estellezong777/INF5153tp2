package model;

import examen.Examen;
public class PrescriptionExamen {
    private Examen examen;
    private Medecin medecin;
    private Patient patient;

    // Constructeur
    public PrescriptionExamen(Medecin medecin, Patient patient, Examen examen) {
        this.medecin = medecin;
        this.patient = patient;
        this.examen = examen;
    }


    // Getters et Setters
    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

}
