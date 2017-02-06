package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class BoutonColonne extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private TransparentButton b1;
	
	public BoutonColonne(String s, ImageIcon i1, ImageIcon i2){
		
	
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(0,40));
		this.b1 = new TransparentButton(s,i1,i2);
		this.b1.setBackground(Color.GRAY);
		this.b1.setSize(22,22);
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(5,5,5,5);
        c.anchor = GridBagConstraints.WEST;      
		
		
		this.add(b1,c);
		
	}

	public TransparentButton getB1() {
		return this.b1;
	}

	public void addActionListener(ActionListener listener) {
		this.b1.addActionListener(listener);		
	}
	
		
		
}
