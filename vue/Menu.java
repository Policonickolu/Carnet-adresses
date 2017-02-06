package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

import modele.Fiche;
import modele.Groupe;

import controleur.AbstractControleur;

public class Menu extends JMenuBar {

	private static final long serialVersionUID = 1L;

	private JMenu menu1 = new JMenu("Fichier");
		private JMenuItem item11 = new JMenuItem("Quitter");
		private JMenuItem item12 = new JMenuItem("Nouvelle Carte");
		private JMenuItem item13 = new JMenuItem("Nouveau Groupe");
	private JMenu menu2 = new JMenu("Options");
		private JMenuItem item21 = new JMenuItem("Gestion du modèle de carte");
		private JMenu menu22 = new JMenu("Afficher le prénom");
			private JRadioButtonMenuItem item221 = new JRadioButtonMenuItem("Avant le Nom",true);
			private JRadioButtonMenuItem item222 = new JRadioButtonMenuItem("Après le Nom",false);
		private JMenuItem item23 = new JMenuItem("Fusion des doublons");
	private JMenu menu3 = new JMenu("Edition");
		private JMenu menu31 = new JMenu("Ajouter/Retirer des champs");
			private JMenuItem cb1;
			private JMenuItem cb2;
			private JMenuItem cb3;
			private JMenuItem cb4;
			private JMenuItem cb5;
			private JMenuItem cb6;
			private JMenuItem cb7;
			private JMenuItem cb8;
			private JMenuItem cb9;
			private JMenuItem cb10;
			private JMenuItem cb11;
			private JMenuItem cb12;
			private JMenuItem cb13;
			private JMenuItem cb14;
			private JMenuItem cb15;
		private JMenuItem item32 = new JMenuItem("Supprimer la carte sélectionnée");	
		private JMenuItem item33 = new JMenuItem("Supprimer le groupe sélectionné");
		private JMenuItem item34 = new JMenuItem("Retirer les étiquettes personnalisées");
		private JMenuItem item35 = new JMenuItem("Supprimer l'image de la carte");	

			
		private AbstractControleur controleur;
		private Modele fenetreModele;
		
		
		
		
		public Menu(AbstractControleur controleur){
		
		this.controleur = controleur;
		ButtonGroup bg = new ButtonGroup();
		bg.add(item221);
		bg.add(item222);
		
		this.item11.addActionListener(new MenuFermerListener());
		this.item12.addActionListener(new AddCarteListener());
		this.item13.addActionListener(new AddGroupeListener());
        this.item221.addActionListener(new AvantNomListener());
        this.item222.addActionListener(new ApresNomListener());
        this.item23.addActionListener(new FusionListener());
        this.item32.addActionListener(new RemCarteListener());
        this.item33.addActionListener(new RemGroupeListener());
        this.item34.addActionListener(new RemEtiListener());
        this.item35.addActionListener(new RemPhotoListener());
        
		this.menu22.add(item221);
		this.menu22.add(item222);
		
		this.menu1.add(item12);
		this.menu1.add(item13);
		this.menu1.add(item11);
        this.menu2.add(item21);
        this.menu2.add(menu22);
        this.menu2.add(item23);
        this.menu3.add(menu31);
        this.menu3.add(item35);
        this.menu3.add(item32);
        this.menu3.add(item33);
        this.menu3.add(item34);
        
        this.add(menu1);        
        this.add(menu2);
        this.add(menu3);
        
	}

