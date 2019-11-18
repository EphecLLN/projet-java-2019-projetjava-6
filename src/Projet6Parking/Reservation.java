package Projet6Parking;

/**
 * @author he201732
 *
 */
public class Reservation {
	
	//Variable d'instance
	private int idReservation; //L'id globale de la reservation dans la DB
	private Place place; //La place sur laquelle on fait la réservation
	private User user; //L'utilisateur qui fait la réservation
		
	//Constructeur
	/**Défini une réservation avec la place réservée et l'utilisateur qui fait la réservation
	 * 
	 * @param idReservation l'id de la réservation dans la DB
	 * @param place la place qui est réservée
	 * @param user l'utilisateur qui réserve la place
	 */
	public Reservation(int idReservation, Place place, User user) {
		this.idReservation = idReservation;
		this.place = place;
		this.user = user;
	}

	
	//Getters & Setters 
	/**
	 * @return the idReservation
	 */
	public int getIdReservation() {
		return idReservation;
	}

	/**
	 * @param idReservation the idReservation to set
	 */
	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(Place place) {
		this.place = place;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	
	//Méthodes
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Retourne une réservation sous forme de String
	 * 
	 * @return Une reservation sous forme de String
	 */
	public String toString() {
		return "Reservation N° : " + this.idReservation + ", place : " + this.place + ", utilisateur : " + this.user;
	}

}
