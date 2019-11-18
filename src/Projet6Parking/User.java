package Projet6Parking;

/**
 * @author he201676
 *
 */
public class User {

	//Variables d'instance
	private int idUser; //Ajout pour pouvoir faire le lien avec la DB
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
		return "id : " + this.idUser + ", nom :  " + this.name + " " + this.firstName + ", tel : " + this.phone + ", mail : " + this.mail + ", plaque : " + this.plate + ", nombre de pénalité : " + this.penalty;
	}
}
