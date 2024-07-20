package examen;


import uqam.inf5153.gestionExamensMed.interf.IExamenMedical;

import java.util.ArrayList;

public abstract class Examen<T extends Enum<T>> implements IExamenMedical {
      protected T type;

    protected  boolean isElemen;
    protected String name;
    protected ArrayList<IExamenMedical> listExamensCompo;
    protected ArrayList<Examen> listExamensElem;



    public String getName() {
        return name;
    }

    public String getNomExamen(){
        return name;
    };

    public boolean isExamenElementaire() {
        return isElemen;
    };

    public ArrayList<IExamenMedical> getComposantExamenList(){
        return listExamensCompo;
    };

    public ArrayList<Examen>  getListExamensElem(){
        return listExamensElem;

    };

    }
