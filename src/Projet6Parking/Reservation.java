package Projet6Parking;

/**
 * @author he201732
 *
 */
public class Reservation {
	
	//Variable d'instance
	private int idReservation; //L'id globale de la reservation dans la DB
	private Place place; //La place sur laquelle on fait la r�servation
	private User user; //L'utilisateur qui fait la r�servation
		
	//Constructeur
	/**D�fini une r�servation avec la place r�serv�e et l'utilisateur qui fait la r�servation
	 * 
	 * @param idReservation l'id de la r�servation dans la DB
	 * @param place la place qui est r�serv�e
	 * @param user l'utilisateur qui r�serve la place
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

	
	//M�thodes
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Retourne une r�servation sous forme de String
	 * 
	 * @return Une reservation sous forme de String
	 */
	public String toString() {
		return "Reservation N� : " + this.idReservation + ", place : " + this.place + ", utilisateur : " + this.user;
	}

}
