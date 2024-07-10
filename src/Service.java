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
}