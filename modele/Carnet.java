package modele;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observer;



public class Carnet extends AbstractCarnet implements Serializable{

//////////////////// ATTRIBUTS  ////////////////////
	
	private static final long serialVersionUID = 1L;
	
	protected static boolean premierLancement = true;
	
//////////////////// CONSTRUCTEUR  ////////////////////
	
	public Carnet(){
		super();		
	}
	
	/*public Carnet(Carnet c){
		super(c);
	}*/
	
	
//////////////////// METHODES  ////////////////////	
	
	public void currentGroupe(int i){
		
		if(this.currentGroupe != this.groupes.get(i)){	// le clic sur une liste de groupe donne un indice 					
			this.currentFiche = null;					// qui permet de savoir quel groupe a été sélectionné
			this.currentGroupe = this.groupes.get(i);
		}																			
															
	}
		
	public void currentFiche(int i){
		
		this.currentFiche = this.currentGroupe.get(this.currentGroupe.indexDe(this.affichage.get(i)));	// le clic sur une liste de fiche donne un indice
																										// qui permet de savoir quel fiche a été sélectionné
	}																									// en fonction du groupe sélectionné
	
	public void affichageFiltre(){
		
		tri();													
		ArrayList<Fiche> al1 = new ArrayList<Fiche>();
		ArrayList<Fiche> al2 = new ArrayList<Fiche>();		
		for(int i=0;i<currentGroupe.size();i++){		
			Fiche f = this.currentGroupe.get(i);
			if(f.toString() == "Nom" || f.toString() == "Prénom Nom de Famille" || f.toString() == "Nom de Famille Prénom"){
				al1.add(f);
			}												
			else{											
				if(f.recherche(this.motcle)){				
					al2.add(f);				 				
				}
			}
		}
		Collections.sort(al1, null);
		Collections.sort(al2, null);
		al1.addAll(al2);
		this.affichage = new ArrayList<Fiche>(al1);
				
	} 
	
	public void fusionDoublons(){
		ArrayList<Fiche> al = new ArrayList<Fiche>(rechercheDoublon());						// on cherche les doublons
		for(int i=0;i<al.size();i+=2){														
			Fiche f1 = al.get(0);															// deux par deux, si les deux doublons
			Fiche f2 = al.get(1);
																							// n'ont pas été supprimés pendant la
			if(this.groupes.get(0).contains(f1) && this.groupes.get(0).contains(f2)){		// manoeuvre, on fusionne leurs données.
																							// f1 prend les valeurs de f2 qu'il n'a pas. 

				if(f1.getTitre().equals(f2.getTitre()) == false){					// f1 prend les valeurs de f2 qu'il n'a pas. 
					if(f1.getTitre() == ""){											
						f1.setTitre(f2.getTitre());						
					}																	
				}
				if(f1.getSecondPrenom().equals(f2.getSecondPrenom()) == false){					// f1 prend les valeurs de f2 qu'il n'a pas. 
					if(f1.getSecondPrenom() == ""){											
						f1.setSecondPrenom(f2.getSecondPrenom());						
					}																	
				}
				if(f1.getSuffixe().equals(f2.getSuffixe()) == false){					// f1 prend les valeurs de f2 qu'il n'a pas. 
					if(f1.getSuffixe() == ""){											
						f1.setSuffixe(f2.getSuffixe());						
					}																	
				}
				if(f1.getSurnom().equals(f2.getSurnom()) == false){					// f1 prend les valeurs de f2 qu'il n'a pas. 
					if(f1.getSurnom() == ""){											
						f1.setSurnom(f2.getSurnom());						
					}																	
				}
				if(f1.getProfession().equals(f2.getProfession()) == false){					// f1 prend les valeurs de f2 qu'il n'a pas. 
					if(f1.getProfession() == ""){											
						f1.setProfession(f2.getProfession());						
					}																	
				}
				if(f1.getService().equals(f2.getService()) == false){					// f1 prend les valeurs de f2 qu'il n'a pas. 
					if(f1.getService() == ""){											
						f1.setService(f2.getService());						
					}																	
				}
				if(f1.getNomJeuneFille().equals(f2.getNomJeuneFille()) == false){
					if(f1.getNomJeuneFille().get(0) == null){
						f1.setNomJeuneFille(f2.getNomJeuneFille());					
					}
				}
				f1.getTelephone().addAll(f2.getTelephone());
				f1.getEmail().addAll(f2.getEmail());
				f1.getUrl().addAll(f2.getUrl());
				if(f1.getDateNaissance().equals(f2.getDateNaissance()) == false){
					if(f1.getDateNaissance().get(0) == null){
						f1.setDateNaissance(f2.getDateNaissance());					
					}
				}
				if(f1.getRendezVous().equals(f2.getRendezVous()) == false){
					if(f1.getRendezVous().get(0) == null){
						f1.setRendezVous(f2.getRendezVous());					
					}
				}
				f1.getNomsAssocies().addAll(f2.getNomsAssocies());
				f1.getMessagerie().addAll(f2.getMessagerie());
				f1.getAdresse().addAll(f2.getAdresse());
				f1.setRemarques(f1.getRemarques() + "\n" + f2.getRemarques());
				remFiche(f2);
				al.remove(0);
				al.remove(0);
			}	
		}
		
		this.updateObserver();
		
	}
	
