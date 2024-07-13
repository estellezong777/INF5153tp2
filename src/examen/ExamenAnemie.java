package examen;

import examen.types.AnalyseDeSangParameter;
import examen.types.AnalyseUrineParameter;

public class ExamenAnemie extends ExamenCompose{
    public ExamenAnemie(){
        super();
        listExamensElem.add(new AnalyseDeSang(AnalyseDeSangParameter.FSC));
        listExamensElem.add(new Myelogramme());
        listExamensElem.add(new AnalyseUrine(AnalyseUrineParameter.PROTEINURIE));
        listExamensElem.add(new AnalyseUrine(AnalyseUrineParameter.GLYCOSURIE));
    }

    @Override
    public String toString() {
        return "ExamenAnemie{" +
                "listExamensElem=" + listExamensElem +
                '}';
    }
}
