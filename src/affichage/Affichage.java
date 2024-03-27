package affichage;

import java.text.DecimalFormat;

import commande.*;

public class Affichage {
	//Déclaration de numCase (indice du tableau Case cases[])
	public int arg;
	static DecimalFormat nf = new DecimalFormat("00");
	
	//Constructeur
	public Affichage(int arg0) {
		super();
		this.arg = arg0;
		System.out.println("*** Initialisation de la console ***");
		System.out.println("------------------------------------");
		System.out.println("");
	}
	
	public static void aff_lancerDe(int de1, int de2) {
		System.out.println("Lancé de dé :");
		System.out.println("\tDé 1 : "+ de1);
		System.out.println("\tDé 2 : "+ de2 + "\t==> +" + (de1+de2));
	}
	
	public static void aff_start(Pirate j1, Pirate j2) {
		System.out.println("Début de la partie :");
		System.out.println("\tPion 1 : ");
		System.out.println("\t\tPosition : "+ j1.getPosition());
		System.out.println("\t\tCouleur : "+ j1.getCouleur());
		System.out.println("\tPion 2 : ");
		System.out.println("\t\tPosition : "+ j2.getPosition());
		System.out.println("\t\tCouleur : "+ j2.getCouleur());
		System.out.println("_________________________________________");
		System.out.println("");
	}

	public static void aff_changePos(Pirate j) {
		System.out.println(j.getNom() + " : ");
		System.out.println("\tPosition : "+ (j.getPosition()));
		System.out.println("_________________________________________");
		System.out.println("");
	}

	public static void aff_gagnant(Pirate winner) {
		System.out.println("VICTOIRE DE : " + winner.getNom());
		System.out.println("_________________________________________");
		System.out.println("");
	}
		
	public static void aff_plateau(Plateau plateau) {
		System.out.println("Plateau :");	
		
		for(int i=0; i<30; i++) {
			System.out.print("  "+nf.format(plateau.cases[i].getNumCase())+"   |");
			
			if(plateau.cases[i] instanceof CaseEffetHP) {
				System.out.println(" "+ ((CaseEffetHP) plateau.cases[i]).getEffet().getName()+" |");
			}else if(plateau.cases[i] instanceof CaseEffetPosition) {
				System.out.println(" "+ ((CaseEffetPosition)plateau.cases[i]).getEffet().getName()+" |");
			}else {
				System.out.println(" "+ plateau.cases[i].getCaseSpecial()+" |");
			}
		}		
		
		System.out.println("_________________________________________");
		System.out.println("");
	}

	public static void aff_casesSpe(int[] p) {
		System.out.println("Cases Spéciales : ");
		System.out.println("\tHopital : " + (p[0]));
		System.out.println("\tCoup de feu : " + (p[1]));
		System.out.println("\tPiège : " + (p[2]));
		System.out.println("\tSwitch : " + (p[3]));
		System.out.println("\tPrison : " + (p[4]));
		System.out.println("\tEspoir : 29");
		
		System.out.println("_________________________________________");
		System.out.println("");
	}


}