	public ArrayList<Fiche> rechercheDoublon(){
		
		ArrayList<Fiche> al = new ArrayList<Fiche>();									// on met dans une liste 2 par 2 les doublons.
		for(int i=0;i<this.groupes.get(0).size();i++){									// on sait que des doublons seront mis plusieurs fois
			for(int j=0;j<i;j++){
				if(this.groupes.get(0).get(i).isDoublon(this.groupes.get(0).get(j))){
					al.add(this.groupes.get(0).get(i));
					al.add(this.groupes.get(0).get(j));
				}
			}
			for(int j=i+1;j<this.groupes.get(0).size();j++){
				if(this.groupes.get(0).get(i).isDoublon(this.groupes.get(0).get(j))){
					al.add(this.groupes.get(0).get(i));
					al.add(this.groupes.get(0).get(j));
				}
			}
		}		
		return al;																		// on retourne la liste
		
	}
	
	public void setNomAvantPrenom(boolean b){
		
		Fiche.setNomAvantPrenom(b);									// on change l'ordre nom prénom des fiches
	
	}
	
	public void tri(){
																	// on tri les listes par ordre lexicographique			
		for(int i=0;i<this.groupes.size();i++){	
			Collections.sort(this.groupes.get(i).getFiches(), null);
		}
		ArrayList<Groupe> al1 = new ArrayList<Groupe>();  // on tri les groupes par ordre lexicographique
		ArrayList<Groupe> al2 = new ArrayList<Groupe>();  // la liste de tous les contacts est en haut
		al1.add(this.groupes.get(0));					  
		for(int i=1;i<this.groupes.size();i++){
			Groupe g = new Groupe(this.groupes.get(i));
			if(g.toString() == "Sans nom"){
				al1.add(g);				
			}
			else{
			al2.add(g);
			}
		}
		Collections.sort(al2, null);
		al1.addAll(al2);
		this.groupes = new ArrayList<Groupe>(al1);
		
	}
	
	public void edition(){
		
		Fiche f1 = new Fiche(currentFiche);
		Fiche f2 = new Fiche(modele);
		if(f1.getIsTitre()==false){
			if(f2.getIsTitre()==true){
				f1.setIsTitre(true);
			}	
		}
		if(f1.getIsSecondPrenom() == false){					
			if(f1.getIsSecondPrenom() == true){											
				f1.setIsSecondPrenom(true);						
			}																	
		}
		if(f1.getIsSuffixe() == false){					
			if(f1.getIsSuffixe() == true){											
				f1.setIsSuffixe(true);						
			}																	
		}
		if(f1.getIsSurnom() == false){					
			if(f1.getIsSurnom() == true){											
				f1.setIsSurnom(true);						
			}																	
		}
		if(f1.getIsProfession() == false){					
			if(f1.getIsProfession() == true){											
				f1.setIsProfession(true);						
			}																	
		}
		if(f1.getIsService() == false){					
			if(f1.getIsService() == true){											
				f1.setIsService(true);						
			}																	
		}
		if(f1.getNomJeuneFille().size() == 0){
			if(f2.getNomJeuneFille().size() != 0){
				f1.setNomJeuneFille(f2.getNomJeuneFille());					
			}
		}
		if(f1.getTelephone().size() == 0){
			if(f2.getTelephone().size() != 0){
				f1.getTelephone().add(f2.getTelephone().get(0));					
			}
		}
		if(f1.getEmail().size() == 0){
			if(f2.getEmail().size() != 0){
				f1.getEmail().add(f2.getEmail().get(0));					
			}
		}
		if(f1.getUrl().size() == 0){
			if(f2.getUrl().size() != 0){
				f1.getUrl().add(f2.getUrl().get(0));					
			}
		}
		if(f1.getDateNaissance().size() == 0){
			if(f2.getDateNaissance().size() != 0){
				f1.setDateNaissance(f2.getDateNaissance());					
			}
		}
		if(f1.getRendezVous().size() == 0){
			if(f2.getRendezVous().size() != 0){
				f1.setRendezVous(f2.getRendezVous());					
			}
		}
		if(f1.getNomsAssocies().size() == 0){
			if(f2.getNomsAssocies().size() != 0){
				f1.getNomsAssocies().add(f2.getNomsAssocies().get(0));					
			}
		}
		if(f1.getMessagerie().size() == 0){
			if(f2.getMessagerie().size() != 0){
				f1.getMessagerie().add(f2.getMessagerie().get(0));					
			}
		}
		if(f1.getAdresse().size() == 0){
			if(f2.getAdresse().size() != 0){
				f1.getAdresse().add(f2.getAdresse().get(0));					
			}
		}		
		this.edition = f1;										
		
	}

	
//////////////////// GESTION FICHES  ////////////////////
	
