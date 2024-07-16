package laboratoire;

import examen.Examen;
import model.Medecin;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;

import java.util.ArrayList;

public class Laboratoire implements ILaboratoire {
    private  String CodeLaboratoire;
    private  String NomLaboratoire;
    private ArrayList<Examen> listExamensProvide;


    public Laboratoire(String NomLabotatoire, ArrayList<Examen> listExamensProvide){
        this.NomLaboratoire=NomLabotatoire;
        this.listExamensProvide= new ArrayList<Examen>(listExamensProvide);
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
