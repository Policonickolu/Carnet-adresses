package modele;

import java.io.Serializable;

public class ChampsDate extends Champs implements Serializable{

////////////////////ATTRIBUTS  ////////////////////	

	private static final long serialVersionUID = 1L;
	
	private Date date;
	
////////////////////CONSTRUCTEURS  ////////////////////	
	
	public ChampsDate(String eti, Date d){
		
		super(eti,"");
		this.date = d;
		
	}	
	
	public ChampsDate(ChampsDate c){
		
		super(new Champs(c.getEtiquette(),c.getTexte()));
		this.date = c.date;
		
	}

////////////////////METHODES  ////////////////////	
	
	public String getEtiquette(){
		
		return super.getEtiquette();
		
	}
	
	public String getTexte(){
		
		return this.date.toString();
		
	}
	
	public Date getDate(){
		
		return this.date;
		
	}
	
	public void setEtiquette(String eti){
		
		super.setEtiquette(eti);
		
	}
	
	public void setDate(Date d){
		
		this.date = d;
		
	}
	
	public boolean equals(ChampsDate c){
		
		return (super.equals(new Champs(c.getEtiquette(),"")) && this.date.equals(c.date));
		
	}
	
	public String toString(){
		
		return "" + super.getEtiquette() + " "+ this.date + "\n";
		
	}
	
}
