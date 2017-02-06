package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoCarte extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JLabel l1 = new JLabel();
	private JLabel l2 = new JLabel();
	
	
	public InfoCarte(String eti, String info){
					
		
		this.l1.setText(eti);
		this.l2.setText(info);		
		
		this.l1.setFont(new Font("Arial",Font.PLAIN,12));
		this.l2.setFont(new Font("Arial",Font.PLAIN,12));
		
		this.l1.setForeground(Color.GRAY);
		this.l2.setForeground(Color.BLACK); 
		
		this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));		

		this.p1.setMaximumSize(new Dimension(150,13));
		this.p1.setBackground(Color.WHITE);
		this.p2.setMaximumSize(new Dimension(10,13));
		this.p2.setBackground(Color.WHITE);	
		
		this.p1.setLayout(new BorderLayout());
		this.p1.add(l1,BorderLayout.EAST);		
		this.add(p1);
		this.add(p2);
		this.add(l2);
		
		this.setBackground(Color.WHITE);
		
		FontMetrics fm = getFontMetrics(l2.getFont());	
		this.setPreferredSize(new Dimension(160+fm.stringWidth(info),13));
		
		this.setAlignmentX(Component.LEFT_ALIGNMENT);
		this.setAlignmentY(Component.TOP_ALIGNMENT);
		
	}

	public void setL2(JLabel l2) {
		this.l2 = l2;
	}

	public JLabel getL2() {
		return l2;
	}

	public void setP2(JPanel p2) {
		this.p2 = p2;
	}

	public JPanel getP2() {
		return p2;
	}

	public void setP1(JPanel p1) {
		this.p1 = p1;
	}

	public JPanel getP1() {
		return p1;
	}

	public void setL1(JLabel l1) {
		this.l1 = l1;
	}

	public JLabel getL1() {
		return l1;
	}

}
