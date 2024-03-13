package commande;

public class De {
	private int valeur;
	
	public void lancerDe() {
		double d = (Math.random()*6)+1;
		setValeur((int)d);
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}
