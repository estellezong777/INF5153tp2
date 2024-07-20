package examen;
import java.util.ArrayList;

public abstract class ExamenCompose extends Examen {
    protected ArrayList<Examen> listExamensElem ;
    boolean isElemen = false;
    protected String name;

    public ExamenCompose(String name) {
        this.name = name;
        this.listExamensElem = new ArrayList<>();

    }

    public boolean isExamenElementaire() {
        return isElemen;
    };
    public void addExamen(ExamenElem examen) {
        listExamensElem.add(examen);
    }

    public void removeExamen(ExamenElem examen) {
        listExamensElem.remove(examen);
    }

    public ArrayList<Examen> getListExamensElem() {
        return listExamensElem;
    }

    @Override
    public String toString() {
        return "ExamenCompose{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName(){
        return name ;
    }
}
