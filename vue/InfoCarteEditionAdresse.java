package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.AbstractControleur;

public class InfoCarteEditionAdresse extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private AbstractControleur controleur;
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JLabel l1 = new JLabel();
	private JTextField tf1 = new JTextField();
	private JTextField tf2 = new JTextField();
	private JTextField tf3 = new JTextField();
	private JTextField tf4 = new JTextField();
	private JLabel miniplus;
	private JLabel minimoins;
	private int position;
	private String nom;
	
	public InfoCarteEditionAdresse(String eti, String rue, String code, String ville, String pays,ArrayList<?> al, boolean b) {
		
		this.controleur = (AbstractControleur) al.get(1);
		this.position = (Integer) al.get(2);
		this.nom = (String) al.get(3);
		
		this.l1.setText(eti);		
		this.l1.setFont(new Font("Arial",Font.PLAIN,12));
		
		this.tf1.setText(rue);
		this.tf1.setForeground(Color.BLACK);
		this.tf1.setFont(new Font("Arial",Font.PLAIN,12));
		this.tf1.setName((String) al.get(5));
		this.tf1.setBorder(null);
		this.tf1.setText((rue=="" ? this.tf1.getName() : rue ));		
		this.tf1.setForeground((rue=="" ? Color.GRAY : Color.BLACK ));
		this.tf1.addFocusListener(new NoFocusListener());
		this.tf1.addKeyListener(new ClavierListener());
		
		this.tf2.setText(code);
		this.tf2.setForeground(Color.BLACK);
		this.tf2.setFont(new Font("Arial",Font.PLAIN,12));
		this.tf2.setName((String) al.get(6));
		this.tf2.setBorder(null);
		this.tf2.setText((code=="" ? this.tf1.getName() : code ));		
		this.tf2.setForeground((code=="" ? Color.GRAY : Color.BLACK ));
		this.tf2.addFocusListener(new NoFocusListener());
		
		this.tf3.setText(ville);
		this.tf3.setForeground(Color.BLACK);
		this.tf3.setFont(new Font("Arial",Font.PLAIN,12));
		this.tf3.setName((String) al.get(7));
		this.tf3.setBorder(null);
		this.tf3.setText((ville=="" ? this.tf1.getName() : ville ));		
		this.tf3.setForeground((ville=="" ? Color.GRAY : Color.BLACK ));
		this.tf3.addFocusListener(new NoFocusListener());
		this.tf1.addKeyListener(new ClavierListener());
		
		this.tf4.setText(pays);
		this.tf4.setForeground(Color.BLACK);
		this.tf4.setFont(new Font("Arial",Font.PLAIN,12));
		this.tf4.setName((String) al.get(8));
		this.tf4.setBorder(null);
		this.tf4.setText((pays=="" ? this.tf1.getName() : pays ));		
		this.tf4.setForeground((pays=="" ? Color.GRAY : Color.BLACK ));
		this.tf1.addFocusListener(new NoFocusListener());
		this.tf1.addKeyListener(new ClavierListener());
		
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));		

		this.p1.setMaximumSize(new Dimension(150,14));
		this.p1.setMinimumSize(new Dimension(150,14));
		this.p1.setPreferredSize(new Dimension(150,14));
		this.p1.setBackground(Color.WHITE);
		this.p1.setLayout(new BorderLayout());
		this.p2.setMaximumSize(new Dimension(10,14));
		this.p2.setMinimumSize(new Dimension(150,14));
		this.p2.setPreferredSize(new Dimension(10,14));
		this.p2.setBackground(Color.WHITE);	
		
		FontMetrics fm1 = getFontMetrics(tf4.getFont());
		this.tf1.setMaximumSize(new Dimension(fm1.stringWidth(rue)+1,13));
		FontMetrics fm2 = getFontMetrics(tf4.getFont());
		this.tf2.setMaximumSize(new Dimension(fm2.stringWidth(code)+1,13));
		FontMetrics fm3 = getFontMetrics(tf4.getFont());
		this.tf3.setMaximumSize(new Dimension(fm3.stringWidth(ville)+1,13));
		FontMetrics fm4 = getFontMetrics(tf4.getFont());
		this.tf4.setMaximumSize(new Dimension(fm4.stringWidth(pays)+1,13));
		
		this.miniplus = new JLabel(((Icones) al.get(0)).getMiniplus());
		this.minimoins = new JLabel(((Icones) al.get(0)).getMinimoins());
		this.miniplus.addMouseListener(new PlusListener());
		this.minimoins.addMouseListener(new MoinsListener());
        
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
		
		Box b4 = Box.createVerticalBox();
		b4.setBackground(Color.WHITE);
		b4.add(tf1);
		b4.add(tf2);
		b4.add(tf3);
		b4.add(tf4);
		
		this.add(p1);
		this.add(p2);
		this.add(b4);
		
		this.setBackground(Color.WHITE);		
		
	    FontMetrics fm = getFontMetrics(tf1.getFont());
	    int largeur = fm.stringWidth(rue);
	    if(fm.stringWidth(code)>fm.stringWidth(rue) && fm.stringWidth(code)>fm.stringWidth(ville) && fm.stringWidth(code)>fm.stringWidth(pays)){
	    	largeur = fm.stringWidth(code);
	    }
	    else if(fm.stringWidth(pays)>fm.stringWidth(rue) && fm.stringWidth(pays)>fm.stringWidth(code) && fm.stringWidth(pays)>fm.stringWidth(ville)){
	    	largeur = fm.stringWidth(pays);
	    }
	    else if(fm.stringWidth(ville)>fm.stringWidth(rue) && fm.stringWidth(ville)>fm.stringWidth(code) && fm.stringWidth(ville)>fm.stringWidth(pays)){
	    	largeur = fm.stringWidth(ville);
	    }
	    this.setMinimumSize(new Dimension(160+(largeur*3),100));
	    this.setMaximumSize(new Dimension(160+(largeur*3),100));
		
	    
	    tf1.setAlignmentX(Component.LEFT_ALIGNMENT);
		tf1.setAlignmentY(Component.TOP_ALIGNMENT);
		tf2.setAlignmentX(Component.LEFT_ALIGNMENT);
		tf2.setAlignmentY(Component.TOP_ALIGNMENT);
		tf3.setAlignmentX(Component.LEFT_ALIGNMENT);
		tf3.setAlignmentY(Component.TOP_ALIGNMENT);
		tf4.setAlignmentX(Component.LEFT_ALIGNMENT);
		tf4.setAlignmentY(Component.TOP_ALIGNMENT);
		b4.setAlignmentX(Component.LEFT_ALIGNMENT);
		b4.setAlignmentY(Component.TOP_ALIGNMENT);
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
			JTextField tf1 = (JTextField) arg0.getSource();
			tf1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			tf1.selectAll();
			FontMetrics fm = getFontMetrics(tf1.getFont());		
			tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+1,13));
			revalidate();
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			tf1.setBorder(null);
			JTextField tf1 = (JTextField) arg0.getSource();
			if (tf1.getText().length() != 0 && !tf1.getText().equals(tf1.getName())){
				controleur.setInfo(tf1.getText(), tf1.getName());
			}
			else{				
				controleur.setInfo("", tf1.getName());
				tf1.setText(tf1.getName());
				tf1.setForeground(Color.GRAY);
			}
			FontMetrics fm = getFontMetrics(tf1.getFont());		
			tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+1,13));
			revalidate();
		}
		
	}
	
	public class ClavierListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			JTextField tf1 = (JTextField) arg0.getSource();
			FontMetrics fm = getFontMetrics(tf1.getFont());
			tf1.setMaximumSize(new Dimension(fm.stringWidth(tf1.getText())+20,13));
			revalidate();		
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}

	}

}
