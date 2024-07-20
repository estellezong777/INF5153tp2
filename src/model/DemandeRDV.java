package model;

import examen.Examen;
import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;

public class DemandeRDV implements IDemandeRDV {
    private int numDemande;
    private String codePatient;

    private String nomPatient;
//TODO
//= labelExamen, composer de nom de l'examen et ses parametres
    private String descriptionExamen;

    // Constructeur
    public DemandeRDV(String nomPatient,String codePatient, String descriptionExamen) {
        this.codePatient = codePatient;
        this.nomPatient = nomPatient;
        this.descriptionExamen = descriptionExamen;
        this.numDemande = DemandeRDV.GenerateurCodeDemande.getInstance().generate();
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
        return descriptionExamen;
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

    public String getDescriptionExamen() {
        return descriptionExamen;
    }

    public void setDescriptionExamen(String descriptionExamen) {
        this.descriptionExamen = descriptionExamen;
    }

    @Override
    public String toString() {
        return "model.DemandeRDV{" +
                "numDemande='" + numDemande + '\'' +
                ", codePatient='" + codePatient + '\'' +
                ", descriptionExamen=" + descriptionExamen +
                '}';
    }


    private static class GenerateurCodeDemande{
        private static GenerateurCodeDemande generateurCodeDemande;
        private int counter;
        private GenerateurCodeDemande(){
            counter = 0;
        }

        public static GenerateurCodeDemande getInstance(){
            if (generateurCodeDemande== null){
                generateurCodeDemande= new GenerateurCodeDemande();
            }return  generateurCodeDemande;
        }

        public int generate(){
            this.counter++;
            return counter;
        }}

}
