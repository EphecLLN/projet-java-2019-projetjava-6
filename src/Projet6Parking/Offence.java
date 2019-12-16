/** Ceci est la classe Offence qui represente une infraction dans l'utilisation des parkings.
 * Chaque Offence se voit attribuee un numero unique afin de pouvoir identifier facilement les objets
 * Une Offence concerne 2 users, celui en tort et celui qui signale. Un commentaire de max 250c permet de decrire le d�lit
 * Une Offence se refaire a une Place et donc a un Parking, ainsi qu'une date
 * 
 * 
 * @author gaeta_2b6psqs
 * @date 11-11-19
 */

package Projet6Parking;
import java.util.Date;


public class Offence {
	
	//Variable d'instance
	int idOffence; //l'id de l'offence dans la DB
	User userSignal; //l'utilisateur qui signale l'infraction
	User userFlagged; //l'utilisateur qui commet l'infraction
	String comment; //la description de l'infraction maximum 50 caracteres (SQL)
	Place place; //la place sur laquelle l'infraction a lieu
	Date date; //la date a laquelle l'infraction a lieu
	
	//Constructeur
	/**
	 * Ceci est le constructeur d'un objet Offence
	 * 
	 * @param idOffence l'id de l'offence de la DB
	 * @param signal le User qui signale l'infraction
	 * @param flag le User qui a comis l'infraction
	 * @param com le commentaire sur l'infraction (max 50caracteres)
	 * @param p la Place de Parking ou a eu lieue l'infraction
	 * @param d la Date a laquelle l'infraction a eu lieue
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
	

	//Getters & Setters
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

	
	
	//Methodes
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Retourne une offence sous forme de String pour l'afficher en console
	 * 
	 * @return une offence et ses donn�es
	 */
	public String toString() {
		return "Offence N� " + this.idOffence + " signaleur : (" + this.userSignal + "), fautif : (" + this.userFlagged + "), place : " + this.place + ", date : " + this.date;
	}

}
