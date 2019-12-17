package Projet6Parking;

import java.util.*;
import Projet6Parking.DataBase;

/**
 * @author he201676
 *
 */
public class User {

	// Variables d'instance
	private int idUser; // Ajout pour pouvoir faire le lien avec la DB
	private String username;
	private String mdp;
	private String name; // Nom de l'utilisateur
	private String firstName; // Prenom de l'utilisateur
	private String phone; // Telephone de l'utilisateur
	private String mail; // Mail de l'utilisateur
	private String plate; // Plaque de la voiture de l'utilisateur
	private int penalty; // Nombre de penalite de l'utilisateur

	// Constructeur
	/**
	 * Constructeur de l'objet User, les differents utilisateurs de l'application
	 * 
	 * @param idUser    : l'id de l'utilisateur
	 * @param name      : nom de l'utilisateur
	 * @param firstName : Prenom de l'utilisateur
	 * @param phone     : numero de telephone de l'utilisateur
	 * @param mail      : email de l'utilisateur
	 * @param plate     : la plaque d'immatriculation du vehicule de l'utilisateur
	 */
	public User(int idUser, String username, String mdp, String name, String firstName, String phone, String mail,
			String plate) {
		this.idUser = idUser;
		this.username = username;
		this.mdp = mdp;
		this.name = name;
		this.firstName = firstName;
		this.phone = phone;
		this.mail = mail;
		this.plate = plate;
		this.penalty = 0;
	}

	/**
	 * Constructeur vide pour pouvoir creer un objet dans a classe DataBase sans
	 * avoir des erreurs d'initialisation
	 */
	public User() {
		this.idUser = -1;
	}

	// Getters & Setters

	/**
	 * @return l'Id du User
	 */
	public int getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return le username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return le mot de passe
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @return le nom
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return le prenom
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return le numero de telephone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return le mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @return le numero de plaque
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * @return le nombre de penalites
	 */
	public int getPenalty() {
		return penalty;
	}

	/**
	 * @param username le prenom a definir
	 */
	public void setUsername(String username) {
		if (username.isEmpty()) {
			System.out.println("Vous n'avez pas mis de nom d'utilisateur");
		} else {
			this.username = username;
			System.out.println("Nom d'utilisateur : " + username);
		}
	}

	/**
	 * @param mdp le mot de passe a definir
	 */
	public void setMdp(String mdp) {
		if (mdp.isEmpty()) {
			System.out.println("Vous n'avez pas mis de nom");
		} else {
			this.mdp = mdp;
		}
	}

	/**
	 * @param name le nom a definir
	 */
	public void setName(String name) {
		if (name.isEmpty()) {
			System.out.println("Vous n'avez pas mis de nom");
		} else {
			this.name = name;
			System.out.println("Nom : " + name);
		}
	}

	/**
	 * @param firstName le prenom a definir
	 */
	public void setFirstName(String firstName) {
		if (firstName.isEmpty()) {
			System.out.println("Vous n'avez pas mis de prenom");
		} else {
			this.firstName = firstName;
			System.out.println("Prenom : " + firstName);
		}
	}

	/**
	 * @param phone le numero de telephone a definir
	 */
	public void setPhone(String phone) {
		if (phone.isEmpty()) {
			System.out.println("Vous n'avez pas mis de  de telephone");
		} else {
			this.phone = phone;
			System.out.println(" de telephone : " + phone);
		}
	}

	/**
	 * @param mail l'adresse email a definir
	 */
	public void setMail(String mail) {
		if (!mail.contains("@") && !mail.contains(".com")) {
			System.out.println("ce n'est pas un email");
		} else {
			this.mail = mail;
			System.out.println("Mail : " + mail);
		}
	}

	/**
	 * @param plate le numero de plaque a definir
	 */
	public void setPlate(String plate) {
		this.plate = plate;
		System.out.println("Plaque d'immatriculation : " + plate);
	}

	/**
	 * @param penalty le nombre de penalites a definir
	 */
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	// Methodes
	public void penalty(int nbPen) {
		if ((nbPen > 0) || (nbPen <= 3)) {
			penalty = nbPen;
			System.out.println("Il vous reste " + (3 - nbPen) + "chance(s).");
		} else if (nbPen > 3) {
			penalty = nbPen;
			System.out.println("Vous avez plus acces au reservation.");
		}
	}

	/**
	 * Ajoute une penalite a l'utilisteur
	 */
	public void addPenalty() {
		this.setPenalty(this.getPenalty() + 1);
		if (this.getPenalty() >= 3) {
			System.out.println("Vous avez trop d'infractions");
		}
		DataBase.addPenalty(this.idUser);
	}

