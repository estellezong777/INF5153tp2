import java.util.ArrayList;
import examen.Examen;
public class PrescriptionExamens {
    private ArrayList<Examen> listExamensAFaire;
    private Medecin medecin;
    private Patient patient;
    private AppController appController;

    // Constructor
    public PrescriptionExamens(Medecin medecin, Patient patient, AppController appController) {
        this.medecin = medecin;
        this.patient = patient;
        this.appController = appController;
        this.listExamensAFaire = new ArrayList<>();
    }
}