	public void newFiche(){
		
		Fiche f = new Fiche(this.modele);							// nouvelle fiche dans le groupe sélectionné ainsi que
		this.groupes.get(0).add(f);									// la liste de toutes les fiches
		if(currentGroupe != this.groupes.get(0)){					// les doublons sont évités
			this.currentGroupe.add(f);
		}
		this.updateObserver();
		
	}
	
	public void remFiche(){		
		if(this.currentFiche != null){									// supprime la fiche selectionnée de tous les groupes
			int[] index = new int[groupes.size()]; 						// combien de groupes ?
			for(int j = 0;j < this.groupes.size();j++){ 				// pour chaque groupe
				Groupe g = new Groupe(this.groupes.get(j));
				index[j] = g.indexDe(this.currentFiche);				// est-ce que la fiche selectionnée s'y trouve ? et à quel indice ?
			}
			for(int k = 0;k < this.groupes.size();k++){
				if(index[k] != -1){                  					// pour tous les groupes possédant la fiche selectionnée
					Groupe g = this.groupes.get(k);  
					g.remove(index[k]);									// on supprime cette fiche.
				}
			}
		}
		this.currentFiche = null;
		this.updateObserver();
	}	
	
	public void remFiche(Fiche f){		
																	// supprime la fiche en paramètre de tous les groupes
		int[] index = new int[groupes.size()]; 						// combien de groupes ?
		for(int j = 0;j < this.groupes.size();j++){ 				// pour chaque groupe
			Groupe g = new Groupe(this.groupes.get(j));
			index[j] = g.indexDe(f);								// est-ce que la fiche s'y trouve ? et à quel indice ?
		}
		for(int k = 0;k < this.groupes.size();k++){
			if(index[k] != -1){                  					// pour tous les groupes possédant la fiche selectionnée
				Groupe g = this.groupes.get(k);  
				g.remove(index[k]);									// on supprime cette fiche.
			}
		}
		this.updateObserver();
	}
	
	public void addFicheDansGroupe(int j){		
		
		if(this.groupes.get(j).indexDe(this.currentFiche) == -1){  			// si la fiche ne se trouve pas déjà dans le groupe de destination 
			this.groupes.get(j).add(this.currentFiche);						// la fiche y est copiée
		}
		this.updateObserver();
	}
	
	public void addFicheDansGroupe(Fiche f,Groupe g){		
		
		int i = this.groupes.indexOf(g);				
		if(!this.groupes.get(i).contains(f))this.groupes.get(i).add(f);
		this.updateObserver();
		
	}
	
	public void remFicheDansGroupe(){
		
		int i = this.currentGroupe.indexDe(this.currentFiche);				// supprime la fiche sélectionée de son groupe uniquement
		this.currentGroupe.remove(i);
		this.updateObserver();
	}
	
	public void remFicheDansGroupe(Fiche f){
		
		int i = this.currentGroupe.indexDe(f);				// supprime la fiche sélectionée de son groupe uniquement
		this.currentGroupe.remove(i);
		this.updateObserver();
	}
	
	/* GESTION GROUPES  */
	
	public void addGroupe(String s){
		
		this.groupes.add(new Groupe(s)); 			// nouveau groupe.
		this.updateObserver();
		this.updateObserver();
	}
	
	public void remGroupe(){
		
		int i = this.groupes.indexOf(currentGroupe);
		this.groupes.remove(i); 					// supprime le groupe
		this.updateObserver();
	}
	
	/* GESTION DU MODELE DE FICHE */
	
	public void addChampsTitre(){
		
		this.modele.setIsTitre(true);
		
	}
	
	public void addChampsSecondPrenom(){
		
		this.modele.setIsSecondPrenom(true);

		
	}
	
	public void addChampsSuffixe(){
		
		this.modele.setIsSuffixe(true);

	}
	
	public void addChampsSurnom(){
		
		this.modele.setIsSurnom(true);
		
	}
	
