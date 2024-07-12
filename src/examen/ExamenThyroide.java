package examen;

import examen.types.AnalyseDeSangParameter;
import examen.types.EchographiePart;

public class ExamenThyroide extends ExamenCompose{

    public ExamenThyroide(){
        super();
        listExamensElem.add(new Echographie(EchographiePart.THYROIDE));
        listExamensElem.add(new ExamenAnemie());
        listExamensElem.add(new AnalyseDeSang(AnalyseDeSangParameter.TSH));

    }

}
