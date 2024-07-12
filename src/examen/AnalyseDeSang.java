package examen;
import examen.types.AnalyseDeSangParameter;

public class AnalyseDeSang extends Examen {
    private AnalyseDeSangParameter type;

    public AnalyseDeSang(AnalyseDeSangParameter type) {
        this.type = type;
    }


    public void setType(AnalyseDeSangParameter type) {
        this.type = type;
    }


    public AnalyseDeSangParameter getType() {
        return this.type;
    }
}
