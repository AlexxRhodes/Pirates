package commande;

import affichage.Affichage;

public class Jeu {
	
	//Déclaration du plateau
	public static Plateau plateau = new Plateau();
	//Déclaration des pions
	public static Pion p1 = new Pion(Couleur.BLEU);
	public static Pion p2 = new Pion(Couleur.ROUGE);
	//Décalaration des joueurs
	public static Pirate j1 = new Pirate("Alex", p1, 3);
	public static Pirate j2 = new Pirate("Benoît", p2, 3);
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
				if(!j1.isPrison()){
					tourPirate(j1);
					Affichage.aff_separation();
				}else{
					Affichage.aff_prison(j1);
				}
				nbTour++;
				checkJail(j1);
			}
			else if(nbTour%2 == 1){
				if(!j2.isPrison()){
					tourPirate(j2);
	
					checkDepassement();
					Affichage.aff_separation();
					Affichage.aff_finTour();
				}else{
					Affichage.aff_prison(j2);
				}
				nbTour++;
				checkJail(j2);
			}
		}
		
		//Affichage du gagnant de la partie
		Affichage.aff_gagnant(Plateau.existeGagnant(j1, j2), nbTour);
	}
	
	private static void checkJail(Pirate j12) {
		Case temp = plateau.getCases(j12.getPosition());

		boolean prison = false;

		
		if(!j12.isPrison()){
			if(temp instanceof CaseEffetPosition){
					if(((CaseEffetPosition)temp).getEffet() == Effets.PRISON){
						prison = true;
					}else{
						prison = false;
					}
			}else{
				prison = false;
			}
			j12.setPrison(prison);
		}else{
			j12.setPrison(false);
		}
	}

	public static void tourPirate(Pirate p) {
		//Lancement des dés
		de1.lancerDe();
    	//de2.lancerDe();
		de2.setValeur(0);
    	Affichage.aff_lancerDe(de1.getValeur(), de2.getValeur());
    	
    	
		int nextPos = p.getPosition()+(de1.getValeur()+de2.getValeur());
		//Déplacement du pion
		if(p.getPosition() == 29){
			p.setPosition(p.getPosition() - (de1.getValeur()+de2.getValeur()));
		}else{ 
			if(nextPos <= 30){
				p.setPosition(nextPos);
			}else if(nextPos > 30){
				p.setPosition(30-(nextPos-30));
			}
		}		
		
    	Affichage.aff_changePos(p);

    	//Affectation des effets des cases spéciales
    	Case case_actuelle = plateau.getCases(p.getPosition());
        if(case_actuelle.getCaseSpecial()) {
        	if(case_actuelle instanceof CaseEffetHP) {
        		CaseEffetHP c = ((CaseEffetHP)case_actuelle);
				c.getEffet().doEffect(p);
        	}else {
        		CaseEffetPosition c = ((CaseEffetPosition)case_actuelle);
				if(c.getEffet() == Effets.SWITCH){
					c.getEffet().doEffect(j1, j2);
				}else{
        			c.getEffet().doEffect(p);
				}
        	}
			System.out.println("");
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
