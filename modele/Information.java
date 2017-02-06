package modele;

import java.io.Serializable;


public class Information implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String etiquette = "";
	private Object texte = "";
	
	public Information(String eti, Object tex){
		
		this.etiquette = eti;
		this.texte = tex;
		
	}
	
	public Information(Information i){
		
		this.etiquette = i.etiquette;
		this.texte = i.texte;
		
	}
	
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
	
	public void setTexte(Date d){
		
		this.texte = new Date(d);
		
	}
	
	public void setTexte(Adresse a){
		
		this.texte = new Adresse(a);
		
	}
	
	public boolean equals(Information i){
		
		return (this.etiquette.equals(i.etiquette) && this.texte.equals(i.texte));
		
	}
	
	public String toString(){
		
		return "" + this.etiquette + "   "+ this.texte + "\n";
		
	}
	
}
