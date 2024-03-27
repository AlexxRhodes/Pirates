package commande;

public class Case {
	//Déclaration de numCase (indice du tableau Case cases[])
	public int numCase;
	public boolean caseSpecial;

	//Constructeur
	public Case() {
		this.numCase = 0;
		this.caseSpecial = false;
	}

	public void setNumCase(int numCase) {
		this.numCase = numCase;
	}

	public int getNumCase() {
		return numCase;
	}
	
	public void setCaseSpecial(char caseSpecial) {
		this.caseSpecial = true;
	}
	
	public boolean getCaseSpecial() {
		return caseSpecial;
	}
}
