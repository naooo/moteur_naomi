package moteur;

import java.util.ArrayList;
import java.util.ListIterator;


/**
 * @author Naomi Sakine et Antoine Ladune
 * Classe Huit représentant les huits
 */
public class Huit extends moteur.CarteSpeciale {
	/**
	 * @param valeurcarte
	 * @param couleurcarte
	 * Constructeur la classe Huit
	 */
	public Huit(int valeurcarte, String couleurcarte){
		super.couleur=couleurcarte;
		super.valeur=valeurcarte;
	}
	
	 /* (non-Javadoc)
	 * @see moteur.CarteSpeciale#jouerEffet()
	 */
	public void jouerEffet() {
		while (Partie.partie.getiIterateurJoueur().hasNext()){
			Partie.partie.getiIterateurJoueur().next();
		}
	}

	/* (non-Javadoc)
	 * @see moteur.Carte#toString()
	 */
	public String toString(){
		return("Huit"+" de "+this.couleur);
	}
}

