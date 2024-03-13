package commande;

public class Plateau {
	//Déclaration du plateau de taille modifiable
	public int taille = 30;
	private Case[] cases = new Case[taille];
	
	//Constructeur
	public Plateau() {
		super();
		//Initialisation des numéros des cases
		for(int i=0; i<taille; i++) {
			cases[i] = new Case();
			cases[i].setNumCase(i+1);
		}
	}
}
