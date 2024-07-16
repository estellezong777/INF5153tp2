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

    private HashMap<String, ArrayList<IDemandeRDV>> demandeRDVsMap = new HashMap<>();

        // Constructeur
        public LaboController() {
           // this.listResults = new ArrayList<>();
            this.listDemandeRDV = new ArrayList<>();
            this.listRDVtraite = new ArrayList<>();
            this.listLabo = new ArrayList<>();
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
}

//TODO 把 recevoirToutDemandeRDV 分开发给each labo , 用laboratoire de recevoir listDemandeRDV 接受
