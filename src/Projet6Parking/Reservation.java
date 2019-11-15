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
	
	//propriétés
	private Place place;
	private User user;
	private Date dateStart;
	private Date dateEnd;
	
	//getters 
	public Place getPlace() {
		return place;
	}
	public User getUser() {
		return user;
	}
	public Date getDateStart() {
		return dateStart;
	}
	public Date getDateEnd() {
		return dateEnd;
	}
	
	//setters
	public void setPlace(Place place) {
		this.place = place;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	//constructeurs
	
	public Reservation(Place place, User user, Date dateS, Date dateE) {
		this.place = place;
		this.user = user;
		this.dateStart = dateS;
		this.dateEnd = dateE;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
