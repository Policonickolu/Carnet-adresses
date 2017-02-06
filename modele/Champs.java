package modele;

import java.io.Serializable;

public class Champs implements Serializable{
	
////////////////////ATTRIBUTS  ////////////////////	

	private static final long serialVersionUID = 1L;
	
	private String etiquette;
	private String texte = "";
	
////////////////////CONSTRUCTEURS  ////////////////////	
	
	public Champs(String eti, String txt){
		
		this.etiquette = eti;
		this.texte = txt;
		
	}	
	
	public Champs(Champs i){
		
		this.etiquette = i.etiquette;
		this.texte = i.texte;
		
	}

////////////////////METHODES  ////////////////////	
	
	public String getEtiquette(){
		
		return this.etiquette;
		
	}
	
	public String getTexte(){
		
		return this.texte.toString();
		
	}
	
	public void setEtiquette(String eti){
		
		this.etiquette = eti;
		
	}
	
	public void setTexte(String txt){
		
		this.texte = txt;
		
	}
	
	public boolean equals(Champs c){
		
		return (this.etiquette.equals(c.etiquette) && this.texte.equals(c.texte));
		
	}
	
	public String toString(){
		
		return "" + this.etiquette + " "+ this.texte + "\n";
		
	}
	
}
