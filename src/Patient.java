import java.util.ArrayList;
import examen.Examen;

public class Patient extends AbstractEcouteur {
    private ArrayList<Examen> listExamensFait;
    private ArrayList<RDV> listRDVaVenir;
    private String codePatient;
    private String numTelPatient;
    private String emailPatient;

    // Constructor
    public Patient(String codePatient, String numTelPatient, String emailPatient) {
        this.codePatient = codePatient;
        this.numTelPatient = numTelPatient;
        this.emailPatient = emailPatient;
        this.listExamensFait = new ArrayList<>();
        this.listRDVaVenir = new ArrayList<>();
    }