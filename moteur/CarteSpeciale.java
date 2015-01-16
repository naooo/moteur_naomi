package moteur;

/**
 * @author Naomi Sakine et Antoine Ladune
 *
 */
public abstract class CarteSpeciale extends moteur.Carte {
	
	/**
	 * @param valeurcarte
	 * @param couleurcarte
	 * Constructeur de la classe CarteSpeciale
	 */
	public CarteSpeciale(int valeurcarte, String couleurcarte){
		super.couleur=couleurcarte;
		super.valeur=valeurcarte;
		
	}
	/**
	 * Constructeur de la classe CarteSpeciale qui ne prend aucun paramètre
	 */
	public CarteSpeciale(){
	}
	
	/**
	 * Méthode abstraite qui joue l'effet d'une carte spéciale, redéfinie dans les classes filles
	 */
	public abstract void jouerEffet();
}
