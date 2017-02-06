package vue;
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JTextField;


public class TextFieldRond extends JTextField{
	
	private static final long serialVersionUID = 1L;

	Image img = Toolkit.getDefaultToolkit().createImage("recherche.PNG");
	
	public TextFieldRond(ImageIcon i1) { 
	    super();
	    this.img = i1.getImage();
	    setOpaque(true);
	} 
	    
	public void paint(Graphics g) { 
	    Graphics2D g2 = (Graphics2D) g.create(); 
	    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f)); 
	    g.drawImage(img, 0, 0, null);

	    super.paint(g2); 
		   g2.dispose(); 
	} 	
	
}
