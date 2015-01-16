package moteur;


/**
 * @author Naomi Sakine et Antoine Ladune
 * Classe Dix représentant les dix
 */
public class Dix extends moteur.CarteSpeciale {
	/**
	 * @param valeurcarte
	 * @param couleurcarte
	 * Constructeur la classe Dix
	 */
	public Dix(int valeurcarte, String couleurcarte){
		super.couleur=couleurcarte;
		super.valeur=valeurcarte;
	};
	
	/* (non-Javadoc)
	 * @see moteur.CarteSpeciale#jouerEffet()
	 * Méthode qui joue l'effet de la carte 10 : vide le talon
	 */
	public void jouerEffet() {
		Partie.partie.getTasDeCarte().getTalon().clear();
	}
	
	/* (non-Javadoc)
	 * @see moteur.Carte#toString()
	 */
	public String toString(){
		return("Dix"+" de "+this.couleur);
	}
}
