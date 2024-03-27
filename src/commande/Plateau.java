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
		
		if(posJ1 >= 30) {
			winner = j1;
		}else if(posJ2 >= 30) {
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
		
		int NbCasesHP = 2;
		int NbCasePos = 3;
		int[] pos = new int[NbCasesHP + NbCasePos];
		
		Effets[] effetsHP = {Effets.HOPITAL, Effets.COUP_DE_FEU};
		Effets[] effetsPos = {Effets.PIEGE, Effets.SWITCH, Effets.PRISON};
		
		for(int i=0; i<pos.length; i++) {
			diff = true;
			int ran = (int) Math.floor(Math.random() *28);
			
			for(int j=0; j<=i; j++) {
				if(ran == pos[j]) {
					diff = false;
					i-=1;
				}
			}
			if(diff) {
				pos[i] = ran;
			}
		}
		
		for(int i=0; i<=(NbCasesHP+NbCasePos-1); i++) {
			if(i<NbCasesHP) {
				cases[pos[i]-1] = new CaseEffetHP(effetsHP[i], pos[i]);
			}else if(i>=NbCasesHP) {
				cases[pos[i]-1] = new CaseEffetPosition(effetsPos[i-NbCasesHP], pos[i]);
			}
		cases[28] = new CaseEffetPosition(Effets.ESPOIR, 29);
		}
		
		Affichage.aff_casesSpe(pos);
	}

}
