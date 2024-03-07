package commande;

public class Joueur {
	
	private String nom;
	private int HP;
	private Couleur couleur;
	private Pion pion;

	public Joueur(String name, Pion pion, int PointDeVie) {
		super();
		this.nom = name;
		this.couleur = pion.getColor();
		HP = PointDeVie;
	}
}
