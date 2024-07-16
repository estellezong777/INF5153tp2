package examen;

import examen.types.MyelogrammeType;

public class Myelogramme extends ExamenElem{
    private MyelogrammeType type;
    public Myelogramme(MyelogrammeType type){
        super("Myelogramme", type);
    }
}
