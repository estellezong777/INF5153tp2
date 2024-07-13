import java.util.ArrayList;
import examen.Examen;
import laboratoire.*;

public class AppController {
    private ArrayList<Examen> listExamensElementaires;
    private ArrayList<Examen> listExamensCompose;
    private ArrayList<Medecin> listMedecin;
    private ArrayList<Patient> listPatient;
    private ArrayList<Laboratoire> listLabo;

    private LaboController laboController;
//    private CentreDeSoinController centreDeSoinController;
//    private RdvController rdvController;

    public AppController() {
        this.listExamensElementaires = new ArrayList<>();
        this.listExamensCompose = new ArrayList<>();
        this.listMedecin = new ArrayList<>();
        this.listPatient = new ArrayList<>();
        this.listLabo = new ArrayList<>();

        this.laboController = new LaboController();
//        this.centreDeSoinController = new CentreDeSoinController();
//        this.rdvController = new RdvController();
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
}