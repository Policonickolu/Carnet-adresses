package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import controleur.AbstractControleur;


import modele.Adresse;
import modele.Champs;
import modele.ChampsAdresse;
import modele.ChampsDate;
import modele.Fiche;

public class Carte extends JPanel {

	private static final long serialVersionUID = 1L;

	// AFFICHAGE
	
	private Fiche fiche = new Fiche();
	private AbstractControleur controleur;
	private JPanel marge = new JPanel();
	
	private Box b1;
		private JPanel p11 = new JPanel();
		private Photo photo;
		private Box b11;
			private JLabel l1 = new JLabel();
				private Font f1 = new Font("Arial", Font.BOLD, 20);
			private JLabel l2 = new JLabel();
			private JLabel l3 = new JLabel();
			private JLabel l4 = new JLabel();
			private JLabel l5 = new JLabel();
			private JLabel l6 = new JLabel();
				private Font f2 = new Font("Arial", Font.BOLD , 10);
			
	private Box b2;
		private ArrayList<InfoCarte> al1 = new ArrayList<InfoCarte>();
		private ArrayList<InfoCarte> al2 = new ArrayList<InfoCarte>();
		private ArrayList<InfoCarte> al3 = new ArrayList<InfoCarte>();
		private ArrayList<InfoCarte> al4 = new ArrayList<InfoCarte>();
		private ArrayList<InfoCarte> al5 = new ArrayList<InfoCarte>();
		private ArrayList<InfoCarte> al6 = new ArrayList<InfoCarte>();
		private ArrayList<InfoCarte> al7 = new ArrayList<InfoCarte>();
		private ArrayList<InfoCarte> al8 = new ArrayList<InfoCarte>();
		private ArrayList<InfoCarte> al9 = new ArrayList<InfoCarte>();
	
