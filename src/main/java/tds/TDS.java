package tds;

import java.util.ArrayList;

import antlr.generatedClasses.GrammaireParser;



public class TDS {
	private int num_region;
	private int num_imbric;
	public ArrayList<Element> table;
	private TDS mere;
	private ArrayList<TDS> filles;
	
	public TDS (int region, int imbric,TDS mere) {
		num_region=region;
		num_imbric=imbric;
		this.mere=mere;
		table = new ArrayList<Element>();
		filles = new ArrayList<>(); //automatic instantiation to avoid null pointer exception
	}
	public Element getByNameCurrentTable(String str, int nature) {
		Element elem = null;
		for(Element e : table) { //check in the table
			if(e.getNom().contentEquals(str)) {
				if ((nature == GrammaireParser.PARAM
						|| nature == GrammaireParser.ATTRIBUT
						|| nature == GrammaireParser.VARIABLE
						|| nature == GrammaireParser.VARIABLE_LOCALE)
						&& e instanceof ElementVariable) {
					elem = e;
					
				}
				else if (nature == GrammaireParser.METHOD && e instanceof ElementMethod)
					elem = e;
			}
		}
		return elem;
	}
	public Pair<Element, Integer> getByName(String str, int nature, boolean isInAMethod) {
		Element elem = null;
		for(Element e : table) { //check in the table
			if(e.getNom().contentEquals(str))
				if((nature == GrammaireParser.PARAM 
				||nature == GrammaireParser.ATTRIBUT 
				|| nature == GrammaireParser.VARIABLE 
				|| nature == GrammaireParser.VARIABLE_LOCALE) 
						&& e instanceof ElementVariable)
					elem = e;
				else if(nature == GrammaireParser.METHOD && e instanceof ElementMethod)
					elem = e;
		}
		if(elem != null) { // a result has been found in the the table
			Pair<Element, Integer> resultat = new Pair<Element, Integer>(elem, num_imbric);
			return resultat;
		}
		//on est revenu a root
		//ou num_imbric est errone
		if(num_imbric <= 1) 
			return null;
		if(!isInAMethod || (isInAMethod && num_imbric>2))	{	// WTF la condition est broken NON elle est bonne et c'est important qu'elle soit comme �a 
			return mere.getByName(str, nature, isInAMethod); // check in mother table
		}
		return null;
	}

	public boolean hasConstructor(String s){
		if(!Character.isUpperCase(s.charAt(0))){
			return false;
		}
		else{
			for(Element e : table){
				if(e instanceof ElementMethod){
					if(Character.isUpperCase(e.getNom().charAt(0))){
						return true;
					}
				}
			}
			return false;
		}
	}
	public int getDeplacementAllouer() {
		int  i;
		for(i=0; i<table.size();i++) {
			if(table.get(i).getDeplacement()>0){
				break;
			}
		}
		return (table.size()-i)*2;
	}
	
	//legacy function -> pas forcement utile
	public ArrayList<String> keySet(){
		ArrayList<String> resultat = new ArrayList<String>();
		for(Element entry : table){
			resultat.add(entry.getNom());
		}
		return resultat;
	}
	
	public void addElement(Element e) {
		int size = table.size();
		if(size != 0)
			if(table.get(size-1).deplacement > 0)
				e.deplacement = e.deplacement + table.get(size-1).deplacement;
		table.add(e);
	}
	
	public int getImbric() {
		return num_imbric;
	}
	
	public int getRegion() {
		return num_region;
	}
	
	public void addTDSFilles(TDS tds) {
		filles.add(tds);
	}

	public int getFillesCount() {
		return filles.size();
	}

	public TDS getFille(int i){
		if(filles.size()>i)
			return filles.get(i);
		return null;
		}
	
	public ArrayList<Element> getTable(){
		return table;
	}

	public void display(){

		if(num_region != 0){
			System.out.println("----------------------------------------------------------");
			System.out.println("TABLE " + num_region + " Imbrication number : " + num_imbric);
			System.out.println("Elements of the table");

			for(Element entry : table){
				entry.display();
			}
			if(table.size() == 0){
				System.out.println("No Element in the table !");
			}
			System.out.println("----------------------------------------------------------");
//			System.out.println(filles.size() + " daughters");
		}
		for(int i=0; i<filles.size();i++){
			filles.get(i).display();
		}
	}

	public void displaySolo(){
		if(num_region != 0){
			System.out.println("----------------------------------------------------------");
			System.out.println("TABLE " + num_region + " Imbrication number : " + num_imbric);
			System.out.println("Elements of the table");

			for(Element entry : table){
				entry.display();
			}
			if(table.size() == 0){
				System.out.println("No Element in the table !");
			}
//			System.out.println(filles.size() + " daughters");
			System.out.println("----------------------------------------------------------");
		}
	}

	public TDS getMere() {
		return mere;
	}
	//	/!\ peut vite devenir long � cause de la r�cursion /!\
	public TDS getTDSNumRegion(int num) {
		//System.out.println("getTDSNumRegion: "+num+" - num_Region = "+num_region);
		if(this.num_region == num) 
			return this;
		if(this.num_region!=0)
			return this.mere.getTDSNumRegion(num);
		return privateGetTDSNumRegion(num);
		
	}
	private TDS privateGetTDSNumRegion(int num) {
		//System.out.println("privateGetTDSNumRegion: "+ num+" - num_Region = "+num_region);
		if(this.num_region == num) 
			return this;
		TDS res;
		for(TDS fille: this.filles) {
			res = fille.privateGetTDSNumRegion(num);
			if(res!=null)
				return res;
		}
		return null;
			
				
		
	}
}
