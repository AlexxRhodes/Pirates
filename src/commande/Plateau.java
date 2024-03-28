package commande;

import affichage.Affichage;

//import affichage.Affichage;

public class Plateau {
	//Déclaration du plateau de taille modifiable
	public int taille = 30;
	public Case[] cases = new Case[taille];
	
	//Constructeur
	public Plateau() {
		super();
		//Initialisation des numéros des cases
		for(int i=0; i<taille; i++) {
			cases[i] = new Case();
			cases[i].setNumCase(i+1);
		}
	}
	
	public static Pirate existeGagnant(Pirate j1, Pirate j2) {
		Pirate winner = null;
		
		int posJ1 = j1.getPosition();
		int posJ2 = j2.getPosition();
		
		if(posJ1 >= 30  || j2.getHP()<=0) {
			winner = j1;
		}else if(posJ2 >= 30 || j1.getHP()<=0) {
			winner = j2;
		}else {
			winner = null;
		}
		return winner;
	}
	
	public Case getCases(int numCase) {
		return cases[numCase];
	}
	
	public void initialiserCasesSpeciales() {
		boolean diff = true;
		
		int NbCasesHP = 4;
		int NbCasePos = 3;
		int[] pos = new int[NbCasesHP + NbCasePos];
		//Tableau comprenant les effets à appliquer sur le plateau
		Effets[] effetsHP = {Effets.HOPITAL, Effets.COUP_DE_FEU, Effets.COUP_DE_FEU, Effets.COUP_DE_FEU};
		Effets[] effetsPos = {Effets.PIEGE, Effets.SWITCH, Effets.PRISON, Effets.ESPOIR};
		
		for(int i=0; i<pos.length; i++) {
			diff = true;
			int ran = (int) Math.floor(Math.random() *28);
			//Vérification absence de double effet sur une case
			for(int j=0; j<=i; j++) {
				if(ran == pos[j]) {
					diff = false;
					i-=1;
				}
			}
			//Affectation de la case sélectionnée comme étant spéciale
			if(diff) {
				pos[i] = ran;
			}
		}
		//Boucle affectant chaque case spéciale à un effet
		for(int i=0; i<=(NbCasesHP+NbCasePos-1); i++) {
			//D'abord les cases affectant les HP puis la position
			if(i<NbCasesHP) {
				cases[pos[i]-1] = new CaseEffetHP(effetsHP[i], pos[i]);
			}else if(i>=NbCasesHP) {
				cases[pos[i]-1] = new CaseEffetPosition(effetsPos[i-NbCasesHP], pos[i]);
			}
		//Affectation de l'avant-dernière case à l'effet Espoir
		cases[28] = new CaseEffetPosition(Effets.ESPOIR, 29);
		}
		//Affichage des cases spéciales
		Affichage.aff_casesSpe(pos);
	}

}
