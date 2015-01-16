package moteur;

import interfaceGraphique.JeuDeCarteDemarrageView;
import interfaceGraphique.JeuDeCarteUniverselView;

import java.util.ArrayList;

import controller.*;

import java.util.Collection;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author Naomi Sakine et Antoine Ladune Classe Partie qui contient le main
 */
public class Partie {
	private int nombreJoueurVirtuel = 0;
	private String nomVainqueur;
	private TasDeCarte tasdecarte;
	private int nbJoueurEnJeu = 0;
	private boolean JoueurEnJeu = true;
	private ArrayList<Joueur> listJoueur;
	private ListIterator iterateurJoueur;
	private String nomJoueur = "Guest";
	static public Partie partie;
	private JeuDeCarteController controller;
	private JeuDeCarteUniverselView fenetreUniverselle;
	private JeuDeCarteDemarrageView menuDemarrage;

	/**
	 * MÈthode qui commence la partie
	 */
	public void lancementPartie() {
		partie.debutPartie();
	}

	/**
	 * MÈthode qui supprime le joueur rÈel du jeu
	 */
	public void sortirJoueur() {
		JoueurEnJeu = false;
		nbJoueurEnJeu--;
	}

	/**
	 * MÈthode qui supprime un joueur virtuel du jeu
	 */
	public void sortirJoueurVirtuel() {
		nbJoueurEnJeu--;
	}

	/**
	 * @return la liste des joueurs
	 */
	public ArrayList<Joueur> getlistJoueur() {
		return (this.listJoueur);
	}

	/**
	 * Constructeur de la classe Partie
	 */
	public Partie() {
		menuDemarrage = new JeuDeCarteDemarrageView();
		fenetreUniverselle = new JeuDeCarteUniverselView();
		controller = new JeuDeCarteController(menuDemarrage, fenetreUniverselle);
		menuDemarrage.setVisible(true);
	}

	/**
	 * @param controller
	 */
	public void setController(JeuDeCarteController controller) {
		this.controller = controller;
	}

	/**
	 * MÈthode qui rÈcupÈre le nombre de joueurs
	 */
	public void setNbJoueur() {
		try {
			Scanner sc = new Scanner(System.in);
			System.out
					.println("Combien voulez vous de joueur virtuels (1 -> *)");
			int nbJoueur = sc.nextInt();
			this.nombreJoueurVirtuel = nbJoueur;
		} catch (InputMismatchException e) {
			System.out.println("n'avez pas entr√© un nombre !");
			setNbJoueur();
		}
	}

	/**
	 * @return nomJoueur
	 */
	public String setNomJoueur() {
		String nomJoueur = null;

		System.out.println("quel est votre nom ? \n \n");
		nomJoueur = lireClavier();

		return (nomJoueur);
	}

	/**
	 * @param nom
	 */
	public void setNomJoueur(String nom) {
		nomJoueur = nom;
	}

	/**
	 * @return
	 */
	public String lireClavier() {
		Scanner sc = new Scanner(System.in);
		return (sc.nextLine());
	}

	/**
	 * @return
	 */
	public int lireClavierInt() {
		Scanner sc = new Scanner(System.in);
		return (sc.nextInt());
	}

	/**
	 * MÈthode qui rÈalise les actions possibles avant de commencer la partie
	 */
	public void debutPartie() {
		listJoueur = new ArrayList<Joueur>();
		Joueur joueur = new Joueur(nomJoueur);
		controller.ajouterJoueurView(joueur);
		listJoueur.add(joueur);
		this.JoueurEnJeu = true;
		this.nbJoueurEnJeu = this.nombreJoueurVirtuel + 1;
		JoueurVirtuel[] joueurVirtuel = new JoueurVirtuel[this.nombreJoueurVirtuel];
		for (int i = 0; i < this.nombreJoueurVirtuel; i++) {
			joueurVirtuel[i] = new JoueurVirtuel();
			controller.ajouterJoueurView(joueurVirtuel[i]);
			listJoueur.add(joueurVirtuel[i]);

		}
	}

	/**
	 *  MÈthode qui rÈalise les actions possibles en cours de partie
	 */
	public void deroulementPartie() {
		while (this.nbJoueurEnJeu != 1 || JoueurEnJeu) {
			while (!(tasdecarte.getpioche().isEmpty())) {

				iterateurJoueur = listJoueur.listIterator();
				int i = 0;
				while (iterateurJoueur.hasNext()) {
					Joueur element = (Joueur) iterateurJoueur.next();
					if (element.JoueurEnJeu) {
						System.out.println(element);
						element.jouerCarte();
						i++;
					}

				}
			}
			{
				ListIterator<Joueur> it = listJoueur.listIterator();
				int i = 0;
				while (it.hasNext()) {
					Joueur element = it.next();
					i++;
					System.out.println("\n \njoueur : " + i + " " + element);
					System.out.println("le talon est :");
					tasdecarte.afficherTalon();
					element.jouerCarte();
				}
			}
		}
		finDePartie();
	}

	/**
	 *  MÈthode qui finit la partie
	 */
	public void finDePartie() {
		if (JoueurEnJeu) {
			System.out.println("\n \n Vous Avez Perdu!!");
		} else {
			System.out.println("\n \nVous Avez Gagn√© !! f√©licitation");
		}
	}

	/**
	 * @return nombreJoueurVirtuel
	 */
	public int getNombreJoueurVirtuel() {
		return nombreJoueurVirtuel;
	}

	/**
	 * @param nombreJoueurVirtuel
	 */
	public void setNombreJoueurVirtuel(int nombreJoueurVirtuel) {
		this.nombreJoueurVirtuel = nombreJoueurVirtuel;
	}

	/**
	 * @return nomVainqueur
	 */
	public String getNomVainqueur() {
		return nomVainqueur;
	}

	/**
	 * @param nomVainqueur
	 */
	public void setNomVainqueur(String nomVainqueur) {
		this.nomVainqueur = nomVainqueur;
	}

	/**
	 * @return tasdecarte
	 */
	public TasDeCarte getTasDeCarte() {
		return (tasdecarte);
	}

	/**
	 * @return iterateurJoueur
	 */
	public ListIterator getiIterateurJoueur() {
		return (iterateurJoueur);
	}

}
