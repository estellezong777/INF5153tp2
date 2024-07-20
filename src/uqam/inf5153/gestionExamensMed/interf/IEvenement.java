package uqam.inf5153.gestionExamensMed.interf;

//Utilisons le patron observateur pour gérer la relation entre l'événement, le notificateur et les écouteurs

public interface IEvenement {
    public  void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);

    public void notifierObserver();

}
