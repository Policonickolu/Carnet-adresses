package vue;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import modele.Fiche;

public class FicheTransferable implements Transferable, Comparable<Object> {

    /**
     * La personne à transférer.
     */
	
	public static String mime =DataFlavor.javaJVMLocalObjectMimeType + ";class=" + FicheTransferable.class.getName();
	public static DataFlavor ficheFlavor;
	public static int compteur = 0;
	private Fiche fiche;
	private String numero;
	
    /**
     * @param p
     */
	public FicheTransferable(Fiche f) {
		
     	
    	compteur++;
		this.numero = ""+compteur;
		fiche = f; 
		try {
			ficheFlavor = new DataFlavor(mime);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
    }

 
    public DataFlavor[] getTransferDataFlavors() { 
    	DataFlavor[] result= new DataFlavor[2]; 
    	result[0]= ficheFlavor; 
    	result[1]= DataFlavor.stringFlavor; 
    	return result; 
    } 

	public boolean isDataFlavorSupported(DataFlavor flavor) { 
		return ficheFlavor.equals(flavor) || DataFlavor.stringFlavor.equals(flavor); 
	}
	
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException { 
		System.out.println("yggfu");
		if (ficheFlavor.equals(flavor)) return fiche; 
		else if (DataFlavor.stringFlavor.equals(flavor)) { 
			return this.numero; 
		} else throw new UnsupportedFlavorException(flavor); 
	}

	public boolean getShowEntreprise() {
		return this.fiche.getShowEntreprise();
	} 
	
	public String toString(){
		return this.numero;		
	}
	
	public String toString2(){
		return this.fiche.toString();		
	}
	
	public Fiche getFiche(){
		return this.fiche;
	}


	public String getNumero() {
		return this.numero;
	}


	@Override
	public int compareTo(Object o) {
		
		return this.toString().compareTo(o.toString());
		
	}
} 