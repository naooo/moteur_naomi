package moteur;

/**
 * @author Naomi Sakine et Antoine Ladune
 * Classe Deux représentant les deux
 */
public class Deux extends moteur.CarteSpeciale {
	
	/**
	 * @param valeurcarte
	 * @param couleurcarte
	 * Constructeur de la classe Deux
	 */
	public Deux(int valeurcarte, String couleurcarte){
		super.couleur=couleurcarte;
		super.valeur=valeurcarte;
	}
	
	/* (non-Javadoc)
	 * @see moteur.CarteSpeciale#jouerEffet()
	 */
	public void jouerEffet() {
	}

	
	/* (non-Javadoc)
	 * @see moteur.Carte#toString()
	 */
	public String toString(){
		return("Deux"+" de "+this.couleur);
	}

}
