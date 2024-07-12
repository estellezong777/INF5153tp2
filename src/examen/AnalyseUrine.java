package examen;
import examen.types.AnalyseUrineParameter;

public class AnalyseUrine extends Examen{
    private AnalyseUrineParameter type;

    public AnalyseUrine(AnalyseUrineParameter type){
        this.type = type;
    }

    public void setType(AnalyseUrineParameter type) {
        this.type=type;

    }


    public AnalyseUrineParameter getType() {
        return null;
    }
}
