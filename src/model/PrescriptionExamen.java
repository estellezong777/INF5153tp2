package model;

import examen.Examen;
public class PrescriptionExamen {
    private Examen examen;
    private Medecin medecin;
    private Patient patient;
    private AppController appController;

    // Constructor
    public PrescriptionExamen(Medecin medecin, Patient patient, Examen examen) {
        this.medecin = medecin;
        this.patient = patient;
        this.examen = examen;
    }

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

    public AppController getAppController() {
        return appController;
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }
}
