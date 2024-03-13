//package commande;
//
//import affichage.Affichage;
//
//public class Main {
//	public static void main(String Args[]) {
//		//Déclaration du plateau
//		Plateau plateau = new Plateau();
//		//Déclaration des pions
//		Pion p1 = new Pion(Couleur.BLEU);
//		Pion p2 = new Pion(Couleur.ROUGE);
//	    //Décalaration des joueurs
//		Joueur j1 = new Joueur("Alex", p1, 100);
//		Joueur j2 = new Joueur("Benoît", p2, 100);
//		//Décalaration du dé
//		De de1 = new De();
//		De de2 = new De();
//		//Déclaration de l'affichage
//		Affichage aff = new Affichage(0);
//		//Déclaration du jeu
//		Jeu jeu = new Jeu();
//		
//		boolean altern = true;
//		
//		
//		jeu.lancerPartie(p1, p2);
//		
//		//Boucle éxecutant le jeu
//		while(!jeu.existeGagnant(j1, j2))
//			if(altern) {
//				jeu.tourJoueur(j1);
//				altern = !altern;
//			}
//			else {
//				jeu.tourJoueur(j2);
//				altern = !altern;
//			}
//			
//    	de1.lancerDe();
//    	de2.lancerDe();
//    	Affichage.aff_lancerDe(de1.getValeur(), de2.getValeur());
//    }
//}
