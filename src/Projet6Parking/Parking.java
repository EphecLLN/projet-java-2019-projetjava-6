package Projet6Parking;
import java.util.*;
import Projet6Parking.*;

/**
 * Classe permettant de dï¿½finir des parkings et les mï¿½thodes qui leurs sont associï¿½es
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
	/**Dï¿½fini un parking avec son nombre de place et sa localisation
	 * 
	 * @param idParking : Id du parking dans la DB
	 * @param name : Nom du parking
	 * @param position : Nom du lieu oï¿½ se situe le parking
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
	 * Constructeur vide pour pouvoir crï¿½er un objet dans a classe DataBase sans avoir des erreurs d'initialisation
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

	
	//Mï¿½thodes
	/**
	 * Retourne le nombre de places disponibles
	 * 
	 * @return Le nombre de places disponibles
	 */
	public int placeAvail() {
		return placesDispo;
	}
	
	/**
	 * Ajoute un nombre dï¿½fini de places au parking
	 * 
	 * @param nouvPlaces : Nombre de place ï¿½ ajouter au parking
	 * @return Le parking modifiï¿½ en terme de nombre total de places et de places disponibles
	 */
	public void addPlace(int nouvPlaces) {
		if (nouvPlaces > 0) {
			placesTot += nouvPlaces;
			placesDispo += nouvPlaces;
		}
	}
	
	/**
	 * Supprime un nombre dï¿½fini de places au parking
	 * 
	 * @param suppPlaces : Nombre de places ï¿½ supprimer du parking
	 * @return Le parking modifiï¿½ en terme de nombre total de places et de places disponibles
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
		
	}
	
	/**
	 * Retourne un parking sous forme de String
	 * 
	 * @return un parking et ses donnï¿½es
	 */
	public String toString() {
		return "Parking N° : " + this.idParking + ", nom : " + this.name + " situé " + this.position + " a " + this.placesDispo +" places dispos sur " + this.placesTot + " et est " + this.type;
	}
	
  
}
