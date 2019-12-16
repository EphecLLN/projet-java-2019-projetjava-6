package Projet6Parking;
import java.util.*;

/**
 * @author he201676
 *
 */
public class User extends Observable{

	//Variables d'instance
	private int idUser; //Ajout pour pouvoir faire le lien avec la DB
	private String username;
	private String mdp;
	private String name; //Nom de l'utilisateur
	private String firstName;  //Prénom de l'utilisateur
	private String phone; //Téléphone de l'utilisateur
	private String mail; //Mail de l'utilisateur
	private String plate; //Plaque de la voiture de l'utilisateur
	private int penalty; //Nombre de pénalité de l'utilisateur
	
	//Constructeur
	/**Constructeur de l'objet User, les différents utilisateurs de l'application
	 * 
	 * @param idUser : l'id de l'utilisateur
	 * @param name : nom de l'utilisateur
	 * @param firstName : prénom de l'utilisateur
	 * @param phone : numéro de téléphone de l'utilisateur
	 * @param mail : email de l'utilisateur
	 * @param plate : la plaque d'immatriculation du véhicule de l'utilisateur
	 */
	public User(int idUser, String username, String mdp, String name, String firstName, String phone, String mail, String plate) {
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
	
	
	//Getters & Setters

	public int getIdUser() {
		return idUser;
	}


	public String getUsername() {
		return username;
	}


	public String getMdp() {
		return mdp;
	}


	public String getName() {
		return name;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getPhone() {
		return phone;
	}


	public String getMail() {
		return mail;
	}


	public String getPlate() {
		return plate;
	}


	public int getPenalty() {
		return penalty;
	}

	public void setUsername(String username) {
		if(username.isEmpty()) {
			System.out.println("Vous n'avez pas mis de nom d'utilisateur");
		}
		else {
		this.username = username;
		System.out.println("Nom d'utilisateur : " + username);
		}
		}

	public void setMdp(String mdp) {
		if(mdp.isEmpty()) {
			System.out.println("Vous n'avez pas mis de nom");
		}
		else {
		this.mdp = mdp;
		}
	}

	public void setName(String name) {
		if(name.isEmpty()) {
			System.out.println("Vous n'avez pas mis de nom");
		}
		else {
		this.name = name;
		System.out.println("Nom : " + name);
		}
	}

	public void setFirstName(String firstName) {
		if(firstName.isEmpty()) {
			System.out.println("Vous n'avez pas mis de prenom");
		}
		else {
		this.firstName = firstName;
		System.out.println("Prenom : " + firstName);
		}
	}

	public void setPhone(String phone) {
		if(phone.isEmpty()) {
			System.out.println("Vous n'avez pas mis de numero de telephone");
		}
		else {
		this.phone = phone;
		System.out.println("Numero de telephone : " + phone);
		}
	}

	public void setMail(String mail) {
		if(!mail.contains("@") && !mail.contains(".com")) {
			System.out.println("ce n'est pas un email");
		}
		else {
		this.mail = mail;
		System.out.println("Mail : " + mail);
		}
	}

	public void setPlate(String plate) {
		this.plate = plate;
		System.out.println("Plaque d'immatriculation : " + plate);
	}
	
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	
	//Méthodes
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
	 * Ajoute une pénalité à l'utilisteur
	 */
	public void addPenalty() {
		this.setPenalty(this.getPenalty()+1);
		if(this.getPenalty()>=3) {
			System.out.println("Vous avez trop d'infractions");
		}
	}
	
	/**
	 * Permet de réserver une place de parking
	 * 
	 * @param p La place que l'utilisateur veut réserver
	 */
	public void reserve(Place p) {
		if(p.isBooked()) {
			System.out.println("La place est déjà prise");
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
	 * Permet de libérer une place de parking
	 * @param p La palce qu'on veut libérer
	 */
	public void liberePlace(Place p) {
		if(p.isFree()) {
			System.out.println("La place n'est pas réservée");
		}
		/*
		 * vérifier si la réservation est bien à l'utilisateur
		 */
		else {
			Parking pa = p.getParking();
			pa.setPlacesDispo(pa.getPlacesDispo()+1);
			p.setBooked(true);
		}
	}
	
	/**
	 * Permet d'arreter une réservation
	 * 
	 * @param r la réservation qui est finie
	 */
	public void libereReservation(Reservation r) {
		Place pl = r.getPlace();
		Parking pa = pl.getParking();
		if(r.getUser()!=this) {
			System.out.println("Vous ne pouvez pas libérer une place que vous n'avez pas réservée");
		}
		if(pl.isFree()) {
			System.out.println("La place n'est pas réservée");
		}
		else {
			pa.setPlacesDispo(pa.getPlacesDispo()+1);
			pl.setBooked(false);
		}
	}
	
	/**
	 * Permet de signaler un utilisateur
	 * 
	 * @param pl la place ou à lieu l'infraction
	 * @param com la raison de l'infraction
	 */
	public void flagV1(Place pl, String com) {
		Date d = new Date();
		//Aller chercher l'utilisateur
		User userF = new User(2,"NathDL", "mdp", "Nath", "DL","0478262700", "he201742@students.ephec.be", "1gfp497");
		Offence of = new Offence(1, this, userF, com, pl, d);
		//Ajouter une penalite a l'utilisateur
		userF.addPenalty();
	}
	
	/**
	 * Permet de signaler un utilisateur
	 * 
	 * @param r la reservation ou à lieu l'infraction
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
	 * @return l'utilisateur avec ses données
	 */
	public String toString() {
		return "id : " + this.idUser + ", username : " + this.username + ", mdp : " + mdp + ", nom :  " + this.name + " " + this.firstName + ", tel : " + this.phone + ", mail : " + this.mail + ", plaque : " + this.plate + ", nombre de pénalité : " + this.penalty;
	}
}
