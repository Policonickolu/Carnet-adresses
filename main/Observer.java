package main;

import java.util.ArrayList;

import modele.Fiche;
import modele.Groupe;


public interface Observer {
	public void update(ArrayList<Groupe> carnet, Groupe groupe, Fiche fiche, Fiche modele);
}