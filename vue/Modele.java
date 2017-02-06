package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import controleur.AbstractControleur;
import modele.Champs;
import modele.ChampsAdresse;
import modele.ChampsDate;
import modele.Fiche;


public class Modele extends JDialog{
	
	private static final long serialVersionUID = 1L;
	
	private AbstractControleur controleur;
	private Fiche modele;
	private Icones icones;
	private JScrollPane sp1;
	
	private JMenuBar mb;
	private JMenu m1;
	
	private JCheckBoxMenuItem cb1;
	private JCheckBoxMenuItem cb2;
	private JCheckBoxMenuItem cb3;
	private JCheckBoxMenuItem cb4;
	private JCheckBoxMenuItem cb5;
	private JCheckBoxMenuItem cb6;
	private JCheckBoxMenuItem cb7;
	private JCheckBoxMenuItem cb8;
	private JCheckBoxMenuItem cb9;
	private JCheckBoxMenuItem cb10;
	private JCheckBoxMenuItem cb11;
	private JCheckBoxMenuItem cb12;
	private JCheckBoxMenuItem cb13;
	private JCheckBoxMenuItem cb14;
	private JCheckBoxMenuItem cb15;

	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel p4;
	private JPanel p5;
	private JPanel p6;
	private JPanel p7;
	private JPanel p8;
	
	private ArrayList<InfoCarteModele> al1;
	private ArrayList<InfoCarteModele> al2;
	private ArrayList<InfoCarteModele> al3;
	private ArrayList<InfoCarteModele> al4;
	private ArrayList<InfoCarteModele> al5;
	private ArrayList<InfoCarteModele> al6;
	private ArrayList<InfoCarteModele> al7;
	private ArrayList<InfoCarteModele> al8;
	private ArrayList<InfoCarteModele> al9;
	
	
	

