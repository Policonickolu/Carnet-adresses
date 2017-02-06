package controleur;

import java.util.ArrayList;

import modele.AbstractCarnet;

public class Controleur extends AbstractControleur {
	

	
	public Controleur(AbstractCarnet carnet){
		
		super(carnet);
		
	}

	public void controlSetInfo(String s, String nom) {
		
		if(nom == "Nom de famille"){
			this.carnet.getCurrentFiche().setNom(s);
		}
		if(nom == "Prénom"){
			this.carnet.getCurrentFiche().setPrenom(s);
		}
		if(nom == "Entreprise"){
			this.carnet.getCurrentFiche().setEntreprise(s);
		}
		if(nom == "Titre"){
			this.carnet.getCurrentFiche().setTitre(s);
		}
		if(nom == "Second prénom"){
			this.carnet.getCurrentFiche().setSecondPrenom(s);
		}
		if(nom == "Suffixe"){
			this.carnet.getCurrentFiche().setSuffixe(s);
		}
		if(nom == "Surnom"){
			this.carnet.getCurrentFiche().setSurnom(s);
		}
		if(nom == "Profession"){
			this.carnet.getCurrentFiche().setProfession(s);
		}
		if(nom == "Service"){
			this.carnet.getCurrentFiche().setService(s);
		}
		if(nom == "Remarques"){
			this.carnet.getCurrentFiche().setRemarques(s);
		}
		
	}
	
	public void controlSetInfo(String s, String nom, int position) {
		
		if(nom == "Nom de jeune fille"){
			this.carnet.getCurrentFiche().getNomJeuneFille().get(position).setTexte(s);
		}
		if(nom == "Numéro de téléphone"){
			this.carnet.getCurrentFiche().getTelephone().get(position).setTexte(s);
		}
		if(nom == "Adresse électronique"){
			this.carnet.getCurrentFiche().getEmail().get(position).setTexte(s);
		}
		if(nom == "Page web"){
			this.carnet.getCurrentFiche().getUrl().get(position).setTexte(s);
		}
		if(nom == "Date de naissance jj/mm/aaaa"){
			boolean b = true;
			char[] c = new char[s.length()];
			s.getChars(0,(s.length()>0?s.length()-1:s.length()),c,0);
			for(int i=0;i<c.length;i++){
				if(Character.isLetter(c[i])){b = false; break;}
			}	
			
			if(b && (s.split("/").length == 3 || s.split(" ").length == 3)){
				String[] s1 = new String[3];
				if(s.indexOf("/")>=0){
					s1 = s.split("/");	
				}
				else{
					s1 = s.split(" ");	
				}
				this.carnet.getCurrentFiche().getDateNaissance().get(position).getDate().setDate(s1[0],s1[1],s1[2]);
				
			}
			
		}
		if(nom == "Rendez-vous"){
			this.carnet.getCurrentFiche().getRendezVous().get(position).setTexte(s);
		}
		if(nom == "Nom"){
			this.carnet.getCurrentFiche().getNomsAssocies().get(position).setTexte(s);
		}
		if(nom == "Adresse de messagerie"){
			this.carnet.getCurrentFiche().getMessagerie().get(position).setTexte(s);
		}
		if(nom == "Rue"){
			this.carnet.getCurrentFiche().getAdresse().get(position).getAdresse().setRue(s);
		}
		if(nom == "Code"){
			this.carnet.getCurrentFiche().getAdresse().get(position).getAdresse().setCode(s);
		}
		if(nom == "Ville"){
			this.carnet.getCurrentFiche().getAdresse().get(position).getAdresse().setVille(s);
		}
		if(nom == "Pays"){
			this.carnet.getCurrentFiche().getAdresse().get(position).getAdresse().setPays(s);
		}
		
	}

