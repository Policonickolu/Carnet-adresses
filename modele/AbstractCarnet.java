package modele;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import main.Observable;
import main.Observer;


public abstract class AbstractCarnet implements Serializable, Observable{

	protected static final long serialVersionUID = 1L;
	
	protected ArrayList<Groupe> groupes = new ArrayList<Groupe>();
	protected Groupe currentGroupe = null;
	protected Fiche currentFiche = null;
	
	protected ArrayList<Fiche> affichage = new ArrayList<Fiche>();
	protected Fiche modele = new Fiche();
	protected Fiche edition = modele;
	protected String motcle = "";	

	transient private ArrayList<Observer> listeObserver = new ArrayList<Observer>();
	
	public AbstractCarnet(){
		
		this.groupes.add(new Groupe("Tous")); 							
		this.currentGroupe = this.groupes.get(0);		
		
		/*newFiche();
		newFiche();
		newFiche();
		newFiche();
		newFiche();
		newFiche();
		newFiche();
		
		this.groupes.get(0).getFiches().get(0).setPrenom("Charles");
		this.groupes.get(0).getFiches().get(0).setNom("Magne"); 
		this.groupes.get(0).getFiches().get(0).setEntreprise("France Télécom");
		this.groupes.get(0).getFiches().get(0).addTelephone();
		this.groupes.get(0).getFiches().get(0).getTelephone().get(0).setTexte("01 30 46 84 27"); 
		this.groupes.get(0).getFiches().get(0).setRemarques("France Télécom c'est bof !!!");
		
		
		
		this.groupes.get(0).getFiches().get(1).setPrenom("Jean"); 
		this.groupes.get(0).getFiches().get(1).setNom("Hèmard");
		this.groupes.get(0).getFiches().get(1).setEntreprise("Carrefour");
		this.groupes.get(0).getFiches().get(1).addTelephone();
		this.groupes.get(0).getFiches().get(1).getTelephone().get(0).setTexte("01 46 43 91 12");
		this.groupes.get(0).getFiches().get(1).setRemarques("erf !!!");
		
		
		this.groupes.get(0).getFiches().get(2).setPrenom("Marc"); 
		this.groupes.get(0).getFiches().get(2).setNom("Assin"); 
		this.groupes.get(0).getFiches().get(2).setEntreprise("Google");
		this.groupes.get(0).getFiches().get(2).setTitre("Seigneur");
		this.groupes.get(0).getFiches().get(2).setSecondPrenom("Ass");
		this.groupes.get(0).getFiches().get(2).setService("compta");
		this.groupes.get(0).getFiches().get(2).setProfession("Ingénieur en bidules Google");
		this.groupes.get(0).getFiches().get(2).setSurnom("Blaireau");
		this.groupes.get(0).getFiches().get(2).setSuffixe("Baron des toilettes");
		this.groupes.get(0).getFiches().get(2).addNomJeuneFille();
		this.groupes.get(0).getFiches().get(2).getNomJeuneFille().get(0).setTexte("Chuis pas une fille salkon");
		this.groupes.get(0).getFiches().get(2).addDateNaissance();
		this.groupes.get(0).getFiches().get(2).getDateNaissance().get(0).getDate().setDate(16,4,1980);
		this.groupes.get(0).getFiches().get(2).addRendezVous();
		this.groupes.get(0).getFiches().get(2).getRendezVous().get(0).setTexte("15 juin 17h café bureau banane");
		this.groupes.get(0).getFiches().get(2).addMessagerie();
		this.groupes.get(0).getFiches().get(2).getMessagerie().get(0).setTexte("hahahaha sur topmessagerie");
		this.groupes.get(0).getFiches().get(2).addNomsAssocies();
		this.groupes.get(0).getFiches().get(2).getNomsAssocies().get(0).setTexte("Didier clébart");
		this.groupes.get(0).getFiches().get(2).addTelephone();
		this.groupes.get(0).getFiches().get(2).getTelephone().get(0).setTexte("01 16 73 17 89");
		this.groupes.get(0).getFiches().get(2).addTelephone();
		this.groupes.get(0).getFiches().get(2).getTelephone().get(1).setTexte("01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 ");
		this.groupes.get(0).getFiches().get(2).addTelephone();
		this.groupes.get(0).getFiches().get(2).getTelephone().get(2).setTexte("hjgh");
		this.groupes.get(0).getFiches().get(2).addEmail();
		this.groupes.get(0).getFiches().get(2).getEmail().get(0).setTexte("marcassin@google.fr"); 
		this.groupes.get(0).getFiches().get(2).addUrl();
		this.groupes.get(0).getFiches().get(2).getUrl().get(0).setTexte("google.fr");
		this.groupes.get(0).getFiches().get(2).addAdresse();
		this.groupes.get(0).getFiches().get(2).getAdresse().get(0).setAdresse(new Adresse("55 rue du Faubourg-Saint-Honoré", "91008", "Paris", "France")); 
		this.groupes.get(0).getFiches().get(2).setRemarques("Attention il mord !!!");
		this.groupes.get(0).getFiches().get(2).setShowEntreprise(true);

		this.groupes.get(0).getFiches().get(3).setPrenom("Charles");
		this.groupes.get(0).getFiches().get(3).setNom("Magne"); 
		this.groupes.get(0).getFiches().get(3).setEntreprise("France Télécom");
		this.groupes.get(0).getFiches().get(3).addTelephone();
		this.groupes.get(0).getFiches().get(3).addTelephone();
		this.groupes.get(0).getFiches().get(3).addTelephone();
		this.groupes.get(0).getFiches().get(3).getTelephone().get(0).setTexte("79 84 15 76 25");
		this.groupes.get(0).getFiches().get(3).getTelephone().get(1).setTexte("06 74 98 15 02"); 
		this.groupes.get(0).getFiches().get(3).getTelephone().get(2).setTexte("19 84 72 13 25"); 
		this.groupes.get(0).getFiches().get(3).setRemarques("France Télécom c'est bof !!!");
		
		this.groupes.get(0).getFiches().get(4).setPrenom("Marc"); 
		this.groupes.get(0).getFiches().get(4).setNom("Assin"); 
		this.groupes.get(0).getFiches().get(4).setEntreprise("Google");
		this.groupes.get(0).getFiches().get(4).setTitre("Seigneur");
		this.groupes.get(0).getFiches().get(4).setSecondPrenom("Ass");
		this.groupes.get(0).getFiches().get(4).setService("compta");
		this.groupes.get(0).getFiches().get(4).setProfession("Ingénieur en bidules Google");
		this.groupes.get(0).getFiches().get(4).setSurnom("Blaireau");
		this.groupes.get(0).getFiches().get(4).setSuffixe("Baron des toilettes");
		this.groupes.get(0).getFiches().get(4).addNomJeuneFille();
		this.groupes.get(0).getFiches().get(4).getNomJeuneFille().get(0).setTexte("Chuis pas une fille salkon");
		this.groupes.get(0).getFiches().get(4).addDateNaissance();
		this.groupes.get(0).getFiches().get(4).getDateNaissance().get(0).getDate().setDate(16,4,1980);
		this.groupes.get(0).getFiches().get(4).addRendezVous();
		this.groupes.get(0).getFiches().get(4).getRendezVous().get(0).setTexte("15 juin 17h café bureau banane");
		this.groupes.get(0).getFiches().get(4).addMessagerie();
		this.groupes.get(0).getFiches().get(4).getMessagerie().get(0).setTexte("hahahaha sur topmessagerie");
		this.groupes.get(0).getFiches().get(4).addNomsAssocies();
		this.groupes.get(0).getFiches().get(4).getNomsAssocies().get(0).setTexte("Didier clébart");
		this.groupes.get(0).getFiches().get(4).addTelephone();
		this.groupes.get(0).getFiches().get(4).getTelephone().get(0).setTexte("01 16 73 17 89");
		this.groupes.get(0).getFiches().get(4).addTelephone();
		this.groupes.get(0).getFiches().get(4).getTelephone().get(1).setTexte("01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 01 16 73 17 89 ");
		this.groupes.get(0).getFiches().get(4).addTelephone();
		this.groupes.get(0).getFiches().get(4).getTelephone().get(2).setTexte("hjgh");
		this.groupes.get(0).getFiches().get(4).addEmail();
		this.groupes.get(0).getFiches().get(4).getEmail().get(0).setTexte("marcassin@google.fr"); 
		this.groupes.get(0).getFiches().get(4).addUrl();
		this.groupes.get(0).getFiches().get(4).getUrl().get(0).setTexte("google.fr");
		this.groupes.get(0).getFiches().get(4).addAdresse();
		this.groupes.get(0).getFiches().get(4).getAdresse().get(0).setAdresse(new Adresse("55 rue du Faubourg-Saint-Honoré", "91008", "Paris", "France")); 
		this.groupes.get(0).getFiches().get(4).setRemarques("Attention il mord !!!");
		this.groupes.get(0).getFiches().get(4).setShowEntreprise(true);
	
		this.groupes.get(0).getFiches().get(6).setNom("Hèmard");
		this.groupes.get(0).getFiches().get(6).setEntreprise("Carrefour");
		this.groupes.get(0).getFiches().get(6).addTelephone();
		this.groupes.get(0).getFiches().get(6).getTelephone().get(0).setTexte("01 46 43 91 12");
		this.groupes.get(0).getFiches().get(6).setRemarques("erf !!!");
		
		this.groupes.add(new Groupe("amis"));
		this.groupes.add(new Groupe("famille"));
		this.groupes.add(new Groupe("boulot"));
		
		this.groupes.get(1).add(this.groupes.get(0).get(6)); */

		
		
		
		
		
		
		
		/*Groupe g = this.currentGroupe;				
		ArrayList<Fiche> al1 = new ArrayList<Fiche>();
		ArrayList<Fiche> al2 = new ArrayList<Fiche>();
		for(int i=0;i<g.getFiches().size();i++){
			Fiche f = g.getFiches().get(i);
			if(f.toString() == "Sans nom"){
				al1.add(f);				
			}
			else{
				al2.add(f);
			}
		}
		Collections.sort(al2, null);
		al1.addAll(al2);
		
		this.currentFiche = al1.get(0);*/
		
	}
	
/*	public AbstractCarnet(AbstractCarnet c){
		
		this.groupes = new ArrayList<Groupe>(c.groupes);
		this.affichage = new ArrayList<Fiche>(c.affichage);
		this.modele = new Fiche(c.modele);
		this.currentGroupe = new Groupe(c.currentGroupe);
		this.currentFiche = new Fiche(c.currentFiche);
		this.motcle = c.motcle;
		
	}*/

