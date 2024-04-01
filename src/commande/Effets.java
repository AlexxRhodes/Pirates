package commande;

public enum Effets{
	HOPITAL("Hôpital"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetHP.hopital(p);
        }
        @Override
        public void doEffect(Pirate p1, Pirate p2) {}
	},
	COUP_DE_FEU("Coup de feu"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetHP.coupDeFeu(p);
        }
        @Override
        public void doEffect(Pirate p1, Pirate p2) {}
	},
	PIEGE("Piège"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetPosition.retourCaseDepart(p);
        }
        @Override
        public void doEffect(Pirate p1, Pirate p2) {}
	},
	SWITCH("Switch"){
        @Override
        public void doEffect(Pirate p) {}
        @Override
        public void doEffect(Pirate p1, Pirate p2) {
            // Implémentation de l'effet HP
            CaseEffetPosition.echangerPos(p1, p2);
        }
	},
	PRISON("Prison"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetPosition.bloquerPion(p);
        }
        @Override
        public void doEffect(Pirate p1, Pirate p2) {}
	},
	ESPOIR("Espoir"){
        @Override
        public void doEffect(Pirate p) {
            // Implémentation de l'effet HP
            CaseEffetPosition.espererLiberation(p);
        }
        @Override
        public void doEffect(Pirate p1, Pirate p2) {}
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
    public abstract void doEffect(Pirate p1, Pirate p2);
}