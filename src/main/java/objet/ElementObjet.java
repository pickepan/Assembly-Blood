package objet;

import java.util.ArrayList;
import java.util.Arrays;

import assembly.ToolsASM;
import org.antlr.runtime.tree.Tree;

import antlr.generatedClasses.GrammaireParser;

public class ElementObjet {
	private String nom;
	private String nature;
	private Tree tree;
	private boolean herite = false;
	private String type; //utilise pour this et super afin de retrouver le descripteurde classe,
	//est set en dehors de cette classe
	private ArrayList<ElementObjet> listeAttributOuParam;

	public ElementObjet(String nom, String nature) {
		this.nom=nom;
		this.nature = nature;
		listeAttributOuParam = new ArrayList<ElementObjet> ();
		
	}
	public ElementObjet(Tree t, String nature, String type_of_operation) {
		this.nature = nature;
		listeAttributOuParam = new ArrayList<ElementObjet> ();
		this.tree = t;
	}

	//message -> a.x.x;
	//currentClass ne sert que pour this et super afin de retrouver le descripteur associe
	public ElementObjet(String currentClass, Tree t, String nature) {
		ArrayList<String> symbol=new ArrayList<String>();
		symbol.add("<");symbol.add(">");symbol.add("<>");symbol.add("=");symbol.add("+");symbol.add("-");symbol.add("/");symbol.add("*");symbol.add("&&");symbol.add("||");
		listeAttributOuParam = new ArrayList<ElementObjet>();
		this.nature = nature;
		//attribut statique
		if(t.getType()==GrammaireParser.SELECT) {
			this.nature = "Static";
			t = t.getChild(0);
			this.nom = t.getChild(0).getText();
			processCast(t, true);
    	}
		else if(t.getType()==GrammaireParser.NEW) {
			this.nom=t.getChild(0).getText();
			processCast(t.getChild(1), false);
		}
		else if(t.getChild(0).getText().contentEquals("this")) {
			processCast(t, true);
			this.nom = "this";
			this.type = currentClass;
		}
		else if(t.getChild(0).getText().contentEquals("super")) {
			if(t.getType()==GrammaireParser.MESSAGE) {
				processCast(t, true);
				this.nom = "super";
				this.type = currentClass;
				
			}
			else {
				this.nom = "super";
				this.type = currentClass;
				//le nom sera null -> super constructeur
				ElementObjet o2=new ElementObjet(null, "Fonction");
				listeAttributOuParam.add(o2);
				for(int i=1; i<t.getChildCount();i++) 
					o2.processCast(t.getChild(i), false);

			}
			herite = true;
			
		}
		else if(symbol.contains(t.getChild(0).getText())){
			this.nom=t.getChild(0).getText();
			this.nature="Operation";
			processCast(t.getChild(1), false);
			
		}
		else {
			processCast(t, true);
		}	
	}
	//le cast a la particularite d'etre fait a l'envers
	//renvoie un boolean qui dit si first a ete change
	private boolean processCast(Tree t, boolean first) {
		if(t.getType()==GrammaireParser.CAST) {
			ElementObjet o2=new ElementObjet(t.getChild(0).getText(), "Cast");
			//si c'est la premiere variable alors le le type du cast sera errone et le nom de la premiere variable sera � NULL
			
			if(first) {
				first = o2.processCast(t.getChild(1), first);
				this.nom = o2.nom;
				o2.nom = t.getChild(0).getText();
			}
			else 
				first = o2.processCast(t.getChild(1), first);
			listeAttributOuParam.add(o2);
		}
		else if(t.getType()==GrammaireParser.MESSAGE) {
			
			if(!first) {
				ElementObjet o2=new ElementObjet((String)null, "Objet");
				boolean first2 = true;
				for(int i=0; i<t.getChildCount(); i++) {
					first2 = o2.processCast(t.getChild(i), first2);
				}
			}
			else {
				for(int i=0; i<t.getChildCount(); i++) {
					first = processCast(t.getChild(i), first);
				}
			}
				
			
		}
		else if(t.getType()==GrammaireParser.GROUP) {
			boolean b = false;
			if(t.getChild(0).getType() == GrammaireParser.MESSAGE){ //(13 + 4).toString process
				if(t.getChild(0).getChildCount() > 1){
					if(t.getChild(0).getChild(1).getType() == GrammaireParser.APPEL_FONCTION){
						if(t.getChild(0).getChild(1).getChildCount() > 0){
							if(t.getChild(0).getChild(1).getChild(0).getType() == GrammaireParser.FONCTION){
								if(t.getChild(0).getChild(1).getChild(0).getChild(0).getText().equals("toString")){
									b = true;
									ElementObjet o2=new ElementObjet(t, "toString", "");
									listeAttributOuParam.add(o2);
								}
							}
						}
					}
				}
			}
			if(b  == false){
				first = processCast(t.getChild(0), first);
			}

		}
		else if(t.getType()==GrammaireParser.VARIABLE) {
			if(first) {
				this.nom = t.getChild(0).getText();
				return false;
			}
			else {
				if(nature.contentEquals("Objet") || nature.contentEquals("Cast") || nature.contentEquals("Static"))
					listeAttributOuParam.add(new ElementObjet(t.getChild(0).getText(),  "Attribut"));
				else
					listeAttributOuParam.add(new ElementObjet(t.getChild(0).getText(),  "Variable"));
			}
		}
		else if(t.getType()==GrammaireParser.APPEL_FONCTION) {
			ElementObjet o2=new ElementObjet(t.getChild(0).getChild(0).getText(), "Fonction");
			o2.processCast(t.getChild(1), false);
			listeAttributOuParam.add(o2);
		}
		else if(t.getType() == GrammaireParser.LIST_PARAM) {
			for(int i=0; i<t.getChildCount();i++) 
				first = processCast(t.getChild(i), first);
		}
		else if(t.getType() == GrammaireParser.SELECT) {
			ElementObjet o2=new ElementObjet(t.getChild(0).getChild(0).getText(), "Static");
			o2.processCast(t.getChild(0), true);
			listeAttributOuParam.add(o2);
		}
		else if(t.getType()==GrammaireParser.NEW) {
			if(first) {
				this.nom=t.getChild(0).getText();
				this.nature = "New";
				processCast(t.getChild(1), false);
			}
			else {
				ElementObjet o2=new ElementObjet(t.getChild(0).getText(), "New");
				o2.processCast(t.getChild(1), false);
				listeAttributOuParam.add(o2);
			}
			
		}
		else {
			//INT, MOINS_UNAIRE, PLUS_UNAIRE et STRING sont toujours en premiere position == this.nom
			if(t.getType()==GrammaireParser.INT) {
				if(first) {
					this.nom = t.getText();
					this.nature = "Integer";
				}
				else {
					ElementObjet o2=new ElementObjet(t.getText(), "Integer");
					listeAttributOuParam.add(o2);
				}
			}
			else if( (t.getType() == GrammaireParser.MOINS_UNAIRE)) {
				if(first) {
					this.nom= "-" + t.getChild(0).getText();
					this.nature = "Integer";
				}
				else {
					ElementObjet o2=new ElementObjet("-" + t.getChild(0).getText(), "Integer");
					listeAttributOuParam.add(o2);
				}
			}
			else if(t.getType() == GrammaireParser.PLUS_UNAIRE) {
				if(first) {
					this.nom=t.getChild(0).getText();
					this.nature = "Integer";
				}
				else {
					ElementObjet o2=new ElementObjet(t.getChild(0).getText(), "Integer");
					listeAttributOuParam.add(o2);
				}
			}
			else if(t.getType()==GrammaireParser.STRING) {
				if(first) {
					this.nom=t.getChild(0).getText();
					this.nature = "String";
				}
				else {
					ElementObjet o2=new ElementObjet(t.getChild(0).getText(), "String");
					listeAttributOuParam.add(o2);
				}
			}
			else if(Arrays.binarySearch(ToolsASM.tab, t.getType()) >= 0){
//				if(first) {
//					this.nom=t.getChild(0).getText();
//					this.nature = "Operation";
//					this.tree = t;
//					System.out.println(t.getText());
//				}
//				else {
					ElementObjet o2=new ElementObjet(t, "Operation", "");
					listeAttributOuParam.add(o2);
//				}
			}
			//si on a this, super ou un nom de classe (static) on atteri aussi ici donc le nom n'est pas remplace
			first = false;
		}
		
		return first;
	}
		
	public String getNom() {
		return nom;
	}
	public String getType() {
		return type;
	}
	public boolean getHerite() {
		return herite;
	}
	public String getNature() {
		return nature;
	}
	public Tree getTree(){return tree;}
	public ArrayList<ElementObjet> getListeAttributOuParam() {
		return listeAttributOuParam;
	}

	public void display(ElementObjet elem, boolean firstCall) {
		if(firstCall)
			System.out.print("Display: "+nom+":"+nature);
		System.out.print("[");
		for(ElementObjet e: elem.getListeAttributOuParam()) {
			System.out.print(e.nom+":"+e.nature);
			if(!e.getListeAttributOuParam().isEmpty())
				display(e, false);
			if(elem.getListeAttributOuParam().size()-1!=elem.getListeAttributOuParam().indexOf(e))
				System.out.print(", ");
		}
		System.out.print("]");
		if(firstCall)
			System.out.println();
	}
}
