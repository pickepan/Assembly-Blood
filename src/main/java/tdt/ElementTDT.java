package tdt;

import java.util.ArrayList;

import tds.ElementMethod;
import tds.ElementVariable;
import tds.Element;

public class ElementTDT {
	private String type;
	private String typeHeritage;
	private ArrayList<ElementVariable> listeAttribut;
	private ArrayList<ElementMethod> listeMethode;
	
	public ElementTDT(String type) {
		this.type = type;
		typeHeritage = null;
		listeAttribut = new ArrayList<ElementVariable>();
		listeMethode = new ArrayList<ElementMethod>();
	}
	public Element get(String nature, String attributOuMethode) {
		if(nature.equals("METHOD")){
			for(Element e : listeMethode) {
				if(e.getNom().equals(attributOuMethode)) {
					return e;
				}
			}
		}
		else{
			for(Element e : listeAttribut) {
				if(e.getNom().equals(attributOuMethode)) {
					return e;
				}
			}
		}
		return null;
	}

	public String getType() {
		return type;
	}

	public String getTypeHeritage() {
		return typeHeritage;
	}
	public void setTypeHeritage(String typeHeritage) {
		this.typeHeritage = typeHeritage;
	}
	
	public void add(Element e) {
		if(e != null)
			if(e instanceof ElementMethod) 
				listeMethode.add((ElementMethod) e);
			else 
				listeAttribut.add((ElementVariable) e);
	}


	public ArrayList<ElementVariable> getListeAttribut() {
		return listeAttribut;
	}
	public ArrayList<ElementMethod> getListeMethode() {
		return listeMethode;
	}
	public void display() {
		System.out.println(getType()+(getTypeHeritage()==null?"":" extends "+getTypeHeritage())+" {");
		for(ElementVariable elem : getListeAttribut()) {

			System.out.println(" "+(elem.getStatique()?"static ":"")+elem.getNom()+" : "+elem.getType());
		}
		for(ElementMethod elem : getListeMethode()) {

			System.out.println(" "+elem.getNom()+elem.getParam().toString()+" : "+elem.getType());
		}
		System.out.println(" }");
	}
}
