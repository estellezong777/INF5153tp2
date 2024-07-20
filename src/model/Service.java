package model;

import java.util.ArrayList;

public class Service extends AbstractEcouteur {
    private String nomService;
    private String numService;
    private String emailService;
    private ArrayList<Medecin> listMedecinService;

    // Constructor
    public Service(String nomService, String numService, String emailService) {
        this.nomService = nomService;
        this.numService = numService;
        this.emailService = emailService;
        this.listMedecinService = new ArrayList<>();
    }


    // Utilisons un patron singleton pour générer un code unique pour le Service
    private static class GenerateurCodeService{
        private static Service.GenerateurCodeService generateurCodeService;
        private int counter;
        private GenerateurCodeService(){
            counter = 0;
        }

        public static GenerateurCodeService getInstance(){
            if (generateurCodeService == null){
                generateurCodeService = new GenerateurCodeService();
            }return generateurCodeService;
        }

        public String generate(){
            this.counter++;
            return "Pat" + String.format("%06d", counter);
        }
    }
}