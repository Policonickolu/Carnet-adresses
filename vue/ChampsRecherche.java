package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChampsRecherche extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private TextFieldRond tf1;
	private Box box = Box.createHorizontalBox();
	private ImageIcon image1 = new ImageIcon(getClass().getResource("loupe.PNG"));
	private JLabel l1 = new JLabel(image1);
	private ImageIcon image2 = new ImageIcon(getClass().getResource("fin.PNG"));
	private JLabel l2 = new JLabel(image2);
	private ColonneNom nom;
	
	public ChampsRecherche(Icones icones, ColonneNom nom){
		
		this.tf1 = new TextFieldRond(icones.getRecherche());
		this.nom = nom;
		this.setPreferredSize(new Dimension(0, 40));
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.GRAY);
		this.tf1.addKeyListener(new RechercheListener());
		this.tf1.setToolTipText("Filtrer les cartes par mot clé");
		
		Font police = new Font("Arial", Font.BOLD, 14);
        this.tf1.setFont(police);
		this.tf1.setPreferredSize(new Dimension(150, 30));
		this.tf1.setBackground(Color.WHITE);
		this.box.setPreferredSize(new Dimension(176, 30));
		this.box.setBackground(Color.WHITE);
		this.box.add(l1);
		this.box.add(tf1);
		this.box.add(l2);
		
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(5,5,5,5);
        c.anchor = GridBagConstraints.EAST;        
		this.add(box,c);
		
	}
	
	public class RechercheListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
	
		}

		@Override
		public void keyReleased(KeyEvent e) {
			nom.setMotCle(((TextFieldRond)e.getSource()).getText());
			nom.initialiser();
			revalidate();	
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
					
		}
		
		
	}
	
}
