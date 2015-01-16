package moteur;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.ListIterator;
import java.util.Scanner;

import javax.swing.JSpinner.ListEditor;


/**
 * @author Naomi Sakine et Antoine Ladune
 * Classe As repr�sentant les as
 */
public class As extends moteur.CarteSpeciale {

	static boolean effetJoue;
	/**
	 * Constructeur de la classe As.
	 * Initialise les paramètres effetjoue,valeur et couleur de la carte.
	 * 
	 * @param valeurcarte
	 * @param couleurcarte
	 */
	public As(int valeurcarte, String couleurcarte){
		super.valeur=valeurcarte;
		super.couleur=couleurcarte;
		effetJoue=false;
		
	}
	/** 
	 * Méthode gérant l'effet de l'As
	 * Demande à qui donner le talon puis rempli la main du joueur en question avec le talon
	 * Peut être contrée par contraAs
	 * @see contreAs
	 * 
	 */
	public void jouerEffet() {
		if(!(effetJoue)){
		Scanner sc = new Scanner(System.in);
		int i=1;
		System.out.println("à qui voulez vous donner le talon (numero)");
		ListIterator<Joueur> it = Partie.partie.getlistJoueur().listIterator();
		while (it.hasNext()){
			Joueur element = it.next();
			System.out.println(element+" "+(i));
			i++;
		}
		System.out.println("?");
		int joueur = sc.nextInt();
		if (!(contreAs(Partie.partie.getlistJoueur().get(joueur-1)))){
			Partie.partie.getTasDeCarte().donnerTalon(Partie.partie.getlistJoueur().get(joueur-1));
			effetJoue=true;
		}
		
		}
	}
	/**
	 * methode qui met effetJoue à false
	 */
	
	public void resetEffet(){
		effetJoue=false;
	}
	/**
	 * Methode qui permet au joueur visé de pouvoir contrer l'as si il a un deux ou un as
	 * Demande quelle carte il veut jouer parmi les 2 et les As
	 * @param joueur
	 * @return
	 */
	public boolean contreAs(Joueur joueur){
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		boolean contre=false;
		boolean grosseBoucle=true;
		while(grosseBoucle){
			grosseBoucle=false;
		System.out.println("voulez vous contrer l'As ?");
		String reponse=sc.nextLine();
		System.out.println("reponse : "+reponse);
		if(reponse.compareTo("oui")==0){
			ListIterator<Carte> it = joueur.getmain().listIterator();
			
			ArrayList<Carte> carteContre = new ArrayList<Carte>();
			while (it.hasNext()){
				Carte element=it.next();
				
				if (element.estDeux() || element.estAs()){
					carteContre.add(element);	
				}
			}
			if (carteContre.size()>0){
								System.out.println("quelle carte voulez vous utiliser pour contrer ?");
								for (int i=0; i<carteContre.size();i++){
									System.out.println("carte n° "+(i+1)+" : "+carteContre.get(i));
								}
								int nocarteajouer=0;
								boolean boucle=true;
								while(boucle){
								try {
								boucle=false;
								
								nocarteajouer = lireClavierInt();
								controlCarteInexistante(nocarteajouer,carteContre);
								} catch (InputMismatchException e) {
									System.out.println("veuillez entrer un chiffre");
									boucle=true;
								}
								catch (CarteInexistanteException e1){
									System.out.println("veuillez entrer entre 1 et "+carteContre.size());
									boucle=true;
								}
						}
								
								Carte carteajouer = carteContre.get(nocarteajouer-1);
								carteContre.clear();
								carteContre.add(carteajouer);
								System.out.println("Vous avez choisi : "+carteajouer);
								joueur.poserCarte(carteContre);
								contre = true;
							}

			
		}
		else if (reponse!="non"){
			System.out.println("veuilez entrer oui ou non");
			grosseBoucle=true;
		}
	}
		
		
		return contre;
	}
	
	/**
	 * @return
	 */
	public int lireClavierInt() {
		 Scanner sc = new Scanner(System.in);
		int sortie=sc.nextInt();
		return(sortie);
	}
	
	/**
	 * @param sortie
	 * @param collec
	 * @throws CarteInexistanteException
	 */
	public void controlCarteInexistante(int sortie,Collection collec)throws CarteInexistanteException{
		if(sortie<0 || sortie>collec.size()){
			throw new CarteInexistanteException();
			}
	}
	
	/* (non-Javadoc)
	 * @see moteur.Carte#toString()
	 */
	public String toString(){
		return("As"+" de "+this.couleur);
	}
	
}