	@Override
	public void controlRemoveChamps(String nom, int i) {
		
		if(nom == "Nom de jeune fille"){
			this.carnet.getCurrentFiche().getNomJeuneFille().remove(i);
		}
		if(nom == "Numéro de téléphone"){
			this.carnet.getCurrentFiche().getTelephone().remove(i);
		}
		if(nom == "Adresse électronique"){
			this.carnet.getCurrentFiche().getEmail().remove(i);
		}
		if(nom == "Page web"){
			this.carnet.getCurrentFiche().getUrl().remove(i);
		}
		if(nom == "Date de naissance jj/mm/aaaa"){
			this.carnet.getCurrentFiche().getDateNaissance().remove(i);
		}
		if(nom == "Rendez-vous"){
			this.carnet.getCurrentFiche().getRendezVous().remove(i);
		}
		if(nom == "Nom"){
			this.carnet.getCurrentFiche().getNomsAssocies().remove(i);
		}
		if(nom == "Adresse de messagerie"){
			this.carnet.getCurrentFiche().getMessagerie().remove(i);
		}
		if(nom == "Rue"){
			this.carnet.getCurrentFiche().getAdresse().remove(i);
		}
		
	}

	@Override
	public void controlAddChamps(String nom) {
		
		if(nom == "Nom de jeune fille"){
			this.carnet.getCurrentFiche().addNomJeuneFille();
		}
		if(nom == "Numéro de téléphone"){
			this.carnet.getCurrentFiche().addTelephone();
		}
		if(nom == "Adresse électronique"){
			this.carnet.getCurrentFiche().addEmail();
		}
		if(nom == "Page web"){
			this.carnet.getCurrentFiche().addUrl();
		}
		if(nom == "Date de naissance jj/mm/aaaa"){
			this.carnet.getCurrentFiche().addDateNaissance();
		}
		if(nom == "Rendez-vous"){
			this.carnet.getCurrentFiche().addRendezVous();
		}
		if(nom == "Nom"){
			this.carnet.getCurrentFiche().addNomsAssocies();
		}
		if(nom == "Adresse de messagerie"){
			this.carnet.getCurrentFiche().addMessagerie();
		}
		if(nom == "Rue" || nom == "Adresse"){
			this.carnet.getCurrentFiche().addAdresse();
		}
		
	}

	@Override
	public ArrayList<String> controlGetEtiquettes(String nom) {
	
		if(nom == "Numéro de téléphone"){
			return this.carnet.getCurrentFiche().getEtiTelephone();
		}
		if(nom == "Adresse électronique"){
			return this.carnet.getCurrentFiche().getEtiEmail();
		}
		if(nom == "Page web"){
			return this.carnet.getCurrentFiche().getEtiUrl();
		}
		if(nom == "Nom"){
			return this.carnet.getCurrentFiche().getEtiNomsAssocies();
		}
		if(nom == "Adresse de messagerie"){
			return this.carnet.getCurrentFiche().getEtiMessagerie();
		}
		if(nom == "Rue"){
			return this.carnet.getCurrentFiche().getEtiAdresse();
		}
		
		return null;
		
	}

	@Override
	public void controlAddEtiquette(String s, String nom) {
		
		if(nom == "Numéro de téléphone"){
			this.carnet.getCurrentFiche().getEtiTelephone().add(s);
		}
		if(nom == "Adresse électronique"){
			this.carnet.getCurrentFiche().getEtiEmail().add(s);
		}
		if(nom == "Page web"){
			this.carnet.getCurrentFiche().getEtiUrl().add(s);
		}
		if(nom == "Nom"){
			this.carnet.getCurrentFiche().getEtiNomsAssocies().add(s);
		}
		if(nom == "Adresse de messagerie"){
			this.carnet.getCurrentFiche().getEtiMessagerie().add(s);
		}
		if(nom == "Rue"){
			this.carnet.getCurrentFiche().getEtiAdresse().add(s);
		}
		
	}