	public class MenuFermerListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			controleur.serializer();
			System.exit(0);
			
		}

	}
	
	public class ModeleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			fenetreModele.setVisible(true);
			
		}		
		
	}
	
	public class AvantNomListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			controleur.ordreNom(false);
			
		}		
		
	}
	
	public class ApresNomListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			controleur.ordreNom(true);
			
		}		
		
	}
	
	public class FusionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			controleur.fusionDoublon();
			
		}		
		
	}
	
	public class ChampsTeteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {	
						
			controleur.setIs(((JMenuItem) arg0.getSource()).getText());			
			if(!ColonneCarte.isModeEdition())ColonneCarte.setModeEdition(true);
			controleur.finEdition();
			
		}		
		
	}
	
	public class ChampsCorpsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
						
			controleur.addChamps(((JMenuItem) arg0.getSource()).getText());				
			if(!ColonneCarte.isModeEdition())ColonneCarte.setModeEdition(true);
			controleur.finEdition();
			
		}
		
		
	}
	
	public class RemCarteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
						
			
			Groupe g = controleur.getCurrentGroupe();
			int i = g.indexDe(controleur.getCurrentFiche());
			if(g.size()>0){
				if(g.getNom()!="Tous"){
					String[] choix = {"Du carnet d'adresses", "Seulement du groupe", "Annuler"};
					int rang = JOptionPane.showOptionDialog(null,
											"Voulez-vous supprimer cette carte ?",
											"Suppression de carte",
											JOptionPane.YES_NO_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null, 
											choix,
											choix[2]);
					if(rang==0)controleur.removeFiche();
					else if(rang==1)controleur.removeFicheGroupe();
				}
				else{
					String[] choix = {"Oui","Annuler"};
					int rang = JOptionPane.showOptionDialog(null,
											"Voulez-vous supprimer cette carte ?",
											"Suppression de carte",
											JOptionPane.OK_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null,
											choix,
											choix[1]);
					if(rang==0)controleur.removeFiche();
				}
				if(g.size()>i){
					controleur.nouvelleSelectionFiche(g.get(i));
				}
			}
			
		}
		
		
	}
	
	public class RemGroupeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
						
			int i = controleur.getCarnet().getGroupes().indexOf(controleur.getCurrentGroupe());
			if(i!=0){
				String[] choix = {"Oui","Annuler"};
				int rang = JOptionPane.showOptionDialog(null,
											"Voulez-vous supprimer ce groupe ?",
											"Suppression de groupe",
											JOptionPane.OK_CANCEL_OPTION,
											JOptionPane.QUESTION_MESSAGE,
											null,
											choix,
											choix[1]);
				if(rang==0)controleur.removeGroupe();
			}
			if(controleur.getCarnet().getGroupes().size()>i+1){
				controleur.nouvelleSelectionGroupe(controleur.getCarnet().getGroupes().get(i));
			}
			
		}		
		
	}
	
	public class RemEtiListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String[] choix = {"Du carnet d'adresses", "Seulement de la carte selectionnée", "Annuler"};
			int rang = JOptionPane.showOptionDialog(null,
									"Voulez-vous supprimer les étiquettes personnalisées ?",
									"Suppression d'étiquettes",
									JOptionPane. YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE,
									null, 
									choix,
									choix[2]);
			if(rang==0)controleur.remAllEtiquette();
			else if(rang==1)controleur.remEtiquette();
			
		}
		
	}
	
	public class AddCarteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Fiche f = controleur.addNouveauNom();
			controleur.nouvelleSelectionFiche(f);
			ColonneCarte.setModeEdition(true);
			controleur.finEdition();
			
		}
		
	}
	
	public class AddGroupeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {			
			String s = "";
			s = "" + JOptionPane.showInputDialog(null, "Entrez un nom de Groupe", "Nouveau Groupe", JOptionPane.QUESTION_MESSAGE);
			if(!s.trim().equals("")){
				controleur.nouvelleSelectionGroupe(controleur.addNouveauGroupe(s)); 
			}
		}
		
	}
	
	public class RemPhotoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			controleur.removePhoto();			
		}
		
		
		
	}
	
	public void setFenetre(Modele fenetreModele){
		
		this.fenetreModele = fenetreModele;
		this.item21.addActionListener(new ModeleListener());
		
	}

	public void setFiche(Fiche fiche) {
		
		this.cb1 = new JMenuItem("Titre");
		this.cb1.addActionListener(new ChampsTeteListener());
		this.cb2 = new JMenuItem("Second prénom");
		this.cb2.addActionListener(new ChampsTeteListener());
		this.cb3 = new JMenuItem("Surnom");
		this.cb3.addActionListener(new ChampsTeteListener());
		this.cb4 = new JMenuItem("Suffixe");
		this.cb4.addActionListener(new ChampsTeteListener());
		this.cb5 = new JMenuItem("Profession");
		this.cb5.addActionListener(new ChampsTeteListener());
		this.cb6 = new JMenuItem("Service");
		this.cb6.addActionListener(new ChampsTeteListener());
		this.cb7 = new JMenuItem("Nom de jeune fille");
		this.cb7.addActionListener(new ChampsCorpsListener());
		this.cb8 = new JMenuItem("Numéro de téléphone");
		this.cb8.addActionListener(new ChampsCorpsListener());
		this.cb9 = new JMenuItem("Adresse électronique");
		this.cb9.addActionListener(new ChampsCorpsListener());
		this.cb10 = new JMenuItem("Page web");
		this.cb10.addActionListener(new ChampsCorpsListener());
		this.cb11 = new JMenuItem("Date de naissance");
		this.cb11.addActionListener(new ChampsCorpsListener());
		this.cb12 = new JMenuItem("Rendez-vous");
		this.cb12.addActionListener(new ChampsCorpsListener());
		this.cb13 = new JMenuItem("Nom");
		this.cb13.addActionListener(new ChampsCorpsListener());
		this.cb14 = new JMenuItem("Adresse de messagerie");
		this.cb14.addActionListener(new ChampsCorpsListener());
		this.cb15 = new JMenuItem("Adresse");
		this.cb15.addActionListener(new ChampsCorpsListener());
		
		this.menu31.add(cb1);
		this.menu31.add(cb2);
		this.menu31.add(cb3);
		this.menu31.add(cb4);
		this.menu31.add(cb5);
		this.menu31.add(cb6);
		this.menu31.add(cb7);
		this.menu31.add(cb8);
		this.menu31.add(cb9);
		this.menu31.add(cb10);
		this.menu31.add(cb11);
		this.menu31.add(cb12);
		this.menu31.add(cb13);
		this.menu31.add(cb14);
		this.menu31.add(cb15);

	}
	
}
