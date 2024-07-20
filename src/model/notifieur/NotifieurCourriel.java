package model.notifieur;

import model.AbstractEcouteur;
import model.Logger.Logger;
import model.RDV;
import uqam.inf5153.gestionExamensMed.vue.NotificationPanel;



public class NotifieurCourriel extends AbstractNotifieur{


    public NotifieurCourriel(NotificationPanel notificationPanel, Logger loggerConsole) {

        super(notificationPanel, loggerConsole);
    }

    public void notifierEcouteur(String reponse) {
        String type=null;
        if( reponse.contains("dateRDV")){
            type = "RDV";
        }else if (reponse.contains("Result")){
            type = "Exam Result";
        }
        switch (type){
            case "RDV":
                notificationPanel.ajouteNotificationMsgPatient("Réponse type est : "+ this.tostring(type) + reponse);
                notificationPanel.ajouteNotificationMsgService("Réponse type est : "+this.tostring(type) + reponse);
                loggerConsole.info("Réponse type est : "+ this.tostring(type) + reponse);
                break;

            case "Exam Result":
                notificationPanel.ajouteNotificationMsgService("Réponse type est : "+ this.tostring(type) + reponse);
                notificationPanel.ajouteNotificationMsgMedecin("Réponse type est : "+this.tostring(type) + reponse);
                loggerConsole.info("Réponse type est : "+this.tostring(type) + reponse);
                break;
            default:
                break;

        }

    }

    @Override
    public String tostring(String type) {
        return "NotifieurCourriel+(" + type + "): ";
    }
}
