package affichage;

import java.text.DecimalFormat;

import commande.*;

public class Affichage {
	// Déclaration de numCase (indice du tableau Case cases[])
	public int arg;
	static DecimalFormat nf = new DecimalFormat("00");

	// Constructeur
	public Affichage(int arg0) {
		super();
		this.arg = arg0;
		System.out.println("*** Initialisation de la console ***");
		System.out.println("------------------------------------");
		System.out.println("");
	}

	public static void aff_start(Pirate j1, Pirate j2) {
		System.out.println("Début de la partie :");
		System.out.println("\tPion 1 : " + j1.getNom());
		System.out.println("\t\tPosition : " + j1.getPosition());
		System.out.println("\t\tCouleur : " + j1.getCouleur());
		System.out.println("\tPion 2 : " + j2.getNom());
		System.out.println("\t\tPosition : " + j2.getPosition());
		System.out.println("\t\tCouleur : " + j2.getCouleur());
		System.out.println("_________________________________________");
		System.out.println("");
	}

	public static void aff_plateau(Plateau plateau) {
		System.out.println("Plateau :");

		for (int i = 0; i < 30; i++) {
			System.out.print("  " + nf.format(plateau.cases[i].getNumCase()) + "   |");

			if (plateau.cases[i] instanceof CaseEffetHP) {
				System.out.println(" " + ((CaseEffetHP) plateau.cases[i]).getEffet().getName() + " |");
			} else if (plateau.cases[i] instanceof CaseEffetPosition) {
				System.out.println(" " + ((CaseEffetPosition) plateau.cases[i]).getEffet().getName() + " |");
			} else {
				System.out.println(" " + plateau.cases[i].getCaseSpecial() + " |");
			}
		}

		System.out.println("_________________________________________");
		System.out.println("");
	}

	public static void aff_lancerDe(int de1, int de2) {
		System.out.print("\nLancé de dé :");
		if (de2 > 0) {
			System.out.println("\tDé 1 : " + de1);
			System.out.println("\tDé 2 : " + de2);
		} else {
			System.out.println("\t +" + de1);
		}
	}

	public static void aff_changePos(Pirate j) {
		System.out.println(j.getNom() + " : ");
		System.out.println("\tPosition : " + (j.getPosition()) + "\tHP : " + j.getHP() + "\n");
	}

	public static void aff_gagnant(Pirate winner, int nbTour) {
		System.out.println("Fin en " + nbTour + " tours\n");
		System.out.println("\t\tVICTOIRE DE : " + winner.getNom());
		System.out.println("________________________________________________________");
		System.out.println("");
	}

	public static void aff_casesSpe(Case[] c) {
		System.out.println("Cases Spéciales : ");
		for(int i=0; i<c.length; i++){
			if(c[i] instanceof CaseEffetHP){
				System.out.println("\t" + ((CaseEffetHP)c[i]).getEffet().getName() + " : " + c[i].getNumCase());
			}else if(c[i] instanceof CaseEffetPosition){
				System.out.println("\t" + ((CaseEffetPosition)c[i]).getEffet().getName() + " : " + c[i].getNumCase());
			}
		}
		System.out.println("\tEspoir : 29");

		System.out.println("_________________________________________");
		System.out.println("");
	}

	public static void aff_depassement(Pirate pTete, Pirate pQueue) {
		System.out.println("\n\tLe joueur " + pTete.getNom() + " prend la tête");
		System.out.println("\t\t" + pQueue.getNom() + " perd 1HP !\n");

	}

	public static void aff_finTour() {
		System.out.println("________________________________________________________\n");
	}

	public static void aff_separation() {
		System.out.println("________________________________________________________");
	}

	public static void aff_prison(Pirate j) {
		aff_changePos(j);
		System.out.println("\t\tVOUS ÊTES EN PRISON");
		System.out.println("\t   VOUS JOUEREZ AU PROCHAIN TOUR\n");
		aff_separation();
	}

}
