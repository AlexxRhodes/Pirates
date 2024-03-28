package commande;

import affichage.Affichage;

public class Jeu {
	//Déclaration du plateau
	public static Plateau plateau = new Plateau();
	//Déclaration des pions
	public static Pion p1 = new Pion(Couleur.BLEU);
	public static Pion p2 = new Pion(Couleur.ROUGE);
	//Décalaration des joueurs
	public static Pirate j1 = new Pirate("Alex", p1, 5);
	public static Pirate j2 = new Pirate("Benoît", p2, 5);
	//Décalaration du dé
	public static De de1 = new De();
	public static De de2 = new De();
	//Déclaration de l'affichage
	Affichage aff = new Affichage(0);
	//Meneur
	static int pirateEnTete = 1;
	static int lastPirateEnTete = 1;
	
	
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
		int nbTour = 0;
		
		//Boucle du jeu tant qu'il n'y a pas de gagnant
		while(Plateau.existeGagnant(j1, j2) == null) {
			//Alternation du tour de chaque joueur
			if(nbTour%2 == 0) {
				tourPirate(j1);
				nbTour++;
				Affichage.aff_separation();
			}
			else {
				tourPirate(j2);
				nbTour++;

		    	checkDepassement();
				Affichage.aff_separation();
				Affichage.aff_finTour();
			}
		}
		
		//Affichage du gagnant de la partie
		Affichage.aff_gagnant(Plateau.existeGagnant(j1, j2), nbTour);
	}
	
	public static void tourPirate(Pirate p) {
		//Lancement des dés
		de1.lancerDe();
    	// de2.lancerDe();
		de2.setValeur(0);
    	Affichage.aff_lancerDe(de1.getValeur(), de2.getValeur());
    	
    	
		int nextPos = p.getPosition()+(de1.getValeur()+de2.getValeur());
		//Déplacement du pion
		if(nextPos <= 28 || nextPos == 30){	
			p.setPosition(nextPos);
		}else if(p.getPosition() == 29){
			p.setPosition(p.getPosition() - (de1.getValeur()+de2.getValeur()));
		}else if(nextPos > 30){
			p.setPosition(30-(nextPos-30));
		}
		
		
    	Affichage.aff_changePos(p);

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
	
	public static void checkDepassement() {
		int posJ1 = j1.getPosition(), posJ2 = j2.getPosition();
    	
		//Vérification de dépassement
		if(posJ1 > posJ2) {
			pirateEnTete = 1;
			if(lastPirateEnTete!=pirateEnTete) {
				j2.setHP(j2.getHP()-1);
				lastPirateEnTete = pirateEnTete;
				Affichage.aff_depassement(j1, j2);
			}
		}else if(posJ1 < posJ2){
			pirateEnTete = 2;
			if(lastPirateEnTete!=pirateEnTete) {
				j1.setHP(j1.getHP()-1);
				lastPirateEnTete = pirateEnTete;
				Affichage.aff_depassement(j2, j1);
			}
		}else {
			pirateEnTete = 0;
		}
	}

	public static void main(String Args[]) {
		//Initialisation des pions joueurs à 0
		initialiserJeu();
		
		//Boucle éxecutant le jeu
		lancerPartie();
    	
    }
}
