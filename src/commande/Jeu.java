package commande;

import affichage.Affichage;

public class Jeu {
	//Déclaration du plateau
	Plateau plateau = new Plateau();
	//Déclaration des pions
	static Pion p1 = new Pion(Couleur.BLEU);
	static Pion p2 = new Pion(Couleur.ROUGE);
	//Décalaration des joueurs
	static Joueur j1 = new Joueur("Alex", p1, 100);
	static Joueur j2 = new Joueur("Benoît", p2, 100);
	//Décalaration du dé
	static De de1 = new De();
	static De de2 = new De();
	//Déclaration de l'affichage
	Affichage aff = new Affichage(0);
	
	public static void initialiserJeu(Joueur j1, Joueur j2) {
		j1.setPosition(1);
		j2.setPosition(1);
		Affichage.aff_start(j1, j2);
	}
	
	public static void lancerPartie(Joueur j1, Joueur j2, De de1, De de2) {
		boolean altern = true;
		
		//Boucle du jeu tant qu'il n'y a pas de gagnant
		while(Plateau.existeGagnant(j1, j2) == null) {
			if(altern) {
				Plateau.tourJoueur(j1, de1, de2);
				altern = !altern;
			}
			else {
				Plateau.tourJoueur(j2, de1, de2);
				altern = !altern;
			}
		}
		
		//Affichage du gagnant de la partie
		Affichage.aff_gagnant(Plateau.existeGagnant(j1, j2));
	}


	public static void main(String Args[]) {
		//Initialisation des pions joueurs à 0
		initialiserJeu(j1, j2);
		
		//Boucle éxecutant le jeu
		lancerPartie(j1, j2, de1, de2);
    	
    }
}