	public abstract void currentGroupe(int i);
		
	public abstract void currentFiche(int i);
	
	public abstract void affichageFiltre();
	
	public abstract void fusionDoublons();
	
	public abstract ArrayList<Fiche> rechercheDoublon();
	
	public abstract void setNomAvantPrenom(boolean b);
	
	public abstract void tri();
	
	public abstract void edition();
	
	public abstract void newFiche();
	
	public abstract void remFiche();
	
	public abstract void remFiche(Fiche f);
	
	public abstract void addFicheDansGroupe(int j);
	
	public abstract void addFicheDansGroupe(Fiche f,Groupe g);
	
	public abstract void remFicheDansGroupe();
	
	public abstract void remFicheDansGroupe(Fiche f);
	
	public abstract void addGroupe(String s);
	
	public abstract void remGroupe();
	
	public abstract void addChampsTitre();
	
	public abstract void addChampsSecondPrenom();
	
	public abstract void addChampsSuffixe();
	
	public abstract void addChampsSurnom();
	
	public abstract void addChampsProfession();	
	
	public abstract void addChampsService();
	
	public abstract void addChampsNomJeuneFille();
	
	public abstract void addChampsTelephone();
	
	public abstract void addChampsEmail();
	
	public abstract void addChampsUrl();
	
