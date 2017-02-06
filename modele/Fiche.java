package modele;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.ImageIcon;




public class Fiche implements Serializable, Comparable<Object>{
	
	private static final long serialVersionUID = 1L;
	
	private ImageIcon photo = new ImageIcon();
	private String prenom = "";
	private String nom = "";
	private String entreprise = "";
	private String titre = "";
	private String secondPrenom = "";
	private String suffixe = "";
	private String surnom = "";
	private String profession = "";
	private String service = "";
	private ArrayList<Champs> nomJeuneFille = new ArrayList<Champs>();
	private ArrayList<Champs> telephone = new ArrayList<Champs>();
	private ArrayList<Champs> email = new ArrayList<Champs>();
	private ArrayList<Champs> url = new ArrayList<Champs>();
	private ArrayList<ChampsDate> dateNaissance = new ArrayList<ChampsDate>();
	private ArrayList<Champs> rendezVous = new ArrayList<Champs>();
	private ArrayList<Champs> nomsAssocies = new ArrayList<Champs>();
	private ArrayList<Champs> messagerie = new ArrayList<Champs>();
	private ArrayList<ChampsAdresse> adresse = new ArrayList<ChampsAdresse>();
	private String remarques = "";
	
	private boolean isTitre = false;
	private boolean isSecondPrenom = false;
	private boolean isSuffixe = false;
	private boolean isSurnom = false;
	private boolean isProfession = false;
	private boolean isService = false;

	private ArrayList<String> etiTelephone = new ArrayList<String>();
	private ArrayList<String> etiEmail = new ArrayList<String>();
	private ArrayList<String> etiUrl = new ArrayList<String>();
	private ArrayList<String> etiNomsAssocies = new ArrayList<String>();
	private ArrayList<String> etiMessagerie = new ArrayList<String>();
	private ArrayList<String> etiAdresse = new ArrayList<String>();
	
	private boolean showEntreprise = false;
	private static boolean nomAvantPrenom = false;
	
	public Fiche(){		
		
		this.etiquettes();
		
	}
	
	public Fiche(Fiche c){
		
		this.prenom = c.prenom;
		this.nom = c.nom;
		this.entreprise = c.entreprise;
		this.showEntreprise = c.showEntreprise;
		this.titre = c.titre;
		this.secondPrenom = c.secondPrenom;
		this.suffixe = c.suffixe;
		this.surnom = c.surnom;
		this.profession = c.profession;
		this.service = c.service;
		this.nomJeuneFille = new ArrayList<Champs>(c.nomJeuneFille);
		this.telephone = new ArrayList<Champs>(c.telephone);
		this.email = new ArrayList<Champs>(c.email); 
		this.url = new ArrayList<Champs>(c.url);
		this.dateNaissance = new ArrayList<ChampsDate>(c.dateNaissance);
		this.rendezVous = new ArrayList<Champs>(c.rendezVous);
		this.nomsAssocies = new ArrayList<Champs>(c.nomsAssocies);
		this.messagerie = new ArrayList<Champs>(c.messagerie);
		this.adresse = new ArrayList<ChampsAdresse>(c.adresse);
		this.remarques = c.remarques;
		
		this.isTitre = c.isTitre;
		this.isSecondPrenom = c.isSecondPrenom;
		this.isSuffixe = c.isSuffixe;
		this.isSurnom = c.isSurnom;
		this.isProfession = c.isProfession;
		this.isService = c.isService;
		
		this.etiTelephone = new ArrayList<String>(c.etiTelephone);
		this.etiEmail = new ArrayList<String>(c.etiEmail);
		this.etiUrl = new ArrayList<String>(c.etiUrl);
		this.etiNomsAssocies = new ArrayList<String>(c.etiNomsAssocies);
		this.etiMessagerie = new ArrayList<String>(c.etiMessagerie);
		this.etiAdresse = new ArrayList<String>(c.etiAdresse);
		
		this.showEntreprise = c.showEntreprise;
		
	}
	
