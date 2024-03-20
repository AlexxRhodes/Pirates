package affichage;

import commande.Joueur;

public class Affichage {
	//Déclaration de numCase (indice du tableau Case cases[])
	public int arg;
	
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
		System.out.println("\tDé 2 : "+ de2);
	}
	
	public static void aff_start(Joueur j1, Joueur j2) {
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

	public static void aff_changePos(Joueur j) {
		System.out.println(j.getNom() + " : ");
		System.out.println("\tPosition : "+ j.getPosition());
		System.out.println("_________________________________________");
		System.out.println("");
	}

	public static void aff_gagnant(Joueur winner) {
		System.out.println("VICTOIRE DE : " + winner.getNom());
		System.out.println("_________________________________________");
		System.out.println("");
	}

}
