import java.util.ArrayList;
import examen.Examen;
import uqam.inf5153.gestionExamensMed.interf.IPatient;

public class Patient extends AbstractEcouteur implements IPatient{
    private ArrayList<Examen> listExamensFait;
    private ArrayList<RDV> listRDVaVenir;
    private String codePatient;

    private String nomPatient;
    private String numTelPatient;
    private String emailPatient;

    // Constructor
    public Patient(String codePatient,String nomPatient, String numTelPatient, String emailPatient) {
        this.codePatient = codePatient;
        this.numTelPatient = numTelPatient;
        this.nomPatient = nomPatient;
        this.emailPatient = emailPatient;
        this.listExamensFait = new ArrayList<>();
        this.listRDVaVenir = new ArrayList<>();
    }

    @Override
    public String getCodePatient() {
        return this.codePatient;
    }

    @Override
    public String getNomPatient() {
        return this.nomPatient;
    }
}