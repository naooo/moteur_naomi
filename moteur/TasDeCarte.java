package moteur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Naomi Sakine et Antoine Ladune
 *  Classe TasDeCarte
 */
public class TasDeCarte extends Carte {
	private ConcurrentLinkedQueue<Carte> pioche;
	private ArrayList<Carte> talon;

	/**
	 * @param nombreJoueurVirtuel
	 * Constructeur de la classe TasDeCarte
	 */
	public TasDeCarte(int nombreJoueurVirtuel) {
		distribuerCarte(nombreJoueurVirtuel);

	}

	/**
	 * @param nombrePaquet
	 * Méthode qui crée la pioche
	 */
	public void creerPioche(int nombrePaquet) {

		int[] valeurCarte = new int[8];
		int[] valeurCarteSpeciale = new int[5];
		int i, j, k;
		String[] couleurCarte = new String[4];

		couleurCarte[0] = "coeur";
		couleurCarte[1] = "carreau";
		couleurCarte[2] = "trefle";
		couleurCarte[3] = "pique";
		ArrayList<Carte> piocheDeMelange = new ArrayList<Carte>();
		for (i = 0; i < nombrePaquet; i++) {
			for (j = 1; j < 14; j++) {
				for (k = 0; k < 4; k++) {
					switch (j) {
					case 13:
						As m = new As((j), couleurCarte[k]);
						piocheDeMelange.add(m);
						break;
					case 1:
						Deux m2 = new Deux((j), couleurCarte[k]);
						piocheDeMelange.add(m2);
						break;
					case 6:
						Sept m3 = new Sept((j), couleurCarte[k]);
						piocheDeMelange.add(m3);
						break;
					case 7:
						Huit m4 = new Huit((j), couleurCarte[k]);
						piocheDeMelange.add(m4);
						break;
					case 9:
						Dix m5 = new Dix((j), couleurCarte[k]);
						piocheDeMelange.add(m5);
						break;

					default:

						Carte m6 = new Carte((j), couleurCarte[k]);
						piocheDeMelange.add(m6);
					}
				}
			}
		}

		Collections.shuffle(piocheDeMelange);
		pioche = new ConcurrentLinkedQueue<Carte>();
		ListIterator<Carte> it = piocheDeMelange.listIterator();
		while (it.hasNext()) {
			Carte element = it.next();
			pioche.add(element);
		}
	}

	/**
	 * Méthode qui crée le tlaon
	 */
	public void creerTalon() {
		talon = new ArrayList<Carte>();
	}

	/**
	 * @param nombreJoueurVirtuel
	 * Méthode qui distribue les cartes
	 */
	public void distribuerCarte(int nombreJoueurVirtuel) {
		int nombrePaquet = 0;
		int i;

		nombrePaquet = nombreJoueurVirtuel / 4;

		if ((nombreJoueurVirtuel % 4) != 0) {
			nombrePaquet++;
		}
		creerPioche(nombrePaquet);
		creerTalon();
		ListIterator<Joueur> it = Partie.partie.getlistJoueur().listIterator();

		while (it.hasNext()) {
			Joueur element = it.next();
			element.creerList();
			for (i = 0; i < 3; i++) {
				element.getfaceCachee().add(pioche.remove());
				element.getfaceVisible().add(pioche.remove());
			}
		}
	}

	/**
	 * @return pioche
	 */
	public ConcurrentLinkedQueue<Carte> getpioche() {
		return (pioche);
	}

	/**
	 * @return talon
	 */
	public ArrayList<Carte> getTalon() {
		return (talon);
	}

	/**
	 * Methode qui affiche le talon
	 */
	public void afficherTalon() {
		if (!(talon.isEmpty())) {
			System.out.println(talon);
		} else {
			System.out.println("rien dans le talon");
		}
	}

	/**
	 * @param joueur
	 * Méthode qui donne le talon
	 */
	public void donnerTalon(Joueur joueur) {
		joueur.getmain().addAll(Partie.partie.getTasDeCarte().talon);
		Partie.partie.getTasDeCarte().talon.clear();
	}

}
