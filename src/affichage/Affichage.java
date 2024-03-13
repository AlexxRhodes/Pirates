package affichage;

import commande.Joueur;
import commande.Pion;

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
		System.out.println("\t\tPosition : "+ j1.getPion().getPosition());
		System.out.println("\t\tCouleur : "+ j1.getPion().getColor());
		System.out.println("\tPion 2 : ");
		System.out.println("\t\tPosition : "+ j2.getPion().getPosition());
		System.out.println("\t\tCouleur : "+ j2.getPion().getColor());
	}

	public static void aff_changePos(Joueur j) {
		System.out.println("Début de la partie :");
		System.out.println(j.getNom() + " : ");
		System.out.println("\tPosition : "+ j.getPion().getPosition());
	}

}
