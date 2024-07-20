package examen;

public class ExamenElem<T extends Enum<T>> extends Examen{
    private String name;
    private T type;
    boolean isElemen = true;

    public ExamenElem(String name, T type) {
       this.name=name;
       this.type=type;
    }

    @Override
    public String getName() {
        return name;
    }

    public T getType() {
        return type;
    }
    public boolean isExamenElementaire() {
        return isElemen;
    };
}
