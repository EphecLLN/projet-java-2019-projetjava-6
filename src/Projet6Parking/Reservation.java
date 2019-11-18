/**
 * 
 */
package Projet6Parking;

import java.util.Date;

/**
 * @author he201732
 *
 */
public class Reservation {
	
	//propri�t�s
	private int idPlace;
	private Place place;
	private User user;
	
	//getters 
	public Place getPlace() {
		return place;
	}
	public User getUser() {
		return user;
	}
	
	//setters
	public void setPlace(Place place) {
		this.place = place;
	}
	public void setUser(User user) {
		this.user = user;
	}

	//constructeurs
	
	public Reservation(int idPlace, Place place, User user) {
		this.idPlace = idPlace;
		this.place = place;
		this.user = user;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
