package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ColonneListe extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private DefaultListModel dlm1 = new DefaultListModel();
	private JList l1 = new JList(dlm1);
	private JScrollPane sp1;
	private BoutonColonne bc1;
	private JPanel p1 = new JPanel();
	private JPanel p2 = new JPanel();
	private JLabel lb1 = new JLabel();
	
	public ColonneListe(String s, Icones i){

		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		this.l1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.bc1 = new BoutonColonne(" ", i.getPlus(), i.getPlusclic());
		
		this.sp1 = new JScrollPane(this.l1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		this.lb1.setText(s);
		this.lb1.setFont(new Font("Arial", Font.BOLD, 11));
		
		this.p1.setPreferredSize(new Dimension(1,20));
		this.p1.add(lb1);
		this.p1.setBackground(Color.LIGHT_GRAY);

		
		this.p2.setLayout(new BorderLayout());
		this.p2.setBackground(Color.WHITE);
		
		
		this.p2.add(p1,BorderLayout.NORTH);
		this.p2.add(sp1,BorderLayout.CENTER);
		this.add(p2,BorderLayout.CENTER);
		this.add(bc1,BorderLayout.SOUTH);
		this.setPreferredSize(new Dimension(150,0));
		
	}

	public DefaultListModel getDlm() {
		
		return this.dlm1;
		
	}

	public void setL1(JList l1) {
		this.l1 = l1;
	}

	public JList getL1() {
		return l1;
	}

	public void setDlm1(DefaultListModel dlm1) {
		this.dlm1 = dlm1;
	}

	public DefaultListModel getDlm1() {
		return dlm1;
	}

	public void setBc1(BoutonColonne bc1) {
		this.bc1 = bc1;
	}

	public BoutonColonne getBc1() {
		return bc1;
	}
	
}
