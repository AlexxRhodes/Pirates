package commande;

import affichage.Affichage;

public class Jeu {
	//Déclaration du plateau
	public static Plateau plateau = new Plateau();
	//Déclaration des pions
	public static Pion p1 = new Pion(Couleur.BLEU);
	public static Pion p2 = new Pion(Couleur.ROUGE);
	//Décalaration des joueurs
	public static Pirate j1 = new Pirate("Alex", p1, 100);
	public static Pirate j2 = new Pirate("Benoît", p2, 100);
	//Décalaration du dé
	public static De de1 = new De();
	public static De de2 = new De();
	//Déclaration de l'affichage
	Affichage aff = new Affichage(0);
	
	
	public static void initialiserJeu() {
		//Initialisation des positions des joueurs
		j1.setPosition(1);
		j2.setPosition(1);
		Affichage.aff_start(j1, j2);
		//Initialisation des cases spéciales
		plateau.initialiserCasesSpeciales();
		Affichage.aff_plateau(plateau);
	}
	
	public static void lancerPartie() {
		boolean altern = true;
		
		//Boucle du jeu tant qu'il n'y a pas de gagnant
		while(Plateau.existeGagnant(j1, j2) == null) {
			if(altern) {
				tourPirate(j1);
				altern = !altern;
			}
			else {
				tourPirate(j2);
				altern = !altern;
			}
		}
		
		//Affichage du gagnant de la partie
		Affichage.aff_gagnant(Plateau.existeGagnant(j1, j2));
	}
	
	public static void tourPirate(Pirate p) {
		//Lancement des dés
		de1.lancerDe();
    	de2.lancerDe();
    	Affichage.aff_lancerDe(de1.getValeur(), de2.getValeur());
    	
    	//Déplacement du pion
    	p.setPosition(p.getPosition() + (de1.getValeur()+de2.getValeur()));
    	
    	if(p.getPosition()>=30) {
    		p.setPosition(30);
    	}else {
    		//Affectation des effets des cases spéciales
    		Case case_actuelle = plateau.getCases(p.getPosition()-1);
        	if(case_actuelle.getCaseSpecial()) {
        		if(case_actuelle instanceof CaseEffetHP) {
        			CaseEffetHP c = ((CaseEffetHP)case_actuelle);
        			c.getEffet().doEffect(p);
        		}else {
        			CaseEffetPosition c = ((CaseEffetPosition)case_actuelle);
        			c.getEffet().doEffect(p);
        		}
        	}
    	}

    	Affichage.aff_changePos(p);
    }

	public static void main(String Args[]) {
		//Initialisation des pions joueurs à 0
		initialiserJeu();
		
		//Boucle éxecutant le jeu
		lancerPartie();
    	
    }
}
