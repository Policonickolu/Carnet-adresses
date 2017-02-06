package vue;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TransparentButton extends JButton{

	private static final long serialVersionUID = 1L;
	
	private Image img;
	private Image i1;
	private Image i2;
	
	public TransparentButton(String s, ImageIcon i1, ImageIcon i2) { 
	    super(s);
	    this.img = i1.getImage();
	    this.i1 = i1.getImage();
	    this.i2 = i2.getImage();

	    this.setOpaque(false);
	    this.addMouseListener(new ClicBoutonListener());
	} 
	    
	public void paint(Graphics g) { 
	    Graphics2D g2 = (Graphics2D) g.create(); 
	    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.0f)); 
	    g.drawImage(img, 0, 0, null);

	    super.paint(g2); 
		   g2.dispose(); 
	}

	public void setImg(Image img) {
		
		this.img = img;
		
	} 
	
	public class ClicBoutonListener implements MouseListener {
	
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			
			setImg(i2);
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
			setImg(i1);
			
		}

	}
}
