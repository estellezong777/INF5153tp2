package examen;


import examen.types.EchographiePart;

public class Echographie extends Examen{
    private EchographiePart type;

    public Echographie(EchographiePart type){
        this.type = type;
    }
}
