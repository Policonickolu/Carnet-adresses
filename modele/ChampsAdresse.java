package modele;

import java.io.Serializable;

public class ChampsAdresse extends Champs implements Serializable{

////////////////////ATTRIBUTS  ////////////////////	

	private static final long serialVersionUID = 1L;
	
	private Adresse adresse;
	
////////////////////CONSTRUCTEURS  ////////////////////	
	
	public ChampsAdresse(String eti, Adresse d){
		
		super(eti,"");
		this.adresse = d;
		
	}	
	
	public ChampsAdresse(ChampsAdresse c){
		
		super(new Champs(c.getEtiquette(),c.getTexte()));
		this.adresse = new Adresse(c.adresse);
		
	}

////////////////////METHODES  ////////////////////	
	
	public String getEtiquette(){
		
		return super.getEtiquette();
		
	}
	
	public Adresse getAdresse(){
		
		return this.adresse;
		
	}
	
	public String getAdresseToString(){
		
		return this.adresse.toString();
		
	}
	
	public void setEtiquette(String eti){
		
		super.setEtiquette(eti);
		
	}
	
	public void setAdresse(Adresse d){
		
		this.adresse = new Adresse(d);
		
	}
	
	public boolean equals(ChampsAdresse c){
		
		return (super.equals(new Champs(c.getEtiquette(),"")) && this.adresse.equals(c.adresse));
		
	}
	
	public String toString(){
		
		return "" + super.getEtiquette() + " "+ this.adresse + "\n";
		
	}
	
}
