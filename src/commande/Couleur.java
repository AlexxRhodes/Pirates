package commande;

public enum Couleur{
	ROUGE(" couleur rouge "), BLEU(" couleur bleu ");
	
	private String nom;
	
	private Couleur(String nom) {
		this.nom = nom;
	}
	
	public String getName() {
		return nom;
	}
}