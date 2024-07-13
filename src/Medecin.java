
public class Medecin extends AbstractEcouteur {
    private String matriculeMed;
    private String nomMed;
    private String numTelMed;
    private String emailMed;

    // Constructor
    public Medecin(String matriculeMed, String nomMed, String numTelMed, String emailMed) {
        this.matriculeMed = matriculeMed;
        this.nomMed = nomMed;
        this.numTelMed = numTelMed;
        this.emailMed = emailMed;
    }


}