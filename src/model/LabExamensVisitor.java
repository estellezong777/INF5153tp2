package model;

import examen.AnalyseDeSang;
import examen.ExamenCompose;
import examen.Examen;

    public class LabExamensVisitor implements Visitor {
        public void visit(Examen examenElementtaire){
            // visitor is used to add examens in the listExamensProvide  in labo

        }

        public void visit(ExamenCompose examenCompose){

        }
    }