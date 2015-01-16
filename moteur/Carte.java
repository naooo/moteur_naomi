package moteur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Naomi Sakine et Antoine Ladune
 *	Classe carte reprÈsentant toutes les cartes du jeu
 */
public class Carte {
	protected int valeur;
	protected String couleur;
	private boolean carteJouable;

	/**
	 * Constructeur de la classe Carte
	 * @param valeur
	 * @param couleurcarte
	 */
	public Carte(int valeur,String couleurcarte){
		this.couleur=couleurcarte;
		this.valeur=valeur;		
	}
	public Carte(){
		
	}
	/**
	 * @return un boolean qui est vrai si la carte est jouable
	 */
	public boolean determinerCarteJouable() {
		boolean cartejouable=true;
		if (!(Partie.partie.getTasDeCarte().getTalon().isEmpty())){
			if(Partie.partie.getTasDeCarte().getTalon().get(Partie.partie.getTasDeCarte().getTalon().size()-1).getValeur()==6){
				if(getValeur()>7){
					cartejouable=false;
					System.out.println("vous devez jouer une carte inf√©rieure ou √©gale au 7 !");
				}
			}
			else if (getValeur() < Partie.partie.getTasDeCarte().getTalon().get(Partie.partie.getTasDeCarte().getTalon().size()-1).getValeur()){
				if (estCarteSpeciale()){
					if (!(estDeux())){
						cartejouable=false;
					}
					else {
						cartejouable=true;
					}}
				else {cartejouable=false;}	
			}
			
		}
		return(cartejouable);
	}

	

	/**
	 * @return la valeur de la carte
	 */
	public int getValeur() {
		return valeur;
	}

	/**
	 * @param valeur
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	
	/**
	 * Getter de l'attribut couleur
	 * @return couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @return l'attribut carteJouable
	 */
	public boolean getCarteJouable() {
		return carteJouable;
	}


	/**
	 * @param carteJouable
	 */
	public void setCarteJouable(boolean carteJouable) {
		this.carteJouable = carteJouable;
	}
	
	/**
	 * @return un boolean qui est vraie si la carte est une carte spÈciale
	 */
	public boolean estCarteSpeciale(){
		boolean cartespeciale=false;
		if (this instanceof CarteSpeciale){
			cartespeciale=true;
		}
		return (cartespeciale);
	}
	
	/**
	 * @return un boolean qui est vrai si la carte est un As
	 */
	public boolean estAs(){
		boolean cartespeciale=false;
		if (this.getClass() == As.class){
			cartespeciale=true;
		}
		return (cartespeciale);
	}
	
	/**
	 * @return un boolean qui est vrai si la carte est un Deux
	 */
	public boolean estDeux(){
		boolean cartespeciale=false;
		if (this.getClass() == Deux.class){
			cartespeciale=true;
		}
		return (cartespeciale);
	}
	
	/**
	 * @return un boolean qui est vrai si la carte est un Sept
	 */
	public boolean estSept(){
		boolean cartespeciale=false;
		if (this.getClass() == Sept.class){
			cartespeciale=true;
		}
		return (cartespeciale);
	}
	
	/**
	 * @return un boolean qui est vrai si la carte est un Huit
	 */
	public boolean estHuit(){
		boolean cartespeciale=false;
		if (this.getClass() == Huit.class){
			cartespeciale=true;
		}
		return (cartespeciale);
	}
	
	/**
	 * @return un boolean qui est vrai si la carte est un Dix
	 */
	public boolean estDix(){
		boolean cartespeciale=false;
		if (this.getClass() == Dix.class){
			cartespeciale=true;
			System.out.println("cest un dix");
		}
		return (cartespeciale);
	}
	
	/**
	 * @param valeur
	 * @return un chaine de caractËres qui correspond a la valeur donnÈe paramËtre
	 */
	public String chiffreEnNom(int valeur){
		String nom=null;
		switch(valeur){
		case 1:
			nom="Deux";
			break;
		case 2:
			nom="Trois";
			break;
		case 3:
			nom="Quatre";
			break;
		case 4:
			nom="Cinq";
			break;
		case 5:
			nom="Six";
			break;
		case 6:
			nom="Sept";
			break;
		case 7:
			nom="Huit";
			break;
		case 8:
			nom="Neuf";
			break;
		case 9:
			nom="Dix";
			break;
		case 10:
			nom="Valet";
			break;
		case 11:
			nom="Dame";
			break;
		case 12:
			nom="Roi";
			break;
		case 13:
			nom="As";
			break;
		
		}
		return(nom);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return(chiffreEnNom(this.valeur)+" de "+this.couleur);
	}
	

}

