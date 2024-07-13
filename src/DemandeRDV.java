import examen.Examen;
import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;

public class DemandeRDV implements IDemandeRDV {
    private int numDemande;
    private String codePatient;

    private String nomPatient;
//TODO
//= labelExamen, composer de nom de l'examen et ses parametres
    private Examen descriptionExamen;

    // Constructeur
    public DemandeRDV(int numDemande, String nomPatient,String codePatient, Examen descriptionExamen) {
        this.numDemande = numDemande;
        this.codePatient = codePatient;
        this.nomPatient = nomPatient;
        this.descriptionExamen = descriptionExamen;
    }

    // Getters et Setters
    public int getNumDemande() {
        return numDemande;
    }

    @Override
    public String getNomPatient() {
        return nomPatient;
    }

    @Override
    public String getLabelExamen() {
        //TODO return descriptionExamen;
        return null;
    }

    public void setNumDemande(int numDemande) {
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
