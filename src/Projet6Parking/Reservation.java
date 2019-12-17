package Projet6Parking;

/**
 * Classe Reservation permettant de gerer les reservations de places de parking
 * faites par les utilisateurs
 * 
 * @author GORTZ Gaëtan
 * @version 2019/12/17
 */
public class Reservation {
	
	//Variable d'instance
	private int idReservation; //L'id globale de la reservation dans la DB
	private Place place; //La place sur laquelle on fait la reservation
	private User user; //L'utilisateur qui fait la reservation
		
	//Constructeur
	/**Defini une reservation avec la place reservee et l'utilisateur qui fait la reservation
	 * 
	 * @param idReservation l'id de la reservation dans la DB
	 * @param place la place qui est reservee
	 * @param user l'utilisateur qui reserve la place
	 */
	public Reservation(int idReservation, Place place, User user) {
		this.idReservation = idReservation;
		this.place = place;
		this.user = user;
	}

	/**
	 * Constructeur vide pour pouvoir creer un objet dans a classe DataBase sans avoir des erreurs d'initialisation
	 */
	public Reservation() {
		idReservation=-1;
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

	
	//Methodes
	
	/**
	 * Retourne une reservation sous forme de String
	 * 
	 * @return Une reservation sous forme de String
	 */
	public String toString() {
		return "Reservation N° : " + this.idReservation + ",\n\t place : [" + this.place + "],\n\t utilisateur : [" + this.user + "]";
	}
	
	/**
	 * Compare 2 reservations pour dire si ce sont les memes sur base de leur id
	 * @return true si les 2 reservations ont le meme id, false sinon
	 */
	public boolean equals(Object o) {
		if(this==null || o==null) {
			return false;
		}
		if(o.getClass()!=this.getClass()) {
			return false;
		}
		Reservation r = (Reservation) o;
		return this.getIdReservation()==r.getIdReservation();
	}

}
