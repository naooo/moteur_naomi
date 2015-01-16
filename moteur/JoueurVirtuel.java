package moteur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Naomi Sakine et Antoine Ladune Classe qui hérite de Joueur qui
 *         représente les joueurs virtuels
 */
public class JoueurVirtuel extends Joueur {
	public String[] nom = { "Roger", "Patrick", "Corentin", "Emilie", "Albert",
			"Alberta", "Alberte", "Albertine", "Albin", "Alda", "Aldo",
			"Aldegonde", "Alï¿½the", "Alex", "Alexandra" };
	static private int indiceNom = 0;
	private Strategie strategie;

	/**
	 * Consructeur de la classe JoueurVirtuel, attribue une stratégie au joueur virtuel
	 */
	public JoueurVirtuel() {
		if (indiceNom == 15) {
			indiceNom = 0;
		}
		super.nomJoueur = nom[indiceNom];
		indiceNom++;
		int random = (int) (Math.random() * 2) + 1;
		if (random == 1) {
			this.strategie = new StrategieAleatoire();
		} else {
			this.strategie = new StrategieLeMeilleurPourLaFin();
		}
	}

	/* (non-Javadoc)
	 * @see moteur.Joueur#echangerCarte()
	 */
	public void echangerCarte() {
		strategie.echangerCarte(this);
	}

	/**
	 * @param main
	 * @return le nombre de cartes jouable dans la main du joueur virtuel
	 */
	public int determinernbCartesJouables(ArrayList<Carte> main) {
		int nbCartesJouables = 0;
		ListIterator<Carte> it = super.main.listIterator();
		while (it.hasNext()) {
			Carte element = it.next();
			if (element.determinerCarteJouable()) {
				nbCartesJouables++;
			}
		}
		return nbCartesJouables;
	}

	/* (non-Javadoc)
	 * @see moteur.Joueur#jouerCarte()
	 * Méthode qui joue une carte
	 */
	public void jouerCarte() {
		strategie.poserCarteStrategique(this);

	}

	/* (non-Javadoc)
	 * @see moteur.Joueur#toString()
	 */
	public String toString() {
		return ("Joueur Virtuel " + nomJoueur + " ");
	}

}