	public void addChampsProfession(){
		
		this.modele.setIsProfession(true);
		
	}
	
	public void addChampsService(){
		
		this.modele.setIsService(true);
		
	}
	
	public void addChampsNomJeuneFille(){
	
		this.modele.addNomJeuneFille();
		
	}
	
	public void addChampsTelephone(){
		
		if(this.modele.getTelephone().size() == 0){
			String s = this.modele.getEtiquette(this.modele.getTelephone(),this.modele.getEtiTelephone());
			Champs c = new Champs(s,"");
			this.modele.getTelephone().add(c);			
		}
		
	}
	
	public void addChampsEmail(){
		
		if(this.modele.getEmail().size() == 0){
			String s = this.modele.getEtiquette(this.modele.getEmail(),this.modele.getEtiEmail());
			Champs c = new Champs(s,"");
			this.modele.getEmail().add(c);			
		}
		
	}
	
	public void addChampsUrl(){
		
		if(this.modele.getUrl().size() == 0){
			String s = this.modele.getEtiquette(this.modele.getUrl(),this.modele.getEtiUrl());
			Champs c = new Champs(s,"");
			this.modele.getUrl().add(c);			
		}
		
	}
	
	public void addChampsDateNaissance(){
				
		this.modele.addDateNaissance();
			
	}
	
	public void addChampsRendezVous(){
		
		this.modele.addRendezVous();
		
	}
	
	public void addChampsNomsAssocies(){
		
		if(this.modele.getNomsAssocies().size() == 0){
			String s = this.modele.getEtiquette(this.modele.getNomsAssocies(),this.modele.getEtiNomsAssocies());
			Champs c = new Champs(s,"");
			this.modele.getNomsAssocies().add(c);			
		}
		
	}
	
	public void addChampsMessagerie(){
		
		if(this.modele.getMessagerie().size() == 0){
			String s = this.modele.getEtiquette(this.modele.getMessagerie(),this.modele.getEtiMessagerie());
			Champs c = new Champs(s,"");
			this.modele.getMessagerie().add(c);			
		}

	}
	
	public void addChampsAdresse(){
		
		if(this.modele.getAdresse().size() == 0){
			String s = this.modele.getEtiquetteAdresse(this.modele.getAdresse(),this.modele.getEtiAdresse());
			ChampsAdresse c = new ChampsAdresse(s,new Adresse());
			this.modele.getAdresse().add(c);	
		}
		
	}
	
	/* RETIRER LES CHAMPS UNIQUES */
		
	public void remChampsTitre(){
			
		this.modele.setIsTitre(false);
			
	}
		
	public void remChampsSecondPrenom(){
			
		this.modele.setIsSecondPrenom(false);

	}
		
	public void remChampsSuffixe(){
			
		this.modele.setIsSuffixe(false);

	}
		
	public void remChampsSurnom(){
			
		this.modele.setIsSurnom(false);
			
	}
		
	public void remChampsProfession(){
			
		this.modele.setIsProfession(false);
			
	}
		
	public void remChampsService(){
			
		this.modele.setIsService(false);
			
	}

	/* GETTER SETTER */	

	public ArrayList<Groupe> getGroupes() {
		return groupes;
	}

	public void setGroupes(ArrayList<Groupe> groupes) {
		this.groupes = groupes;
	}

	public Groupe getCurrentGroupe() {
		return currentGroupe;
	}

	public void setCurrentGroupe(Groupe currentGroupe) {
		this.currentGroupe = currentGroupe;
		updateObserver();
	}

	public Fiche getCurrentFiche() {
		return currentFiche;		
	}

	public void setCurrentFiche(Fiche currentFiche) {
		this.currentFiche = currentFiche;
		updateObserver();
	}

	public ArrayList<Fiche> getAffichage() {
		return affichage;
	}

	public void setAffichage(ArrayList<Fiche> affichage) {
		this.affichage = affichage;
	}

	public Fiche getModele() {
		return modele;
	}

	public void setModele(Fiche modele) {
		this.modele = modele;
	}

	public Fiche getEdition() {
		return edition;
	}

	public void setEdition(Fiche edition) {
		this.edition = edition;
	}

	public String getMotcle() {
		return motcle;
	}

	public void setMotcle(String motcle) {
		this.motcle = motcle;
	}
	
	public static void setPremierLancement(boolean premierLancement) {
		Carnet.premierLancement = premierLancement;
	}

	public static boolean isPremierLancement() {
		return premierLancement;
	}
	
	// METHODES IMPLEMENTEES OBSERVABLE

	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remObserver() {
		// TODO Auto-generated method stub
		
	}

	
	
	
}


