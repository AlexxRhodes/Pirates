package commande;

public class Pirate {
	//Déclaration des variables:
	// nom : nom du Pirate
	// HP : point de vie du Pirate
	// couleur : enum ROUGE ou BLEU
	// pion : pion rattaché au Pirate 
	private String nom;
	private int HP;
	private Couleur couleur;
	private int position;
	private Pion pion;
	private boolean prison;
	
	public boolean isPrison() {
		return prison;
	}

	public void setPrison(boolean prison) {
		this.prison = prison;
	}

	//Constructeur
	public Pirate(String name, Pion pion, int PointDeVie) {
		this.nom = name;
		this.couleur = pion.getColor();
		HP = PointDeVie;
		this.prison = false;
	}
	
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
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

	public int getHP() {
		return HP;
	}
	
	public void setHP(int hP) {
		HP = hP;
	}

	public Couleur getCouleur() {
		return couleur;
	}

}