	/**
	 * Permet de reserver une place de parking
	 * 
	 * @param p Le parking dans lequel l'utilisateur veut reserver
	 */
	public void reserve(Parking p) {
		// verif si encore place dispo
		if (p.getPlacesDispo() < 1) {
			System.out.println("Plus de place disponible");
		}
		else if(this.getPenalty()>=3) {
			System.out.println("Vous avez trop de penalite, vous ne pouvez plus faire de reservation");
		}
		else { // Encore de la place de libre
			Place pl = new Place(DataBase.getIdPlace(), p, DataBase.getNumberPlace(p));
			DataBase.addPlace(pl);
			Reservation r = new Reservation(DataBase.getIdReservation(), pl, this);
			System.out.println("Votre réservation est la " + r.getIdReservation());
			DataBase.addReservation(r);
			DataBase.reservations.enqueue(r);
			pl.setBooked(true);
			DataBase.setBooked(pl);
			p.setPlacesDispo(p.getPlacesDispo() - 1);
			DataBase.removePlaceDispo(p);
		}
	}

	/**
	 * Permet d'arreter une reservation
	 * 
	 * @param r la reservation qui est finie
	 */
	public void libereReservation(Reservation r) {
		Place pl = r.getPlace();
		Parking pa = pl.getParking();
		if (!this.equals(r.getUser())) {
			System.out.println("Vous ne pouvez pas liberer une place que vous n'avez pas reservee");
		}
		else if (pl.isBooked()) {
			System.out.println("La place n'est pas reservee");
		} else {
			pa.setPlacesDispo(pa.getPlacesDispo() + 1);
			DataBase.addPlaceDispo(pa);
			pl.setBooked(false);
			DataBase.unsetBooked(pl);
			DataBase.reservations.suppresReservation(r);
			System.out.println("Votre reservation avec le numero " + r.getIdReservation() + " a ete supprimee");
		}
	}

	/**
	 * Permet de signaler un utilisateur
	 * 
	 * @param r   la reservation ou a lieu l'infraction
	 * @param com la raison de l'infraction
	 */
	public void flagV2(Reservation r, String com) {
		Place pl = r.getPlace();
		Date d = new Date();
		User userF = r.getUser();
		Offence of = new Offence(DataBase.getIdOffence(), this, userF, com, pl, d);
		DataBase.addOffence(of);
		userF.addPenalty();
		System.out.println("Voici votre signalisation : ");
		System.out.println(of);
	}

	/**
	 * Compare si 2 utilisateurs sont les memes sur base de leur id
	 * 
	 * @return true si les 2 id sont les memes, false sinon
	 */
	public boolean equals(Object o) {
		if (this == null || o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		User u = (User) o;
		return this.idUser == u.idUser;
	}

	/**
	 * Retourne un utilisateur sous forme de String pour un affichage console
	 * 
	 * @return l'utilisateur avec ses donnees
	 */
	public String toString() {
		return "id : " + this.idUser + ", username : " + this.username + ", mdp : " + this.mdp + ", nom :  " + this.name
				+ " " + this.firstName + ", tel : " + this.phone + ", mail : " + this.mail + ", plaque : " + this.plate
				+ ", nombre de penalite : " + this.penalty;
	}

//--PEUT ETRE INUTILE---
	/*	
		*//**
			 * Permet de liberer une place de parking
			 * 
			 * @param p La place qu'on veut liberer
			 */
	/*
	 * public void liberePlace(Place p) { if(p.isFree()) {
	 * System.out.println("La place n'est pas reservee"); }
	 * 
	 * verifier si la reservation est bien à l'utilisateur
	 * 
	 * else { Parking pa = p.getParking(); pa.setPlacesDispo(pa.getPlacesDispo()+1);
	 * p.setBooked(true); } }
	 * 
	 * 
	 *//**
		 * Permet de signaler un utilisateur
		 * 
		 * @param pl  la place ou a lieu l'infraction
		 * @param com la raison de l'infraction
		 *//*
			 * public void flagV1(Place pl, String com) { Date d = new Date(); //Aller
			 * chercher l'utilisateur User userF = new User(2,"NathDL", "mdp", "Nath",
			 * "DL","0478262700", "he201742@students.ephec.be", "1gfp497"); Offence of = new
			 * Offence(1, this, userF, com, pl, d); //Ajouter une penalite a l'utilisateur
			 * userF.addPenalty(); }
			 */
}
