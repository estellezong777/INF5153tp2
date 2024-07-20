package model;

import uqam.inf5153.gestionExamensMed.interf.IEvenement;
import uqam.inf5153.gestionExamensMed.interf.IObserver;

import java.util.ArrayList;

public class Evenement implements IEvenement {
    protected ArrayList<AbstractEcouteur> ecouteurList;
    private ArrayList<IObserver> observerList;

    // Une réponse donnée par le Laboratoire, y compris les réponses au DemandeRDV et les résultats de l'examen
    private String reponse;


    public Evenement( String reponse,ArrayList<IObserver> observerList ) {
        this.reponse = reponse;
        this.observerList = observerList;
    }

    public void addEcouteur(AbstractEcouteur ecouteur) {
        ecouteurList.add(ecouteur);
    }

    public void removeEcouteur(AbstractEcouteur ecouteur){
        ecouteurList.remove(ecouteur);
    }

    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(IObserver observer){
        observerList.remove(observer);
    }

    // Envoyons une notification à la personne correspondante en fonction de la réponse donnée par le laboratoire
    public void notifierObserver(){
        for(IObserver observer:observerList){
            observer.notifierEcouteur(reponse);
        }
    };
}
