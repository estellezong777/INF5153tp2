package examen;
import java.util.ArrayList;

public class ExamenCompose extends Examen {
    private ArrayList<Examen> listExamensElem = new ArrayList<>();

    public ExamenCompose(String type) {
        this.type = type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public void addExamen(Examen examen) {
        listExamensElem.add(examen);
    }

    public void removeExamen(Examen examen) {
        listExamensElem.remove(examen);
    }

    public ArrayList<Examen> getListExamensElem() {
        return listExamensElem;
    }
}
