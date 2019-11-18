/** Ceci est la classe Offence qui repr�sente une infraction dans l'utilisation des parkings.
 * Chaque Offence se voit attribu� un num�ro unique afin de pouvoir identifier facilement les objets
 * Une Offence concerne 2 users, celui en tort et celui qui signale. Un commentaire de max 250c permet de d�crire le d�lit
 * Une Offence se r�f�re � une Place et donc � un Parking, ainsi qu'une date
 * 
 * 
 * @author gaeta_2b6psqs
 * @date 11-11-19
 */

package Projet6Parking;

import java.util.Date;


public class Offence {
	int idOffence; //g�r� par db
	User userSignal;
	User userFlagged;
	String comment; //maximum 50 caract�res (SQL)
	Place place;
	Date date;
	
	
	/**
	 * Ceci est le constructeur d'un objet Offence
	 * 
	 * @param signal le User qui signale l'infraction
	 * @param flag le User qui a comis l'infraction
	 * @param com le commentaire sur l'infraction
	 * @param p la Place de Parking o� � eu lieue l'infraction
	 * @param d la Date � laquelle l'infraction � eu lieue
	 */
	public Offence(int idOffence, User signal, User flag, String com, Place p, Date d) {
		this.idOffence = idOffence;
		userSignal = signal;
		userFlagged =flag;
		if(com.length()>50) {
			String shortComment="";
			for(int i=0; i<50; i++) {
				shortComment+=com.charAt(i);
			}
			comment=shortComment;
		}
		else {
			comment = com;
		}
		place = p;
		date = d;
	}
	

	
	/**
	 * @return the idOffence
	 */
	public int getIdOffence() {
		return idOffence;
	}

	/**
	 * @param idOffence the idOffence to set
	 */
	public void setIdOffence(int idOffence) {
		this.idOffence = idOffence;
	}

	/**
	 * @return the userSignal
	 */
	public User getUserSignal() {
		return userSignal;
	}

	/**
	 * @param userSignal the userSignal to set
	 */
	public void setUserSignal(User userSignal) {
		this.userSignal = userSignal;
	}

	/**
	 * @return the userFlagged
	 */
	public User getUserFlagged() {
		return userFlagged;
	}

	/**
	 * @param userFlagged the userFlagged to set
	 */
	public void setUserFlagged(User userFlagged) {
		this.userFlagged = userFlagged;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		if(comment.length()>50) {
			String shortComment="";
			for(int i=0; i<50; i++) {
				shortComment+=comment.charAt(i);
			}
			this.comment=shortComment;
		}
		else {
			this.comment = comment;
		}
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