	@Override
	public void controlSetEtiquette(String s, String nom, int position) {

		if(nom == "Nom de jeune fille"){
			this.carnet.getCurrentFiche().getNomJeuneFille().get(position).setEtiquette(s);
		}
		if(nom == "Numéro de téléphone"){
			this.carnet.getCurrentFiche().getTelephone().get(position).setEtiquette(s);
		}
		if(nom == "Adresse électronique"){
			this.carnet.getCurrentFiche().getEmail().get(position).setEtiquette(s);
		}
		if(nom == "Page web"){
			this.carnet.getCurrentFiche().getUrl().get(position).setEtiquette(s);
		}
		if(nom == "Date de naissance jj/mm/aaaa"){
			this.carnet.getCurrentFiche().getDateNaissance().get(position).setEtiquette(s);
		}
		if(nom == "Rendez-vous"){
			this.carnet.getCurrentFiche().getRendezVous().get(position).setEtiquette(s);
		}
		if(nom == "Nom"){
			this.carnet.getCurrentFiche().getNomsAssocies().get(position).setEtiquette(s);
		}
		if(nom == "Adresse de messagerie"){
			this.carnet.getCurrentFiche().getMessagerie().get(position).setEtiquette(s);
		}
		if(nom == "Rue"){
			this.carnet.getCurrentFiche().getAdresse().get(position).setEtiquette(s);
		}
		
	}

	@Override
	public void controlRemoveChampsModele(String nom, int i) {

		if(nom == "Nom de jeune fille"){
			this.carnet.getModele().getNomJeuneFille().remove(i);
		}
		if(nom == "Numéro de téléphone"){
			this.carnet.getModele().getTelephone().remove(i);
		}
		if(nom == "Adresse électronique"){
			this.carnet.getModele().getEmail().remove(i);
		}
		if(nom == "Page web"){
			this.carnet.getModele().getUrl().remove(i);
		}
		if(nom == "Date de naissance jj/mm/aaaa"){
			this.carnet.getModele().getDateNaissance().remove(i);
		}
		if(nom == "Rendez-vous"){
			this.carnet.getModele().getRendezVous().remove(i);
		}
		if(nom == "Nom"){
			this.carnet.getModele().getNomsAssocies().remove(i);
		}
		if(nom == "Adresse de messagerie"){
			this.carnet.getModele().getMessagerie().remove(i);
		}
		if(nom == "Rue"){
			this.carnet.getModele().getAdresse().remove(i);
		}
		
	}

	@Override
	public void controlAddChampsModele(String nom) {

		if(nom == "Nom de jeune fille"){
			this.carnet.getModele().addNomJeuneFille();
		}
		if(nom == "Numéro de téléphone"){
			this.carnet.getModele().addTelephone();
		}
		if(nom == "Adresse électronique"){
			this.carnet.getModele().addEmail();
		}
		if(nom == "Page web"){
			this.carnet.getModele().addUrl();
		}
		if(nom == "Date de naissance jj/mm/aaaa"){
			this.carnet.getModele().addDateNaissance();
		}
		if(nom == "Rendez-vous"){
			this.carnet.getModele().addRendezVous();
		}
		if(nom == "Nom"){
			this.carnet.getModele().addNomsAssocies();
		}
		if(nom == "Adresse de messagerie"){
			this.carnet.getModele().addMessagerie();
		}
		if(nom == "Adresse" || nom == "Rue"){
			this.carnet.getModele().addAdresse();
		}

	}

	@Override
	public void controlSetIsModele(String nom) {
		
		if(nom == "Titre"){
			boolean b = this.carnet.getModele().getIsTitre();
			this.carnet.getModele().setIsTitre(!b);
		}
		if(nom == "Second prénom"){
			boolean b = this.carnet.getModele().getIsSecondPrenom();
			this.carnet.getModele().setIsSecondPrenom(!b);
		}
		if(nom == "Suffixe"){
			boolean b = this.carnet.getModele().getIsSuffixe();
			this.carnet.getModele().setIsSuffixe(!b);
		}
		if(nom == "Surnom"){
			boolean b = this.carnet.getModele().getIsSurnom();
			this.carnet.getModele().setIsSurnom(!b);
		}
		if(nom == "Profession"){
			boolean b = this.carnet.getModele().getIsProfession();
			this.carnet.getModele().setIsProfession(!b);
		}
		if(nom == "Service"){
			boolean b = this.carnet.getModele().getIsService();
			this.carnet.getModele().setIsService(!b);
		}
		
	}
	
