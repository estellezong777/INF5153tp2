package laboratoire;

import uqam.inf5153.gestionExamensMed.interf.IDemandeRDV;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoire;
import uqam.inf5153.gestionExamensMed.interf.ILaboratoireController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.DemandeRDV;

public class LaboController implements ILaboratoireController {

        //private ArrayList<ResultExamen> listResults;
        private ArrayList<IDemandeRDV> listDemandeRDV;
        private ArrayList<String> listRDVtraite;

        private ArrayList<ILaboratoire> listLabo;

        private ArrayList<String> resultExamenlist;

    private HashMap<String, ArrayList<IDemandeRDV>> demandeRDVsMap = new HashMap<>();

        // Constructeur
        public LaboController() {
           // this.listResults = new ArrayList<>();
            this.listDemandeRDV = new ArrayList<>();
            this.listRDVtraite = new ArrayList<>();
            this.listLabo = new ArrayList<>();
            this.resultExamenlist = new ArrayList<>();
        }



    @Override
    public ArrayList<ILaboratoire> getListLaboratoire() {
            //TODO GET LISTLABO FROM APPCONTROLEERE

        return listLabo;
    }



    @Override
    public ArrayList<IDemandeRDV> listDemandeRDV(String codeLab) {

        return demandeRDVsMap.get(codeLab);
    }

    public void recevoirToutDemandeRDV(HashMap<String, ArrayList<IDemandeRDV>> demandeRDVMap) {
            //把所有的appcontroller（rdvcontroller的hashmap）通过appController接过来
        //String = codeLab
        this.demandeRDVsMap = demandeRDVMap;
    }

    public void recevoirReponseResultExamen(ArrayList<String> resultExamenlist){
        this.resultExamenlist =resultExamenlist;

    }



    public void setListLabo(ArrayList<ILaboratoire> listLabo) {
        this.listLabo = listLabo;
    }

    public HashMap<String, ArrayList<IDemandeRDV>> getDemandeRDVsMap() {
        return demandeRDVsMap;
    }

    //demandeRDVsMap{Pat000003={examen.RadiographieIRM@433c675d=laboratoire.Laboratoire@37f8bb67, examen.RadiographieRayonX@179d3b25=laboratoire.Laboratoire@37f8bb67}, Pat000002={examen.Echographie@254989ff=laboratoire.Laboratoire@49c2faae}, Pat000001={examen.AnalyseDeSang@76fb509a=laboratoire.Laboratoire@37f8bb67, examen.Myelogramme@300ffa5d=laboratoire.Laboratoire@37f8bb67, examen.AnalyseUrine@1f17ae12=laboratoire.Laboratoire@49c2faae, examen.AnalyseUrine@4d405ef7=laboratoire.Laboratoire@49c2faae, examen.AnalyseDeSang@5d099f62=laboratoire.Laboratoire@49c2faae}}
    //codeLaboLab000002
    public void distribueDemandeRDV(){
        for (ILaboratoire labo: listLabo) {
            String codeLabo=labo.getCodeLaboratoire();
            ArrayList<IDemandeRDV> listDemandeRdv = demandeRDVsMap.get(codeLabo);
            System.out.println("          ");
            System.out.println("demandeRDVsMap"+demandeRDVsMap);
            System.out.println("codeLabo"+codeLabo);
            System.out.println("listDemandeRdv"+listDemandeRdv);
            if(listDemandeRdv != null){
                labo.setListDemandeRDV(listDemandeRdv);
                System.out.println("listDemandeRdv after set"+listDemandeRdv);
            }
        }
    }

    public ArrayList<String> getResultExamenlist() {
        return resultExamenlist;
    }
}

//TODO 把 recevoirToutDemandeRDV 分开发给each labo , 用laboratoire de recevoir listDemandeRDV 接受


