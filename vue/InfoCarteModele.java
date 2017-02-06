package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import controleur.AbstractControleur;

public class InfoCarteModele extends JPanel{

	private static final long serialVersionUID = 1L;
	private AbstractControleur controleur;
	private String nom;
	private int position;
	private JPopupMenu pm;
	private JLabel l3;
	private JPanel p2;
	
	public InfoCarteModele(AbstractControleur controleur, Icones icones, String eti, String nom, int position, boolean b,boolean b2){
		
		this.setPreferredSize(new Dimension(480,13));
		this.setMaximumSize(new Dimension(480,13));
		this.setMinimumSize(new Dimension(480,13));
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.controleur = controleur;
		this.nom = nom;
		this.position = position;
		
		
		JLabel l1 = new JLabel(eti);
		l1.setForeground(Color.BLACK);
		JLabel l2 = new JLabel(nom);
		l2.setForeground(Color.GRAY);
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(150,13));
		p1.setLayout(new BorderLayout());
		p1.setBackground(Color.WHITE);
		
		p2 = new JPanel();
		p2.setPreferredSize(new Dimension(10,13));
		p2.setLayout(new BorderLayout());
		p2.setBackground(Color.WHITE);
		
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(320,13));
		p3.setLayout(new BorderLayout());
		p3.setBackground(Color.WHITE);
		
		p1.add(l1,BorderLayout.EAST);
		p3.add(l2,BorderLayout.WEST);
		
		JLabel miniplus = new JLabel(icones.getMiniplus());
		JLabel minimoins = new JLabel(icones.getMinimoins());
		miniplus.addMouseListener(new PlusListener());
		minimoins.addMouseListener(new MoinsListener());
		
		Box b1  = Box.createHorizontalBox();
		b1.setBackground(Color.WHITE);
		b1.add(minimoins);
		b1.add(miniplus);
		if(b){
			b1.setPreferredSize(new Dimension(30,13));
			p1.add(b1,BorderLayout.WEST);
		}
		else{
			minimoins.setPreferredSize(new Dimension(15,13));
			p1.add(minimoins,BorderLayout.WEST);
		}
		
		pm = new JPopupMenu();
		for(int i =0;i<controleur.getEtiquettes(nom).size();i++){
			JMenuItem mi = new JMenuItem(controleur.getEtiquettes(nom).get(i));
			mi.addActionListener(new PopupListener());
			pm.add(mi);
		}
		pm.addSeparator(); 
		JMenuItem mi10 = new JMenuItem("Personnaliser");
		mi10.addActionListener(new PersoListener());
		pm.add(mi10);	
		

		l3 = new JLabel(icones.getEtiquette());
		l3.addMouseListener(new EtiquetteListener());
		p2.add(l3);
		
		this.add(p1,BorderLayout.WEST);
		this.add(p2,BorderLayout.CENTER);
		this.add(p3,BorderLayout.EAST);
		
		
		this.setAlignmentY(Component.TOP_ALIGNMENT);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);

	}
	
	public InfoCarteModele(AbstractControleur controleur, Icones icones, String eti, String nom, int position, boolean b){
		
		this.setPreferredSize(new Dimension(480,13));
		this.setMaximumSize(new Dimension(480,13));
		this.setMinimumSize(new Dimension(480,13));
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.controleur = controleur;
		this.nom = nom;
		this.position = position;
		
		
		JLabel l1 = new JLabel(eti);
		l1.setForeground(Color.BLACK);
		JLabel l2 = new JLabel(nom);
		l2.setForeground(Color.GRAY);
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(150,13));
		p1.setLayout(new BorderLayout());
		p1.setBackground(Color.WHITE);
		
		p2 = new JPanel();
		p2.setPreferredSize(new Dimension(10,13));
		p2.setLayout(new BorderLayout());
		p2.setBackground(Color.WHITE);
		
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(320,13));
		p3.setLayout(new BorderLayout());
		p3.setBackground(Color.WHITE);
		
		p1.add(l1,BorderLayout.EAST);
		p3.add(l2,BorderLayout.WEST);
		
		JLabel miniplus = new JLabel(icones.getMiniplus());
		JLabel minimoins = new JLabel(icones.getMinimoins());
		miniplus.addMouseListener(new PlusListener());
		minimoins.addMouseListener(new MoinsListener());
		
		Box b1  = Box.createHorizontalBox();
		b1.setBackground(Color.WHITE);
		b1.add(minimoins);
		b1.add(miniplus);
		if(b){
			b1.setPreferredSize(new Dimension(30,13));
			p1.add(b1,BorderLayout.WEST);
		}
		else{
			minimoins.setPreferredSize(new Dimension(15,13));
			p1.add(minimoins,BorderLayout.WEST);
		}		
		
		this.add(p1,BorderLayout.WEST);
		this.add(p2,BorderLayout.CENTER);
		this.add(p3,BorderLayout.EAST);
		
		this.setAlignmentY(Component.TOP_ALIGNMENT);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
		
	}
	
	public InfoCarteModele(AbstractControleur controleur,String nom){
		
		this.setPreferredSize(new Dimension(480,13));
		this.setMaximumSize(new Dimension(480,13));
		this.setMinimumSize(new Dimension(480,13));
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.controleur = controleur;
		this.nom = nom;

		JLabel l2 = new JLabel(nom);
		l2.setForeground(Color.GRAY);
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(150,13));
		p1.setLayout(new BorderLayout());
		p1.setBackground(Color.WHITE);
		
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(10,13));
		p2.setLayout(new BorderLayout());
		p2.setBackground(Color.WHITE);
		
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(320,13));
		p3.setLayout(new BorderLayout());
		p3.setBackground(Color.WHITE);
		
		p3.add(l2,BorderLayout.WEST);		
		
		this.add(p1,BorderLayout.WEST);
		this.add(p2,BorderLayout.CENTER);
		this.add(p3,BorderLayout.EAST);
		
		this.setAlignmentY(Component.TOP_ALIGNMENT);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        
	}
	
	public class PlusListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			controleur.addChampsModele(nom);
			revalidate();
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
			controleur.removeChampsModele(nom,position);
			revalidate();
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
	
	public class EtiquetteListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			pm.show(p2, e.getX(), e.getY());			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}		
		
	}
	
	public class PopupListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			controleur.setEtiquetteModele(((JMenuItem) arg0.getSource()).getText(),nom,position);	
		}		
		
	}
	
	public class PersoListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String s = JOptionPane.showInputDialog(null, "Entrez un nom d'étiquette", "Personnalisation d'une étiquette", JOptionPane.QUESTION_MESSAGE);
			if(s!=null){
				controleur.addEtiquetteModele(s,nom);
				s = controleur.getEtiquettesModele(nom).get(controleur.getEtiquettesModele(nom).size()-1);
				controleur.setEtiquetteModele(s, nom, position);
				controleur.finEdition();
			}	
		}		
		
	}
	
}
