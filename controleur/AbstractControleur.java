package controleur;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import modele.AbstractCarnet;
import modele.Fiche;
import modele.Groupe;

public abstract class AbstractControleur {
	
	protected AbstractCarnet carnet;
	
	public AbstractControleur(AbstractCarnet carnet){		
		this.carnet = carnet;		
	}
	
	public void nouvelleSelectionFiche(Fiche fiche){		
		this.carnet.setCurrentFiche(fiche);		
	}	
	
	public void nouvelleSelectionGroupe(Groupe groupe){		
		this.carnet.setCurrentGroupe(groupe);		
	}		
	
	public void serializer(){		
		carnet.serializer();		
	}

	public void setPhoto(Image im) {
		ImageIcon image = new ImageIcon(im);
		this.carnet.getCurrentFiche().setPhoto(image);
		this.carnet.setCurrentFiche(this.carnet.getCurrentFiche());
	}
	
	public void finEdition(){
		this.carnet.updateObserver();		
	}

	public void setInfo(String s, String nom) {
		controlSetInfo(s,nom);
	}
	
	public void setInfo(String s, String nom, int position) {
		controlSetInfo(s,nom,position);		
	}
	
	public void setEtiquette(String s, String nom, int position) {
		controlSetEtiquette(s,nom,position);
		this.carnet.updateObserver();
	}
	
	public void setEtiquetteModele(String s, String nom, int position) {
		controlSetEtiquetteModele(s,nom,position);
		this.carnet.updateObserver();
	}

	public void setShowEntreprise() {
		boolean b = this.carnet.getCurrentFiche().getShowEntreprise();
		this.carnet.getCurrentFiche().setShowEntreprise(!b);
		this.carnet.updateObserver();
	}

	public void removeChamps(String nom, int position) {
		controlRemoveChamps(nom,position);
		this.carnet.updateObserver();
	}

	public void addChamps(String nom) {
		controlAddChamps(nom);
		this.carnet.updateObserver();
	}
	
	public ArrayList<String> getEtiquettes(String nom){
		return controlGetEtiquettes(nom);		
	}
	
	public ArrayList<String> getEtiquettesModele(String nom){
		return controlGetEtiquettesModele(nom);		
	}
	
	public void addEtiquette(String s, String nom){
		controlAddEtiquette(s,nom);
	}
	
	public void addEtiquetteModele(String s, String nom){
		controlAddEtiquetteModele(s,nom);
	}
	
	public Fiche getCurrentFiche() {
		return this.carnet.getCurrentFiche();
	}
	
	public Groupe getCurrentGroupe() {
		return this.carnet.getCurrentGroupe();
	}
	
	public void removeChampsModele(String nom, int position) {
		controlRemoveChampsModele(nom,position);
		this.carnet.updateObserver();
	}

	public void addChampsModele(String nom) {
		controlAddChampsModele(nom);
		this.carnet.updateObserver();		
	}
	
	public void setIsModele(String nom) {
		controlSetIsModele(nom);
		this.carnet.updateObserver();
	}
	
	public void setIs(String nom) {
		controlSetIs(nom);
		this.carnet.updateObserver();
	}
	
	public AbstractCarnet getCarnet() {
		return this.carnet;
	}
	
	public Groupe addNouveauGroupe(String s) {
		this.carnet.addGroupe(s);
		return this.carnet.getGroupes().get(this.carnet.getGroupes().size()-1);
	}
	
	public Fiche addNouveauNom() {
		this.carnet.newFiche();
		return this.carnet.getGroupes().get(0).get(this.carnet.getGroupes().get(0).size()-1);
	}
	
	public void ordreNom(boolean b) {
		Fiche.setNomAvantPrenom(b);
		this.carnet.updateObserver();
	}
	
	public void fusionDoublon() {
		this.carnet.fusionDoublons();		
	}
	
	public void removeFiche() {
		this.carnet.remFiche();		
	}
	
	public void removeFicheGroupe() {
		this.carnet.remFicheDansGroupe();
	}
	
	public void removeGroupe() {
		this.carnet.remGroupe();		
	}
	
	public void addFicheDansGroupe(Fiche fiche, Groupe groupe) {
		this.carnet.addFicheDansGroupe(fiche,groupe);		
	}
	
	public void remAllEtiquette() {
		controlRemAllEtiquette();
	}
	
	public void remEtiquette() {
		controlRemEtiquette();
	}
	
	public void remEtiquetteModele() {
		controlRemEtiquetteModele();
	}
	
	public void removePhoto() {
		this.carnet.getCurrentFiche().setPhoto(new ImageIcon("vide.png"));
		this.carnet.updateObserver();
	}

	public abstract ArrayList<String> controlGetEtiquettes(String nom);

	public abstract void controlSetInfo(String s, String nom);
	
	public abstract void controlRemoveChamps(String nom, int i);
	
	public abstract void controlAddChamps(String nom);
	
	public abstract void controlRemoveChampsModele(String nom, int i);
	
	public abstract void controlAddChampsModele(String nom);

	public abstract void controlSetInfo(String s, String nom, int position);
	
	public abstract void controlAddEtiquette(String s, String nom);

	public abstract void controlSetEtiquette(String s, String nom, int position);

	public abstract void controlSetIs(String nom);
	
	public abstract void controlSetIsModele(String nom);

	public abstract void controlAddEtiquetteModele(String s, String nom);

	public abstract void controlSetEtiquetteModele(String s, String nom, int position);

	public abstract ArrayList<String> controlGetEtiquettesModele(String nom);	

	public abstract void controlRemAllEtiquette();
	
	public abstract void controlRemEtiquette();
	
	public abstract void controlRemEtiquetteModele();
	
}
