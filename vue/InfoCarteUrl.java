package vue;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InfoCarteUrl extends InfoCarte{	
	
	private static final long serialVersionUID = 1L;
	String s = getL2().getText();
	
	public InfoCarteUrl(String eti, String info) {
		super(eti, info);
		this.getL2().setForeground(Color.BLUE);
		this.getL2().addMouseListener(new ClickUrlListener());	
		
	}

	public class ClickUrlListener implements MouseListener{
		
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			String os = System.getProperty("os.name").toLowerCase();
			
			if(os.indexOf( "mac" ) >= 0){
				try { 
					  Runtime r = Runtime.getRuntime(); 
					  Process p = r.exec("open " + (s.indexOf("http://") >= 0 || s.indexOf("https://") >= 0 || s.indexOf("ftp://") >= 0 ? "" : "http://") + s); 
					  p.waitFor();
				}catch(Exception e) {} 
			}
			if(os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0){
				try { 
					  Runtime r = Runtime.getRuntime(); 
					  Process p = r.exec("xdg-open " + (s.indexOf("http://") >= 0 || s.indexOf("https://") >= 0 || s.indexOf("ftp://") >= 0 ? "" : "http://") + s); 
					  p.waitFor();
				}catch(Exception e) {} 
			}
			if(os.indexOf( "win" ) >= 0){
				try { 
					  Runtime r = Runtime.getRuntime(); 
					  Process p = r.exec("rundll32 url.dll,FileProtocolHandler " + (s.indexOf("http://") >= 0 || s.indexOf("https://") >= 0 || s.indexOf("ftp://") >= 0 ? "" : "http://") + s); 
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
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			
			getL2().setForeground(Color.BLUE);
			
		}

	}
	
}