	@Override
	public void controlSetIs(String nom) {
		
		if(nom == "Titre"){
			boolean b = this.carnet.getCurrentFiche().getIsTitre();
			this.carnet.getCurrentFiche().setIsTitre(!b);
		}
		if(nom == "Second prénom"){
			boolean b = this.carnet.getCurrentFiche().getIsSecondPrenom();
			this.carnet.getCurrentFiche().setIsSecondPrenom(!b);
		}
		if(nom == "Suffixe"){
			boolean b = this.carnet.getCurrentFiche().getIsSuffixe();
			this.carnet.getCurrentFiche().setIsSuffixe(!b);
		}
		if(nom == "Surnom"){
			boolean b = this.carnet.getCurrentFiche().getIsSurnom();
			this.carnet.getCurrentFiche().setIsSurnom(!b);
		}
		if(nom == "Profession"){
			boolean b = this.carnet.getCurrentFiche().getIsProfession();
			this.carnet.getCurrentFiche().setIsProfession(!b);
		}
		if(nom == "Service"){
			boolean b = this.carnet.getCurrentFiche().getIsService();
			this.carnet.getCurrentFiche().setIsService(!b);
		}
		
	}
	
	@Override
	public void controlAddEtiquetteModele(String s, String nom) {
		
		if(nom == "Numéro de téléphone"){
			this.carnet.getModele().getEtiTelephone().add(s);
		}
		if(nom == "Adresse électronique"){
			this.carnet.getModele().getEtiEmail().add(s);
		}
		if(nom == "Page web"){
			this.carnet.getModele().getEtiUrl().add(s);
		}
		if(nom == "Nom"){
			this.carnet.getModele().getEtiNomsAssocies().add(s);
		}
		if(nom == "Adresse de messagerie"){
			this.carnet.getModele().getEtiMessagerie().add(s);
		}
		if(nom == "Rue"){
			this.carnet.getModele().getEtiAdresse().add(s);
		}
		
	}

	@Override
	public void controlSetEtiquetteModele(String s, String nom, int position) {

		if(nom == "Nom de jeune fille"){
			this.carnet.getModele().getNomJeuneFille().get(position).setEtiquette(s);
		}
		if(nom == "Numéro de téléphone"){
			this.carnet.getModele().getTelephone().get(position).setEtiquette(s);
		}
		if(nom == "Adresse électronique"){
			this.carnet.getModele().getEmail().get(position).setEtiquette(s);
		}
		if(nom == "Page web"){
			this.carnet.getModele().getUrl().get(position).setEtiquette(s);
		}
		if(nom == "Date de naissance jj/mm/aaaa"){
			this.carnet.getModele().getDateNaissance().get(position).setEtiquette(s);
		}
		if(nom == "Rendez-vous"){
			this.carnet.getModele().getRendezVous().get(position).setEtiquette(s);
		}
		if(nom == "Nom"){
			this.carnet.getModele().getNomsAssocies().get(position).setEtiquette(s);
		}
		if(nom == "Adresse de messagerie"){
			this.carnet.getModele().getMessagerie().get(position).setEtiquette(s);
		}
		if(nom == "Rue"){
			this.carnet.getModele().getAdresse().get(position).setEtiquette(s);
		}
		
	}
	
	@Override
	public ArrayList<String> controlGetEtiquettesModele(String nom) {
	
		if(nom == "Numéro de téléphone"){
			return this.carnet.getModele().getEtiTelephone();
		}
		if(nom == "Adresse électronique"){
			return this.carnet.getModele().getEtiEmail();
		}
		if(nom == "Page web"){
			return this.carnet.getModele().getEtiUrl();
		}
		if(nom == "Nom"){
			return this.carnet.getModele().getEtiNomsAssocies();
		}
		if(nom == "Adresse de messagerie"){
			return this.carnet.getModele().getEtiMessagerie();
		}
		if(nom == "Rue"){
			return this.carnet.getModele().getEtiAdresse();
		}
		
		return null;
		
	}