	public void etiquettes(){
		
		this.etiTelephone.add("travail");
		this.etiTelephone.add("domicile");
		this.etiTelephone.add("portable");
		this.etiTelephone.add("fax travail");
		this.etiTelephone.add("fax domicile");
		this.etiTelephone.add("bipeur");
		this.etiTelephone.add("autre");
		
		this.etiEmail.add("travail");
		this.etiEmail.add("domicile");
		this.etiEmail.add("autre");
		
		this.etiUrl.add("page entreprise");
		this.etiUrl.add("page personnelle");
		this.etiUrl.add("autre");
		
		this.etiNomsAssocies.add("ami");
		this.etiNomsAssocies.add("assistant");
		this.etiNomsAssocies.add("famille");
		this.etiNomsAssocies.add("père");
		this.etiNomsAssocies.add("mère");
		this.etiNomsAssocies.add("sœur");
		this.etiNomsAssocies.add("frère");
		this.etiNomsAssocies.add("partenaire");
		this.etiNomsAssocies.add("collègue");
		this.etiNomsAssocies.add("autre");
		
		this.etiMessagerie.add("travail");
		this.etiMessagerie.add("domicile");
		this.etiMessagerie.add("autre");
		
		this.etiAdresse.add("travail");
		this.etiAdresse.add("domicile");
		this.etiAdresse.add("autre");		
		
	}
	
	public boolean recherche(String s){
		
		String str[]=infoToString().split(s);
		if(str.length>1){return true;}
		else{return false;}
		
	}
	
	public boolean equals(Fiche f){
		
		return (this.prenom.equals(f.prenom) && this.nom.equals(f.nom) && this.entreprise.equals(f.entreprise) &&
				this.titre.equals(f.titre) && this.secondPrenom.equals(f.secondPrenom) && this.suffixe.equals(f.suffixe) &&
				this.surnom.equals(f.surnom) && this.profession.equals(f.profession) && this.service.equals(f.service) && 
				this.nomJeuneFille.equals(f.nomJeuneFille) && this.telephone.equals(f.telephone) &&	this.email.equals(f.email) &&
				this.url.equals(f.url) &&	this.dateNaissance.equals(f.dateNaissance) &&	this.rendezVous.equals(f.rendezVous) &&	
				this.nomsAssocies.equals(f.nomsAssocies) &&	this.messagerie.equals(f.messagerie) &&	this.adresse.equals(f.adresse) &&
				this.remarques.equals(f.remarques) && this.isTitre == f.isTitre && this.isSecondPrenom == f.isSecondPrenom &&
				this.isSuffixe == f.isSuffixe && this.isSurnom == f.isSurnom && this.isProfession == f.isProfession &&
				this.isService == f.isService && this.etiTelephone.equals(f.etiTelephone) && this.etiEmail.equals(f.etiEmail) &&
				this.etiUrl.equals(f.etiUrl) && this.etiNomsAssocies.equals(f.etiNomsAssocies) && this.etiMessagerie.equals(f.etiMessagerie) &&
				this.etiAdresse.equals(f.etiAdresse) && this.showEntreprise == f.showEntreprise );
		
	}
	
	public String toString(){		
		
		String s = "";
		if( showEntreprise == false ){
			if(!this.nom.equals("") || !this.prenom.equals("")){
				if(nomAvantPrenom){
					s = this.nom + " " + this.prenom;			
				}
				else{
					s = this.prenom + " " + this.nom;		
				}
			}
			else{
				s = "Sans nom";				
			}
		}
		else{
			if(!this.entreprise.equals("")){
				s = this.entreprise;
			}
			else{
				s = "Sans nom";
			}
		}
		return s.trim();
		
	}
	
	@Override
	public int compareTo(Object o) {
		
		return this.toString().compareTo(o.toString());
		
	}
	
	public boolean isDoublon(Fiche f) {
		
		return (this.nom.equals(f.nom) && this.prenom.equals(f.prenom) && this.entreprise.equals(f.entreprise));
		
	}
	
	public String getEtiquette(ArrayList<Champs> champs, ArrayList<String> etiquettes){
		
		ArrayList<String> al = new ArrayList<String>();
		for(int i=0;i<champs.size();i++){
			al.add(champs.get(i).getEtiquette());
		}
		for(int i=0;i<etiquettes.size();i++){
			if(!al.contains(etiquettes.get(i))){
				return etiquettes.get(i);
			}
		}
		return etiquettes.get(champs.size()%etiquettes.size());
		
	}
	
	public String getEtiquetteAdresse(ArrayList<ChampsAdresse> champs, ArrayList<String> etiquettes){
		
		ArrayList<String> al = new ArrayList<String>();
		for(int i=0;i<champs.size();i++){
			al.add(champs.get(i).getEtiquette());
		}
		for(int i=0;i<etiquettes.size();i++){
			if(!al.contains(etiquettes.get(i))){
				return etiquettes.get(i);
			}
		}
		return etiquettes.get(champs.size()%etiquettes.size());
		
	}	

