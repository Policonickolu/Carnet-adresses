package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Robot;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.TransferHandler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import controleur.AbstractControleur;

import modele.Fiche;
import modele.Groupe;

public class ColonneGroupe extends ColonneListe{

	private static final long serialVersionUID = 1L;
	
	private AbstractControleur controleur;
	private ColonneNom nom;
	private ArrayList<Groupe> carnet;
	private Groupe currentGroupe = null;
	private Fiche f = null;
	private ListSelectionListener listener = new GroupeSelectionListener();
	
	public ColonneGroupe(String s, Icones i, AbstractControleur controleur,ColonneNom nom) {
		super(s, i);
		this.controleur = controleur;
		this.nom = nom;
		this.getBc1().addActionListener(new NewGroupeListener());
		this.getBc1().getB1().setToolTipText("Créer un nouveau groupe");
		this.getL1().addKeyListener(new SupprListener());
		this.getL1().addListSelectionListener(this.listener);
		this.getL1().setCellRenderer(new Rendu(i));
		this.setTransferHandler(new MyTransferHandler());
		
		
	}
	
	public void initialiser(){
		if(f!=null){
			Fiche f2=f;
			f=null;
			controleur.addFicheDansGroupe(f2,currentGroupe);	
		}
		getL1().removeListSelectionListener(this.listener);
		ArrayList<Groupe> al1 = new ArrayList<Groupe>();
		ArrayList<Groupe> al2 = new ArrayList<Groupe>();
		al1.add(carnet.get(0));
		for(int i=1;i<carnet.size();i++){
			al2.add(carnet.get(i));
		}
		Collections.sort(al2, null);
		al1.addAll(al2);
		getDlm1().clear();
		for(int i=0;i<al1.size();i++){
			getDlm1().addElement(al1.get(i));	
		}
		getL1().setSelectedValue(this.currentGroupe,false);
		getL1().addListSelectionListener(this.listener);

	}
	
	public class GroupeSelectionListener implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()) {
				ColonneCarte.setModeEdition(false);
				currentGroupe = (Groupe) getL1().getSelectedValue();
				controleur.nouvelleSelectionGroupe((Groupe) getL1().getSelectedValue());
			}
		}			
	}
	
	public class NewGroupeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {			
			String s = "";
			s = "" + JOptionPane.showInputDialog(null, "Entrez un nom de Groupe", "Nouveau Groupe", JOptionPane.QUESTION_MESSAGE);
			if(!s.trim().equals("")){
				getL1().setSelectedValue(controleur.addNouveauGroupe(s),false); 
			}
		}
		
	}
	
	public class ListMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			int s = getL1().locationToIndex(arg0.getPoint());
			getL1().setSelectedIndex(s);			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			int s = getL1().locationToIndex(arg0.getPoint());
			getL1().setSelectedIndex(s);			
			
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
				if(getDlm1().getSize()>0){
					getL1().setSelectedIndex(i);
				}
			}					
		}

		@Override
		public void keyTyped(KeyEvent arg0) {			
			
		}		
		
	}

	public void setCarnet(ArrayList<Groupe> groupes) {

		this.carnet = new ArrayList<Groupe>(groupes);
		if(this.currentGroupe == null){
			this.currentGroupe = this.carnet.get(0);
		}
	}
	
	public class Rendu extends JLabel implements ListCellRenderer {

		private static final long serialVersionUID = 1L;
		ImageIcon tous; 
		ImageIcon autre;
		Groupe groupe;
		public  Rendu(Icones icones){
			tous = icones.getTous();
			autre = icones.getDossier();
		}
		public Component getListCellRendererComponent(JList list, 
																Object value,
																int index,
																boolean isSelected,
																boolean cellHasFocus)
		   														{
			groupe = (Groupe) value;
			String s = value.toString();
			setText(s);
			setBackground(Color.WHITE);
			if (index==0) {	
				setIcon(tous);
			}else{
				setIcon(autre);
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
	
	public class MyTransferHandler extends TransferHandler {
		
		private static final long serialVersionUID = 1L;
	 
		@Override 
		public boolean canImport(JComponent c, DataFlavor[] df) {
			for (int i = 0; i < df.length; i++) {
				if (df[i].equals(FicheTransferable.ficheFlavor)) {
					return true;
				}
				if (df[i].equals(DataFlavor.stringFlavor)) {
					return true;
				}
			}
			return false;
		}
		
		@Override 
		public boolean importData(JComponent c, Transferable t) {
			if (t.isDataFlavorSupported(FicheTransferable.ficheFlavor)) {	      
				return false;
	    	}
	    	else if (t.isDataFlavorSupported(DataFlavor.stringFlavor)) {
	        try {	        	
	        	String s = (String) t.getTransferData(DataFlavor.stringFlavor);
	        	for(int i=0;i<nom.getDlm1().size();i++){
	        		if(((FicheTransferable) nom.getDlm1().get(i)).getNumero().equals(s)){
	        			f=((FicheTransferable) nom.getDlm1().get(i)).getFiche();
	        		}
	        	}
    			
	        	Robot robot = new Robot();
	        	robot.mousePress(InputEvent.BUTTON1_MASK);
	        	robot.mouseRelease(InputEvent.BUTTON1_MASK);        	
	        	return true;
	        }	
	        catch (Exception e) {
	          e.printStackTrace();
	        }
	    	}
	    	return false;
	    }
	}
	
}
