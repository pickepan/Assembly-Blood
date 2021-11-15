package tdt;

import java.util.ArrayList;

import objet.ElementObjet;
import tds.Element;
import tds.ElementMethod;


public class TDT {
	private ArrayList<ElementTDT> table;
	
	public TDT() {
		table = new ArrayList<ElementTDT>();

		ElementTDT elemInt = new  ElementTDT("Integer");
		ElementMethod eInt = new ElementMethod("toString", "String", 0, 0, 0);
		elemInt.add(eInt);
		table.add(elemInt);

		ElementTDT elem = new ElementTDT("String");
		ElementMethod e = new ElementMethod("print", null, 0, 0, 0);
		ElementMethod e1 = new ElementMethod("println", null, 0, 0, 0);
		elem.add(e);
		elem.add(e1);
		table.add(elem);
	}

	public ArrayList<ElementTDT> getTable() {
		return table;
	}

	public void addType(ElementTDT e) {
		table.add(e);
	}
	public String getTypeAttributFonction(ElementObjet obj, int index, int indexMax, String type, String res) {
		res = type;
		if(index < obj.getListeAttributOuParam().size() && index < indexMax)
			if(obj.getListeAttributOuParam().get(index).getNature().contentEquals("Attribut"))
				res = getTypeAttributFonction(obj,index+1, indexMax,get(type, "attribut", obj.getListeAttributOuParam().get(index).getNom()).getType(), res);
			else
				res = getTypeAttributFonction(obj,index+1, indexMax,get(type, "METHOD", obj.getListeAttributOuParam().get(index).getNom()).getType(), res);
		return res;
	}
	public ElementTDT getType(String type) {
		for(ElementTDT e : table){
			if(type.contentEquals(e.getType()))
				return e;
		}
		return null; //type not found
	}
	
	//recherche une fonction ou un attribut dans la definition d'un type
	//si il existe renvoie la definition pour etre utilise dans un controle semantique
	//sinon renvoie null
	public Element get(String type, String nature, String attributOuMethode) {
		//System.out.println(type+" "+attributOuMethode);
		ElementTDT elem = getType(type);
		if(elem == null) {
			return null;
		}
		Element e = elem.get(nature, attributOuMethode);
		if(e == null) {
			if(elem.getTypeHeritage() == null) {
				return null;
			}
			return get(elem.getTypeHeritage(),nature, attributOuMethode);
		}
		return e;
	}
	//recherche une fonction ou un attribut dans la definition d'un type et de ses classe heritee
	//renvoie le type ou la premiere occurence est contenue
	//sinon renvoie null
	public String getTypeMethode(String type,String attributOuMethode) {
		//System.out.println(type+" "+attributOuMethode);
		ElementTDT elem = getType(type);
		if(elem == null) 
			return null;
		for(Element e: elem.getListeMethode()) {
			if(e.getNom().contentEquals(attributOuMethode))
				return elem.getType();
		}
		if(elem.getTypeHeritage() == null)
			return null;
		return getTypeMethode(elem.getTypeHeritage(),attributOuMethode);
	}
	public void display(){
		System.out.println("\n-----------------------------");
		System.out.println("Display of type table");
		for(ElementTDT e : this.getTable()) {
			e.display();
		}
		System.out.println("-----------------------------");
	}
}
