package Projet6Parking;
import java.util.*;
import Projet6Parking.*;

/**
 * Classe permettant de d�finir des parkings et les m�thodes qui leurs sont associ�es
 * 
 * @author Nathan DE LEENER - HE201742
 * @version 2019/11/14
 *
 */
public class Parking {
	
	//Variables d'instance
	private int idParking;
	private String name;
	private String position;
	private int placesTot;
	private int placesDispo;
	private String type;
	
	//Constructeur
	/**D�fini un parking avec son nombre de place et sa localisation
	 * 
	 * @param idParking : Id du parking dans la DB
	 * @param name : Nom du parking
	 * @param position : Nom du lieu o� se situe le parking
	 * @param nbrPlace : Nombre de place totale
	 * @param nbrPlaceDisp : Nombre de place disponible
	 * @param type : Type du parking
	 */
	public Parking(int idParking, String name, String position, int nbrPlace, int nbrPlaceDisp, String type) {
		this.idParking = idParking;
		this.name = name;
		this.position = position;
		this.placesTot = nbrPlace;
		this.placesDispo = nbrPlaceDisp;
		this.type = type;
	}

	/**
	 * Constructeur vide pour pouvoir cr�er un objet dans a classe DataBase sans avoir des erreurs d'initialisation
	 */
	public Parking() {
		this.idParking=-1;
	}
	
	//Getters & Setters
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	/**
	 * @return the placesTot
	 */
	public int getPlacesTot() {
		return placesTot;
	}

	/**
	 * @param placesTot the placesTot to set
	 */
	public void setPlacesTot(int placesTot) {
		this.placesTot = placesTot;
	}

	/**
	 * @return the placesDispo
	 */
	public int getPlacesDispo() {
		return placesDispo;
	}

	/**
	 * @param placesDispo the placesDispo to set
	 */
	public void setPlacesDispo(int placesDispo) {
		this.placesDispo = placesDispo;
	}

	
	//M�thodes
	/**
	 * Retourne le nombre de places disponibles
	 * 
	 * @return Le nombre de places disponibles
	 */
	public int placeAvail() {
		return placesDispo;
	}
	
	/**
	 * Ajoute un nombre d�fini de places au parking
	 * 
	 * @param nouvPlaces : Nombre de place � ajouter au parking
	 * @return Le parking modifi� en terme de nombre total de places et de places disponibles
	 */
	public void addPlace(int nouvPlaces) {
		if (nouvPlaces > 0) {
			placesTot += nouvPlaces;
			placesDispo += nouvPlaces;
		}
	}
	
	/**
	 * Supprime un nombre d�fini de places au parking
	 * 
	 * @param suppPlaces : Nombre de places � supprimer du parking
	 * @return Le parking modifi� en terme de nombre total de places et de places disponibles
	 */
	public void deletePlace(int suppPlaces) {
		if (suppPlaces > 0) {
			placesTot -= suppPlaces;
			placesDispo -= suppPlaces;
		}
	}
	
	/**
	 * Retourne la localisation du parking
	 * 
	 * @return La localisation du parking
	 */
	public String localisation() {
		return position;
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Users
		User user1 = new User (0, "gGortz", "motdepasse", "Gortz", "Gaetan", "11111111", "g.gortz@students.ephec.be", "1-AAA-111");
		User user2 = new User (1, "nDL", "nathan", "De Leener", "Nathan", "22222222", "n.deleener@students.ephec.be", "1-BBB-222");
		User user3 = new User (2, "bLuk", "1234", "Luk", "Brian", "33333333", "b.luk@students.ephec.be", "1-CCC-333");
		// Parkings
		Parking p1 = new Parking (0, "Parking 1", "Localisation 1", 100, 100, "Gratuit");
		Parking p2 = new Parking (1, "Parking 2", "Localisation 2", 25, 25, "Payant");
		// Places
		Place pl1 = new Place (0, p1, 1);
		Place pl2 = new Place (1, p1, 2);
		Place pl3 = new Place (2, p2, 1);
		Place pl4 = new Place (3, p2, 2);
		// Reservations
		Reservation r1 = new Reservation (0, pl1, user1);
		Reservation r2 = new Reservation (1, pl2, user2);
		Reservation r3 = new Reservation (2, pl4, user3);
		// Offences
		Date d = new Date();
		Offence o1 = new Offence (0, user1, user2, "Blabla1", pl1, d);
		
		// Tests
		//System.out.println(user1.getName() + " " + user1.getFirstname() + " " + user1.getMail() + " " + user1.getPhone() + " " + user1.getPlate() + " " + user1.getPenalty());
		System.out.println(user1);
		System.out.println(p1.getPlacesDispo());
		user1.reserve(pl2);
		System.out.println(p1.getPlacesDispo());
		user1.liberePlace(pl2);
		System.out.println(p1.getPlacesDispo());
	}
	
	/**
	 * Retourne un parking sous forme de String
	 * 
	 * @return un parking et ses donn�es
	 */
	public String toString() {
		return "Parking N� : " + this.idParking + ", nom : " + this.name + " situ� " + this.position + " a " + this.placesDispo +" places dispos sur " + this.placesTot + " et est " + this.type;
	}
	
  
}
