import examen.Examen;
public class DemandeRDV {
    private String numDemande;
    private String codePatient;
    private Examen descriptionExamen;

    // Constructeur
    public DemandeRDV(String numDemande, String codePatient, Examen descriptionExamen) {
        this.numDemande = numDemande;
        this.codePatient = codePatient;
        this.descriptionExamen = descriptionExamen;
    }

    // Getters et Setters
    public String getNumDemande() {
        return numDemande;
    }

    public void setNumDemande(String numDemande) {
        this.numDemande = numDemande;
    }

    public String getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(String codePatient) {
        this.codePatient = codePatient;
    }

    public Examen getDescriptionExamen() {
        return descriptionExamen;
    }

    public void setDescriptionExamen(Examen descriptionExamen) {
        this.descriptionExamen = descriptionExamen;
    }

    @Override
    public String toString() {
        return "DemandeRDV{" +
                "numDemande='" + numDemande + '\'' +
                ", codePatient='" + codePatient + '\'' +
                ", descriptionExamen=" + descriptionExamen +
                '}';
    }
}
