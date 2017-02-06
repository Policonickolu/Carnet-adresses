package modele;

import java.io.Serializable;

public class Adresse implements Serializable{
	
////////////////////ATTRIBUTS  ////////////////////		

	private static final long serialVersionUID = 1L;
	
	private String rue;
	private String code;
	private String ville;
	private String pays;
	
////////////////////CONSTRUCTEURS  ////////////////////	
	
	public Adresse(){
		
		this.rue = "";
		this.code = "";
		this.ville = "";
		this.pays = "";
		
	}
	
	public Adresse(String r, String c, String v, String p){
		
		this.rue = r;
		this.code = c;
		this.ville = v;
		this.pays = p;
		
	}
	
	public Adresse(Adresse a){
		
		this.rue = a.rue;
		this.code = a.code;
		this.ville = a.ville;
		this.pays = a.pays;
		
	}
	
////////////////////METHODES ////////////////////	
	
	public void setAdresse(String r, String c, String v, String p){

		this.rue = r;
		this.code = c;
		this.ville = v;
		this.pays = p;
	
	}
	
	public boolean equals(Adresse a){
		
		return ( this.rue.equals(a.rue) && this.code.equals(a.code) && this.ville.equals(a.ville) && this.pays.equals(a.pays) );
		
	}
	
	public String toString(){
		
		String s = this.rue + " " + this.code + " " + this.ville + " " + this.pays;
		return s.trim();
		
	}
	
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	
}
