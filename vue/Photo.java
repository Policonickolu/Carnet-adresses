package vue;
import java.awt.datatransfer.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

import controleur.AbstractControleur;


import modele.Fiche;

public class Photo extends JPanel {
	  
	private static final long serialVersionUID = 1L;
	
	private AbstractControleur controleur;
	private Fiche f;
	
	public Photo(Fiche f,AbstractControleur controleur) {
		this.f = f;
		this.controleur = controleur;

	    this.setTransferHandler(new MyTransferHandler());
	    this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        this.setPreferredSize(new Dimension(90,90));
        this.setBackground(Color.WHITE);
        this.addMouseListener(new PhotoListener());
        this.setToolTipText("Ajouter une nouvelle image");
        
	}
	
	public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(f.getPhoto().getImage(),0, 0, null);	
    }
	
	public class MyTransferHandler extends TransferHandler {
		
		private static final long serialVersionUID = 1L;
	 
		@Override 
		public boolean canImport(JComponent c, DataFlavor[] df) {
			for (int i = 0; i < df.length; i++) {
				if (df[i].equals(DataFlavor.javaFileListFlavor)) {
					return true;
				}
				if (df[i].equals(DataFlavor.stringFlavor)) {
					return true;
				}
			}
			return false;
		}
	 
		private boolean hasFileFlavor(DataFlavor[] df) {
			boolean b = false;
			for (DataFlavor flavor : df) {
				b = DataFlavor.javaFileListFlavor.equals(flavor);
				if (b) {
					break;
				}
			}
			return b;
		}
	 
		private boolean hasStringFlavor(DataFlavor[] df) {
			boolean b = false;
			for (DataFlavor flavor : df) {
				b = DataFlavor.stringFlavor.equals(flavor);
				if (b) {
					break;
				}
			}
			return b;
		}
	 

		
		@Override 
		public boolean importData(JComponent c, Transferable t) {
	    	if (this.hasFileFlavor(t.getTransferDataFlavors())) {
	        try {
	        	List<?> files = (List<?>) (t.getTransferData(DataFlavor.javaFileListFlavor));
	        	StringBuilder builder = new StringBuilder();
	        	for (int i = 0; i < files.size(); i++) {
	        		File file = (File) files.get(i);
	        		builder.append(file.getAbsolutePath());
	        	}      	
	        	Image image = Toolkit.getDefaultToolkit().getImage(builder.toString()).getScaledInstance(90,90,Image.SCALE_DEFAULT);
	        	controleur.setPhoto(image);	        	
	        	repaint();
	        	return true;
	        }
	        catch (Exception e) {
	        	e.printStackTrace();
	        }
	        return false;
	    	}
	    	if (this.hasStringFlavor(t.getTransferDataFlavors())) {
	        try {
	        Image image = Toolkit.getDefaultToolkit().getImage((String) t.getTransferData(DataFlavor.stringFlavor)).getScaledInstance(90,90,Image.SCALE_DEFAULT);
	        controleur.setPhoto(image);		    
        	repaint();
	        }
	        catch (Exception e) {
	          e.printStackTrace();
	        }
	    	}
	    	return false;
	    }
	}
	
	
	public class PhotoListener implements MouseListener{

		private Timer t;
		private boolean doubleClic = false; 
		
		public PhotoListener(){
		
		}
		
		class Tache extends TimerTask {
		    
			private double d = 1;
			
			public void run() {
				if (d > 0) {
					d--;
					doubleClic = true;
				} else {
					t.cancel();
					doubleClic = false;
				}
			}			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(!doubleClic){
				t = new Timer();
				t.schedule(new Tache(), 0, 1000 );
			}
			else{
				JFileChooser fc = new JFileChooser();
		        fc.setApproveButtonText("Ouvrir");
		        if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
		        	Image image = Toolkit.getDefaultToolkit().getImage(fc.getSelectedFile().getAbsolutePath()).getScaledInstance(100,100,Image.SCALE_DEFAULT);
		        	controleur.setPhoto(image);
		        	repaint();
		        }	
			}
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
}