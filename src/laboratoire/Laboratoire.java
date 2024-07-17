package laboratoire;

import examen.Examen;
import model.Medecin;
import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;

import java.util.ArrayList;

public class Laboratoire implements ILaboratoire {
    private  String CodeLaboratoire;
    private  String NomLaboratoire;
    private ArrayList<Examen> listExamensProvide;

    private ArrayList<IDemandeRDV> listDemandeRDV;




    public Laboratoire(String NomLabotatoire, ArrayList<Examen> listExamensProvide){
        this.NomLaboratoire=NomLabotatoire;
        this.listExamensProvide= new ArrayList<Examen>(listExamensProvide);
        this.listDemandeRDV = new ArrayList<>();
        this.CodeLaboratoire = Laboratoire.GenerateurCodeLaboratoire.getInstance().generate();
    }


    public ArrayList<Examen> getListExamensProvide() {
        return listExamensProvide;
    }

    @Override
    public String getCodeLaboratoire() {
        return CodeLaboratoire;
    }

    @Override
    public String getNomLaboratoire() {
        return NomLaboratoire;
    }

    public void setListDemandeRDV(ArrayList<IDemandeRDV> listDemandeRDV) {
        this.listDemandeRDV = listDemandeRDV;
    }

    public ArrayList<IDemandeRDV> getListDemandeRDV() {
        return listDemandeRDV;
    }

    private static class GenerateurCodeLaboratoire{
        private static GenerateurCodeLaboratoire generateurCodeLaboratoire;
        private int counter;
        private GenerateurCodeLaboratoire(){
            counter = 0;
        }

        public static GenerateurCodeLaboratoire getInstance(){
            if (generateurCodeLaboratoire== null){
                generateurCodeLaboratoire= new GenerateurCodeLaboratoire();
            }return generateurCodeLaboratoire;
        }

        public String generate(){
            this.counter++;
            return "Lab" + String.format("%06d", counter);
        }


    }}