	private Box b3;
		private JPanel p31 = new JPanel();
		private Box b31;
			private JLabel l7 = new JLabel("Note :");
			private JTextPane tp1 = new JTextPane();

    
	
  
	public Carte(Fiche fiche,AbstractControleur controleur){
		
		this.fiche = fiche;
		this.controleur = controleur;
		
		this.photo = new Photo(fiche,controleur);
        this.photo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.photo.setPreferredSize(new Dimension(90,90));
		
        /* Panneau de la Sous Colonne 1 */
        
        
        p11.setBackground(Color.WHITE);
        p11.setMaximumSize(new Dimension(100,100));
        p11.setMinimumSize(new Dimension(100,100));
        p11.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        p11.add(photo,gbc);
        
        
        /* Panneau de la Sous Colonne 3 */
        
        p31.setBackground(Color.WHITE);
        p31.setMaximumSize(new Dimension(20,20));
        p31.setMinimumSize(new Dimension(20,20));
        p31.setAlignmentY(Component.TOP_ALIGNMENT);
        p31.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        /* Panneau marge 1 */
        
        
        marge.setBackground(Color.WHITE);
        marge.setMinimumSize(new Dimension(10,20));
        marge.setMaximumSize(new Dimension(10,20));
        
        /* Panneau BoxLayout */
        
        b1 = Box.createHorizontalBox();
        b1.setBackground(Color.WHITE);
        b1.setMinimumSize(new Dimension(160,100));
        b1.setMaximumSize(new Dimension(10000,100));
        
        b2 = Box.createVerticalBox();
        b2.setBackground(Color.WHITE);
        
        b3 = Box.createHorizontalBox();
        b3.setBackground(Color.WHITE);
        
        b11 = Box.createVerticalBox();
        b11.setBackground(Color.WHITE);
        
        b31 = Box.createVerticalBox();
        b31.setBackground(Color.WHITE);
		
		
		// 1
	
		
		
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		String s5 = "";
		String s6 = "";
		if(fiche.getShowEntreprise() != true){
			if(!fiche.getNom().equals("") || !fiche.getPrenom().equals("")){
				s1 += (!fiche.getTitre().equals("") ? fiche.getTitre() + " " : "");
				s2 += (!fiche.getSurnom().equals("") ? "<< " + fiche.getSurnom() + " >>" : "");
				s3 += (!fiche.getSuffixe().equals("") ? fiche.getSuffixe() : "");
				s4 += (!fiche.getProfession().equals("") ? fiche.getProfession() : "");
				s5 += (!fiche.getService().equals("") ? fiche.getService() : ""); 
				
				if(Fiche.getNomAvantPrenom()){
					s1 += (!fiche.getNom().equals("") ? fiche.getNom() : "") + " " + (!fiche.getPrenom().equals("") ? fiche.getPrenom() : "") + (!fiche.getSecondPrenom().equals("") ? " " + fiche.getSecondPrenom() : "");
				}
				else{
					s1 += (!fiche.getPrenom().equals("") ? fiche.getPrenom() : "") + (!fiche.getSecondPrenom().equals("") ? " " + fiche.getSecondPrenom() : "") + " " + (!fiche.getNom().equals("") ? fiche.getNom() : "");
				}
				s6 += (!fiche.getEntreprise().equals("") ? fiche.getEntreprise() : ""); 
			}
			else{
				s1 += "Sans nom";			
			}
		}
		else{
			if(!fiche.getEntreprise().equals("")){
				s2 += (!fiche.getTitre().equals("")? fiche.getTitre() + " " : "");
				s3 += (!fiche.getSurnom().equals("") ? "<< " + fiche.getSurnom() + " >>" : "");
				s4 += (!fiche.getSuffixe().equals("") ? fiche.getSuffixe() : "");
				s5 += (!fiche.getProfession().equals("") ? fiche.getProfession() : "");
				s6 += (!fiche.getService().equals("") ? fiche.getService() : ""); 
			
				if(Fiche.getNomAvantPrenom()){
					s2 += (!fiche.getNom().equals("") ? fiche.getNom() : "Nom de famille") + " " + (!fiche.getPrenom().equals("") ? fiche.getPrenom() : "Prénom") + (!fiche.getSecondPrenom().equals("") ? " " + fiche.getSecondPrenom() : "");
				}
				else{
					s2 += (!fiche.getPrenom().equals("") ? fiche.getPrenom() : "Prénom") + (!fiche.getSecondPrenom().equals("") ? " " + fiche.getSecondPrenom() : "") + " " + (!fiche.getNom().equals("") ? fiche.getNom() : "Nom de famille");
				}
				s1 += (!fiche.getEntreprise().equals("") ? fiche.getEntreprise() : "Sans nom"); 
			}
			else{
				s1 += "Sans nom";			
			}
		}
		
		s1.trim();
		s2.trim();
		s3.trim();
		s4.trim();
		s5.trim();
		s6.trim();
		
		this.l1.setFont(this.f1);
		if(s1.equals("Sans nom")){
			this.l1.setForeground(Color.GRAY);
		}
		this.l1.setText(s1);
		
		this.l2.setFont(this.f2);
		this.l2.setText(s2);
		
		this.l3.setFont(this.f2);
		this.l3.setText(s3);
		
		this.l4.setFont(this.f2);
		this.l4.setText(s4);
		
		this.l5.setFont(this.f2);
		this.l5.setText(s5);
		
		this.l6.setFont(this.f2);
		this.l6.setText(s6);
		
		this.l7.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.l7.setAlignmentY(Component.TOP_ALIGNMENT);
		this.tp1.setText(fiche.getRemarques());		
		this.tp1.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.tp1.setAlignmentY(Component.TOP_ALIGNMENT);
		this.tp1.setPreferredSize(new Dimension(300,100));
		this.tp1.setBorder(null);
		this.tp1.setFocusable(false);
		
        
		
		// 2
		
        
		for(int i=0;i<fiche.getNomJeuneFille().size();i++){
			Champs c = fiche.getNomJeuneFille().get(i);
			if(c.getTexte() != ""){
				this.al1.add(new InfoCarte(c.getEtiquette(),c.getTexte()));
			}	
		}
		for(int i=0;i<fiche.getTelephone().size();i++){
			Champs c = fiche.getTelephone().get(i);
			if(c.getTexte() != ""){
				this.al2.add(new InfoCarte(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getEmail().size();i++){
			Champs c = fiche.getEmail().get(i);
			if(c.getTexte() != ""){
				this.al3.add(new InfoCarteEmail(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getUrl().size();i++){
			Champs c = fiche.getUrl().get(i);
			if(c.getTexte() != ""){
				this.al4.add(new InfoCarteUrl(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getDateNaissance().size();i++){
			ChampsDate c = fiche.getDateNaissance().get(i);
			if(c.getTexte() != ""){
				this.al5.add(new InfoCarte(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getRendezVous().size();i++){
			Champs c = fiche.getRendezVous().get(i);
			if(c.getTexte() != ""){
				this.al6.add(new InfoCarte(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getNomsAssocies().size();i++){
			Champs c = fiche.getNomsAssocies().get(i);
			if(c.getTexte() != ""){
				this.al7.add(new InfoCarte(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getMessagerie().size();i++){
			Champs c = fiche.getMessagerie().get(i);
			if(c.getTexte() != ""){
				this.al8.add(new InfoCarte(c.getEtiquette(),c.getTexte()));
			}	
		}
		for(int i=0;i<fiche.getAdresse().size();i++){
			ChampsAdresse c = fiche.getAdresse().get(i);
			if(c.getAdresseToString().trim() != ""){
				this.al9.add(new InfoCarteAdresse(c.getEtiquette(),c.getAdresse().getRue(),c.getAdresse().getCode(),c.getAdresse().getVille(),c.getAdresse().getPays()));			
			}
		}
			
		if(al1.size() > 0){
			for(int i=0;i<al1.size();i++){
				this.b2.add(al1.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al2.size() > 0){
			for(int i=0;i<al2.size();i++){
				this.b2.add(al2.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al3.size() > 0){
			for(int i=0;i<al3.size();i++){
				this.b2.add(al3.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al4.size() > 0){
			for(int i=0;i<al4.size();i++){
				this.b2.add(al4.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al5.size() > 0){
			for(int i=0;i<al5.size();i++){
				this.b2.add(al5.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al6.size() > 0){
			for(int i=0;i<al6.size();i++){
				this.b2.add(al6.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al7.size() > 0){
			for(int i=0;i<al7.size();i++){
				this.b2.add(al7.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al8.size() > 0){
			for(int i=0;i<al8.size();i++){
				this.b2.add(al8.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al9.size() > 0){
			for(int i=0;i<al9.size();i++){
				this.b2.add(al9.get(i));
			}
		}
				
       
        /* Sous Colonne 1 */
        
        b11.setAlignmentY(Component.TOP_ALIGNMENT);
        p11.setAlignmentY(Component.TOP_ALIGNMENT);
        b11.add(this.l1);
        b11.add(this.l2);
        b11.add(this.l3);
        b11.add(this.l4);
        b11.add(this.l5);
        b11.add(this.l6);
        b1.add(Box.createHorizontalStrut(60));
        b1.add(p11);
        b1.add(b11);
        b1.setAlignmentX(Component.LEFT_ALIGNMENT);
        b1.setAlignmentY(Component.TOP_ALIGNMENT);
        
        /* Sous Colonne 2 */
        
        b2.setAlignmentX(Component.LEFT_ALIGNMENT);
        b2.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        
        /* Sous Colonne 3 */
        
        
        b31.add(l7);
        b31.add(Box.createVerticalStrut(10));
        b31.add(tp1);
        b31.add(Box.createGlue());
        b31.setAlignmentX(Component.LEFT_ALIGNMENT);
        b31.setAlignmentY(Component.TOP_ALIGNMENT);
        b3.add(p31);
        b3.add(b31);
        b3.setAlignmentX(Component.LEFT_ALIGNMENT);
        b3.setAlignmentY(Component.TOP_ALIGNMENT);
        
        /* Colonne principale */
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        this.add(b1);
        this.add(Box.createVerticalStrut(20));
        this.add(b2);
        this.add(Box.createVerticalStrut(20));
        this.add(b3);
        
		
	}

	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}

	public Fiche getFiche() {
		return fiche;
	}
	
	public boolean equals(Carte c){
		
		return this.fiche.equals(c.fiche);
		
	}

	public void affichageCarte(Fiche fiche) {
		
		this.fiche = fiche;
		
		this.b1 = null;
			this.p11 = new JPanel();
			this.photo = null;
			this.b11 = null;
				this.l1 = new JLabel();
					this.f1 = new Font("Helvetica", Font.BOLD, 20);
				this.l2 = new JLabel();
				this.l3 = new JLabel();
				this.l4 = new JLabel();
				this.l5 = new JLabel();
				this.l6 = new JLabel();
					this.f2 = new Font("Helvetica", Font.BOLD , 10);
				
		this.b2 = null;
			this.al1 = new ArrayList<InfoCarte>();
			this.al2 = new ArrayList<InfoCarte>();
			this.al3 = new ArrayList<InfoCarte>();
			this.al4 = new ArrayList<InfoCarte>();
			this.al5 = new ArrayList<InfoCarte>();
			this.al6 = new ArrayList<InfoCarte>();
			this.al7 = new ArrayList<InfoCarte>();
			this.al8 = new ArrayList<InfoCarte>();
			this.al9 = new ArrayList<InfoCarte>();
		
		this.b3 = null;
			this.p31 = new JPanel();
			this.b31 = null;
				this.l7 = new JLabel("Note :");
		
		this.marge = new JPanel();
		
		this.removeAll();
		
		this.fiche = new Fiche(fiche);
		this.photo = new Photo(fiche,controleur);

        this.photo.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.photo.setPreferredSize(new Dimension(90,90));
        
        
        /* Panneau de la Sous Colonne 1 */
        
        
        
        p11.setBackground(Color.WHITE);
        p11.setMaximumSize(new Dimension(100,100));
        p11.setMinimumSize(new Dimension(100,100));
        p11.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.NORTHEAST;
        p11.add(photo,gbc);
        //p11.setTransferHandler(new TransferHandler());
        
        /* Panneau de la Sous Colonne 3 */
        
        p31.setBackground(Color.WHITE);
        p31.setMaximumSize(new Dimension(20,20));
        p31.setMinimumSize(new Dimension(20,20));
        p31.setAlignmentY(Component.TOP_ALIGNMENT);
        p31.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        /* Panneau marge 1 */
        
        
        marge.setBackground(Color.WHITE);
        marge.setMinimumSize(new Dimension(10,20));
        marge.setMaximumSize(new Dimension(10,20));
        
        /* Panneau BoxLayout */
        
        b1 = Box.createHorizontalBox();
        b1.setBackground(Color.WHITE);
        b1.setMinimumSize(new Dimension(160,100));
        b1.setMaximumSize(new Dimension(10000,100));
        
        b2 = Box.createVerticalBox();
        b2.setBackground(Color.WHITE);
        
        b3 = Box.createHorizontalBox();
        b3.setBackground(Color.WHITE);
        
        b11 = Box.createVerticalBox();
        b11.setBackground(Color.WHITE);
        
        b31 = Box.createVerticalBox();
        b31.setBackground(Color.WHITE);
		
		
		// 1
	
		
		
		String s1 = "";
		String s2 = "";
		String s3 = "";
		String s4 = "";
		String s5 = "";
		String s6 = "";
		if(fiche.getShowEntreprise() != true){
			if(!fiche.getNom().equals("") || !fiche.getPrenom().equals("")){
				s1 += (!fiche.getTitre().equals("") ? fiche.getTitre() + " " : "");
				s2 += (!fiche.getSurnom().equals("") ? "<< " + fiche.getSurnom() + " >>" : "");
				s3 += (!fiche.getSuffixe().equals("") ? fiche.getSuffixe() : "");
				s4 += (!fiche.getProfession().equals("") ? fiche.getProfession() : "");
				s5 += (!fiche.getService().equals("") ? fiche.getService() : ""); 
				
				if(Fiche.getNomAvantPrenom()){
					s1 += (!fiche.getNom().equals("") ? fiche.getNom() : "") + " " + (!fiche.getPrenom().equals("") ? fiche.getPrenom() : "") + (!fiche.getSecondPrenom().equals("") ? " " + fiche.getSecondPrenom() : "");
				}
				else{
					s1 += (!fiche.getPrenom().equals("") ? fiche.getPrenom() : "") + (!fiche.getSecondPrenom().equals("") ? " " + fiche.getSecondPrenom() : "") + " " + (!fiche.getNom().equals("") ? fiche.getNom() : "");
				}
				s6 += (!fiche.getEntreprise().equals("") ? fiche.getEntreprise() : ""); 
			}
			else{
				s1 += "Sans nom";			
			}
		}
		else{
			if(!fiche.getEntreprise().equals("")){
				s2 += (!fiche.getTitre().equals("") ? fiche.getTitre() + " " : "");
				s3 += (!fiche.getSurnom().equals("") ? "<< " + fiche.getSurnom() + " >>" : "");
				s4 += (!fiche.getSuffixe().equals("") ? fiche.getSuffixe() : "");
				s5 += (!fiche.getProfession().equals("") ? fiche.getProfession() : "");
				s6 += (!fiche.getService().equals("") ? fiche.getService() : ""); 
			
				if(Fiche.getNomAvantPrenom()){
					s2 += (!fiche.getNom().equals("") ? fiche.getNom() : "Nom de famille") + " " + (!fiche.getPrenom().equals("") ? fiche.getPrenom() : "Prénom") + (!fiche.getSecondPrenom().equals("") ? " " + fiche.getSecondPrenom() : "");
				}
				else{
					s2 += (!fiche.getPrenom().equals("") ? fiche.getPrenom() : "Prénom") + (!fiche.getSecondPrenom().equals("") ? " " + fiche.getSecondPrenom() : "") + " " + (!fiche.getNom().equals("") ? fiche.getNom() : "Nom de famille");
				}
				s1 += (!fiche.getEntreprise().equals("") ? fiche.getEntreprise() : "Sans nom"); 
			}
			else{
				s1 += "Sans nom";			
			}
		}
		
		s1.trim();
		s2.trim();
		s3.trim();
		s4.trim();
		s5.trim();
		s6.trim();
		
		this.l1.setFont(this.f1);
		if(s1.equals("Sans nom")){
			this.l1.setForeground(Color.GRAY);
		}
		this.l1.setText(s1);
		
		this.l2.setFont(this.f2);
		this.l2.setText(s2);
		
		this.l3.setFont(this.f2);
		this.l3.setText(s3);
		
		this.l4.setFont(this.f2);
		this.l4.setText(s4);
		
		this.l5.setFont(this.f2);
		this.l5.setText(s5);
		
		this.l6.setFont(this.f2);
		this.l6.setText(s6);
		
		this.l7.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.l7.setAlignmentY(Component.TOP_ALIGNMENT);
		this.tp1.setText(fiche.getRemarques());
		
		
		this.tp1.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.tp1.setAlignmentY(Component.TOP_ALIGNMENT);
		this.tp1.setPreferredSize(new Dimension(300,100));
		this.tp1.setBorder(null);
		this.tp1.setFocusable(false);
        
        
		
		// 2
		
        
		for(int i=0;i<fiche.getNomJeuneFille().size();i++){
			Champs c = fiche.getNomJeuneFille().get(i);
			if(c.getTexte() != ""){
				this.al1.add(new InfoCarte(c.getEtiquette(),c.getTexte()));
			}	
		}
		for(int i=0;i<fiche.getTelephone().size();i++){
			Champs c = fiche.getTelephone().get(i);
			if(c.getTexte() != ""){
				this.al2.add(new InfoCarte(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getEmail().size();i++){
			Champs c = fiche.getEmail().get(i);
			if(c.getTexte() != ""){
				this.al3.add(new InfoCarteEmail(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getUrl().size();i++){
			Champs c = fiche.getUrl().get(i);
			if(c.getTexte() != ""){
				this.al4.add(new InfoCarteUrl(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getDateNaissance().size();i++){
			ChampsDate c = fiche.getDateNaissance().get(i);
			if(c.getTexte() != ""){
				this.al5.add(new InfoCarte(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getRendezVous().size();i++){
			Champs c = fiche.getRendezVous().get(i);
			if(c.getTexte() != ""){
				this.al6.add(new InfoCarte(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getNomsAssocies().size();i++){
			Champs c = fiche.getNomsAssocies().get(i);
			if(c.getTexte() != ""){
				this.al7.add(new InfoCarte(c.getEtiquette(),c.getTexte()));	
			}	
		}
		for(int i=0;i<fiche.getMessagerie().size();i++){
			Champs c = fiche.getMessagerie().get(i);
			if(c.getTexte() != ""){
				this.al8.add(new InfoCarte(c.getEtiquette(),c.getTexte()));
			}	
		}
		for(int i=0;i<fiche.getAdresse().size();i++){
			ChampsAdresse c = fiche.getAdresse().get(i);
			if(c.getAdresseToString().trim() != ""){
				this.al9.add(new InfoCarteAdresse(c.getEtiquette(),c.getAdresse().getRue(),c.getAdresse().getCode(),c.getAdresse().getVille(),c.getAdresse().getPays()));			
			}
		}
			
		if(al1.size() > 0){
			for(int i=0;i<al1.size();i++){
				this.b2.add(al1.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al2.size() > 0){
			for(int i=0;i<al2.size();i++){
				this.b2.add(al2.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al3.size() > 0){
			for(int i=0;i<al3.size();i++){
				this.b2.add(al3.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al4.size() > 0){
			for(int i=0;i<al4.size();i++){
				this.b2.add(al4.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al5.size() > 0){
			for(int i=0;i<al5.size();i++){
				this.b2.add(al5.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al6.size() > 0){
			for(int i=0;i<al6.size();i++){
				this.b2.add(al6.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al7.size() > 0){
			for(int i=0;i<al7.size();i++){
				this.b2.add(al7.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al8.size() > 0){
			for(int i=0;i<al8.size();i++){
				this.b2.add(al8.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al9.size() > 0){
			for(int i=0;i<al9.size();i++){
				this.b2.add(al9.get(i));
			}
		}
				
       
        /* Sous Colonne 1 */
        
        b11.setAlignmentY(Component.TOP_ALIGNMENT);
        p11.setAlignmentY(Component.TOP_ALIGNMENT);
        b11.add(this.l1);
        b11.add(this.l2);
        b11.add(this.l3);
        b11.add(this.l4);
        b11.add(this.l5);
        b11.add(this.l6);
        b1.add(Box.createHorizontalStrut(60));
        b1.add(p11);
        b1.add(b11);
        b1.setAlignmentX(Component.LEFT_ALIGNMENT);
        b1.setAlignmentY(Component.TOP_ALIGNMENT);
        
        /* Sous Colonne 2 */
        
        b2.setAlignmentX(Component.LEFT_ALIGNMENT);
        b2.setAlignmentY(Component.TOP_ALIGNMENT);
        
        /* Sous Colonne 3 */
        
        
        b31.add(l7);
        b31.add(Box.createVerticalStrut(10));
        b31.add(tp1);
        b31.add(Box.createGlue());
        b31.setAlignmentX(Component.LEFT_ALIGNMENT);
        b31.setAlignmentY(Component.TOP_ALIGNMENT);
        b3.add(p31);
        b3.add(b31);
        b3.setAlignmentX(Component.LEFT_ALIGNMENT);
        b3.setAlignmentY(Component.TOP_ALIGNMENT);
        
        /* Colonne principale */
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        this.add(b1);
        this.add(Box.createVerticalStrut(20));
        this.add(b2);
        this.add(Box.createVerticalStrut(20));
        this.add(b3);
        
		
	}
	
	public void editionCarte(Fiche fiche, AbstractControleur controleur, Icones icones) {
		
		this.removeAll();
		
		this.fiche = fiche;
		this.controleur = controleur;
		
		this.b1 = null;
			this.p11 = new JPanel();
			this.photo = null;
			this.b11 = null;
				this.l1 = new JLabel();
					this.f1 = new Font("Arial", Font.BOLD, 20);
				this.l2 = new JLabel();
				this.l3 = new JLabel();
				this.l4 = new JLabel();
				this.l5 = new JLabel();
				this.l6 = new JLabel();
					this.f2 = new Font("Arial", Font.BOLD , 10);
				
		this.b2 = null;
			this.al1 = new ArrayList<InfoCarte>();
			this.al2 = new ArrayList<InfoCarte>();
			this.al3 = new ArrayList<InfoCarte>();
			this.al4 = new ArrayList<InfoCarte>();
			this.al5 = new ArrayList<InfoCarte>();
			this.al6 = new ArrayList<InfoCarte>();
			this.al7 = new ArrayList<InfoCarte>();
			this.al8 = new ArrayList<InfoCarte>();
			this.al9 = new ArrayList<InfoCarte>();
			ArrayList<InfoCarteEdition> al1 = new ArrayList<InfoCarteEdition>();
			ArrayList<InfoCarteEdition> al2 = new ArrayList<InfoCarteEdition>();
			ArrayList<InfoCarteEdition> al3 = new ArrayList<InfoCarteEdition>();
			ArrayList<InfoCarteEdition> al4 = new ArrayList<InfoCarteEdition>();
			ArrayList<InfoCarteEdition> al5 = new ArrayList<InfoCarteEdition>();
			ArrayList<InfoCarteEdition> al6 = new ArrayList<InfoCarteEdition>();
			ArrayList<InfoCarteEdition> al7 = new ArrayList<InfoCarteEdition>();
			ArrayList<InfoCarteEdition> al8 = new ArrayList<InfoCarteEdition>();
			ArrayList<InfoCarteEdition> al9 = new ArrayList<InfoCarteEdition>();
		
		this.b3 = null;
			this.p31 = new JPanel();
			this.b31 = null;
				this.l7 = new JLabel("Note :");
		
		this.marge = new JPanel();
		
		
		        
        
        /* Panneau de la Sous Colonne 1 */
        
        
        
        p11.setBackground(Color.WHITE);
        p11.setMaximumSize(new Dimension(100,180));
        p11.setMinimumSize(new Dimension(100,180));
        p11.setPreferredSize(new Dimension(100,180));
        
        /* Panneau de la Sous Colonne 3 */
        
        p31.setBackground(Color.WHITE);
        p31.setMaximumSize(new Dimension(20,20));
        p31.setMinimumSize(new Dimension(20,20));
        p31.setAlignmentY(Component.TOP_ALIGNMENT);
        p31.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        /* Panneau marge 1 */
        
        
        marge.setBackground(Color.WHITE);
        marge.setMinimumSize(new Dimension(10,20));
        marge.setMaximumSize(new Dimension(10,20));
        
        /* Panneau BoxLayout */
        
        b1 = Box.createVerticalBox();
        b1.setBackground(Color.WHITE);
        b1.setPreferredSize(new Dimension(100000,180));
        
        b2 = Box.createVerticalBox();
        b2.setBackground(Color.WHITE);
        
        b3 = Box.createHorizontalBox();
        b3.setBackground(Color.WHITE);
        
        b11 = Box.createHorizontalBox();
        b11.setBackground(Color.WHITE);
        b11.setPreferredSize(new Dimension(100000,13));
        
        b31 = Box.createVerticalBox();
        b31.setBackground(Color.WHITE);
		
		
		// 1
	
               
		InfoCarteEdition ltf12 = new InfoCarteEdition(controleur,"Nom de famille",f1);
		InfoCarteEdition ltf13 = new InfoCarteEdition(controleur,"Prénom",f1);
		InfoCarteEdition ltf11 = new InfoCarteEdition(controleur,"Titre",f2);
		InfoCarteEdition ltf14 = new InfoCarteEdition(controleur,"Second prénom",f2);
		InfoCarteEdition ltf2 = new InfoCarteEdition(controleur,"Surnom",f2);
		InfoCarteEdition ltf3 = new InfoCarteEdition(controleur,"Suffixe",f2);
		InfoCarteEdition ltf4 = new InfoCarteEdition(controleur,"Profession",f2);
		InfoCarteEdition ltf5 = new InfoCarteEdition(controleur,"Service",f2);
		InfoCarteEdition ltf6 = new InfoCarteEdition(controleur,"Entreprise",f1);
        
		String s11 = (fiche.getTitre()!= "" ? fiche.getTitre() : "Titre");
		String s12 = (fiche.getNom()!="" ? fiche.getNom() : "Nom de famille");
		String s13 = (fiche.getPrenom()!="" ? fiche.getPrenom() : "Prénom");
		String s14 = (fiche.getSecondPrenom()!="" ? fiche.getSecondPrenom() : "Second prénom");
		String s2 = (fiche.getSurnom()!= "" ? fiche.getSurnom() : "Surnom");
		String s3 = (fiche.getSuffixe()!= "" ? fiche.getSuffixe() : "Suffixe");
		String s4 = (fiche.getProfession()!= "" ? fiche.getProfession() : "Profession");
		String s5 = (fiche.getService()!= "" ? fiche.getService() : "Service"); 
		String s6 = (fiche.getEntreprise()!= "" ? fiche.getEntreprise() : "Entreprise"); 		
		
		ltf11.setTexte(s11);
		ltf12.setTexte(s12);
		ltf13.setTexte(s13); 		
		ltf14.setTexte(s14);
		ltf2.setTexte(s2);
		ltf3.setTexte(s3);
		ltf4.setTexte(s4);
		ltf5.setTexte(s5);	
		ltf6.setTexte(s6);
		
		
		if(s11=="Titre"){
			ltf11.setForeground(Color.GRAY);
		}
		if(s12=="Nom de famille"){
			ltf12.setForeground(Color.GRAY);
		}
		if(s13=="Prénom"){
			ltf13.setForeground(Color.GRAY);
		}
		if(s14=="Second prénom"){
			ltf14.setForeground(Color.GRAY);
		}
		if(s2=="Surnom"){
			ltf2.setForeground(Color.GRAY);
		}
		if(s3=="Suffixe"){
			ltf3.setForeground(Color.GRAY);
		}
		if(s4=="Profession"){
			ltf4.setForeground(Color.GRAY);
		}
		if(s5=="Service"){
			ltf5.setForeground(Color.GRAY);
		}
		if(s6=="Entreprise"){
			ltf6.setForeground(Color.GRAY);
		}
		InfoCarteEdition check1 = new InfoCarteEdition(controleur,fiche);        
        
		
		// 2
		
        
		for(int i=0;i<fiche.getNomJeuneFille().size();i++){
			Champs c = fiche.getNomJeuneFille().get(i);
				ArrayList<Object> al = new ArrayList<Object>();
				al.add(icones);
				al.add(controleur);
				al.add(i);
				al.add("Nom de jeune fille");
				al.add(fiche);
				al1.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,false));	
		}
		for(int i=0;i<fiche.getTelephone().size();i++){
			Champs c = fiche.getTelephone().get(i);
				ArrayList<Object> al = new ArrayList<Object>();
				al.add(icones);
				al.add(controleur);
				al.add(i);
				al.add("Numéro de téléphone");
				al.add(fiche);
				if(i==fiche.getTelephone().size()-1){
					al2.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,true,true));
				}
				else{
					al2.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,false,true));
				}	
		}
		for(int i=0;i<fiche.getEmail().size();i++){
			Champs c = fiche.getEmail().get(i);
				ArrayList<Object> al = new ArrayList<Object>();
				al.add(icones);
				al.add(controleur);
				al.add(i);
				al.add("Adresse électronique");
				al.add(fiche);
				if(i==fiche.getEmail().size()-1){
					al3.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,true,true));
				}
				else{
					al3.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,false,true));
				}	
				
		}
		for(int i=0;i<fiche.getUrl().size();i++){
			Champs c = fiche.getUrl().get(i);
				ArrayList<Object> al = new ArrayList<Object>();
				al.add(icones);
				al.add(controleur);
				al.add(i);
				al.add("Page web");
				al.add(fiche);
				if(i==fiche.getUrl().size()-1){
					al4.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,true,true));
				}
				else{
					al4.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,false,true));
				}	
		}
		for(int i=0;i<fiche.getDateNaissance().size();i++){
			ChampsDate c = fiche.getDateNaissance().get(i);
				ArrayList<Object> al = new ArrayList<Object>();
				al.add(icones);
				al.add(controleur);
				al.add(i);
				al.add("Date de naissance jj/mm/aaaa");
				al.add(fiche);
				al5.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,false));	
		}
		for(int i=0;i<fiche.getRendezVous().size();i++){
			Champs c = fiche.getRendezVous().get(i);
				ArrayList<Object> al = new ArrayList<Object>();
				al.add(icones);
				al.add(controleur);
				al.add(i);
				al.add("Rendez-vous");
				al.add(fiche);
				al6.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,false));	
		}
		for(int i=0;i<fiche.getNomsAssocies().size();i++){
			Champs c = fiche.getNomsAssocies().get(i);
				ArrayList<Object> al = new ArrayList<Object>();
				al.add(icones);
				al.add(controleur);
				al.add(i);
				al.add("Nom");
				al.add(fiche);
				if(i==fiche.getNomsAssocies().size()-1){
					al7.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,true,true));
				}
				else{
					al7.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,false,true));
				}		
		}
		for(int i=0;i<fiche.getMessagerie().size();i++){
			Champs c = fiche.getMessagerie().get(i);
				ArrayList<Object> al = new ArrayList<Object>();
				al.add(icones);
				al.add(controleur);
				al.add(i);
				al.add("Adresse de messagerie");
				al.add(fiche);
				if(i==fiche.getMessagerie().size()-1){
					al8.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,true,true));
				}
				else{
					al8.add(new InfoCarteEdition(c.getEtiquette(),c.getTexte(),al,false,true));
				}	
		}
		for(int i=0;i<fiche.getAdresse().size();i++){
			ChampsAdresse c = fiche.getAdresse().get(i);
				ArrayList<Object> al = new ArrayList<Object>();
				al.add(icones);
				al.add(controleur);
				al.add(i);
				al.add("Rue");				
				al.add(fiche);	
				Adresse a = c.getAdresse();
				if(i==fiche.getAdresse().size()-1){
					al9.add(new InfoCarteEdition(c.getEtiquette(),a.getRue(),al,true,true));
					al9.add(new InfoCarteEdition(a.getCode(),al,"Code"));
					al9.add(new InfoCarteEdition(a.getVille(),al,"Ville"));
					al9.add(new InfoCarteEdition(a.getPays(),al,"Pays"));
				}
				else{
					al9.add(new InfoCarteEdition(c.getEtiquette(),a.getRue(),al,false,true));
					al9.add(new InfoCarteEdition(a.getCode(),al,"Code"));
					al9.add(new InfoCarteEdition(a.getVille(),al,"Ville"));
					al9.add(new InfoCarteEdition(a.getPays(),al,"Pays"));		
				}
		}
			
		if(al1.size() > 0){
			for(int i=0;i<al1.size();i++){
				this.b2.add(al1.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al2.size() > 0){
			for(int i=0;i<al2.size();i++){
				this.b2.add(al2.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al3.size() > 0){
			for(int i=0;i<al3.size();i++){
				this.b2.add(al3.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al4.size() > 0){
			for(int i=0;i<al4.size();i++){
				this.b2.add(al4.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al5.size() > 0){
			for(int i=0;i<al5.size();i++){
				this.b2.add(al5.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al6.size() > 0){
			for(int i=0;i<al6.size();i++){
				this.b2.add(al6.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al7.size() > 0){
			for(int i=0;i<al7.size();i++){
				this.b2.add(al7.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al8.size() > 0){
			for(int i=0;i<al8.size();i++){
				this.b2.add(al8.get(i));
			}
			this.b2.add(Box.createVerticalStrut(10));
		}
		if(al9.size() > 0){
			for(int i=0;i<al9.size();i++){
				this.b2.add(al9.get(i));
			}
		}
		
		// 3
		
		this.l7.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.l7.setAlignmentY(Component.TOP_ALIGNMENT);
		this.l7.setForeground(Color.GRAY);
		
		this.tp1.addFocusListener(new NoteFocusListener());
		this.tp1.setText(fiche.getRemarques());
		this.tp1.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.tp1.setAlignmentY(Component.TOP_ALIGNMENT);
		this.tp1.setPreferredSize(new Dimension(300,100));
        this.tp1.setBorder(null);
        this.tp1.setFocusable(true);
				
       
        /* Sous Colonne 1 */
        

        if(this.fiche.getShowEntreprise()){
        	b1.add(ltf6);
        	if(Fiche.getNomAvantPrenom()){    			  			
    			b1.add(ltf12);
    			b1.add(ltf13);    			
    		}
    		else{    			
    			b1.add(ltf13);    			
    			b1.add(ltf12);			
    		} 
        	if(fiche.getIsTitre()||fiche.getTitre()!=""){b1.add(ltf11);}  
        	if(fiche.getIsSecondPrenom()||fiche.getSecondPrenom()!=""){b1.add(ltf14);}
        	if(fiche.getIsSurnom()||fiche.getSurnom()!=""){b1.add(ltf2);}
        	if(fiche.getIsSuffixe()||fiche.getSuffixe()!=""){b1.add(ltf3);}
        	if(fiche.getIsProfession()||fiche.getProfession()!=""){b1.add(ltf4);}
        	if(fiche.getIsService()||fiche.getService()!=""){b1.add(ltf5);}
        }
        else{
        	if(Fiche.getNomAvantPrenom()){
    			b1.add(ltf12);
    			b1.add(ltf13);
    		}
    		else{
    			b1.add(ltf13);
    			b1.add(ltf12);			
    		} 
        	b1.add(ltf6);
        	if(fiche.getIsTitre()||fiche.getTitre()!=""){b1.add(ltf11);}  
        	if(fiche.getIsSecondPrenom()||fiche.getSecondPrenom()!=""){b1.add(ltf14);}
        	if(fiche.getIsSurnom()||fiche.getSurnom()!=""){b1.add(ltf2);}
        	if(fiche.getIsSuffixe()||fiche.getSuffixe()!=""){b1.add(ltf3);}
        	if(fiche.getIsProfession()||fiche.getProfession()!=""){b1.add(ltf4);}
        	if(fiche.getIsService()||fiche.getService()!=""){b1.add(ltf5);}
        }
        b1.add(check1);  
        b1.setAlignmentX(Component.LEFT_ALIGNMENT);
        b1.setAlignmentY(Component.TOP_ALIGNMENT);
        ((InfoCarteEdition) b1.getComponent(0)).focus();
        
        /* Sous Colonne 2 */
        
        b2.setAlignmentX(Component.LEFT_ALIGNMENT);
        b2.setAlignmentY(Component.TOP_ALIGNMENT);
        
        /* Sous Colonne 3 */
        
        b31.add(l7);
        b31.add(Box.createVerticalStrut(10));
        b31.add(tp1);
        b31.add(Box.createGlue());
        b31.setAlignmentX(Component.LEFT_ALIGNMENT);
        b31.setAlignmentY(Component.TOP_ALIGNMENT);
        b3.add(p31);
        b3.add(b31);
        b3.setAlignmentX(Component.LEFT_ALIGNMENT);
        b3.setAlignmentY(Component.TOP_ALIGNMENT);
        
        /* Colonne principale */
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
        this.add(b1);
        this.add(Box.createVerticalStrut(20));
        this.add(b2);
        this.add(Box.createVerticalStrut(20));
        this.add(b3);
		
        revalidate();
	}
	
	public class NoteFocusListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			((JTextPane) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.BLACK));
			revalidate();
		}

		@Override
		public void focusLost(FocusEvent e) {
			
			((JTextPane) e.getSource()).setBorder(null);
			controleur.setInfo(((JTextPane) e.getSource()).getText(),"Remarques");
			revalidate();
		}
		
	}

	public void affichageCarte() {
		removeAll();
		this.b1 = null;
		this.p11 = new JPanel();
		this.photo = null;
		this.b11 = null;
			this.l1 = new JLabel();
				this.f1 = new Font("Helvetica", Font.BOLD, 20);
			this.l2 = new JLabel();
			this.l3 = new JLabel();
			this.l4 = new JLabel();
			this.l5 = new JLabel();
			this.l6 = new JLabel();
				this.f2 = new Font("Helvetica", Font.BOLD , 10);
			
	this.b2 = null;
		this.al1 = new ArrayList<InfoCarte>();
		this.al2 = new ArrayList<InfoCarte>();
		this.al3 = new ArrayList<InfoCarte>();
		this.al4 = new ArrayList<InfoCarte>();
		this.al5 = new ArrayList<InfoCarte>();
		this.al6 = new ArrayList<InfoCarte>();
		this.al7 = new ArrayList<InfoCarte>();
		this.al8 = new ArrayList<InfoCarte>();
		this.al9 = new ArrayList<InfoCarte>();
	
	this.b3 = null;
		this.p31 = new JPanel();
		this.b31 = null;
			this.l7 = new JLabel("Note :");
	
	this.marge = new JPanel();
	
	 revalidate();
	
	}

}
