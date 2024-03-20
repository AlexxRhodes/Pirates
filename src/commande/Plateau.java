package commande;

import affichage.Affichage;

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
	
	public static Joueur existeGagnant(Joueur j1, Joueur j2) {
		Joueur winner = null;
		
		int posJ1 = j1.getPosition();
		int posJ2 = j2.getPosition();
		
		if(posJ1 >= 30) {
			winner = j1;
		}else if(posJ2 >= 30) {
			winner = j2;
		}else {
			winner = null;
		}
		return winner;
	}
	
	public static void tourJoueur(Joueur j, De de1, De de2) {
		de1.lancerDe();
    	de2.lancerDe();
    	Affichage.aff_lancerDe(de1.getValeur(), de2.getValeur());
    	
    	j.setPosition(j.getPosition()+(de1.getValeur()+de2.getValeur()));
    	Affichage.aff_changePos(j);
		
	}
}
