package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import main.Observer;
import modele.Fiche;
import modele.Groupe;

import controleur.AbstractControleur;


public class FenetrePrincipale extends JFrame implements Observer{
	
	private static final long serialVersionUID = 1L;
	
	private AbstractControleur controleur;
	
	private Menu menu;
	
	private JSplitPane sp1;
	private JSplitPane sp2;
	
	private ColonneGroupe groupe;
	private ColonneNom nom;
	private ColonneCarte carte;
	
	private ChampsRecherche cr1;
	
	private Icones icones;

	private Modele fenetreModele;
	public FenetrePrincipale(AbstractControleur controleur){
		
		this.controleur = controleur;
		this.setIcones(new Icones());
		this.setTitle("Carnet d'Adresses");
        this.setSize(800, 800);
        this.setMinimumSize(new Dimension(214,139)); 
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new FenetreListener());
        this.setLayout(new BorderLayout());
    	
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
		} catch (Exception e) {}		
		

	
		this.carte = new ColonneCarte(this.icones,this.controleur);
		this.nom = new ColonneNom("Nom",this.icones,this.controleur);
		this.groupe = new ColonneGroupe("Groupe",this.icones,this.controleur,this.nom);
		this.cr1 = new ChampsRecherche(this.icones,this.nom);
		this.menu = new Menu(controleur);
		
        this.sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.groupe, this.nom);
        this.sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp1, this.carte);        
        
        this.setJMenuBar(this.menu);       
        this.add(cr1, BorderLayout.NORTH);
        this.add(sp2,BorderLayout.CENTER);        
        
        this.setIconImage(icones.getCarnet().getImage());
        
        this.setVisible(true);
        
		
    }
	
	public void setIcones(Icones icones) {
		this.icones = icones;
	}

	public Icones getIcones() {
		return icones;
	}
	
	public ColonneGroupe getGroupe() {
		
		return this.groupe;
		
	}

	public class FenetreListener implements WindowListener{
		
		@Override
		public void windowActivated(WindowEvent arg0) {

		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
		
			controleur.serializer();
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			
		}

	}	

	@Override
	public void update(ArrayList<Groupe> carnet, Groupe groupe, Fiche fiche, Fiche modele) {
		
		this.groupe.setCarnet(carnet); 
		this.nom.setGroupe(groupe,fiche); 
		this.carte.setFiche(fiche,icones);	
		this.groupe.initialiser();
		this.nom.initialiser();
		//if(fiche!=null){
			this.carte.initialiser();
		if(this.fenetreModele==null){
			this.fenetreModele = new Modele(this, "Modèle de carte", true, controleur, icones, modele);
			this.menu.setFenetre(this.fenetreModele);
			this.menu.setFiche(fiche);
		}
		this.fenetreModele.initComponent();
				
	}
	
}
