package examen;


public abstract class Examen<T extends Enum<T>>{
      protected T type;


    protected String name;

    public String getName() {
        return name;
    }
}