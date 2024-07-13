package uqam.inf5153.gestionExamensMed.testModel;

import java.util.ArrayList;
import java.util.Hashtable;

import uqam.inf5153.gestionExamensMed.interf.IExaMedicalHandler;
import uqam.inf5153.gestionExamensMed.interf.IExamenMedical;
import uqam.inf5153.gestionExamensMed.interf.IPatient;

public class ExaMedHandler implements IExaMedicalHandler {

    private static Generateur generateur = new Generateur() ;

    private ArrayList<IPatient> patientList ;

    private Hashtable<String , ArrayList<IExamenMedical>> examemPrescritTable ;


    public ExaMedHandler() {
        patientList = new  ArrayList<IPatient>() ;
        examemPrescritTable = new Hashtable<>()  ;

        defaultModelInitialisation() ;
    }
    @Override
    public ArrayList<IPatient> examPatientList() {
        // TODO Auto-generated method stub
        return patientList;
    }

    @Override
    public ArrayList<IExamenMedical> examenPrescritList(String codePatient) {
        return examemPrescritTable.get(codePatient) ;
    }

    /**
     * Création des prescriptions d'examens fictifs
     *
     *
     */

    // Use function in appcontroller?
    public void defaultModelInitialisation() {
        DefaultPatient p1 = new DefaultPatient("ABC110" , "Alice") ;
        DefaultPatient p2 = new DefaultPatient("ALL120" , "Bob") ;
        patientList.add(p1) ;
        patientList.add(p2) ;

        ArrayList<IExamenMedical> examensList1 = new ArrayList<IExamenMedical>() ;
        DefaultExamenMedical examen ;
        examen = new DefaultExamenMedical(generateur.generate(),  ConstanteExamen.ANALYSE_SANG) ;
        examen.addExamenParametre(ConstanteExamen.FSC);
        examen.addExamenParametre(ConstanteExamen.TSH);
        examensList1.add(examen);

        examen = new DefaultExamenMedical(generateur.generate(), ConstanteExamen.Endoscopie) ;
        examen.addExamenParametre(ConstanteExamen.OESOPHAGE);
        examensList1.add(examen);

        examen = new DefaultExamenMedical(generateur.generate(), ConstanteExamen.Echographie) ;
        examen.addExamenParametre(ConstanteExamen.OBSTETRICALE);
        examensList1.add(examen);

        String codeP1 = patientList.get(0).getCodePatient() ;
        examemPrescritTable.putIfAbsent(codeP1, examensList1) ;

        // Examen du Patient 2
        ArrayList<IExamenMedical> examensList2 = new ArrayList<IExamenMedical>() ;
        examen = new DefaultExamenMedical(generateur.generate(), ConstanteExamen.ExamenThyroide) ;
        examensList2.add(examen);

        DefaultExamenMedical examenComposant ;
        examenComposant = new DefaultExamenMedical(generateur.generate(), ConstanteExamen.Echographie) ;
        examenComposant.addExamenParametre(ConstanteExamen.THYROIDE);
        examen.addExamenChild(examenComposant);

        examenComposant  = new DefaultExamenMedical(generateur.generate(), ConstanteExamen.ExamenAnemie) ;
        examen.addExamenChild(examenComposant);


        DefaultExamenMedical examenComposant2 ;
        examenComposant2 = new DefaultExamenMedical(generateur.generate(), ConstanteExamen.ANALYSE_SANG) ;
        examenComposant2.addExamenParametre(ConstanteExamen.FSC);
        examenComposant.addExamenChild(examenComposant2);

        examenComposant2 = new DefaultExamenMedical(generateur.generate(), ConstanteExamen.Myelogramme) ;
        examenComposant.addExamenChild(examenComposant2);

        examenComposant2 = new DefaultExamenMedical(generateur.generate(), ConstanteExamen.AnalyseUrine) ;
        examenComposant2.addExamenParametre(ConstanteExamen.PROTEINURE);
        examenComposant2.addExamenParametre(ConstanteExamen.GLYCOSURIE);
        examenComposant.addExamenChild(examenComposant2);


        examenComposant  = new DefaultExamenMedical(generateur.generate(), ConstanteExamen.ANALYSE_SANG) ;
        examenComposant.addExamenParametre(ConstanteExamen.TSH);
        examen.addExamenChild(examenComposant);



//		 examen = new DefaultExamenMedical(ConstanteExamen.Myelogramme) ;
//		 examensList2.add(examen);
        examen = new DefaultExamenMedical(generateur.generate(), ConstanteExamen.RadioIRM) ;
        examen.addExamenParametre(ConstanteExamen.CERVEAU);
        examensList2.add(examen);

        String codeP2 = patientList.get(1).getCodePatient() ;
        examemPrescritTable.putIfAbsent(codeP2, examensList2) ;

    }


    private static class Generateur {
        private int cpt = 0 ;
        private Generateur() {

        }
        public int generate() {
            cpt++ ;
            return cpt ;
        }
    }
}
