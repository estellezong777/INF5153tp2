package uqam.inf5153.gestionExamensMed.interf;


public interface IObserver {


    // La réponse est la réponse du laboratoire à la demande de résultats RDV ou d'examen
    public  void notifierEcouteur( String reponse);
}
