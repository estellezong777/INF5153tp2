package laboratoire;

import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoireController;

import java.util.ArrayList;
import java.util.HashMap;

public class LaboController implements ILaboratoireController {


        private ArrayList<ILaboratoire> listLabo; // Liste des laboratoires situés au centre de soin

        private ArrayList<String> resultExamenlist; //Liste des resultats d'Examens

    /**
     * Une table de hachage est utilisée pour stocker la liste des demandes de rendez-vous.
     * Elle utilise le code du laboratoire comme clé et la valeur correspond aux informations
     * de la demande de rendez-vous dans ce laboratoire, y compris le numéro de rendez-vous,
     * le codePatient et la description d'Examen.
    */
    private HashMap<String, ArrayList<IDemandeRDV>> demandeRDVsMap = new HashMap<>();

        // Constructeur
        public LaboController() {
            //this.listDemandeRDV = new ArrayList<>();
          //  this.listRDVtraite = new ArrayList<>();
            this.listLabo = new ArrayList<>();
            this.resultExamenlist = new ArrayList<>();
        }

    @Override
    public ArrayList<ILaboratoire> getListLaboratoire() {
        return listLabo;
    }
    public void setListLabo(ArrayList<ILaboratoire> listLabo) {
        this.listLabo = listLabo;
    }


    /**
     * Cette méthode obtient la liste des informations de tous les rendez-vous demandés
     * dans un laboratoire spécifique avec le codeLab
    */
    @Override
    public ArrayList<IDemandeRDV> listDemandeRDV(String codeLab) {

        return demandeRDVsMap.get(codeLab);
    }

    // Cette méthode obtient le map de demande RDV du RDVController via appController
    public void recevoirToutDemandeRDV(HashMap<String, ArrayList<IDemandeRDV>> demandeRDVMap) {
        this.demandeRDVsMap = demandeRDVMap;
    }

    public void recevoirReponseResultExamen(ArrayList<String> resultExamenlist){
        this.resultExamenlist = resultExamenlist;

    }

    public HashMap<String, ArrayList<IDemandeRDV>> getDemandeRDVsMap() {
        return demandeRDVsMap;
    }

    //demandeRDVsMap{Pat000003={examen.RadiographieIRM@433c675d=laboratoire.Laboratoire@37f8bb67, examen.RadiographieRayonX@179d3b25=laboratoire.Laboratoire@37f8bb67}, Pat000002={examen.Echographie@254989ff=laboratoire.Laboratoire@49c2faae}, Pat000001={examen.AnalyseDeSang@76fb509a=laboratoire.Laboratoire@37f8bb67, examen.Myelogramme@300ffa5d=laboratoire.Laboratoire@37f8bb67, examen.AnalyseUrine@1f17ae12=laboratoire.Laboratoire@49c2faae, examen.AnalyseUrine@4d405ef7=laboratoire.Laboratoire@49c2faae, examen.AnalyseDeSang@5d099f62=laboratoire.Laboratoire@49c2faae}}
    //codeLaboLab000002


    /**
     * Cette méthode parcourt la liste des labos et chaque fois que nous obtenons le code d'un labo,
     * nous le comparons pour voir s'il y a une requête DemandeRdv pour ce labo dans la listeDemandeRdv.
     * Si c'est le cas, ajoutons cette demande de rendez-vous à la listeDemandeRdv de ce labo.
    */
    public void distribueDemandeRDV(){

            // Parcourt la liste des labos
        for (ILaboratoire labo: listLabo) {

            // Obtenons le codeLabo
            String codeLabo=labo.getCodeLaboratoire();

            // Obtenons tout les demande rendez-vous dans demandeRDVsMap
            ArrayList<IDemandeRDV> listDemandeRdv = demandeRDVsMap.get(codeLabo);

            // Si la listeDemandeRdv n'est pas vide, nous ajoutons cette liste dans à ce labo spécifique
            if(listDemandeRdv != null){
                labo.setListDemandeRDV(listDemandeRdv);
            }
        }
    }

    public ArrayList<String> getResultExamenlist() {
        return resultExamenlist;
    }
}



