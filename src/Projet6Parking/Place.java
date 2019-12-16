package Projet6Parking;

/**
 * Classe permettant de gérer les places des parkings
 * 
 * @author Nathan DE LEENER - HE201742
 * @version 2019/11/12
 *
 */
public class Place {
	
	//Variables d'instance
	private int idPlace;		//Numero global de la place dans la DB
	private int number;			//Numero de la place dans le parking
	private Parking parking;	//Parking auquel la place appartient
	private boolean booked;		//Etat de la reservation de la place 
	
	//Constructeur
	/**Défini une place avec son id, son numéro et le parking auquel elle appartient, par défault la place n'est pas réservée
	 * 
	 * @param idPlace l'id de la place dans la DB
	 * @param parking le parking auquel la place appartient
	 * @param number le numéro de la place dans le parking
	 */
	public Place(int idPlace, Parking parking, int number) {
		this.idPlace = idPlace;
		this.number = number;
		this.parking = parking;
		this.booked = false;
	}

	/**
	 * Constructeur vide pour pouvoir créer un objet dans a classe DataBase sans avoir des erreurs d'initialisation
	 */
	public Place() {
		idPlace=-1;
	}


	//Getters & Setters
	/**
	 * @return the idPlace
	 */
	public int getIdPlace() {
		return idPlace;
	}

	/**
	 * @param idPlace the idPlace to set
	 */
	public void setIdPlace(int idPlace) {
		this.idPlace = idPlace;
	}

	/**
	 * @return the parkingId
	 */
	public Parking getParking() {
		return parking;
	}

	/**
	 * @param parking the parking to set
	 */
	public void setParking(Parking parking) {
		this.parking = parking;
	}

	/**
	 * @return the booked
	 */
	public boolean isBooked() {
		return booked;
	}

	/**
	 * @param booked the booked to set
	 */
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	
	
	//Méthodes
	/**
	 * Nous dis si une place est libre ou non
	 * 
	 * @return true si la palce est libre, false sinon
	 */
	public boolean isFree() {
		return !booked;
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Retourne une place sous forme de String
	 * 
	 * @return une place sous forme de String
	 */
	public String toString() {
		return "Place N° : " + this.number + " du \n\t\tparking : [" + this.parking + "] est prise : " + this.booked;
	}

}