	@Override
	public void controlRemAllEtiquette() {
		
		for(int i=0;i<this.carnet.getGroupes().get(0).size();i++){
			for(int j=0;j<this.carnet.getGroupes().get(0).get(i).getEtiTelephone().size();j++){
				this.carnet.getGroupes().get(0).get(i).remEtiTelephone(j);
			}
			for(int j=0;j<this.carnet.getGroupes().get(0).get(i).getEtiEmail().size();j++){
				this.carnet.getGroupes().get(0).get(i).remEtiEmail(j);
			}
			for(int j=0;j<this.carnet.getGroupes().get(0).get(i).getEtiUrl().size();j++){
				this.carnet.getGroupes().get(0).get(i).remEtiUrl(j);
			}
			for(int j=0;j<this.carnet.getGroupes().get(0).get(i).getEtiNomsAssocies().size();j++){
				this.carnet.getGroupes().get(0).get(i).remEtiNomsAssocies(j);
			}
			for(int j=0;j<this.carnet.getGroupes().get(0).get(i).getEtiMessagerie().size();j++){
				this.carnet.getGroupes().get(0).get(i).remEtiMessagerie(j);
			}
			for(int j=0;j<this.carnet.getGroupes().get(0).get(i).getEtiAdresse().size();j++){
				this.carnet.getGroupes().get(0).get(i).remEtiAdresse(j);
			}
		}
		for(int j=0;j<this.carnet.getModele().getEtiTelephone().size();j++){
			this.carnet.getModele().remEtiTelephone(j);
		}
		for(int j=0;j<this.carnet.getModele().getEtiEmail().size();j++){
			this.carnet.getModele().remEtiEmail(j);
		}
		for(int j=0;j<this.carnet.getModele().getEtiUrl().size();j++){
			this.carnet.getModele().remEtiUrl(j);
		}
		for(int j=0;j<this.carnet.getModele().getEtiNomsAssocies().size();j++){
			this.carnet.getModele().remEtiNomsAssocies(j);
		}
		for(int j=0;j<this.carnet.getModele().getEtiMessagerie().size();j++){
			this.carnet.getModele().remEtiMessagerie(j);
		}
		for(int j=0;j<this.carnet.getModele().getEtiAdresse().size();j++){
			this.carnet.getModele().remEtiAdresse(j);
		}
		
	}
	
	public void controlRemEtiquette() {
		
		for(int j=0;j<this.carnet.getCurrentFiche().getEtiTelephone().size();j++){
			this.carnet.getCurrentFiche().remEtiTelephone(j);
		}
		for(int j=0;j<this.carnet.getCurrentFiche().getEtiEmail().size();j++){
			this.carnet.getCurrentFiche().remEtiEmail(j);
		}
		for(int j=0;j<this.carnet.getCurrentFiche().getEtiUrl().size();j++){
			this.carnet.getCurrentFiche().remEtiUrl(j);
		}
		for(int j=0;j<this.carnet.getCurrentFiche().getEtiNomsAssocies().size();j++){
			this.carnet.getCurrentFiche().remEtiNomsAssocies(j);
		}
		for(int j=0;j<this.carnet.getCurrentFiche().getEtiMessagerie().size();j++){
			this.carnet.getCurrentFiche().remEtiMessagerie(j);
		}
		for(int j=0;j<this.carnet.getCurrentFiche().getEtiAdresse().size();j++){
			this.carnet.getCurrentFiche().remEtiAdresse(j);
		}
		
	}
	
	public void controlRemEtiquetteModele() {
		
		for(int j=0;j<this.carnet.getModele().getEtiTelephone().size();j++){
			this.carnet.getModele().remEtiTelephone(j);
		}
		for(int j=0;j<this.carnet.getModele().getEtiEmail().size();j++){
			this.carnet.getModele().remEtiEmail(j);
		}
		for(int j=0;j<this.carnet.getModele().getEtiUrl().size();j++){
			this.carnet.getModele().remEtiUrl(j);
		}
		for(int j=0;j<this.carnet.getModele().getEtiNomsAssocies().size();j++){
			this.carnet.getModele().remEtiNomsAssocies(j);
		}
		for(int j=0;j<this.carnet.getModele().getEtiMessagerie().size();j++){
			this.carnet.getModele().remEtiMessagerie(j);
		}
		for(int j=0;j<this.carnet.getModele().getEtiAdresse().size();j++){
			this.carnet.getModele().remEtiAdresse(j);
		}
		
	}

	
}
