package main;


import vue.FenetrePrincipale;

import modele.AbstractCarnet;
import modele.Carnet;
import controleur.AbstractControleur;
import controleur.Controleur;

public class Test {
	

		
	public static void main(String[] args){
	
		AbstractCarnet carnet = new Carnet();
		carnet.deSerializerCarnet();
		AbstractControleur controleur = new Controleur(carnet);		
		FenetrePrincipale f = new FenetrePrincipale(controleur);
		carnet.addObserver(f);
		carnet.updateObserver();		
		
	}
}	

 
	

