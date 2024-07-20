package model.notifieur;

import model.AbstractEcouteur;
import model.Logger.Logger;
import model.RDV;
import uqam.inf5153.gestionExamensMed.vue.NotificationPanel;

import java.util.ArrayList;


public class NotifieurCourriel extends AbstractNotifieur{


    public NotifieurCourriel(NotificationPanel notificationPanel, Logger loggerConsole) {

        super(notificationPanel, loggerConsole);
    }

    public void notifierEcouteur(String reponse) {
        //this.ecouteurList = listEcouteurs;
        //notifier ecouteur
        String type=null;
        if( reponse.contains("dateRDV")){
            type = "RDV";
        }else if (reponse.contains("Result")){
            type = "Exam Result";
        }
        switch (type){
            case "RDV":
                notificationPanel.ajouteNotificationMsgPatient(this.tostring(type) + reponse);
                notificationPanel.ajouteNotificationMsgService(this.tostring(type) + reponse);
                //logger
                loggerConsole.info(this.tostring(type) + reponse);



                break;
            case "Exam Result":
                notificationPanel.ajouteNotificationMsgService(this.tostring(type) + reponse);
                notificationPanel.ajouteNotificationMsgMedecin(this.tostring(type) + reponse);
                //logger
                loggerConsole.info(this.tostring(type) + reponse);


                break;
            default:
                break;

        }

        //logger



    }

    @Override
    public String tostring(String type) {
        return "NotifieurCourriel+(" + type + "):  ";
    }
}
