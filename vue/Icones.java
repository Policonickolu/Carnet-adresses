package vue;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Icones implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private static boolean premierLancement = true;
	
	private ImageIcon personne; 
	private ImageIcon loupe; 
	private ImageIcon fin; 
	private ImageIcon modifier; 
	private ImageIcon modifierclic; 
	private ImageIcon plus; 
	private ImageIcon plusclic; 
	private ImageIcon entete;
	private ImageIcon recherche;
	private ImageIcon miniplus;
	private ImageIcon minimoins;
	private ImageIcon carnet;
	private ImageIcon etiquette;
	private ImageIcon entreprise;
	private ImageIcon dossier;
	private ImageIcon tous;
	
	public Icones(){
		personne = new ImageIcon(getClass().getResource("personne.PNG")); 
		loupe = new ImageIcon(getClass().getResource("loupe.PNG")); 
		fin = new ImageIcon(getClass().getResource("fin.PNG")); 
		modifier = new ImageIcon(getClass().getResource("modifier.PNG")); 
		modifierclic = new ImageIcon(getClass().getResource("modifierclic.PNG")); 
		plus = new ImageIcon(getClass().getResource("plus.PNG")); 
		plusclic = new ImageIcon(getClass().getResource("plusclic.PNG")); 
		entete = new ImageIcon(getClass().getResource("entete.PNG"));
		recherche = new ImageIcon(getClass().getResource("recherche.PNG"));
		miniplus = new ImageIcon(getClass().getResource("miniplus.PNG"));
		minimoins = new ImageIcon(getClass().getResource("minimoins.PNG"));
		carnet = new ImageIcon(getClass().getResource("carnet.PNG"));
		etiquette = new ImageIcon(getClass().getResource("etiquette.PNG"));
		entreprise = new ImageIcon(getClass().getResource("entreprise.PNG"));
		dossier = new ImageIcon(getClass().getResource("dossier.PNG"));
		tous = new ImageIcon(getClass().getResource("tous.PNG"));
	}
	
	public ImageIcon getPersonne() {
		return personne;
	}
	public void setPersonne(ImageIcon personne) {
		this.personne = personne;
	}
	public ImageIcon getLoupe() {
		return loupe;
	}
	public void setLoupe(ImageIcon loupe) {
		this.loupe = loupe;
	}
	public ImageIcon getFin() {
		return fin;
	}
	public void setFin(ImageIcon fin) {
		this.fin = fin;
	}
	public ImageIcon getModifier() {
		return modifier;
	}
	public void setModifier(ImageIcon modifier) {
		this.modifier = modifier;
	}
	public ImageIcon getModifierclic() {
		return modifierclic;
	}
	public void setModifierclic(ImageIcon modifierclic) {
		this.modifierclic = modifierclic;
	}
	public ImageIcon getPlus() {
		return plus;
	}
	public void setPlus(ImageIcon plus) {
		this.plus = plus;
	}
	public ImageIcon getPlusclic() {
		return plusclic;
	}
	public void setPlusclic(ImageIcon plusclic) {
		this.plusclic = plusclic;
	}
	public ImageIcon getEntete() {
		return entete;
	}
	public void setEntete(ImageIcon entete) {
		this.entete = entete;
	}
	public static void setPremierLancement(boolean premierLancement) {
		Icones.premierLancement = premierLancement;
	}
	public static boolean isPremierLancement() {
		return premierLancement;
	}
	public void setRecherche(ImageIcon recherche) {
		this.recherche = recherche;
	}
	public ImageIcon getRecherche() {
		return recherche;
	}
	public void setMiniplus(ImageIcon miniplus) {
		this.miniplus = miniplus;
	}
	public ImageIcon getMiniplus() {
		return miniplus;
	}
	public void setMinimoins(ImageIcon minimoins) {
		this.minimoins = minimoins;
	}
	public ImageIcon getMinimoins() {
		return minimoins;
	}
	public void setCarnet(ImageIcon carnet) {
		this.carnet = carnet;
	}
	public ImageIcon getCarnet() {
		return carnet;
	}
	public void setEtiquette(ImageIcon etiquette) {
		this.etiquette = etiquette;
	}
	public ImageIcon getEtiquette() {
		return etiquette;
	}
	public void setEntreprise(ImageIcon entreprise) {
		this.entreprise = entreprise;
	}
	public ImageIcon getEntreprise() {
		return entreprise;
	}
	public void setDossier(ImageIcon dossier) {
		this.dossier = dossier;
	}
	public ImageIcon getDossier() {
		return dossier;
	}
	public void setTous(ImageIcon tous) {
		this.tous = tous;
	}
	public ImageIcon getTous() {
		return tous;
	} 
	
}
