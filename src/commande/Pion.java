package commande;

public class Pion {
	//Déclaration des variables
	// position : position du pion sur la plateau (correspond à l'indice du tableau Case cases[position-1]"
	// couleur : enum (ROUGE ou BLEU)
	Couleur color;
	
	public Pion(Couleur color) {
		super();
		this.color = color;
	}
	
	public Couleur getColor() {
		return color;
	}

	public void setColor(Couleur color) {
		this.color = color;
	}
}
