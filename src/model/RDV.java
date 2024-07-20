package model;
public class RDV {
        private String codePatient;
        private String numDemande;
        private String dateRDV;
        private String heureRDV;

        // Constructeur
        public RDV(String codePatient, String numDemande, String dateRDV, String heureRDV) {
            this.codePatient = codePatient;
            this.numDemande = numDemande;
            this.dateRDV = dateRDV;
            this.heureRDV = heureRDV;
        }

        // Getters et Setters
        public String getCodePatient() {
            return codePatient;
        }

        public void setCodePatient(String codePatient) {
            this.codePatient = codePatient;
        }

        public String getNumDemande() {
            return numDemande;
        }

        public void setNumDemande(String numDemande) {
            this.numDemande = numDemande;
        }

        public String getDateRDV() {
            return dateRDV;
        }

        public void setDateRDV(String dateRDV) {
            this.dateRDV = dateRDV;
        }

        public String getHeureRDV() {
            return heureRDV;
        }

        public void setHeureRDV(String heureRDV) {
            this.heureRDV = heureRDV;
        }


    }



