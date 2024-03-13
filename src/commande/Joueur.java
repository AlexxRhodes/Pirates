package commande;

public class Joueur {
	//Déclaration des variables:
	// nom : nom du joueur
	// HP : point de vie du joueur
	// couleur : enum ROUGE ou BLEU
	// pion : pion rattaché au joueur 
	private String nom;
	private int HP;
	private Couleur couleur;
	private Pion pion;
	
	//Constructeur
	public Joueur(String name, Pion pion, int PointDeVie) {
		super();
		this.nom = name;
		this.couleur = pion.getColor();
		HP = PointDeVie;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Pion getPion() {
		return pion;
	}

	public void setPion(Pion pion) {
		this.pion = pion;
	}
}
