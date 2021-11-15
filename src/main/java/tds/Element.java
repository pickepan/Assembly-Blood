package tds;

public abstract class Element {
	protected String nom;
	protected String type;
	protected int deplacement;
	protected int ligne;
	protected int decalage;
	protected boolean statique = false;
	
	
	public Element(String nom, String type,int deplacement,int ligne,int decalage) {
		this.nom=nom;
		this.type=type;
		this.ligne=ligne;
		this.decalage=decalage;
		this.deplacement = deplacement;
	}

	public String getNom() {
		return nom;
	}
	
	public int getDeplacement() {
		return deplacement;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean getStatique() {
		return statique;
	}
	public void setStatique(boolean statique) {
		this.statique = statique;
	}
	
	public int getLigne() {
		return ligne;
	}
	
	public int getDecalage() {
		return decalage;
	}

	public void display() {
		System.out.println("line " + ligne + ":" + decalage + " | deplacement: "+deplacement +" | "+ nom + ":" + type);
	}
}
