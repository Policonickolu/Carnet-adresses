package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import modele.Fiche;

import controleur.AbstractControleur;

public class LabelTextField extends JTextField{

	private static final long serialVersionUID = 1L;
	
	private String nom;
	private AbstractControleur controleur;
	private Fiche currentFiche;

	public LabelTextField(AbstractControleur controleur,String s,Font f){
		super(30);
		this.controleur = controleur;
		this.nom = s;	
		this.setBorder(null);
		this.addFocusListener(new NoFocusListener());
		this.addKeyListener(new ClavierListener());
		
		this.setFont(f);		
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setAlignmentY(Component.TOP_ALIGNMENT);		
		this.setBackground(Color.WHITE);
		if(getText()==nom)this.setForeground(Color.GRAY);	
		
		
	}

	public class NoFocusListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			currentFiche = controleur.getCurrentFiche();
			setBorder(BorderFactory.createLineBorder(Color.BLACK));
			LabelTextField tf = ((LabelTextField) arg0.getSource());
			tf.selectAll();
			FontMetrics fm = getFontMetrics(tf.getFont());		
			tf.setMaximumSize(new Dimension(fm.stringWidth(tf.getText())+20,13));
			tf.revalidate();
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			if(currentFiche.equals(controleur.getCurrentFiche())){
				setBorder(null);
				LabelTextField tf = ((LabelTextField) arg0.getSource());
				if (tf.getText().length() != 0 && !tf.getText().equals(tf.getNom())){
				controleur.setInfo(tf.getText(), nom);
				}
				else{				
				controleur.setInfo("", nom);
				tf.setText(nom);
				
				}
				FontMetrics fm = getFontMetrics(tf.getFont());		
				setMaximumSize(new Dimension(fm.stringWidth(tf.getText())+1,fm.getHeight()));
				tf.revalidate();
			}
		}		
		
	}
	
	public class ClavierListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			LabelTextField tf = (LabelTextField) arg0.getSource();
			FontMetrics fm = getFontMetrics(getFont());
			tf.setSize(new Dimension(fm.stringWidth(tf.getText())+20,fm.getHeight()));
			tf.revalidate();
		}

		@Override
		public void keyReleased(KeyEvent arg0) {

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
					
		}		
		
	}
	
	
	public void setTexte(String s){
		this.setText(s);
		FontMetrics fm = getFontMetrics(this.getFont());
		this.setMaximumSize(new Dimension(fm.stringWidth(s)+1,fm.getHeight()));		
	}
	
	public String getNom(){
		return this.nom;
	}
	
	
}
