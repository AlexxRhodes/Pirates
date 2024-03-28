package commande;

public class CaseEffetHP extends Case{
	Effets effet;
	
	public CaseEffetHP(Effets effet, int i) {
		super();
		this.caseSpecial = true;
		this.effet = effet;
		
		super.setNumCase(i);;
	}

	public static void hopital(Pirate p) {
//		System.out.println("\t\t\tHopital");
		if(p.getHP()<5) {
			p.setHP(p.getHP()+1);
			System.out.println("\t\t\t|");
			System.out.println("\t\tEffet :\t| Hôpital : +1HP");
			System.out.println("\t\t\t|\n");
		}else {
			System.out.println("\tHôpital : Mais vous avez déjà toute votre vie !\n");
		}
	}
	
	public static void coupDeFeu(Pirate p) {
//		System.out.println("\t\t\tCoup de feu");
		p.setHP(p.getHP()-1);
		System.out.println("\t\t\t|");
		System.out.println("\t\tEffet :\t| PAM ! -1HP");
		System.out.println("\t\t\t|\n");
	}
	
	public Effets getEffet() {
		return effet;
	}
}
