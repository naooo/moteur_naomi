package moteur;

import java.util.ArrayList;

/**
 * @author Naomi Sakine et Antoine Ladune
 * Interface Strategie
 */
public interface Strategie {

	/**
	 * @param j
	 * M�thode qui joue une carte pour le joueur virtuel
	 */
	public abstract void poserCarteStrategique(JoueurVirtuel j);
	/**
	 * @param j
	 * M�thode qui �change les cartes pour le joueur virtuel
	 */
	public abstract void echangerCarte(JoueurVirtuel j);
	/**
	 * @param nbCartesPosees
	 * @param j
	 * M�thode qui pioche pour le joueur virtuel
	 */
	public abstract void piocher(int nbCartesPosees, Joueur j);

}
