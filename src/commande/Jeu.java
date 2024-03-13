package commande;

import affichage.Affichage;

public class Jeu {
	public static void lancerPartie(Joueur j1, Joueur j2) {
		j1.getPion().setPosition(1);
		j2.getPion().setPosition(1);
		Affichage.aff_start(j1, j2);
	}

	public static Joueur existeGagnant(Joueur j1, Joueur j2) {
		Joueur winner = null;
		Pion p1 = j1.getPion();
		Pion p2 = j2.getPion();
		
		int posJ1 = p1.getPosition();
		int posJ2 = p2.getPosition();
		
		if(posJ1==30) {
			winner = j1;
		}else if(posJ2==30) {
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
    	
    	j.getPion().setPosition(j.getPion().getPosition()+(de1.getValeur()+de2.getValeur()));
    	Affichage.aff_changePos(j);
		
	}
	public static void main(String Args[]) {
		//Déclaration du plateau
		Plateau plateau = new Plateau();
		//Déclaration des pions
		Pion p1 = new Pion(Couleur.BLEU);
		Pion p2 = new Pion(Couleur.ROUGE);
	    //Décalaration des joueurs
		Joueur j1 = new Joueur("Alex", p1, 100);
		Joueur j2 = new Joueur("Benoît", p2, 100);
		//Décalaration du dé
		De de1 = new De();
		De de2 = new De();
		//Déclaration de l'affichage
		Affichage aff = new Affichage(0);
		
		boolean altern = true;
		
		
		lancerPartie(j1, j2);
		
		//Boucle éxecutant le jeu
		while(existeGagnant(j1, j2) != null)
			if(altern) {
				tourJoueur(j1, de1, de2);
				altern = !altern;
			}
			else {
				tourJoueur(j2, de1, de2);
				altern = !altern;
			}
			
    	
    }
	


}
