package examen;
import java.util.ArrayList;

public abstract class ExamenCompose extends Examen {
    protected ArrayList<Examen> listExamensElem ;

    public ExamenCompose() {

        this.listExamensElem = new ArrayList<>();
    }

    public void addExamen(ExamenElem examen) {
        listExamensElem.add(examen);
    }

    public void removeExamen(ExamenElem examen) {
        listExamensElem.remove(examen);
    }

    public ArrayList<Examen> getListExamensElem() {
        return listExamensElem;
    }


}
