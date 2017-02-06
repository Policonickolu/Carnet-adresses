package modele;
import java.io.Serializable;
import java.util.ArrayList;



public class Groupe implements Serializable, Comparable<Object>{
	
////////////////////ATTRIBUTS  ////////////////////	

	private static final long serialVersionUID = 1L;
	
	private String nom = "";
	private ArrayList<Fiche> fiches = new ArrayList<Fiche>();
	
////////////////////CONSTRUCTEURS  ////////////////////	
	
	public Groupe(){		
		
	}
	
	public Groupe(String s){
		
		this.nom = s;
		this.fiches = new ArrayList<Fiche>();
		
	}
	
	public Groupe(Groupe g){
	
		this.nom = g.nom;
		this.fiches = new ArrayList<Fiche>(g.fiches);		
		
	}
	
//////////////////// METHODES ////////////////////	
	
	public void add(Fiche f){
		
		this.fiches.add(f);
		
	}
	
	public Fiche get(int i){
		
		return this.fiches.get(i);
		
	}
	
	public void remove(int i){
		
		this.fiches.remove(i);
		
	}
	
	public int size() {
	
		return this.fiches.size();
	
	}
	
	public ArrayList<Fiche> getFiches(){
		
		return this.fiches;
		
	}

	public void setFiches(ArrayList<Fiche> al) {
		
		this.fiches = new ArrayList<Fiche>(al);
		
	}
	
	public int indexDe(Fiche f) {
		
		return this.fiches.indexOf(f);
		
	}	

	public boolean contains(Fiche f) {	
		
		return this.fiches.contains(f);
		
	}
	
	public boolean equals(Groupe g){
		
		return (this.nom.equals(g.nom) && this.fiches.equals(g.fiches));
		
	}	
	
	public String toString(){
		
		return (this.nom != "" ? this.nom : "Sans nom");
		
	}

	@Override
	public int compareTo(Object o) {
		
		return this.toString().compareTo(o.toString());
		
	}

	public String getNom() {
		return this.nom;
	}


	
}
