package uqam.inf5153.gestionExamensMed.interf;

public interface IEvenement {
    public  void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);

    public void notifierObserver();

}
