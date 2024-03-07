package commande;

public class Pion {
	//Déclaration des variables
	// position : position du pion sur la plateau (correspond à l'indice du tableau Case cases[position-1]"
	// couleur : enum (ROUGE ou BLEU)
	private int position;
	Couleur color;
	
	public Couleur getColor() {
		return color;
	}
}