	public abstract void addChampsDateNaissance();
	
	public abstract void addChampsRendezVous();
	
	public abstract void addChampsNomsAssocies();		
	
	public abstract void addChampsMessagerie();
	
	public abstract void addChampsAdresse();
			
	public abstract void remChampsTitre();
		
	public abstract void remChampsSecondPrenom();
		
	public abstract void remChampsSuffixe();
		
	public abstract void remChampsSurnom();
		
	public abstract void remChampsProfession();
		
	public abstract void remChampsService();
	
	// GETTERS SETTERS

	public abstract ArrayList<Groupe> getGroupes();

	public abstract void setGroupes(ArrayList<Groupe> groupes);

	public abstract Groupe getCurrentGroupe();

	public abstract void setCurrentGroupe(Groupe currentGroupe);

	public abstract Fiche getCurrentFiche();

	public abstract void setCurrentFiche(Fiche currentFiche);

	public abstract ArrayList<Fiche> getAffichage();

	public abstract void setAffichage(ArrayList<Fiche> affichage);

	public abstract Fiche getModele();

	public abstract void setModele(Fiche modele);

	public abstract Fiche getEdition();

	public abstract void setEdition(Fiche edition);

	public abstract String getMotcle();

	public abstract void setMotcle(String motcle);
	
	public ArrayList<Observer> getListeObserver() {
		return listeObserver;
	}
	
	// METHODE IMPLEMENTEES DE OBSERVABLE

	public void addObserver(Observer obs) {
		this.listeObserver.add(obs);
	}

	public void removeObserver() {
		listeObserver = new ArrayList<Observer>();
	}
	
	public void updateObserver() {				
		for(Observer obs : listeObserver)
			obs.update(this.groupes,this.currentGroupe,this.currentFiche,this.modele);		
	}
	
	public void serializer(){
		
		try {
			FileOutputStream fos = new FileOutputStream("carnet.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.flush();
			oos.close();
		}
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void deSerializerCarnet(){
		
		try {
			FileInputStream fis = new FileInputStream("carnet.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    AbstractCarnet c = (AbstractCarnet) ois.readObject();
		    
		    groupes = c.getGroupes();
			currentGroupe = c.getCurrentGroupe();
			currentFiche = c.getCurrentFiche();
			
			affichage = c.getAffichage();
			modele = c.modele;
			edition = c.getEdition();
			motcle = c.getMotcle();	

		    
		    
		} 
		catch (java.io.IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}		
	}
	
}


