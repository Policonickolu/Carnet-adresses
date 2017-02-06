package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controleur.AbstractControleur;

import modele.Fiche;

public class ColonneCarte extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private AbstractControleur controleur;
	private Fiche fiche;
	private Icones icones;
	private Carte c1 = null;
	private BoutonColonne bc1;
	private JScrollPane sp1;
	private static boolean modeEdition = false;
	
	public ColonneCarte(Icones i, AbstractControleur controleur){		

		
		this.controleur = controleur;
		this.fiche = new Fiche();
		this.fiche.setNom(" ");
		this.c1 = new Carte(this.fiche,this.controleur);
	 	this.sp1 = new JScrollPane(c1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	 	
		this.bc1 = new BoutonColonne(".......",i.getModifier(),i.getModifierclic());
		this.bc1.getB1().addActionListener(new ModifierListener());
		this.bc1.getB1().setToolTipText("Modifier la carte");
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.add(sp1,BorderLayout.CENTER);
		this.add(bc1,BorderLayout.SOUTH);	
		
	}
	
	public void initialiser(){
		if(fiche!=null){
		if(modeEdition){
			this.c1.editionCarte(fiche,controleur,icones);							
		}
		else{
			this.c1.affichageCarte(fiche);			
		}
		this.revalidate();
		}
		else{
			this.c1.affichageCarte();
			this.revalidate();
		}

	}	

	public void setFiche(Fiche fiche, Icones icones) {
			if(this.fiche!=fiche){
				modeEdition = false;
			}
			this.fiche = fiche;
			this.icones = icones;
	}

	
	public static void setModeEdition(boolean modeEdition) {
		ColonneCarte.modeEdition = modeEdition;
	}

	public static boolean isModeEdition() {
		return modeEdition;
	}


	public class ModifierListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(fiche!=null){	
				setModeEdition((isModeEdition()==true?false:true));
				if(isModeEdition()){
					c1.editionCarte(fiche,controleur,icones);
				}
				else{
					controleur.finEdition();
					c1.removeAll();
					c1.affichageCarte(fiche);						
				}
				revalidate();
			}	
		}	
	
	}
	
}
