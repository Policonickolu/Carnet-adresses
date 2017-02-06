package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controleur.AbstractControleur;

import modele.Fiche;
import modele.Groupe;

public class ColonneNom extends ColonneListe{

	private static final long serialVersionUID = 1L;
	
	private AbstractControleur controleur;
	private Groupe groupe;
	private String motCle = "";
	private Fiche currentFiche;
	
	private ListSelectionListener listener = new NomSelectionListener();
	
	public ColonneNom(String s, Icones i, AbstractControleur controleur) {
		super(s, i);
		
		this.controleur = controleur;
		this.getBc1().addActionListener(new NewNomListener());
		this.getBc1().getB1().setToolTipText("Créer une nouvelle carte");
		this.getL1().setDragEnabled(true);
		this.getL1().addListSelectionListener(this.listener);
		this.getL1().addKeyListener(new SupprListener());
		this.getL1().setCellRenderer(new Rendu(i));
		
	}
	
	public void initialiser(){
		
		getL1().removeListSelectionListener(this.listener);			
		ArrayList<FicheTransferable> al1 = new ArrayList<FicheTransferable>();
		ArrayList<FicheTransferable> al2 = new ArrayList<FicheTransferable>();
		for(int i=0;i<this.groupe.size();i++){
			Fiche f = this.groupe.get(i);
			if(f.toString().equals("Sans nom")){
				al1.add(new FicheTransferable(f));				
			}
			else{
				if(f.recherche(motCle)){				
					al2.add(new FicheTransferable(f));				 				
				}
			}
		}
		Collections.sort(al2, null);
		al1.addAll(al2);
		this.getDlm1().clear();
		for(int i=0;i<al1.size();i++){
			this.getDlm1().addElement(al1.get(i));	
		}
		FicheTransferable ft = new FicheTransferable(currentFiche);
		for(int i=0;i<this.getDlm1().getSize();i++){
			if(currentFiche==((FicheTransferable) this.getDlm1().get(i)).getFiche()){
				ft = (FicheTransferable) this.getDlm1().get(i);
			}
		}
		this.getL1().setSelectedValue(ft,false);
		this.getL1().addListSelectionListener(this.listener);
			
	}	
	
	public class NomSelectionListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if (!e.getValueIsAdjusting()) {
				currentFiche = ((FicheTransferable) getL1().getSelectedValue()).getFiche();
				controleur.nouvelleSelectionFiche(((FicheTransferable) getL1().getSelectedValue()).getFiche());		
			}    
		}	
		
	}
	
	public class NewNomListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {			
			
			Fiche f = controleur.addNouveauNom();
			FicheTransferable ft = new FicheTransferable(f);
			for(int i=0;i<getDlm1().getSize();i++){
				if(f==((FicheTransferable) getDlm1().get(i)).getFiche()){
					ft = (FicheTransferable) getDlm1().get(i);
				}
			}
			getL1().setSelectedValue(ft,false);
			ColonneCarte.setModeEdition(true);
			controleur.finEdition();
			
		}		
		
	}
	
	public class SupprListener implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			if(arg0.getKeyCode()==KeyEvent.VK_DELETE){
				int i = getL1().getSelectedIndex();
				if(getDlm1().getSize()>0){
					if(groupe.getNom()!="Tous"){
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
					if(getDlm1().getSize()>0){
						getL1().setSelectedIndex(i);
					}
				}
			}					
		}

		@Override
		public void keyTyped(KeyEvent arg0) {			
		}		
		
	}

	public void setGroupe(Groupe groupe,Fiche fiche) {
		
		this.groupe = groupe;
		this.currentFiche = fiche;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle.trim();
	}

	public String getMotCle() {
		return motCle;
	}
	
	public class Rendu extends JLabel implements ListCellRenderer{

		private static final long serialVersionUID = 1L;
		ImageIcon personne; 
		ImageIcon entreprise;
		public  Rendu(Icones icones){
			personne = icones.getPersonne();
			entreprise = icones.getEntreprise();
		}
		public Component getListCellRendererComponent(JList list, 
																Object value,
																int index,
																boolean isSelected,
																boolean cellHasFocus)
		   														{
			String s = ((FicheTransferable) value).toString2();
			setText(s);
			setBackground(Color.WHITE);
			if (((FicheTransferable) value).getShowEntreprise()) {	
				setIcon(entreprise);
			}else{
				setIcon(personne);
			}
			if (isSelected) {
				setBorder(BorderFactory.createLineBorder(Color.GRAY));		      
		    }else{
		    	 setBorder(BorderFactory.createLineBorder(Color.WHITE));
		    }

			setEnabled(list.isEnabled());
			setFont(list.getFont());
			setOpaque(true);
			
			return this;
		}
	}
}