	/* AJOUTER DES ETIQUETTES PERSONNALISEES EN PLUS */
	
	public void addEtiTelephone(String s){
		
		this.etiTelephone.add(s);
		
	}
	
	public void addEtiEmail(String s){
		
		this.etiEmail.add(s);
		
	}
	
	public void addEtiUrl(String s){
		
		this.etiUrl.add(s);
		
	}
	
	public void addEtiNomsAssocies(String s){
		
		this.etiNomsAssocies.add(s);
		
	}
	
	public void addEtiMessagerie(String s){
		
		this.etiMessagerie.add(s);
		
	}
	
	public void addEtiAdresse(String s){
		
		this.etiAdresse.add(s);
		
	}
	
	/* RETIRER DES ETIQUETTES PERSONNALISEE */
	
	public void remEtiTelephone(int i){
		
		if(i > 6 ){
			this.etiTelephone.remove(i);
		}
		
	}
	
	public void remEtiEmail(int i){
		
		if(i > 2 ){
			this.etiEmail.remove(i);
		}
		
	}
	
	public void remEtiUrl(int i){
		
		if(i > 2 ){
			this.etiUrl.remove(i);
		}
		
	}
	
	public void remEtiNomsAssocies(int i){
		
		if(i > 9 ){
			this.etiNomsAssocies.remove(i);
		}
		
	}
	
	public void remEtiMessagerie(int i){
		
		if(i > 2 ){
			this.etiMessagerie.remove(i);
		}
		
	}
	
	public void remEtiAdresse(int i){
		
		if(i > 2 ){
			this.etiAdresse.remove(i);
		}
		
	}
	
	/* AJOUTER DES CHAMPS EN PLUS */
	
	public void addNomJeuneFille(){
		
		if(this.dateNaissance.size() == 0 ){
			
			Champs c = new Champs("Nom de jeune fille","");
			this.nomJeuneFille.add(c);
		}
		
	}
	
	public void addTelephone(){
		
		String s = getEtiquette(this.telephone,this.etiTelephone);
		Champs c = new Champs(s,"");
		this.telephone.add(c);
		
	}
	
	public void addEmail(){
		
		String s = getEtiquette(this.email,this.etiEmail);
		Champs c = new Champs(s,"");
		this.email.add(c);
		
	}
	
	public void addUrl(){
		
		String s = getEtiquette(this.url,this.etiUrl);
		Champs c = new Champs(s,"");
		this.url.add(c);
		
	}
	
	public void addDateNaissance(){
		
		if(this.dateNaissance.size() == 0 ){
			ChampsDate c = new ChampsDate("Date de naissance",new Date());
			this.dateNaissance.add(c);
		}
			
	}
	
	public void addRendezVous(){
		
		if(this.rendezVous.size() == 0 ){
			Champs c = new Champs("Rendez-vous","");
			this.rendezVous.add(c);
		}
		
	}
	
	public void addNomsAssocies(){
		
		String s = getEtiquette(this.nomsAssocies,this.etiNomsAssocies);
		Champs c = new Champs(s,"");
		this.nomsAssocies.add(c);
		
	}
	
	public void addMessagerie(){
		
		String s = getEtiquette(this.messagerie,this.etiMessagerie);
		Champs c = new Champs(s,"");
		this.messagerie.add(c);
		
	}
	
	public void addAdresse(){
		
		String s = getEtiquetteAdresse(this.adresse,this.etiAdresse);
		ChampsAdresse c = new ChampsAdresse(s,new Adresse());
		this.adresse.add(c);
		
	}
	
	/* SUPPRIMER DES CHAMPS SUPPLEMENTAIRES */
	
	public void remTelephone(int i){
		
		this.telephone.remove(i);
		
	}
	
	public void remEmail(int i){
		
		this.email.remove(i);
		
	}
	
	public void remUrl(int i){
		
		this.url.remove(i);
		
	}
	
	public void remNomsAssocies(int i){
		
		this.nomsAssocies.remove(i);
		
	}
	
	public void remMessagerie(int i){
		
		this.messagerie.remove(i);
		
	}
	
