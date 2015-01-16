package moteur;

/**
 * @author Naomi Sakine et Antoine Ladune
 *  Classe Sept représentant les sept
 */
public class Sept extends moteur.CarteSpeciale {
	/**
	 * @param valeurcarte
	 * @param couleurcarte
	 * Constructeur de la classe Sept
	 */
	public Sept(int valeurcarte, String couleurcarte) {
		super.couleur = couleurcarte;
		super.valeur = valeurcarte;

	};

	/* (non-Javadoc)
	 * @see moteur.CarteSpeciale#jouerEffet()
	 */
	public void jouerEffet() {

	}


	/* (non-Javadoc)
	 * @see moteur.Carte#toString()
	 */
	public String toString() {
		return ("Sept" + " de " + this.couleur);
	}
}
