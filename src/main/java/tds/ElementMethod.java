package tds;

import java.util.ArrayList;

public class ElementMethod extends Element {

	private ArrayList<String> parametres;
	
	public ElementMethod(String nom, String type, int deplacement,int ligne,int decalage) {
		super(nom, type, deplacement,ligne,decalage);
		if(deplacement == 0) {
			this.deplacement = 2;
		}
		parametres=new ArrayList<String>();
	}
	
	public void addParameter(String param) {
		parametres.add(param);
	}
	
	public ArrayList<String> getParam(){
		return parametres;
	}

	public int getParamNumber(){return parametres.size(); }
}