	public void remAdresse(int i){
		
		this.adresse.remove(i);
		
	}	
	
	/* RECUPERER LE TEXTE DES CHAMPS POUR LA RECHERCHE PAR MOT CLE*/

	public String infoToString(){
		
		String s =this.prenom+" "+this.nom+" "+this.entreprise+" "+this.titre+" "+this.secondPrenom+" "+this.suffixe+" "+this.surnom+" "+this.profession+" "+this.service+" "+this.remarques;
			for(int i=0;i<this.nomJeuneFille.size();i++){
				s += this.nomJeuneFille.get(i).getTexte()+" ";	
			}
			for(int i=0;i<this.telephone.size();i++){
				s += this.telephone.get(i).getTexte()+" ";	
			}
			for(int i=0;i<this.email.size();i++){
				s += this.email.get(i).getTexte()+" ";	
			}
			for(int i=0;i<this.url.size();i++){
				s += this.url.get(i).getTexte()+" ";	
			}
			for(int i=0;i<this.dateNaissance.size();i++){
				s += this.dateNaissance.get(i).getTexte()+" ";	
			}
			for(int i=0;i<this.rendezVous.size();i++){
				s += this.rendezVous.get(i).getTexte()+" ";	
			}
			for(int i=0;i<this.nomsAssocies.size();i++){
				s += this.nomsAssocies.get(i).getTexte()+" ";	
			}
			for(int i=0;i<this.messagerie.size();i++){
				s += this.messagerie.get(i).getTexte()+" ";	
			}
			for(int i=0;i<this.adresse.size();i++){
				s += this.adresse.get(i).getAdresse().toString()+" ";	
			}
		return s;
		
	}	
	
	/* RECUPERER LES CHAMPS */
	
	public String getPrenom(){
		
		return this.prenom;
		
	}
	
	public String getNom(){
		
		return this.nom;
		
	}
	
	public String getEntreprise(){
		
		return this.entreprise;
		
	}
	
	public String getTitre(){
		
		return this.titre;
		
	}
	
	public String getSecondPrenom(){
		
		return this.secondPrenom;
		
	}
	
	public String getSuffixe(){
		
		return this.suffixe;
		
	}
	
	public String getSurnom(){
		
		return this.surnom;
		
	}
	
	public String getProfession(){
		
		return this.profession;
		
	}
	
	public String getService(){
		
		return this.service;
		
	}
	
	public ArrayList<Champs> getNomJeuneFille(){
		
		return this.nomJeuneFille;
		
	}
	
	public ArrayList<Champs> getTelephone(){
		
		return this.telephone;
		
	}
	
	public ArrayList<Champs> getEmail(){
		
		return this.email;
		
	}
	
	public ArrayList<Champs> getUrl(){
		
		return this.url;
		
	}
	
	public ArrayList<ChampsDate> getDateNaissance(){
		
		return this.dateNaissance;
		
	}
	
	public ArrayList<Champs> getRendezVous(){
		
		return this.rendezVous;
		
	}	
	
	public ArrayList<Champs> getNomsAssocies(){
		
		return this.nomsAssocies;
		
	}
	
	public ArrayList<Champs> getMessagerie(){
		
		return this.messagerie;
		
	}
	
	public ArrayList<ChampsAdresse> getAdresse(){
		
		return this.adresse;
		
	}
	
	public String getRemarques(){
		
		return this.remarques;
		
	}
	
	public boolean getIsTitre(){
		
		return this.isTitre;
		
	}
	
	public boolean getIsSecondPrenom(){
		
		return this.isSecondPrenom;
		
	}
	
	public boolean getIsSuffixe(){
		
		return this.isSuffixe;
		
	}
	
	public boolean getIsSurnom(){
		
		return this.isSurnom;
		
	}
	
	public boolean getIsProfession(){
		
		return this.isProfession;
		
	}
	
	public boolean getIsService(){
		
		return this.isService;
		
	}
	
	public ArrayList<String> getEtiTelephone(){
		
		return this.etiTelephone;
		
	}
	
	public ArrayList<String> getEtiEmail(){
		
		return this.etiEmail;
		
	}
	
	public ArrayList<String> getEtiUrl(){
		
		return this.etiUrl;
		
	}
	
	public ArrayList<String> getEtiNomsAssocies(){
		
		return this.etiNomsAssocies;
		
	}
	
