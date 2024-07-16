package examen;


import examen.types.EchographiePart;

public class Echographie extends ExamenElem{
    private EchographiePart type;

    public Echographie(EchographiePart type){
        super("Echographie",type);
    }
}
