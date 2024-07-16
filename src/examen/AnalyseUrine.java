package examen;
import examen.types.AnalyseUrineParameter;

public class AnalyseUrine extends ExamenElem{
    private AnalyseUrineParameter type;

    public AnalyseUrine(AnalyseUrineParameter type){
        super("Analyse d'Urine",type);

    }

    public void setType(AnalyseUrineParameter type) {
        this.type=type;

    }

    public AnalyseUrineParameter getType() {
        return null;
    }

//    public void accept(model.Visitor visitor) {
//        visitor.visit(this);
//    }
}
