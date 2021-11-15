package objet;

import org.antlr.runtime.tree.Tree;

import tds.TDS;

public class AffectationStatique {
	//lorsqu'une variable statique est initialise lors de la creation d'une classe
	//on ne peut pas executer immediatement le code car le descripteur de classe dont
	//on a eventuellement besoin n'est peut etre pas encore cree ou remplit
	//il nous faut donc une liste d'arbre, currentType, tds afin de lancer toutes ces creation apres
	private Tree t;
	private TDS tds;
	private String type;
	public AffectationStatique(Tree t, TDS tds, String type){
		this.t = t;
		this.tds = tds;
		this.type = type;	
	}
	public Tree getT() {
		return t;
	}
	public TDS getTds() {
		return tds;
	}
	public String getType() {
		return type;
	}
}
