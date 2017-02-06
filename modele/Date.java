package modele;

import java.io.Serializable;
import java.util.Calendar;

public class Date implements Serializable{
	
////////////////////ATTRIBUTS  ////////////////////	
	
	private static final long serialVersionUID = 1L;
	
	private int jour, mois, annee;
	
////////////////////CONSTRUCTEURS  ////////////////////	

	public Date(){
		
		this.jour = 0;
		this.mois = 0;
		this.annee = 0;
		
	}
	
	public Date(Date date){
	
		this.jour = date.jour;
		this.mois = date.mois;
		this.annee = date.annee;
		
	}
	
////////////////////METHODES ////////////////////	

	public void setDate(int j, int m, int a){
		
			if( isValide(j,m,a) == true ){	
				this.jour = j;
				this.mois = m;
				
			    Calendar c = Calendar.getInstance();
			    int y = c.get(Calendar.YEAR)%2000;
				
			    if(a > y && a < 99){this.annee = a+1900;}
			    else if(a > 0 && a < y){this.annee = a+2000;}
			    else {this.annee = a;}		
			}
			else{
			this.jour = 0;
			this.mois = 0;
			this.annee = 0;	
			}
		
	}
	
	public void setDate(String j, String m, String a){
		
		int j2 = Integer.parseInt(j.trim());
		int m2 = Integer.parseInt(m.trim());
		int a2 = Integer.parseInt(a.trim());
		
		if( isValide(j2,m2,a2) == true ){	
			this.jour = j2;
			this.mois = m2;
			
		    Calendar c = Calendar.getInstance();
		    int y = c.get(Calendar.YEAR)%2000;
			
		    if(a2 > y && a2 < 99){this.annee = a2+1900;}
		    else if(a2 > 0 && a2 < y){this.annee = a2+2000;}
		    else {this.annee = a2;}		
		}
		else{
		this.jour = 0;
		this.mois = 0;
		this.annee = 0;	
		}
	
}
	
	public boolean isValide(int j, int m, int a){
		 
   		if(m == 2){
   			if(j <= (isBissextile(a) == true ? 29 : 28) && j >= 1){ 
				return true;
   			}
			else{ 
				return false;
			}
		}	
		else{
			if(m <= 12 && m >= 1){
				if(m == 4 || m == 6 || m == 9 || m == 11){
					if(j <= 30 && j >= 1){
						return true;
					}
					else{
						return false;
					}
				}
				else{
					if(j <= 31 && j >= 1){
						return true;
					}
					else{
						return false;
					}
				}
			}
			else{
				return false;
			}
		}
   		
	}
	
	public boolean isBissextile(int a){
		
		if((a % 4 == 0 && a % 100 != 0) || a % 400 == 0){return true;}
		else{return false;}		
		
	}
	
	public String moisToString(){
		
		String[] mois = {"mois", "janvier", "février", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre"};
		return mois[this.mois];
		
	}
	
	public boolean equals(Date d){
		
		return ( this.jour == d.jour && this.mois == d.mois && this.annee == d.annee);
		
	}
	
	public String toString(){
		
		return ( this.jour != 0 || this.mois != 0 || this.annee != 0 ? this.jour + " " + this.moisToString() + " " + this.annee : "" );
		
	}
	
}