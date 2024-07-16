package model;

import examen.AnalyseDeSang;
import examen.AnalyseUrine;
import examen.ExamenCompose;
import examen.Myelogramme;
import examen.Examen;

public interface Visitor {

    void visit(Examen examen);



}
