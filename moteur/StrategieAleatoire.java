package moteur;

import java.util.ArrayList;
import java.util.Random;
import java.util.ListIterator;

/**
 * @author Naomi Sakine et Antoine Ladune
 *Classe StrategieAleatoire, stratégie qui joue une carte au hasard parmi
 *les cartes jouables de la main du joueur virtuel 
 */
public class StrategieAleatoire implements Strategie {
	/* (non-Javadoc)
	 * @see moteur.Strategie#poserCarteStrategique(moteur.JoueurVirtuel)
	 */
	public void poserCarteStrategique(JoueurVirtuel j) {
		ArrayList<Carte> cartesJouables = new ArrayList<Carte>();
		ArrayList<Carte> cartesAPoser = new ArrayList<Carte>();
		Random random = new Random();
		Carte carteAPoser = null;
		System.out.println("--------main de " + j + " : "
				+ j.getmain().toString());
		cartesJouables = determinerCartesJouables(j.getmain());
		System.out.println("-----cartes jouables : "
				+ cartesJouables.toString());

		if (cartesJouables.size() > 0) {

			carteAPoser = determinerCarteAPoser(cartesJouables);
			cartesAPoser = determinerCartesAPoser(carteAPoser, cartesJouables);

			if (carteAPoser.estAs()) {

				int i = random.nextInt(Partie.partie.getlistJoueur().size());
				Joueur joueurRecupereTalon = Partie.partie.getlistJoueur().get(
						i);
				System.out.println("joueur recupere talon :  "
						+ joueurRecupereTalon);
				while (joueurRecupereTalon.getNom(joueurRecupereTalon) == j
						.getNom(j)) {
					i = random.nextInt(Partie.partie.getlistJoueur().size());
					joueurRecupereTalon = Partie.partie.getlistJoueur().get(i);
				}
				System.out.println("joueur recupere talon :  "
						+ joueurRecupereTalon);
				ListIterator<Carte> it = cartesAPoser.listIterator();
				while (it.hasNext()) {
					Carte element = it.next();
					Partie.partie.getTasDeCarte().getTalon().add(element);
					j.getmain().remove(element);
				}

				if (joueurRecupereTalon instanceof Joueur
						&& peutContrerAs(joueurRecupereTalon)) {
					As carte = (As) carteAPoser;
					carte.contreAs(joueurRecupereTalon);
				}

				Partie.partie.getTasDeCarte().donnerTalon(
						Partie.partie.getlistJoueur().get(
								(Partie.partie.getlistJoueur()
										.indexOf(joueurRecupereTalon))));
				System.out.println(j
						+ " donne le talon Ã  "
						+ Partie.partie.getlistJoueur().get(
								(Partie.partie.getlistJoueur()
										.indexOf(joueurRecupereTalon))));
				piocher(cartesAPoser.size(), j);
			} else {
				j.poserCarte(cartesAPoser);
				piocher(cartesAPoser.size(), j);
			}
		} else {
			System.out.println("L'ordi ne peut pas jouer!");
			Partie.partie.getTasDeCarte().donnerTalon(j);
		}
	}

	/* (non-Javadoc)
	 * @see moteur.Strategie#echangerCarte(moteur.JoueurVirtuel)
	 */
	public void echangerCarte(JoueurVirtuel j) {
	}

	/* (non-Javadoc)
	 * @see moteur.Strategie#piocher(int, moteur.Joueur)
	 */
	public void piocher(int nbCartesPosees, Joueur j) {
		for (int i = 0; i < nbCartesPosees; i++) {
			if (j.getmain().size() < 3) {
				j.piocher(1);
			}
		}
	}

	/**
	 * @param main
	 * @return une arraylist des cartes jouables
	 */
	public ArrayList<Carte> determinerCartesJouables(ArrayList<Carte> main) {
		ArrayList<Carte> cartesJouables = new ArrayList<Carte>();
		ListIterator<Carte> it = main.listIterator();
		while (it.hasNext()) {
			Carte element = it.next();
			if (element.determinerCarteJouable()) {
				cartesJouables.add(element);
			}
		}
		return cartesJouables;
	}

	/**
	 * @param cartesJouables
	 * @return  la carte à poser
	 */
	public Carte determinerCarteAPoser(ArrayList<Carte> cartesJouables) {
		Random random = new Random();
		Carte carteAPoser = null;
		int index = random.nextInt(cartesJouables.size());
		carteAPoser = cartesJouables.get(index);
		return carteAPoser;
	}

	/**
	 * @param carteAPoser
	 * @param cartesJouables
	 * @return une arraylist des cartes à poser
	 */
	public ArrayList<Carte> determinerCartesAPoser(Carte carteAPoser,
			ArrayList<Carte> cartesJouables) {
		ArrayList<Carte> cartesAPoser = new ArrayList<Carte>();
		ListIterator<Carte> it = cartesJouables.listIterator();
		while (it.hasNext()) {
			Carte element = it.next();
			if (element.getValeur() == carteAPoser.getValeur()) {
				cartesAPoser.add(element);
			}
		}
		System.out
				.println("------cartes Ã  poser : " + cartesAPoser.toString());
		return cartesAPoser;
	}

	/**
	 * @param joueur
	 * @return un boolean qui est vrai si le joueur réel peut contrer l'As
	 */
	public boolean peutContrerAs(Joueur joueur) {
		boolean peutContrer = false;
		ListIterator<Carte> it = joueur.getmain().listIterator();
		while (it.hasNext()) {
			Carte element = it.next();
			if (element.estDeux() || element.estAs()) {
				peutContrer = true;
			}
		}
		return peutContrer;
	}
}