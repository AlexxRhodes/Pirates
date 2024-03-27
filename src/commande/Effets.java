package commande;

public enum Effets{
	HOPITAL("Hôpital"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetHP.hopital(p);
        }
	},
	COUP_DE_FEU("Coup de feu"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetHP.coupDeFeu(p);
        }
	},
	PIEGE("Piège"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetPosition.retourCaseDepart(p);
        }
	},
	SWITCH("Switch"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetPosition.echangerPos(p);
        }
	},
	PRISON("Prison"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetPosition.bloquerPion(p);
        }
	},
	ESPOIR("Espoir"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetPosition.espererLiberation(p);
        }
	};
	
	private String nom;
	
	private Effets(String nom) {
		this.nom = nom;
	}
	
	public String getName() {
		return nom;
	}
	
	// Méthode abstraite pour effectuer l'effet
    public abstract void doEffect(Pirate p);
}