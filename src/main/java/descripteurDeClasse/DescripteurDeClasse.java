package descripteurDeClasse;

import java.util.ArrayList;

import tds.ElementMethod;
import tds.ElementVariable;
import tdt.ElementTDT;
import tdt.TDT;

public class DescripteurDeClasse {
	//taille d'un objet / nb methodes / adresses des methodes
	public String type; //ne pas ajouter dans la pile
	public int taille = 2;	//adresse 2 + somme(taille attributs)
	public int nbMethodes;
	public int tailleDescripteur;//pour faciliter le code assembleur = 2+2+nbMethodes*2
	public ArrayList<ElementVariable> listeAttribut;
	public ArrayList<ElementVariable> listeAttributStatique;
	public ArrayList<ElementMethod> adressesMethodes; //debug pas encore d'adresse donc je mets les noms des methodes
	public String debug;

	public DescripteurDeClasse(TDT tdt, ElementTDT elem, String debug) {
		adressesMethodes = new ArrayList<ElementMethod>();
		listeAttribut = new ArrayList<ElementVariable>();
		listeAttributStatique = new ArrayList<ElementVariable>();
		getAttributEtTaille(tdt, elem);
		ajoutMethodes(tdt, elem); 
		type = elem.getType();
		nbMethodes = adressesMethodes.size();
		tailleDescripteur = 4+2*nbMethodes;
		this.debug = debug;
		if(debug.equals("yes")){
			display();
		}
	}
	private void getAttributEtTaille(TDT tdt,ElementTDT classeCourante){
		if(classeCourante.getTypeHeritage() != null)
			if (tdt.getType(classeCourante.getTypeHeritage()) != null) {
				getAttributEtTaille(tdt, tdt.getType(classeCourante.getTypeHeritage()));
			}
		for(ElementVariable e : classeCourante.getListeAttribut()) {
			
			if(!e.getStatique()) {
				listeAttribut.add(e);
				taille+=2;
			}
			else
				listeAttributStatique.add(e);
				
		}
	}
	private void ajoutMethodes(TDT tdt, ElementTDT classeCourante) {
		if(classeCourante.getTypeHeritage() != null)
			if (tdt.getType(classeCourante.getTypeHeritage()) != null) {
				ajoutMethodes(tdt, tdt.getType(classeCourante.getTypeHeritage()));//on doit ajouter l'heritage le plus profond afin de garder le meme ordre de methode
			}
		//pour chaque methode on l'ajoute a l'ArrayList, si elle est deja presente c'est une redefinition donc on change l'adresse.
		for(ElementMethod elem : classeCourante.getListeMethode()) {
			if((containsGetDebug(elem.getNom())) == -1){
				adressesMethodes.add(elem);
			}
		}
	}
	
	
	private int containsGetDebug(String test) {
		for(int i=0; i< adressesMethodes.size(); i++) {
			if(adressesMethodes.get(i).getNom().contentEquals(test))
				return i;
		}
		return -1;
	}
	public void display() {
		System.out.println(type);
		System.out.println("taille = "+taille);
		System.out.println("nb methodes = "+nbMethodes);
		for(ElementMethod str : adressesMethodes) {
			System.out.println(str.getNom());
		}
		System.out.println("\n\n");
	}
	public int getDeplacementAttribut(String attribut) {
		for(int i=0; i<listeAttribut.size();i++) 
			if(listeAttribut.get(i).getNom().contentEquals(attribut))
				return 2+2*i;
		return -1;
	}
	public ElementVariable getAttribut(String attribut) {
		for(int i=0; i<listeAttribut.size();i++) 
			if(listeAttribut.get(i).getNom().contentEquals(attribut))
				return listeAttribut.get(i);
		for(int i=0; i<listeAttributStatique.size();i++) 
			if(listeAttributStatique.get(i).getNom().contentEquals(attribut))
				return listeAttributStatique.get(i);
		return null;
	}
	public ElementMethod getMethode(String methode) {
		for(int i=0; i<adressesMethodes.size();i++) 
			if(adressesMethodes.get(i).getNom().contentEquals(methode))
				return adressesMethodes.get(i);
		return null;
	}
	public int getDeplacementMethode(String methode) {
		for(int i=0; i<adressesMethodes.size();i++) 
			if(adressesMethodes.get(i).getNom().contentEquals(methode))
				return 4+2*(listeAttributStatique.size()+i);
		return -1;
	}
	public int getDeplacementAttributStatique(String attribut) {
		for(int i=0; i<listeAttributStatique.size();i++) 
			if(listeAttributStatique.get(i).getNom().contentEquals(attribut))
				return 2+2*i;
		return -1;
	}
	public boolean attributIsInteger(String attribut) {
		for(int i=0; i<listeAttribut.size();i++) 
			if(listeAttribut.get(i).getNom().contentEquals(attribut))
				if(listeAttribut.get(i).getType().contentEquals("Integer"))
					return true;
				else
					return false;
		return false;
	}
}
