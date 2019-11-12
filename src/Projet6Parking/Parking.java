/**
 * 
 */
package Projet6Parking;

/**
 * Classe permettant de définir des parkings et les méthodes qui leurs sont associé
 * 
 * @author Nathan DE LEENER - HE201742
 * @version 2019/11/12
 *
 */
public class Parking {
	
	//Variables d'instance
	
	private String position;
	private int nbrPlaces;
	//Constructeur(s)
	
	/**
	 * Défini un parking avec son nombre de place et sa localisation
	 * 
	 * @param position : Nom du lieu où se situe le parking
	 * @param nbrPlace : Nombre de place disponible
	 */
	public Parking(String position, int nbrPlace) {
		this.position = position;
		this.nbrPlaces = nbrPlace;
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
	 * @return the nbrPlace
	 */
	public int getNbrPlace() {
		return nbrPlaces;
	}
	
	/**
	 * @param nbrPlace the nbrPlace to set
	 */
	public void setNbrPlace(int nbrPlaces) {
		this.nbrPlaces = nbrPlaces;
	}
	
	//Méthodes
	
	/**
	 * Retourne le nombre de places disponibles
	 * 
	 * @return nbrLibre : Le nombre de places disponibles
	 */
	public int placeAvail() {
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
