package examen;


public abstract class Examen<T extends Enum<T>>{
      protected T type;

//    public abstract void setType(T type);
//    public abstract T getType();


   public void accept(model.Visitor visitor){
      visitor.visit(this);
   };

    protected String name;

    public String getName() {
        return name;
    }
}