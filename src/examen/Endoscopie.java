package examen;

import examen.types.EndoscopieType;

public class Endoscopie extends ExamenElem {
    private EndoscopieType type;
    public Endoscopie(EndoscopieType type){
        super("Endoscopie",type);
    }
}
