package model.notifieur;

import model.AbstractEcouteur;
import uqam.inf5153.gestionExamensMed.vue.NotificationPanel;

public class NotifieurSMS extends AbstractNotifieur{


    public NotifieurSMS(NotificationPanel notificationPanel) {
        super(notificationPanel);
    }

    @Override
    public void notifierEcouteur(String reponse) {

    }



}