	public ArrayList<String> getEtiMessagerie(){
		
		return this.etiMessagerie;
		
	}
	
	public ArrayList<String> getEtiAdresse(){
		
		return this.etiAdresse;
		
	}
	
	public boolean getShowEntreprise(){
		
		return this.showEntreprise;
		
	}
	
	public static boolean getNomAvantPrenom(){
		
		return nomAvantPrenom;
		
	}
	
	/* REMPLACER LES CHAMPS */
	
	public void setPrenom(String s){
		
		this.prenom = s;
		
	}
	
	public void setNom(String s){
		
		this.nom = s;
		
	}
	
	public void setEntreprise(String s){
		
		this.entreprise = s;
		
	}
	
	public void setTitre(String s){
		
		this.titre = s;
		
	}
	
	public void setSecondPrenom(String s){
		
		this.secondPrenom = s;
		
	}
	
	public void setSuffixe(String s){
		
		this.suffixe = s;
		
	}
	
	public void setSurnom(String s){
		
		this.surnom = s;
		
	}
	
	public void setProfession(String s){
		
		this.profession = s;
		
	}
	
	public void setService(String s){
		
		this.service = s;
		
	}
	
	public void setNomJeuneFille(ArrayList<Champs> al){
		
		this.nomJeuneFille = new ArrayList<Champs>(al);
		
	}
	
	public void setTelephone(ArrayList<Champs> al){
		
		this.telephone = new ArrayList<Champs>(al);
		
	}
	
	public void setEmail(ArrayList<Champs> al){
		
		this.email = new ArrayList<Champs>(al);
		
	}
	
	public void setUrl(ArrayList<Champs> al){
		
		this.url = new ArrayList<Champs>(al);
		
	}
	
	public void setDateNaissance(ArrayList<ChampsDate> al){
		
		this.dateNaissance = new ArrayList<ChampsDate>(al);
		
	}
	
	public void setRendezVous(ArrayList<Champs> al){
		
		this.rendezVous = new ArrayList<Champs>(al);
		
	}
	
	public void setNomsAssocies(ArrayList<Champs> al){
		
		this.nomsAssocies = new ArrayList<Champs>(al);
		
	}
	
	public void setMessagerie(ArrayList<Champs> al){
		
		this.messagerie = new ArrayList<Champs>(al);
		
	}
	
	public void setAdresse(ArrayList<ChampsAdresse> al){
		
		this.adresse = new ArrayList<ChampsAdresse>(al);
		
	}
	
	public void setRemarques(String s){
		
		this.remarques = s;
		
	}
	
	public void setIsTitre(boolean b){
		
		this.isTitre = b;
		
	}
	
	public void setIsSecondPrenom(boolean b){
		
		this.isSecondPrenom = b;
		
	}
	
	public void setIsSuffixe(boolean b){
		
		this.isSuffixe = b;
		
	}
	
	public void setIsSurnom(boolean b){
		
		this.isSurnom = b;
		
	}
	
	public void setIsProfession(boolean b){
		
		this.isProfession = b;
		
	}
	
	public void setIsService(boolean b){
		
		this.isService = b;
		
	}
	
	public void setEtiTelephone(ArrayList<String> al){
		
		this.etiTelephone = new ArrayList<String>(al);
		
	}
	
	public void setEtiEmail(ArrayList<String> al){
		
		this.etiEmail = new ArrayList<String>(al);
		
	}
	
	public void setEtiUrl(ArrayList<String> al){
		
		this.etiUrl = new ArrayList<String>(al);
		
	}
	
	public void setEtiNomsAssocies(ArrayList<String> al){
		
		this.etiNomsAssocies = new ArrayList<String>(al);
		
	}
	
	public void setEtiMessagerie(ArrayList<String> al){
		
		this.etiMessagerie = new ArrayList<String>(al);
		
	}
	
	public void setEtiAdresse(ArrayList<String> al){
		
		this.etiAdresse = new ArrayList<String>(al);
		
	}
	
	public void setShowEntreprise (boolean b){
		
		this.showEntreprise  = b;
		
	}
	
	public static void setNomAvantPrenom(boolean b){
		
		nomAvantPrenom = b;
		
	}

	public void setPhoto(ImageIcon image) {
		this.photo = image;
	}

	public ImageIcon getPhoto() {
		return this.photo;
	}

	public void setPhoto(String s) {
		this.photo = new ImageIcon(s);		
	}
	
}