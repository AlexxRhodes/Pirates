package commande;

public class CaseEffetPosition extends Case{
	Effets effet;
	
	public CaseEffetPosition(Effets effet, int i) {
		super();
		this.caseSpecial = true;
		this.effet = effet;
		super.setNumCase(i);
	}

	public static void retourCaseDepart(Pirate p) {
//		System.out.println("\t\t\tPiège");
		p.setPosition(1);

		System.out.println("\t\t\t|");
		System.out.println("\t\tEffet :\t| Piège : Retour case départ ");
		System.out.println("\t\t\t|\n");
		
	}
	
	public static void echangerPos(Pirate p1, Pirate p2) {
		System.out.println("\t\t\t|");
		System.out.println("\t\tEffet :\t| Switch !");
		System.out.println("\t\t\t|\n");

		int temp = p1.getPosition();

		p1.setPosition(p2.getPosition());
		p2.setPosition(temp);
		
	}
	
	public static void bloquerPion(Pirate p) {
//		System.out.println("\t\t\tPrison");
	System.out.println("\t\t\t|");
	System.out.println("\t\tEffet :\t| Prison !");
	System.out.println("\t\t\t|\n");

	}
	
	public static void espererLiberation(Pirate p) {
//		System.out.println("\t\t\tEspoir");
		
		
	}
	
	public Effets getEffet() {
		return effet;
	}
}
