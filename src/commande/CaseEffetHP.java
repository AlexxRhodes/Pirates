package commande;

public class CaseEffetHP extends Case{
	Effets effet;
	
	public CaseEffetHP(Effets effet, int i) {
		super();
		this.caseSpecial = true;
		this.effet = effet;
		
		super.setNumCase(i);;
	}

	public static void hopital(Pirate j) {
//		System.out.println("\t\t\tHopital");
	}
	
	public static void coupDeFeu(Pirate p) {
//		System.out.println("\t\t\tCoup de feu");
		
	}
	
	public Effets getEffet() {
		return effet;
	}
}
