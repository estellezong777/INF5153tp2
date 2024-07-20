package examen;
import examen.types.AnalyseDeSangParameter;


public class AnalyseDeSang extends ExamenElem {
    private AnalyseDeSangParameter type;

    public AnalyseDeSang(AnalyseDeSangParameter type) {
        super("Analyse de sang",type);
    }



    public void setType(AnalyseDeSangParameter type) {
        this.type = type;
    }


    public AnalyseDeSangParameter getType() {
        return this.type;
    }

}
