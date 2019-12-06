package Projet6Parking;
import java.util.*;

/**
 * @author he201676
 *
 */
public class User {

	//Variables d'instance
	private int idUser; //Ajout pour pouvoir faire le lien avec la DB
	private String name; //Nom de l'utilisateur
	private String firstName;  //Pr�nom de l'utilisateur
	private String phone; //T�l�phone de l'utilisateur
	private String mail; //Mail de l'utilisateur
	private String plate; //Plaque de la voiture de l'utilisateur
	private int penalty; //Nombre de p�nalit� de l'utilisateur
	
	//Constructeur
	/**Constructeur de l'objet User, les diff�rents utilisateurs de l'application
	 * 
	 * @param idUser : l'id de l'utilisateur
	 * @param name : nom de l'utilisateur
	 * @param firstName : pr�nom de l'utilisateur
	 * @param phone : num�ro de t�l�phone de l'utilisateur
	 * @param mail : email de l'utilisateur
	 * @param plate : la plaque d'immatriculation du v�hicule de l'utilisateur
	 */
	public User(int idUser, String name, String firstName, String phone, String mail, String plate) {
		this.idUser = idUser;
		this.name = name;
		this.firstName = firstName;
		this.phone = phone;
		this.mail = mail;
		this.plate = plate;
		this.penalty = 0;
	}
	
	
	//Getters & Setters
	/**
	 * @return the idUser
	 */
	public int getidUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setidUser(int idUser) {
		this.idUser = idUser;
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
	 * @return the firstName
	 */
	public String getfirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the plate
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * @param plate the plate to set
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}

	/**
	 * @return the penalty
	 */
	public int getPenalty() {
		return penalty;
	}

	/**
	 * @param penalty the penalty to set
	 */
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	
	//M�thodes
	public void penalty(int nbPen) {
		if((nbPen > 0) || (nbPen <= 3)) {
			penalty = nbPen;
			System.out.println("Il vous reste "+(3-nbPen)+"chance(s).");
		}
		else if(nbPen > 3) {
			penalty = nbPen;
			System.out.println("Vous avez plus acces au reservation.");
		}
	}
	
	/**
	 * Ajoute une p�nalit� � l'utilisteur
	 */
	public void addPenalty() {
		this.setPenalty(this.getPenalty()+1);
		if(this.getPenalty()>=3) {
			System.out.println("Vous avez trop d'infractions");
		}
	}
	
	/**
	 * Permet de r�server une place de parking
	 * 
	 * @param p La place que l'utilisateur veut r�server
	 */
	public void reserve(Place p) {
		if(p.isBooked()) {
			System.out.println("La place est d�j� prise");
		}
		else {
		Reservation r = new Reservation(1, p, this);
		p.setBooked(true);
			System.out.println(r);
		Parking pa = p.getParking();
		pa.setPlacesDispo(pa.getPlacesDispo()-1);
		}
	}
	
	/**
	 * Permet de lib�rer une place de parking
	 * @param p La palce qu'on veut lib�rer
	 */
	public void liberePlace(Place p) {
		if(p.isFree()) {
			System.out.println("La place n'est pas r�serv�e");
		}
		/*
		 * v�rifier si la r�servation est bien � l'utilisateur
		 */
		else {
			Parking pa = p.getParking();
			pa.setPlacesDispo(pa.getPlacesDispo()+1);
			p.setBooked(true);
		}
	}
	
	/**
	 * Permet d'arreter une r�servation
	 * 
	 * @param r la r�servation qui est finie
	 */
	public void libereReservation(Reservation r) {
		Place pl = r.getPlace();
		Parking pa = pl.getParking();
		if(r.getUser()!=this) {
			System.out.println("Vous ne pouvez pas lib�rer une place que vous n'avez pas r�serv�e");
		}
		if(pl.isFree()) {
			System.out.println("La place n'est pas r�serv�e");
		}
		else {
			pa.setPlacesDispo(pa.getPlacesDispo()+1);
			pl.setBooked(false);
		}
	}
	
	/**
	 * Permet de signaler un utilisateur
	 * 
	 * @param pl la place ou � lieu l'infraction
	 * @param com la raison de l'infraction
	 */
	public void flagV1(Place pl, String com) {
		Date d = new Date();
		//Aller chercher l'utilisateur
		User userF = new User(2, "Nath", "DL","0478262700", "he201742@students.ephec.be", "1gfp497");
		Offence of = new Offence(1, this, userF, com, pl, d);
		//Ajouter une penalite a l'utilisateur
		userF.addPenalty();
	}
	
	/**
	 * Permet de signaler un utilisateur
	 * 
	 * @param r la reservation ou � lieu l'infraction
	 * @param com la raison de l'infraction
	 */
	public void flagV2(Reservation r, String com) {
		Place pl = r.getPlace();
		Date d = new Date();
		User userF = r.getUser();
		Offence of = new Offence(1, this, userF, com, pl, d);
		userF.addPenalty();
	}
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	/**
	 * Retourne un utilisateur sous forme de String pour un affichage console
	 * 
	 * @return l'utilisateur avec ses donn�es
	 */
	public String toString() {
		return "id : " + this.idUser + ", nom :  " + this.name + " " + this.firstName + ", tel : " + this.phone + ", mail : " + this.mail + ", plaque : " + this.plate + ", nombre de p�nalit� : " + this.penalty;
	}
}
