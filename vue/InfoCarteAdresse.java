package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JLabel;

public class InfoCarteAdresse extends InfoCarte{

	private static final long serialVersionUID = 1L;

	private Box b1 = Box.createVerticalBox();
	private JLabel l3 = new JLabel();
	private JLabel l4 = new JLabel();
	private String rue;
	private String code;
	private String ville;
	private String pays;
	
	public InfoCarteAdresse(String eti, String rue, String code, String ville, String pays) {
		super(eti, rue);
		this.l3.setText(code + " " + ville);
		this.l4.setText(pays);
		
		this.rue = rue;
		this.code = code;
		this.ville = ville;
		this.pays = pays;
		
		this.getP1().setMinimumSize(new Dimension(150,14));
		this.getP1().setMaximumSize(new Dimension(150,14));
		this.getP2().setMinimumSize(new Dimension(10,14));
		this.getP2().setMaximumSize(new Dimension(10,14));
		
		this.b1.setBackground(Color.WHITE);
		this.getL2().setForeground(Color.BLUE);
		this.l3.setForeground(Color.BLUE);
		this.l3.setFont(new Font("Arial",Font.PLAIN,12));
	    this.l4.setForeground(Color.BLUE);;
	    this.l4.setFont(new Font("Arial",Font.PLAIN,12));
	    
	    this.b1.add(this.getL2());
	    this.b1.add(this.l3);
	    this.b1.add(this.l4);
	    
	    this.add(b1);
	    
	    this.getP1().setAlignmentY(Component.TOP_ALIGNMENT);
	    this.getP2().setAlignmentY(Component.TOP_ALIGNMENT);
	    this.b1.setAlignmentX(Component.LEFT_ALIGNMENT);
	    this.b1.setAlignmentY(Component.TOP_ALIGNMENT);
	    
	    FontMetrics fm = getFontMetrics(getL2().getFont());
	    int largeur = fm.stringWidth(rue);
	    if(fm.stringWidth(code + " " + ville)>fm.stringWidth(rue) && fm.stringWidth(code + " " + ville)>fm.stringWidth(pays)){
	    	largeur = fm.stringWidth(code + " " + ville);
	    }
	    else if(fm.stringWidth(pays)>fm.stringWidth(rue) && fm.stringWidth(pays)>fm.stringWidth(code + " " + ville)){
	    	largeur = fm.stringWidth(pays);
	    }
	    this.setPreferredSize(new Dimension(160+largeur,45));
		
	    this.b1.addMouseListener(new ClickAdresseListener());
	}
	
	public class ClickAdresseListener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			String os = System.getProperty("os.name").toLowerCase();

			if(os.indexOf( "mac" ) >= 0){
				try { 
					  Runtime r = Runtime.getRuntime(); 
					  Process p = r.exec("open "
							  + "http://maps.google.fr/maps?f=q&source=s_q&hl=fr&geocode=&q=" 
							  + (rue!="" ? rue + "+" : "")
							  + (code!="" ? code + "+" : "")
							  + (ville!="" ? ville + "+" : "")
							  + pays);					  
					  p.waitFor();
				}catch(Exception e) {} 
			}
			if(os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0){
				try { 
					  Runtime r = Runtime.getRuntime(); 
					  Process p = r.exec("xdg-open " 
							  + "http://maps.google.fr/maps?f=q&source=s_q&hl=fr&geocode=&q=" 
							  + (rue!="" ? rue + "+" : "")
							  + (code!="" ? code + "+" : "")
							  + (ville!="" ? ville + "+" : "")
							  + pays);					  
					  p.waitFor();
				}catch(Exception e) {} 
			}
			if(os.indexOf( "win" ) >= 0){
				try { 
					  Runtime r = Runtime.getRuntime(); 
					  Process p = r.exec("rundll32 url.dll,FileProtocolHandler " 
							  + "http://maps.google.fr/maps?f=q&source=s_q&hl=fr&geocode=&q=" 
							  + (rue!="" ? rue + "+" : "")
							  + (code!="" ? code + "+" : "")
							  + (ville!="" ? ville + "+" : "")
							  + pays);			  
					  p.waitFor();
				}catch(Exception e) {} 
			}
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
			
			getL2().setForeground(Color.RED);
			l3.setForeground(Color.RED);
			l4.setForeground(Color.RED);
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
			getL2().setForeground(Color.BLUE);
			l3.setForeground(Color.BLUE);
			l4.setForeground(Color.BLUE);
			
		}

	}

}
