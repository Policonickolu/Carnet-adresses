package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import modele.Fiche;

import controleur.AbstractControleur;

public class InfoCarteEdition extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private AbstractControleur controleur;
	private Fiche currentFiche;
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JLabel l1 = new JLabel();
	private JTextField tf1 = new JTextField();
	private JPopupMenu pm;
	private JLabel miniplus;
	private JLabel minimoins;
	private int position;
	private String nom;
	
	public InfoCarteEdition(String eti, String info, ArrayList<Object> al, boolean b){
		
		this.controleur = (AbstractControleur) al.get(1);
		this.position = (Integer) al.get(2);
		this.nom = (String) al.get(3);
		
		this.l1.setText(eti);	
		
		this.l1.setFont(new Font("Arial",Font.PLAIN,12));
		this.tf1.setFont(new Font("Arial",Font.PLAIN,12));
		
		this.tf1.setName((String) al.get(3));
		this.tf1.setBorder(null);
		this.tf1.setText((info.equals("") ? this.nom : info ));		
		this.tf1.setForeground((info.equals("") ? Color.GRAY : Color.BLACK ));
		this.tf1.addFocusListener(new NoFocusListener());
		this.tf1.addKeyListener(new ClavierListener());
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));		

		this.p1.setMaximumSize(new Dimension(150,13));
		this.p1.setMinimumSize(new Dimension(150,13));
		this.p1.setPreferredSize(new Dimension(150,13));
		this.p1.setBackground(Color.WHITE);
		this.p1.setLayout(new BorderLayout());
		this.p2.setMaximumSize(new Dimension(10,13));
		this.p2.setMinimumSize(new Dimension(150,13));
		this.p2.setPreferredSize(new Dimension(10,13));
		this.p2.setBackground(Color.WHITE);	
		
		FontMetrics fm = getFontMetrics(tf1.getFont());
		this.tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+1,13));
		
		this.miniplus = new JLabel(((Icones) al.get(0)).getMiniplus());
		this.minimoins = new JLabel(((Icones) al.get(0)).getMinimoins());
		this.miniplus.addMouseListener(new PlusListener());
		this.minimoins.addMouseListener(new MoinsListener());
		this.miniplus.setToolTipText("Ajouter un champs");
		this.minimoins.setToolTipText("Supprimer ce champs");
        
		Box b3 = Box.createHorizontalBox();
		b3.setBackground(Color.WHITE);
		b3.add(minimoins);
		b3.add(miniplus);
		if(b){
			b3.setPreferredSize(new Dimension(30,14));
			this.p1.add(b3,BorderLayout.WEST);
		}
		else{
			this.minimoins.setPreferredSize(new Dimension(15,14));
			this.p1.add(minimoins,BorderLayout.WEST);
		}		
		
		
		this.p1.add(l1,BorderLayout.EAST);		
		this.add(p1);
		this.add(p2);
		this.add(tf1);
		
		this.setBackground(Color.WHITE);		
			
		this.setPreferredSize(new Dimension(201+fm.stringWidth(tf1.getText()),13));
		
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setAlignmentY(Component.TOP_ALIGNMENT);
		
		
	
	}
	
	public InfoCarteEdition(String eti, String info, ArrayList<Object> al, boolean b, boolean popup){
		
		this.controleur = (AbstractControleur) al.get(1);
		this.position = (Integer) al.get(2);
		this.nom = (String) al.get(3);
		
		this.l1.setText(eti);;		
		
		this.l1.setFont(new Font("Arial",Font.PLAIN,12));
		this.tf1.setFont(new Font("Arial",Font.PLAIN,12));		
		
		ImageIcon ii = ((Icones) al.get(0)).getEtiquette();
		JLabel l3 = new JLabel(ii);
		l3.setToolTipText("Changer l'étiquette");
		l3.addMouseListener(new EtiquetteListener());
		this.p2.setLayout(new GridLayout(1,1));
		this.p2.add(l3);
		
		this.tf1.setName((String) al.get(3));
		this.tf1.setBorder(null);
		this.tf1.setText((info.equals("") ? this.tf1.getName() : info ));		
		this.tf1.setForeground((info.equals("") ? Color.GRAY : Color.BLACK ));
		this.tf1.addFocusListener(new NoFocusListener());
		this.tf1.addKeyListener(new ClavierListener());
		
		pm = new JPopupMenu();
		for(int i =0;i<controleur.getEtiquettes(nom).size();i++){
			JMenuItem mi = new JMenuItem(controleur.getEtiquettes(nom).get(i));
			mi.addActionListener(new PopupListener());
			pm.add(mi);
		}
		pm.addSeparator(); 
		JMenuItem mi = new JMenuItem("Personnaliser");
		mi.addActionListener(new PersoListener());
		pm.add(mi);		
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));		

		this.p1.setMaximumSize(new Dimension(150,13));
		this.p1.setMinimumSize(new Dimension(150,13));
		this.p1.setPreferredSize(new Dimension(150,13));
		this.p1.setBackground(Color.WHITE);
		this.p1.setLayout(new BorderLayout());
		this.p2.setMaximumSize(new Dimension(10,13));
		this.p2.setMinimumSize(new Dimension(150,13));
		this.p2.setPreferredSize(new Dimension(10,13));
		this.p2.setBackground(Color.WHITE);	
		
		FontMetrics fm = getFontMetrics(tf1.getFont());
		this.tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+1,13));
		
		this.miniplus = new JLabel(((Icones) al.get(0)).getMiniplus());
		this.minimoins = new JLabel(((Icones) al.get(0)).getMinimoins());
		this.miniplus.addMouseListener(new PlusListener());
		this.minimoins.addMouseListener(new MoinsListener());
		this.miniplus.setToolTipText("Ajouter un champs");
		this.minimoins.setToolTipText("Supprimer ce champs");
        
		Box b3 = Box.createHorizontalBox();
		b3.setBackground(Color.WHITE);
		b3.add(minimoins);
		b3.add(miniplus);
		if(b){
			b3.setPreferredSize(new Dimension(30,14));
			this.p1.add(b3,BorderLayout.WEST);
		}
		else{
			this.minimoins.setPreferredSize(new Dimension(15,14));
			this.p1.add(minimoins,BorderLayout.WEST);
		}		
		
		
		this.p1.add(l1,BorderLayout.EAST);		
		this.add(p1);
		this.add(p2);
		this.add(tf1);
		
		this.setBackground(Color.WHITE);		
			
		this.setPreferredSize(new Dimension(201+fm.stringWidth(tf1.getText()),13));
		
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setAlignmentY(Component.TOP_ALIGNMENT);
	
	}
	
	public InfoCarteEdition(String info, ArrayList<Object> al, String s){
		
		this.controleur = (AbstractControleur) al.get(1);
		this.position = (Integer) al.get(2);
		this.nom = s;
		
			
		this.tf1.setFont(new Font("Arial",Font.PLAIN,12));
	
		this.tf1.setForeground(Color.BLACK);
		
		this.tf1.setName(s);
		this.tf1.setBorder(null);
		this.tf1.setText((info.equals("") ? this.tf1.getName() : info ));		
		this.tf1.setForeground((info.equals("") ? Color.GRAY : Color.BLACK ));
		this.tf1.addFocusListener(new NoFocusListener());
		this.tf1.addKeyListener(new ClavierListener());
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));		

		this.p1.setMaximumSize(new Dimension(150,13));
		this.p1.setMinimumSize(new Dimension(150,13));
		this.p1.setPreferredSize(new Dimension(150,13));
		this.p1.setBackground(Color.WHITE);
		this.p1.setLayout(new BorderLayout());
		this.p2.setMaximumSize(new Dimension(10,13));
		this.p2.setMinimumSize(new Dimension(150,13));
		this.p2.setPreferredSize(new Dimension(10,13));
		this.p2.setBackground(Color.WHITE);	
		
		FontMetrics fm = getFontMetrics(tf1.getFont());
		this.tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+1,13));
		
		this.add(p1);
		this.add(p2);
		this.add(tf1);
		
		this.setBackground(Color.WHITE);		
			
		this.setPreferredSize(new Dimension(201+fm.stringWidth(info),13));
		
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setAlignmentY(Component.TOP_ALIGNMENT);
	
	}
	
	public InfoCarteEdition(AbstractControleur controleur, String s, Font f){
		
		this.controleur = controleur;
		this.nom = s;
		
		this.tf1.setFont(f);
		
		this.tf1.setForeground(Color.BLACK);
		
		this.tf1.setName(s);
		this.tf1.setBorder(null);
		
		this.tf1.addFocusListener(new TeteFocusListener());
		this.tf1.addKeyListener(new ClavierListener());
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));		

		this.p1.setMaximumSize(new Dimension(150,13));
		this.p1.setMinimumSize(new Dimension(150,13));
		this.p1.setPreferredSize(new Dimension(150,13));
		this.p1.setBackground(Color.WHITE);
		this.p1.setLayout(new BorderLayout());
		this.p2.setMaximumSize(new Dimension(10,13));
		this.p2.setMinimumSize(new Dimension(150,13));
		this.p2.setPreferredSize(new Dimension(10,13));
		this.p2.setBackground(Color.WHITE);
		
		this.add(p1);
		this.add(p2);
		this.add(tf1);
		
		this.setBackground(Color.WHITE);			
		
		
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setAlignmentY(Component.TOP_ALIGNMENT);
		


	}
	
	public InfoCarteEdition(AbstractControleur controleur, Fiche fiche){
		
		this.controleur = controleur;
		
		JCheckBox check = new JCheckBox("Entreprise",(fiche.getShowEntreprise() ? true : false));
		check.setBackground(Color.WHITE);
		check.setFont(new Font("Arial", Font.BOLD , 10));
		check.addActionListener(new EntrepriseListener());	
		
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));		

		this.p1.setMaximumSize(new Dimension(150,13));
		this.p1.setMinimumSize(new Dimension(150,13));
		this.p1.setPreferredSize(new Dimension(150,13));
		this.p1.setBackground(Color.WHITE);
		this.p1.setLayout(new BorderLayout());
		this.p2.setMaximumSize(new Dimension(10,13));
		this.p2.setMinimumSize(new Dimension(150,13));
		this.p2.setPreferredSize(new Dimension(10,13));
		this.p2.setBackground(Color.WHITE);
		
		this.add(p1);
		this.add(p2);
		this.add(check);
		
		this.setBackground(Color.WHITE);			
		
		
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setAlignmentY(Component.TOP_ALIGNMENT);
		
	}
	
	public class PlusListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			controleur.addChamps(nom);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	
	public class MoinsListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			controleur.removeChamps(nom,position);
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
		}
		
	}
	
	public class NoFocusListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			currentFiche = controleur.getCurrentFiche();
			JTextField tf1 = (JTextField) arg0.getSource();
			tf1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			tf1.selectAll();
			FontMetrics fm = getFontMetrics(tf1.getFont());		
			tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+1,13));
			setMinimumSize(new Dimension((int) (161+tf1.getMaximumSize().getWidth()),13));
			setMaximumSize(new Dimension((int) (161+tf1.getMaximumSize().getWidth()),13));
			revalidate();
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			if(currentFiche.equals(controleur.getCurrentFiche())){
				tf1.setBorder(null);
				JTextField tf1 = (JTextField) arg0.getSource();
				if (tf1.getText().length() != 0 && !tf1.getText().equals(tf1.getName())){
					controleur.setInfo(tf1.getText(), tf1.getName(),position);
				}
				else{				
					controleur.setInfo("", tf1.getName(),position);
					tf1.setText(tf1.getName());
					tf1.setForeground(Color.GRAY);
				}
				FontMetrics fm = getFontMetrics(tf1.getFont());		
				tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+1,13));
				setMinimumSize(new Dimension((int) (161+tf1.getMaximumSize().getWidth()),13));
				setMaximumSize(new Dimension((int) (161+tf1.getMaximumSize().getWidth()),13));
				revalidate();
			}
		}
		
	}
	
	public class TeteFocusListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			currentFiche = controleur.getCurrentFiche();
			JTextField tf1 = (JTextField) arg0.getSource();
			tf1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			tf1.setForeground(Color.BLACK);
			tf1.selectAll();
			FontMetrics fm = getFontMetrics(tf1.getFont());		
			tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+1,fm.getHeight()));
			setMinimumSize(new Dimension((int) (161+tf1.getMaximumSize().getWidth()),fm.getHeight()));
			setMaximumSize(new Dimension((int) (161+tf1.getMaximumSize().getWidth()),fm.getHeight()));
			revalidate();
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			if(currentFiche.equals(controleur.getCurrentFiche())){
				tf1.setBorder(null);
				JTextField tf1 = (JTextField) arg0.getSource();
				if (tf1.getText().length() != 0 && !tf1.getText().equals(tf1.getName())){
					controleur.setInfo(tf1.getText(), nom);
				}
				else{
					controleur.setInfo("", nom);
					tf1.setText(tf1.getName());
					tf1.setForeground(Color.GRAY);
				}
				FontMetrics fm = getFontMetrics(tf1.getFont());		
				tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+1,fm.getHeight()));
				setMinimumSize(new Dimension((int) (161+tf1.getMaximumSize().getWidth()),fm.getHeight()));
				setMaximumSize(new Dimension((int) (161+tf1.getMaximumSize().getWidth()),fm.getHeight()));
				revalidate();
			}
		}
		
	}
	
	public class ClavierListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			JTextField tf1 = (JTextField) arg0.getSource();
			FontMetrics fm = getFontMetrics(tf1.getFont());
			tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+20,fm.getHeight()));
			setMinimumSize(new Dimension((int) (170+tf1.getMaximumSize().getWidth()),fm.getHeight()));
			setMaximumSize(new Dimension((int) (170+tf1.getMaximumSize().getWidth()),fm.getHeight()));
			revalidate();		
		}

		@Override
		public void keyReleased(KeyEvent arg0) {

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
					
		}		
		
	}
	
	public class EtiquetteListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			pm.show(p2, e.getX(), e.getY());			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}		
		
	}
	
	public class PopupListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			controleur.setEtiquette(((JMenuItem) arg0.getSource()).getText(),nom,position);	
		}		
		
	}
	
	public class PersoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String s = JOptionPane.showInputDialog(null, "Entrez un nom d'étiquette (10 caractères maximum)", "Personnalisation d'une étiquette", JOptionPane.QUESTION_MESSAGE);
			if(!s.trim().equals("") && s.length()<=10){
				controleur.addEtiquette(s,nom);
				s = controleur.getEtiquettes(nom).get(controleur.getEtiquettes(nom).size()-1);
				controleur.setEtiquette(s, nom, position);
				controleur.finEdition();
			}	
		}		
		
	}
	
	public class EntrepriseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			controleur.setShowEntreprise();
			
		}		
		
	}

	public void setTexte(String s) {
		
		this.tf1.setText((s.equals("") ? this.tf1.getName() : s ));		
		this.tf1.setForeground((s.equals(tf1.getText()) ? Color.GRAY : Color.BLACK ));
		FontMetrics fm = getFontMetrics(this.tf1.getFont());
		this.tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+1,fm.getHeight()));
		this.setPreferredSize(new Dimension(201+fm.stringWidth(s),fm.getHeight()));
		
	}
	
	public void focus(){
		
		SwingUtilities.invokeLater(new Runnable() {public void run() { tf1.requestFocusInWindow(); }});
		
	}
		
}
