package tds;

public class ElementVariable  extends Element{
	
	public ElementVariable(String nom, String type,int deplacement,int ligne, int decalage){
		super(nom, type, deplacement,ligne,decalage);
		if(deplacement == 0) {
			if(type.contentEquals("Integer")) {
				this.deplacement = 2;
			}
			else {//adresse
				this.deplacement = 2;
			}
		}
	}
}