	public Modele(JFrame parent, String title, boolean modal, AbstractControleur controleur,Icones icones, Fiche modele){
		super(parent, title, modal);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()) ;
		} catch (Exception e) {}
		
		this.controleur = controleur;
		this.icones = icones;
		this.modele = modele;
		this.setSize(588, 650);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		mb = new JMenuBar();
		m1 = new JMenu("Ajouter des champs");
		
		cb1 = new JCheckBoxMenuItem("Titre",(modele.getIsTitre() ? true : false));
		cb2 = new JCheckBoxMenuItem("Second prénom",(modele.getIsSecondPrenom() ? true : false));
		cb3 = new JCheckBoxMenuItem("Surnom",(modele.getIsSurnom() ? true : false));
		cb4 = new JCheckBoxMenuItem("Suffixe",(modele.getIsSuffixe() ? true : false));
		cb5 = new JCheckBoxMenuItem("Profession",(modele.getIsProfession() ? true : false));
		cb6 = new JCheckBoxMenuItem("Service",(modele.getIsService() ? true : false));
		cb7 = new JCheckBoxMenuItem("Nom de jeune fille",(modele.getNomJeuneFille().size()>0 ? true : false));
		cb8 = new JCheckBoxMenuItem("Numéro de téléphone",(modele.getTelephone().size()>0 ? true : false));
		cb9 = new JCheckBoxMenuItem("Adresse électronique",(modele.getEmail().size()>0 ? true : false));
		cb10 = new JCheckBoxMenuItem("Page web",(modele.getUrl().size()>0 ? true : false));
		cb11 = new JCheckBoxMenuItem("Date de naissance",(modele.getDateNaissance().size()>0 ? true : false));
		cb12 = new JCheckBoxMenuItem("Rendez-vous",(modele.getRendezVous().size()>0 ? true : false));
		cb13 = new JCheckBoxMenuItem("Nom",(modele.getNomsAssocies().size()>0 ? true : false));
		cb14 = new JCheckBoxMenuItem("Adresse de messagerie",(modele.getMessagerie().size()>0 ? true : false));
		cb15 = new JCheckBoxMenuItem("Adresse",(modele.getAdresse().size()>0 ? true : false));

		
		cb1.addActionListener(new ChampsTeteListener());
		cb2.addActionListener(new ChampsTeteListener());
		cb3.addActionListener(new ChampsTeteListener());
		cb4.addActionListener(new ChampsTeteListener());
		cb5.addActionListener(new ChampsTeteListener());
		cb6.addActionListener(new ChampsTeteListener());
		cb7.addActionListener(new ChampsCorpsListener());
		cb8.addActionListener(new ChampsCorpsListener());
		cb9.addActionListener(new ChampsCorpsListener());
		cb10.addActionListener(new ChampsCorpsListener());
		cb11.addActionListener(new ChampsCorpsListener());
		cb12.addActionListener(new ChampsCorpsListener());
		cb13.addActionListener(new ChampsCorpsListener());
		cb14.addActionListener(new ChampsCorpsListener());
		cb15.addActionListener(new ChampsCorpsListener());
		
		if(modele.getNomJeuneFille().size()>0)cb7.setEnabled(false);
		if(modele.getTelephone().size()>0)cb8.setEnabled(false);
		if(modele.getEmail().size()>0)cb9.setEnabled(false);
		if(modele.getUrl().size()>0)cb10.setEnabled(false);
		if(modele.getDateNaissance().size()>0)cb11.setEnabled(false);
		if(modele.getRendezVous().size()>0)cb12.setEnabled(false);
		if(modele.getNomsAssocies().size()>0)cb13.setEnabled(false);
		if(modele.getMessagerie().size()>0)cb14.setEnabled(false);
		if(modele.getAdresse().size()>0)cb15.setEnabled(false);
		
		m1.add(cb1);
		m1.add(cb2);
		m1.add(cb3);
		m1.add(cb4);
		m1.add(cb5);
		m1.add(cb6);
		m1.addSeparator();
		m1.add(cb7);
		m1.add(cb8);
		m1.add(cb9);
		m1.add(cb10);
		m1.add(cb11);
		m1.add(cb12);
		m1.add(cb13);
		m1.add(cb14);
		m1.add(cb15);
		
		mb.add(m1);
		
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p2 = new JPanel();
		p2.setBackground(Color.GRAY);
		p2.setPreferredSize(new Dimension(50,50));
		p3 = new JPanel();
		p3.setBackground(Color.GRAY);
		p3.setPreferredSize(new Dimension(50,50));
		p4 = new JPanel();
		p4.setBackground(Color.GRAY);
		p4.setPreferredSize(new Dimension(50,50));
		p5 = new JPanel();
		p5.setBackground(Color.GRAY);
		p5.setPreferredSize(new Dimension(50,50));
		
		
		p7 = new JPanel();
		p7.setLayout(new BoxLayout(p7,BoxLayout.Y_AXIS));
		p7.setBackground(Color.WHITE);

		
		p6 = new JPanel();
		p6.setLayout(new BoxLayout(p6,BoxLayout.Y_AXIS));
		p6.setMinimumSize(new Dimension(470,1));
		
		p8 = new JPanel();
		p8.setBackground(Color.WHITE);
		
		al1 = new ArrayList<InfoCarteModele>();
		al2 = new ArrayList<InfoCarteModele>();
		al3 = new ArrayList<InfoCarteModele>();
		al4 = new ArrayList<InfoCarteModele>();
		al5 = new ArrayList<InfoCarteModele>();
		al6 = new ArrayList<InfoCarteModele>();
		al7 = new ArrayList<InfoCarteModele>();
		al8 = new ArrayList<InfoCarteModele>();
		al9 = new ArrayList<InfoCarteModele>();
		
		for(int i=0;i<modele.getNomJeuneFille().size();i++){
			Champs c = modele.getNomJeuneFille().get(i);
				al1.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Nom de jeune fille",i,false));	
		}
		for(int i=0;i<modele.getTelephone().size();i++){
			Champs c = modele.getTelephone().get(i);				
				if(i==modele.getTelephone().size()-1){
					al2.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Numéro de téléphone",i,true));
				}
				else{
					al2.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Numéro de téléphone",i,false));
				}	
		}
		for(int i=0;i<modele.getEmail().size();i++){
			Champs c = modele.getEmail().get(i);
				if(i==modele.getEmail().size()-1){
					al3.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Adresse électronique",i,true));
				}
				else{
					al3.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Adresse électronique",i,false));
				}	
				
		}
		for(int i=0;i<modele.getUrl().size();i++){
			Champs c = modele.getUrl().get(i);
				if(i==modele.getUrl().size()-1){
					al4.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Page web",i,true));
				}
				else{
					al4.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Page web",i,false));
				}	
		}
		for(int i=0;i<modele.getDateNaissance().size();i++){
			ChampsDate c = modele.getDateNaissance().get(i);
				al5.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Date de naissance",i,false));	
		}
		for(int i=0;i<modele.getRendezVous().size();i++){
			Champs c = modele.getRendezVous().get(i);
				al6.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Rendez-vous",i,false));	
		}
		for(int i=0;i<modele.getNomsAssocies().size();i++){
			Champs c = modele.getNomsAssocies().get(i);				
				if(i==modele.getNomsAssocies().size()-1){
					al7.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Nom",i,true));
				}
				else{
					al7.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Nom",i,false));
				}		
		}
		for(int i=0;i<modele.getMessagerie().size();i++){
			Champs c = modele.getMessagerie().get(i);
				if(i==modele.getMessagerie().size()-1){
					al8.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Adresse de messagerie",i,true));
				}
				else{
					al8.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Adresse de messagerie",i,false));
				}	
		}
		for(int i=0;i<modele.getAdresse().size();i++){
			ChampsAdresse c = modele.getAdresse().get(i);
				if(i==modele.getAdresse().size()-1){
					al9.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Rue",i,true));
					al9.add(new InfoCarteModele(controleur,"Code"));
					al9.add(new InfoCarteModele(controleur,"Ville"));
					al9.add(new InfoCarteModele(controleur,"Pays"));
				}
				else{
					al9.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Rue",i,false));
					al9.add(new InfoCarteModele(controleur,"Code"));
					al9.add(new InfoCarteModele(controleur,"Ville"));
					al9.add(new InfoCarteModele(controleur,"Pays"));		
				}
		}
		
		p6.add(new InfoCarteModele(controleur,"Prénom Nom de famille"));
		p6.add(new InfoCarteModele(controleur,"Entreprise"));
		if(modele.getIsTitre())p6.add(new InfoCarteModele(controleur,"Titre"));
		if(modele.getIsSecondPrenom())p6.add(new InfoCarteModele(controleur,"Second prénom"));
		if(modele.getIsSurnom())p6.add(new InfoCarteModele(controleur,"Surnom"));
		if(modele.getIsSuffixe())p6.add(new InfoCarteModele(controleur,"Suffixe"));
		if(modele.getIsProfession())p6.add(new InfoCarteModele(controleur,"Profession"));
		if(modele.getIsService())p6.add(new InfoCarteModele(controleur,"Service"));
		
		p6.add(Box.createVerticalStrut(20));
		
		if(al1.size() > 0){
			for(int i=0;i<al1.size();i++){
				p6.add(al1.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al2.size() > 0){
			for(int i=0;i<al2.size();i++){
				p6.add(al2.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al3.size() > 0){
			for(int i=0;i<al3.size();i++){
				p6.add(al3.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al4.size() > 0){
			for(int i=0;i<al4.size();i++){
				p6.add(al4.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al5.size() > 0){
			for(int i=0;i<al5.size();i++){
				p6.add(al5.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al6.size() > 0){
			for(int i=0;i<al6.size();i++){
				p6.add(al6.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al7.size() > 0){
			for(int i=0;i<al7.size();i++){
				p6.add(al7.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al8.size() > 0){
			for(int i=0;i<al8.size();i++){
				p6.add(al8.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al9.size() > 0){
			for(int i=0;i<al9.size();i++){
				p6.add(al9.get(i));
			}		
			p6.add(Box.createVerticalStrut(20));
		}
		p6.add(new JLabel("Note :"));
		
		p6.setBackground(Color.WHITE);
		p6.setAlignmentY(Component.TOP_ALIGNMENT);
        p6.setAlignmentX(Component.LEFT_ALIGNMENT);
		
        p7.add(p6);
        
		sp1 = new JScrollPane(p7,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp1.setBackground(Color.WHITE);
		
		p1.add(sp1,BorderLayout.CENTER);
		p1.add(p2,BorderLayout.NORTH);
		p1.add(p3,BorderLayout.EAST);
		p1.add(p4,BorderLayout.SOUTH);
		p1.add(p5,BorderLayout.WEST);		
		
		this.setContentPane(p1);
		this.setJMenuBar(mb);
		this.setBackground(Color.WHITE);
		
	}
	
	
	
	
	
	
	
	
	
	
	public void initComponent(){
		
		this.p6.removeAll();
		
		al1.clear();
		al2.clear();
		al3.clear();
		al4.clear();
		al5.clear();
		al6.clear();
		al7.clear();
		al8.clear();
		al9.clear();
		
		for(int i=0;i<modele.getNomJeuneFille().size();i++){
			Champs c = modele.getNomJeuneFille().get(i);
				al1.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Nom de jeune fille",i,false));	
		}
		for(int i=0;i<modele.getTelephone().size();i++){
			Champs c = modele.getTelephone().get(i);				
				if(i==modele.getTelephone().size()-1){
					al2.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Numéro de téléphone",i,true,true));
				}
				else{
					al2.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Numéro de téléphone",i,false,true));
				}	
		}
		for(int i=0;i<modele.getEmail().size();i++){
			Champs c = modele.getEmail().get(i);
				if(i==modele.getEmail().size()-1){
					al3.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Adresse électronique",i,true,true));
				}
				else{
					al3.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Adresse électronique",i,false,true));
				}	
				
		}
		for(int i=0;i<modele.getUrl().size();i++){
			Champs c = modele.getUrl().get(i);
				if(i==modele.getUrl().size()-1){
					al4.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Page web",i,true,true));
				}
				else{
					al4.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Page web",i,false,true));
				}	
		}
		for(int i=0;i<modele.getDateNaissance().size();i++){
			ChampsDate c = modele.getDateNaissance().get(i);
				al5.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Date de naissance",i,false));	
		}
		for(int i=0;i<modele.getRendezVous().size();i++){
			Champs c = modele.getRendezVous().get(i);
				al6.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Rendez-vous",i,false));	
		}
		for(int i=0;i<modele.getNomsAssocies().size();i++){
			Champs c = modele.getNomsAssocies().get(i);				
				if(i==modele.getNomsAssocies().size()-1){
					al7.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Nom",i,true,true));
				}
				else{
					al7.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Nom",i,false,true));
				}		
		}
		for(int i=0;i<modele.getMessagerie().size();i++){
			Champs c = modele.getMessagerie().get(i);
				if(i==modele.getMessagerie().size()-1){
					al8.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Adresse de messagerie",i,true,true));
				}
				else{
					al8.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Adresse de messagerie",i,false,true));
				}	
		}
		for(int i=0;i<modele.getAdresse().size();i++){
			ChampsAdresse c = modele.getAdresse().get(i);
				if(i==modele.getAdresse().size()-1){
					al9.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Rue",i,true,true));
					al9.add(new InfoCarteModele(controleur,"Code"));
					al9.add(new InfoCarteModele(controleur,"Ville"));
					al9.add(new InfoCarteModele(controleur,"Pays"));
				}
				else{
					al9.add(new InfoCarteModele(controleur,icones,c.getEtiquette(),"Rue",i,false,true));
					al9.add(new InfoCarteModele(controleur,"Code"));
					al9.add(new InfoCarteModele(controleur,"Ville"));
					al9.add(new InfoCarteModele(controleur,"Pays"));		
				}
		}
		
		if(modele.getNomJeuneFille().size()==0){cb7.setEnabled(true);cb7.setSelected(false);}
		if(modele.getTelephone().size()==0){cb8.setEnabled(true);cb8.setSelected(false);}
		if(modele.getEmail().size()==0){cb9.setEnabled(true);cb9.setSelected(false);}
		if(modele.getUrl().size()==0){cb10.setEnabled(true);cb10.setSelected(false);}
		if(modele.getDateNaissance().size()==0){cb11.setEnabled(true);cb11.setSelected(false);}
		if(modele.getRendezVous().size()==0){cb12.setEnabled(true);cb12.setSelected(false);}
		if(modele.getNomsAssocies().size()==0){cb13.setEnabled(true);cb13.setSelected(false);}		
		if(modele.getMessagerie().size()==0){cb14.setEnabled(true);cb14.setSelected(false);}
		if(modele.getAdresse().size()==0){cb15.setEnabled(true);cb15.setSelected(false);}
		
		
		p6.add(new InfoCarteModele(controleur,"Prénom Nom de famille"));
		p6.add(new InfoCarteModele(controleur,"Entreprise"));
		if(modele.getIsTitre())p6.add(new InfoCarteModele(controleur,"Titre"));
		if(modele.getIsSecondPrenom())p6.add(new InfoCarteModele(controleur,"Second prénom"));
		if(modele.getIsSurnom())p6.add(new InfoCarteModele(controleur,"Surnom"));
		if(modele.getIsSuffixe())p6.add(new InfoCarteModele(controleur,"Suffixe"));
		if(modele.getIsProfession())p6.add(new InfoCarteModele(controleur,"Profession"));
		if(modele.getIsService())p6.add(new InfoCarteModele(controleur,"Service"));
		
		p6.add(Box.createVerticalStrut(30));
		
		if(al1.size() > 0){
			for(int i=0;i<al1.size();i++){
				p6.add(al1.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al2.size() > 0){
			for(int i=0;i<al2.size();i++){
				p6.add(al2.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al3.size() > 0){
			for(int i=0;i<al3.size();i++){
				p6.add(al3.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al4.size() > 0){
			for(int i=0;i<al4.size();i++){
				p6.add(al4.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al5.size() > 0){
			for(int i=0;i<al5.size();i++){
				p6.add(al5.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al6.size() > 0){
			for(int i=0;i<al6.size();i++){
				p6.add(al6.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al7.size() > 0){
			for(int i=0;i<al7.size();i++){
				p6.add(al7.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al8.size() > 0){
			for(int i=0;i<al8.size();i++){
				p6.add(al8.get(i));
			}
			p6.add(Box.createVerticalStrut(10));
		}
		if(al9.size() > 0){
			for(int i=0;i<al9.size();i++){
				p6.add(al9.get(i));
			}		
			
		}	
		p6.add(Box.createVerticalStrut(30));
		p6.add(new JLabel("Note :"));
		
		
		p6.setBackground(Color.WHITE);	
		p6.setAlignmentY(Component.TOP_ALIGNMENT);
        p6.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		p6.revalidate();
		
		p7.add(p6);
		
	}
	
	public class ChampsTeteListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {	
						
			controleur.setIsModele(((JMenuItem) arg0.getSource()).getText());			
			
		}		
		
	}
	
	public class ChampsCorpsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			((JMenuItem) arg0.getSource()).setEnabled(false);
						
			controleur.addChampsModele(((JMenuItem) arg0.getSource()).getText());				
			
		}
		
		
	}
		
}