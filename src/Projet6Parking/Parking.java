package Projet6Parking;
import java.util.*;
import Projet6Parking.*;

/**
 * Classe permettant de definir des parkings et les methodes qui leurs sont associees
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
	/**Defini un parking avec son nombre de place et sa localisation
	 * 
	 * @param idParking : Id du parking dans la DB
	 * @param name : Nom du parking
	 * @param position : Nom du lieu ou se situe le parking
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
	 * Constructeur vide pour pouvoir creer un objet dans a classe DataBase sans avoir des erreurs d'initialisation
	 */
	public Parking() {
		this.idParking=-1;
	}
	
	//Getters & Setters
	/**
	 * @return the idParking
	 */
	public int getIdParking() {
		return idParking;
	}
	
	/**
	 * @param idParking the idParking to set
	 */
	public void setIdParking(int idParking) {
		this.idParking=idParking;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

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

	
	//Methodes
	/**
	 * Retourne le nombre de places disponibles
	 * 
	 * @return Le nombre de places disponibles
	 */
	public int placeAvail() {
		return placesDispo;
	}
	
	/**
	 * Ajoute un nombre defini de places au parking
	 * 
	 * @param nouvPlaces : Nombre de place a ajouter au parking
	 */
	public void addPlace(int nouvPlaces) {
		if (nouvPlaces > 0) {
			placesTot += nouvPlaces;
			placesDispo += nouvPlaces;
		}
	}
	
	/**
	 * Supprime un nombre defini de places au parking
	 * 
	 * @param suppPlaces : Nombre de places a supprimer du parking
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
	 * Retourne un parking sous forme de String
	 * 
	 * @return un parking et ses donnees
	 */
	public String toString() {
		return "Parking N° : " + this.idParking + ", nom : " + this.name + " situe " + this.position + " a " + this.placesDispo +" places dispos sur " + this.placesTot + " et est " + this.type;
	}
	
  
}
