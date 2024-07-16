package examen;

public class ExamenElem<T extends Enum<T>> extends Examen{
    private String name;
    private T type;

    public ExamenElem(String name, T type) {
        this.type = type;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public T getType() {
        return type;
    }
}
