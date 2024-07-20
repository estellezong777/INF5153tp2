package model;

import uqam.inf5153.gestionExamensMed.interf.IEvenement;
import uqam.inf5153.gestionExamensMed.interf.IObserver;

import java.util.ArrayList;

public class Evenement implements IEvenement {
    protected ArrayList<AbstractEcouteur> ecouteurList;
    private ArrayList<IObserver> observerList;

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

    // Observer = Notifieur
    public void notifierObserver(){
        for(IObserver observer:observerList){
            //notifierEcouteur = update   reponse == rdv / examenrdv
            observer.notifierEcouteur(reponse);
        }
    };
}
