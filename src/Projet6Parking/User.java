/**
 * 
 */
package Projet6Parking;

/**
 * @author he201676
 *
 */
public class User {
	
	//propriétés
	private static int userId;
	private String name;
	private String firstname;
	private String phone;
	private String mail;
	private String plate;
	private int penalty;
	
	//getters
	public String getName() {
		return name;
	}
	public String getFirstName() {
		return firstname;
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
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setPlate(String plate) {
		this.plate = plate;
	}
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	//constructeurs
	
	/**
	 * constructeur de l'objet User, les différents utilisateurs de l'application
	 * 
	 * @param name : nom de l'utilisateur
	 * @param firstname : son prénom
	 * @param phone : son numéro de téléphone
	 * @param mail : son email
	 * @param plate : la plaque d'immatriculation de son véhicule
	 */
	public User(String name, String firstname, String phone, String mail,
			String plate) {
		this.userId = userId;
		userId++; //incr�mentation de l'id
		this.name = name;
		this.firstname = firstname;
		this.phone = phone;
		this.mail = mail;
		this.plate = plate;
		this.penalty = 0;
	}
	
	//m�thodes
	
	public void penalty(int nbPen) {
		if((nbPen > 0) || (nbPen >= 3)) {
			penalty = nbPen;
			System.out.println("Il vous reste "+(3-nbPen)+"chance(s).");
		}
		else if(nbPen > 3) {
			penalty = nbPen;
			System.out.println("Vous avez plus acc�s au r�servation.");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		userId=0;
		User u1 = new User("Gortz1", "Gaetan", "0478262700", "he201732@students.ephec.be", "87tx3");
		System.out.println(u1);
		User u2 = new User("Gortz2", "Gaetan", "0478262700", "he201732@students.ephec.be", "87tx3");
		User u3 = new User("Gortz3", "Gaetan", "0478262700", "he201732@students.ephec.be", "87tx3");
		System.out.println(u2);
		System.out.println(u3);

	}
	
	
	public String toString() {
		return this.userId + " " + this.name;
	}
}
