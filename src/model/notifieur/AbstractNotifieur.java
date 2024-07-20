package model.notifieur;

import model.AbstractEcouteur;
import model.Logger.Logger;
import uqam.inf5153.gestionExamensMed.interf.IObserver;
import uqam.inf5153.gestionExamensMed.vue.NotificationPanel;

import java.util.ArrayList;

public abstract class  AbstractNotifieur implements IObserver {
    protected ArrayList<AbstractEcouteur> ecouteurList;
    protected NotificationPanel notificationPanel;
    protected  Logger loggerConsole;

    protected  Logger loggerFile;
    public AbstractNotifieur(NotificationPanel notificationPanel, Logger loggerConsole) {
        this.notificationPanel = notificationPanel;
        this.loggerConsole = loggerConsole;

    }

    public  void notifierEcouteur(String reponse) {


       // triggerNotififaction();
    }
    //protected abstract void triggerNotififaction();
    public String tostring(String type){ return null;}
}
