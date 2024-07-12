package examen;

import examen.types.EndoscopieType;

public class Endoscopie extends Examen {
    private EndoscopieType type;
    public Endoscopie(EndoscopieType type){
        this.type = type;
    }
}
